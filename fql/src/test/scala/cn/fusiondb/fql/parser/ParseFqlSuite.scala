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

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.hive.test.TestHive
import org.apache.spark.sql.internal.SQLConf
import org.scalatest.{BeforeAndAfterAll, FunSuite}

class ParseFqlSuite extends FunSuite with BeforeAndAfterAll {

  val spark = SparkSession.builder.master("local").appName("ParseFql").getOrCreate()

  lazy val fql = new FqlParse(new SQLConf(), spark)
  lazy val pql = new PgParse(new SQLConf())

  lazy val sqlContext = TestHive

  override protected def beforeAll() : Unit = {
    super.beforeAll()
  }

  def assertValidSQLString(sparkSql: String, pgSql: String): Unit = {
    fql.parsePlan(sparkSql)
    fql.parsePlan(pgSql)
  }

  def assertValidSQLStringForPg(sparkSql: String, pgSql: String): Unit = {
    val p1 = pql.parsePlan(sparkSql)
    val p2 = pql.parsePlan(pgSql)
    print(p2.treeString)
  }

  test("pql parse") {
    assertValidSQLStringForPg(
      "load 'file:///data/github/fusiondb/data/csv' format csv options('inferSchema'='true', 'header'='true') as t1",
      "SAVE append T1 TO 'file:///data/github/fusiondb/data/csv/t1' FORMAT CSV options('inferSchema'='true', 'header'='true')"
    )
  }

  test("~") {
    assertValidSQLString(
      "SELECT * FROM testData WHERE value RLIKE 'abc'",
      "SELECT * FROM testData WHERE value=10",
    )
  }

  test("load & save file") {
    assertValidSQLString(
      "load 'file:///data/github/fusiondb/data/csv' format csv options('inferSchema'='true', 'header'='true') as t1",
      "SAVE APPEND T1 TO 'file:///data/github/fusiondb/data/csv/t1' FORMAT PARQUET"
    )
  }

  override protected def afterAll(): Unit = {
    spark.close()
  }
}
