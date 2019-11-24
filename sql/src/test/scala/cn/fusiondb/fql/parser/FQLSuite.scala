/*
 * Copyright 2019 Fusionlab, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.fusiondb.fql.parser

import org.scalatest.BeforeAndAfterAll

import org.apache.spark.SparkFunSuite
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.hive.test.TestHive
import org.apache.spark.sql.internal.SQLConf

class FQLSuite extends SparkFunSuite with BeforeAndAfterAll {

  val spark = SparkSession.builder.master("local")
    .appName("FQLSuite")
//    .enableHiveSupport()
    .getOrCreate()

  lazy val fql = new FqlParse(new SQLConf(), spark)
  lazy val pql = new PgParse(new SQLConf())

  lazy val sqlContext = TestHive

  override protected def beforeAll() : Unit = {
    super.beforeAll()
  }

  def assertValidSQLString(sparkSql: String, pgSql: String): Unit = {
    var p1 = fql.parsePlan(sparkSql)
    var p2 = fql.parsePlan(pgSql)
    // println(p1.treeString)
    // println(p2.treeString)
  }

  def assertValidSQLStringForPg(sparkSql: String, pgSql: String): Unit = {
    // spark.sql("create table if not exists t1(a int,b string,c int)")
    val p1 = pql.parsePlan(sparkSql)
    val qe = spark.sessionState.executePlan(p1)
    qe.assertAnalyzed()
    // println(qe.optimizedPlan.numberedTreeString)

    val rdd = qe.executedPlan.execute()

    val p2 = pql.parsePlan(pgSql)
     val qe2 = spark.sessionState.executePlan(p2)
     qe2.assertAnalyzed()
     // println(qe2.optimizedPlan.numberedTreeString)

     val rdd2 = qe2.executedPlan.execute()
     // println(rdd2.collect().foreach(println))
  }

  test("load kafka data") {
    assertValidSQLStringForPg(
      "load kafka " +
        "options('KAFKA.bootstrap.servers'='192.168.0.191:9092', 'subscribe'='topic_xu', " +
        "'startingOffsets'='earliest') as T1",
      "SAVE T1 TO 'hdfs://192.168.0.210:8020/tmp/t2' FORMAT delta"
    )
  }

  test("testing write delta") {
    assertValidSQLStringForPg(
      """
        | load 'file:///data/github/fusiondb/data/csv'
        |   format csv
        |   options(
        |     inferSchema=true,
        |     header=true
        |   ) as t1
      """.stripMargin,
      """
        | save overwrite t1
        |   to 'file:///data/github/fusiondb/data/delta'
        |   format delta
      """.stripMargin
    )
  }

  test("testing read delta") {
    assertValidSQLStringForPg(
      """
        | load 'file:///data/github/fusiondb/data/delta'
        |   format delta
        |   as t1
      """.stripMargin,
      "select * from t1"
    )
  }

  test("load in sqlserver") {
    assertValidSQLStringForPg(
      """
        | load sqlserver
        |   options(
        |     'url'='jdbc:sqlserver://192.168.0.116:1433',
        |     'database'='test',
        |     'dbtable'='types_tab',
        |     'user'='SA',
        |     'password'='@123'
        |     ) AS sqlserver_t1
      """.stripMargin,
      "SAVE sqlserver_t1 TO 'file:///data/github/fusiondb/data/csv/sqlserver_t1' FORMAT csv"
    )
  }

  test("load in teradata") {
    assertValidSQLStringForPg(
      """
        | load teradata
        |   options(
        |     'url'='jdbc:teradata://192.168.0.112/database=test,CHARSET=UTF8,TMODE=TERA',
        |     'dbtable'='csv_case_1',
        |     'user'='dbc',
        |     'password'='dbc'
        |     ) AS tera_t1
      """.stripMargin,
      "SAVE tera_t1 TO 'file:///data/github/fusiondb/data/csv/tera_t1' FORMAT csv"
    )
  }

  test("load in db2") {
    assertValidSQLStringForPg(
      """
        | load db2
        |   options(
        |     'url'='jdbc:db2://192.168.0.11:50001/tdb',
        |     'dbtable'='TEST',
        |     'user'='db2user',
        |     'password'='db2@123'
        |     ) AS db2_t1
      """.stripMargin,
      "SAVE db2_t1 TO 'file:///data/github/fusiondb/data/csv/db2_t1' FORMAT csv"
    )
  }

  test("load in oracle") {
    assertValidSQLStringForPg(
      """
        | load oracle
        |   options(
        |     'url'='jdbc:oracle:thin:@//192.65.23.122:49161/xe',
        |     'dbtable'='TEST20',
        |     'user'='TEST',
        |     'password'='12345'
        |     ) AS ora_t1
      """.stripMargin,
      "SAVE ora_t1 TO 'file:///data/github/fusiondb/data/csv/ora_t1' FORMAT csv"
    )
  }

  test("load csv & save parquet") {
    assertValidSQLStringForPg(
      """
        | load 'file:///data/github/fusiondb/data/csv'
        |   format csv
        |   options('inferSchema'='true', 'header'='true') as t1
      """.stripMargin,
      "SAVE APPEND T1 TO 'file:///data/github/fusiondb/data/csv/t1' FORMAT PARQUET"
    )
  }

  test("~") {
    assertValidSQLString(
      "SELECT * FROM testData WHERE value RLIKE 'abc'",
      "LOAD DATA LOCAL INPATH 'file:///data/github/fusiondb/data/csv/t1' OVERWRITE INTO TABLE pokes"
    )
  }

  test("load in kafka") {
    assertValidSQLStringForPg(
      """
        | load kafka format json
        |   options(
        |    'kafka.bootstrap.servers'='172.27.137.232:6667',
        |    'subscribe'='topic1', 'startingOffsets'='earliest',
        |    'startingOffsets'='earliest',
        |    'columns'='ts STRING, user string, age string, sex string, record_time string'
        |   ) as test
      """.stripMargin,
      "select * from test")
  }

  override protected def afterAll(): Unit = {
    spark.close()
  }
}
