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

import cn.fusiondb.common.internal.Logging
import org.apache.spark.sql.{DataFrame, SparkSession}
/*
  * CSV Data Source
 */
abstract class CSVDataSource extends Serializable with Logging{
  def readFile(sparkSession: SparkSession, path: String, option: Map[String, String]): DataFrame
  def writeFile(dataFrame: DataFrame, path: String, option: Map[String, String]): Unit
}

object OptionsCSVDataSource extends CSVDataSource{
  var fileFormat = "csv"
  override def readFile(sparkSession: SparkSession, path: String, option: Map[String, String]): DataFrame = {
    sparkSession.read.format(fileFormat).options(option).load(path)
  }

  override def writeFile(dataFrame: DataFrame, path: String, option: Map[String, String]): Unit = {
    dataFrame.write.format(fileFormat).options(option).save(path)
  }
}
