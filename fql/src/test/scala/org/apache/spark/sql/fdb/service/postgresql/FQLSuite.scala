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

package org.apache.spark.sql.fdb.service.postgresql

import org.scalatest.BeforeAndAfterAll

import org.apache.spark.SparkFunSuite
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.hive.test.TestHive
import org.apache.spark.sql.internal.SQLConf

class FQLSuite extends SparkFunSuite with BeforeAndAfterAll {
  val spark = SparkSession.builder.master("local")
    .appName("ParseFql")
    .enableHiveSupport()
    .getOrCreate()

  lazy val pql = new PgParser(new SQLConf())

  lazy val sqlContext = TestHive

  override protected def beforeAll() : Unit = {
    super.beforeAll()
  }

  def assertValidSQLString(sparkSql: String, pgSql: String): Unit = {
    var p1 = pql.parsePlan(sparkSql)
    var p2 = pql.parsePlan(pgSql)
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

  test("read stream by kafka") {
    assertValidSQLStringForPg("load 'kafka' format json " +
      "options('kafka.bootstrap.servers'='192.168.2.107:6667', " +
      "'subscribe'='topic1', 'startingOffsets'='earliest', " +
      "'columns'='ts STRING, user string, age string, sex string, record_time string') as t1")
    assertValidSQLStringForPg("load 'file:///tmp/delta' format delta as t1")
    assertValidSQLStringForPg("select * from t1")
  }

  def assertValidSQLStringForPg(fql: String): Unit = {
    val p1 = pql.parsePlan(fql)
    val qe = spark.sessionState.executePlan(p1)
    qe.assertAnalyzed()
    println(qe.optimizedPlan.numberedTreeString)

    val rdd = qe.executedPlan.execute()
    println(rdd.collect().foreach(println))
  }

  test("pql parse") {
    assertValidSQLStringForPg(
      "load 'FILE:///data/github/fusiondb/data/csv' format csv " +
        "options(inferSchema=true, header=true) as t1",
      "SAVE APPEND T1 TO 'File:///data/github/fusiondb/data/csv/t1' FORMAT PARQUET"
    )
  }

  test("pql parse in load") {
    assertValidSQLStringForPg(
      "load 'file:///data/github/fusiondb/data/csv' format csv " +
        "options('inferSchema'='true', 'header'='true') as t1",
      "LOAD DATA LOCAL INPATH 'file:///data/github/fusiondb/data/csv/t1' OVERWRITE INTO TABLE pokes"
    )
  }

  test("~") {
    assertValidSQLString(
      "SELECT * FROM testData WHERE value RLIKE 'abc'",
      "LOAD DATA LOCAL INPATH 'file:///data/github/fusiondb/data/csv/t1' OVERWRITE INTO TABLE pokes"
    )
  }

  test("load & save file") {
    assertValidSQLString(
      "load 'file:///data/github/fusiondb/data/csv' format csv " +
        "options('inferSchema'='true', 'header'='true') as t1",
      "SAVE APPEND T1 TO 'file:///data/github/fusiondb/data/csv/t1' FORMAT parquet"
    )
  }

  override protected def afterAll(): Unit = {
    spark.close()
  }
}
