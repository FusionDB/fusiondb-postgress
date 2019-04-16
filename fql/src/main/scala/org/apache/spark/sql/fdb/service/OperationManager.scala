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

package org.apache.spark.sql.fdb.service

import javax.annotation.concurrent.ThreadSafe

import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.expressions.Literal
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.fdb.SQLServerConf._
import org.apache.spark.sql.fdb.SQLServerEnv
import org.apache.spark.sql.types.StructType


sealed trait OperationState
case object INITIALIZED extends OperationState
case object RUNNING extends OperationState
case object FINISHED extends OperationState
case object CANCELED extends OperationState
case object CLOSED extends OperationState
case object ERROR extends OperationState
case object UNKNOWN extends OperationState
case object PENDING extends OperationState

sealed trait OperationType {
  override def toString: String = getClass.getSimpleName.stripSuffix("$")
}

object BEGIN extends OperationType
object FETCH extends OperationType
object SELECT extends OperationType

@ThreadSafe
trait Operation {

  private val timeout = SQLServerEnv.sqlConf.sqlServerIdleOperationTimeout
  private var lastAccessTime: Long = System.currentTimeMillis()

  @volatile protected var state: OperationState = INITIALIZED

  def statementId(): String
  def outputSchema(): StructType
  def prepare(params: Map[Int, Literal]): Unit
  def run(): Iterator[InternalRow]
  def cancel(): Unit
  def close(): Unit

  protected def setState(newState: OperationState): Unit = {
    lastAccessTime = System.currentTimeMillis()
    state = newState
  }

  def isTimeOut(current: Long): Boolean = {
    if (timeout == 0) {
      true
    } else if (timeout > 0) {
      Seq(FINISHED, CANCELED, CLOSED, ERROR).contains(state) &&
        lastAccessTime + timeout <= current
    } else {
      lastAccessTime - timeout <= current
    }
  }
}

object NOP extends Operation {

  override val statementId: String = "nop"
  override val outputSchema: StructType = new StructType()

  override def prepare(params: Map[Int, Literal]): Unit = {}
  override def run(): Iterator[InternalRow] = Iterator.empty
  override def cancel(): Unit = {}
  override def close(): Unit = {}
}

trait OperationExecutor {

  // Creates a new instance for service-specific operations
  def newOperation(
    sessionState: SessionState,
    statementId: String,
    query: (String, LogicalPlan)): Operation
}
