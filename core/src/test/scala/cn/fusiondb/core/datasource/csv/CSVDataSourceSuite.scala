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

package cn.fusiondb.core.datasource.csv

import java.io.File

import org.apache.commons.io.FileUtils
import org.apache.spark.sql.SparkSession
import org.scalatest.{BeforeAndAfterAll, FunSuite}

import scala.reflect.io.Directory

/**
  * CSV Data Source Test
  */
class CSVDataSourceSuite extends FunSuite with BeforeAndAfterAll{

  override protected def beforeAll(): Unit = {
    FileUtils.deleteDirectory(new File(output))
  }

  val spark = SparkSession.builder.master("local").appName("CSVDataSourceSuite").getOrCreate()
  val path = "/data/github/fusiondb/data/csv"
  val output = path+"/output"
  val csvOptioin = Map("inferSchema" -> "true", "header" -> "true")

  test("read csv file") {
    val csvRead = OptionsCSVDataSource.readFile(spark, path, csvOptioin)
    assert(csvRead.count() == 2)
    assert(csvRead.schema.size == 17)
  }

  test("write csv file") {
    val csvRead = OptionsCSVDataSource.readFile(spark, path, csvOptioin)
    OptionsCSVDataSource.writeFile(csvRead, output, csvOptioin)
  }

  override protected def afterAll(): Unit = {
    FileUtils.deleteDirectory(new File(output))
    spark.close()
  }
}
