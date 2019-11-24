/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql.fdb.service.livy

import java.net.URI
import java.util.concurrent.ExecutionException

import scala.collection.JavaConverters._
import scala.util.Random
import scala.util.control.NonFatal

import org.apache.livy.{LivyClient, LivyClientBuilder}
import org.apache.livy.client.http.HttpClientProxy

import org.apache.spark.internal.Logging
import org.apache.spark.rpc.RpcEndpointRef
import org.apache.spark.sql.internal.SQLConf
import org.apache.spark.sql.fdb.SQLServerConf
import org.apache.spark.sql.fdb.SQLServerConf._
import org.apache.spark.sql.fdb.service.SessionContext
import org.apache.spark.sql.fdb.util.SQLServerUtils


class LivyProxyContext(sqlConf: SQLConf, livyService: LivyServerService)
    extends SessionContext with Logging {

  private var connectMethod: Option[() => Unit] = None
  private var livyClient: LivyClient = _
  private var rpcEndpoint: RpcEndpointRef = _

  private val impersonated = SQLServerUtils.isKerberosEnabled(sqlConf) &&
    sqlConf.sqlServerImpersonationEnabled

  private val sparkConfBlacklist: Seq[String] = Seq(
    SQLServerConf.SQLSERVER_PORT.key,
    SQLServerConf.SQLSERVER_VERSION.key,
    SQLServerConf.SQLSERVER_EXECUTION_MODE.key,
    SQLServerConf.SQLSERVER_PSQL_ENABLED.key,
    SQLServerConf.SQLSERVER_WORKER_THREADS.key,
    SQLServerConf.SQLSERVER_RECOVERY_MODE.key,
    SQLServerConf.SQLSERVER_RECOVERY_DIR.key,
    SQLServerConf.SQLSERVER_IDLE_SESSION_CLEANUP_DELAY.key,
    SQLServerConf.SQLSERVER_IMPERSONATION_ENABLED.key,
    "spark.sql.server.livy.",
    "spark.sql.server.ssl.",
    "spark.sql.server.ui.",
    "spark.master",
    "spark.deploy-mode",
    "spark.driver.cores",
    "spark.driver.memory",
    "spark.executor.cores",
    "spark.executor.memory",
    "spark.jars",
    "spark.submit.deployMode"
  ) ++ (if (impersonated) {
    Seq("spark.yarn.principal", "spark.yarn.keytab")
  } else {
    Nil
  })

  def init(serviceName: String, sessionId: Int, userName: String, dbName: String): Unit = {
    logInfo(s"serviceName=$serviceName sessionId=$sessionId dbName=$dbName")

    // Configurations that Livy passes into `SQLContext`
    val sparkConf = Map(
      // General configurations
      "spark.master" -> sqlConf.sqlServerLivySparkMaster,
      "spark.deploy-mode" -> sqlConf.sqlServerLivySparkDeployMode,
      "spark.driver.cores" -> sqlConf.sqlServerLivySparkDriverCores,
      "spark.driver.memory" -> sqlConf.sqlServerLivySparkDriverMemory,
      "spark.executor.cores" -> sqlConf.sqlServerLivySparkExecutorCores,
      "spark.executor.memory" -> sqlConf.sqlServerLivySparkExecutorMemory,
      "spark.rpc.askTimeout" -> "720s"
      // We need to have at least two threads for Spark Netty RPC: task thread + cancel thread
      // "spark.rpc.netty.dispatcher.numThreads" -> "2",
      // "spark.rpc.io.numConnectionsPerPeer" -> "2",
      // "spark.rpc.io.threads" -> "2"
    ) ++ sqlConf.settings.asScala.filterNot {
      case (key, _) => sparkConfBlacklist.exists(key.contains)
    }
    val livyClientConf = Seq(
      "job-cancel.trigger-interval" -> "100ms",
      "job-cancel.timeout" -> "24h"
    )
    logInfo(
      s"""Spark properties for the SQLContext that Livy launches:
         |  ${sparkConf.map { case (k, v) => s"key=$k value=$v" }.mkString("\n  ") }
       """.stripMargin)

    val _connectMethod = () => {
      // Submits a job to open a session, initializes a RPC endpoint in the session, and
      // registers the endpoint in `RpcEnv`.
      val (_livyClient, _rpcEndpoint) =
          LivyProxyContext.retryRandom(numRetriesLeft = 4, maxBackOffMillis = 10000) {

        val client = if (impersonated) {
          // If Kerberos and impersonation enabled, sets `userName` at `proxyUser`
          logInfo(s"Kerberos and impersonation enabled: proxyUser=$userName")

          // scalastyle:off line.size.limit
          // Workaround: Starts a Livy session with `proxyUser`
          //  https://stackoverflow.com/questions/45230416/how-to-set-proxy-user-in-livy-job-submit-through-its-java-api
          // scalastyle:on line.size.limit
          val livyUrl = s"http://${sqlConf.sqlServerLivyHost}:${sqlConf.sqlServerLivyPort}"
          val params = livyClientConf ++ sparkConf
          val livySessionId = HttpClientProxy.start(new URI(livyUrl), userName, params.toMap)

          // Attaches the created Livy session
          val _livyUrl = s"$livyUrl/sessions/$livySessionId"
          val builder = new LivyClientBuilder().setURI(new URI(_livyUrl))
          builder.build()
        } else {
          // Starts a Livy session in a regular way
          val livyUrl = s"http://${sqlConf.sqlServerLivyHost}:${sqlConf.sqlServerLivyPort}"
          var builder = new LivyClientBuilder().setURI(new URI(livyUrl))

          (livyClientConf ++ sparkConf).foreach { case (key, value) =>
            builder = builder.setConf(key, value)
          }

          builder.build()
        }

        val endpoint = try {
          // Submits a job to open a session and initializes a RPC endpoint
          val endpointRef = client.submit(new OpenSessionJob(sessionId, dbName)).get()
          // Then, registers the endpoint in `RpcEnv`
          livyService.rpcEnv.setupEndpointRef(
            endpointRef.address, OpenSessionJob.ENDPOINT_NAME)
        } catch {
          case e: Throwable =>
            client.stop(true)
            throw e
        }

        (client, endpoint)
      }

      livyClient = _livyClient
      rpcEndpoint = _rpcEndpoint
    }

    connectMethod = Some(_connectMethod)
  }

  def connect(): Unit = {
    val func = connectMethod.getOrElse {
      sys.error("init() should be called before connect() called.")
    }
    func()
  }

  def ask(message: AnyRef): AnyRef = {
    var failCount = 0
    var success = false
    var result: AnyRef = null
    while (!success) {
      try {
        result = rpcEndpoint.askSync[AnyRef](message)
        success = true
      } catch {
        case NonFatal(_) if failCount < 3 =>
          logWarning("Spark Netty RPC failed, so try to start a Spark job again...")
          failCount += 1
          connect()
        case e =>
          logError(s"Spark Netty RPC failed ${sqlConf.sqlServerLivyRpcFailThreshold} times")
          throw e
      }
    }
    result
  }

  def stop(): Unit = {
    if (livyClient != null) {
      livyClient.stop(true)
    }
  }
}

object LivyProxyContext extends Logging {

  @annotation.tailrec
  def retryRandom[T](numRetriesLeft: Int, maxBackOffMillis: Int)(expression: => T): T = {
    util.Try { expression } match {
      // The function succeeded, evaluate to x
      case util.Success(x) => x

      // The function failed, either retry or throw the exception
      case util.Failure(e) => e match {
        // Retry: Throttling or other Retryable exception has occurred
        case _: RuntimeException | _: ExecutionException if numRetriesLeft > 1 =>
          val backOffMillis = Random.nextInt(maxBackOffMillis)
          Thread.sleep(backOffMillis)
          logWarning(s"Retryable Exception: Random backOffMillis=$backOffMillis")
          retryRandom(numRetriesLeft - 1, maxBackOffMillis)(expression)

        // Throw: Unexpected exception has occurred
        case _ => throw e
      }
    }
  }
}
