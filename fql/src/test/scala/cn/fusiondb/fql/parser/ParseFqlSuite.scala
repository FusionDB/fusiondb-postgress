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

  lazy val parser = new FqlParse(new SQLConf(), spark)
  lazy val sqlContext = TestHive

  override protected def beforeAll() : Unit = {
    super.beforeAll()
  }

  def assertValidSQLString(sparkSql: String, pgSql: String): Unit = {
    parser.parsePlan(sparkSql)
    parser.parsePlan(pgSql)
  }

  test("~") {
    assertValidSQLString(
      "SELECT * FROM testData WHERE value RLIKE 'abc'",
      "SELECT * FROM testData WHERE value=10",
    )
  }

  test("load & save file") {
    assertValidSQLString(
      "LOAD 'LOCAL'.'/data/github/fusiondb/data/csv' FORMAT 'CSV' OPTIONS(inferSchema=true, header=true) AS T1",
      "SAVE T1 TO 'LOCAL'.'/data/github/fusiondb/data/csv/t1' FORMAT 'PARQUET'"
    )
  }

  override protected def afterAll(): Unit = {
    spark.close()
  }
}
