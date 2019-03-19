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

import cn.fusiondb.fql.internal.SQLConf
import org.apache.spark.sql.hive.test.TestHive
import org.scalatest.{BeforeAndAfterAll, FunSuite}

class ParseFqlSuite extends FunSuite with BeforeAndAfterAll {
  lazy val parser = new FqlParse(new SQLConf())
  lazy val sqlContext = TestHive

  override protected def beforeAll() : Unit = {
    super.beforeAll()
  }

  def assertValidSQLString(mySql: String, sparkSql: String): Unit = {
    parser.parse(sparkSql)
  }

  test("~") {
    assertValidSQLString(
      "SELECT * FROM testData WHERE value ~ 'abc'",
      "SELECT * FROM testData WHERE value RLIKE 'abc'"
    )
  }

  test("load") {
    assertValidSQLString(
      "LOAD 'HDFS'.'/usr/test' FORMAT 'CSV' OPTIONS('header'='true') AS T WHERE A=1",
      "SAVE T1 TO 'LOCAL'.'/usr/a' FORMAT 'PARQUET' PARTITION BY COL2"
    )
  }
}
