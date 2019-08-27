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

package cn.fusiondb.spark.source

import org.scalatest.BeforeAndAfterAll

import org.apache.spark.SparkFunSuite
import org.apache.spark.sql.SparkSession

class ClickhouseSourceSuite extends SparkFunSuite with BeforeAndAfterAll {

  val spark = SparkSession.builder.master("local")
    .appName("ClickhouseSourceSuite")
//    .enableHiveSupport()
    .getOrCreate()

  override protected def beforeAll() : Unit = {
    super.beforeAll()
  }

  test("load ClickHouse table") {
    val ckTable = spark.sql(
          """
            | CREATE TEMPORARY table ckTable
            | USING cn.fusiondb.spark.source.Clickhouse
            | OPTIONS (
            |  'url' 'jdbc:clickhouse://localhost:8132/default',
            |  'dbtable' "test_all",
            |  'use' 'default',
            |  'password' ''
            | )
        """.stripMargin)
      ckTable.show()

    val countTable = spark.sql("select * from ckTable")
    countTable.show()
  }

  test("write ClickHouse table") {
    val ckTable = spark.sql(
      """
        | insert into table ckTable
        | values(1, 16, 32, 64, 8, 16, 32, 64, 15.2, 32.4, 'aaa', '0.11', now(), '2011-01-01')
      """.stripMargin)
    ckTable.show()

    val countTable = spark.sql("show tables")
    countTable.show()
  }

  test("~") {
    val df = spark.read.
      format("cn.fusiondb.spark.source.Clickhouse")
      .option("url", "jdbc:clickhouse://localhost:8132/default")
      .option("user", "default")
      .option("password", "")
      .option("dbtable", "test_all")
      .option("query", "select * from test_all")
      .load()

    df.show()

    df.write.format("cn.fusiondb.spark.source.Clickhouse")
      .option("url", "jdbc:clickhouse://localhost:8132/default")
      .option("user", "default")
      .option("password", "")
      .option("dbtable", "default.test_all")
      .option("batchsize", "100")
      .save()
    // df.explain(true)
  }

  override protected def afterAll(): Unit = {
    spark.close()
  }
}
