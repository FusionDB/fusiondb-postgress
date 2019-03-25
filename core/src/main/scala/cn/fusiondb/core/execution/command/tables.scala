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

package cn.fusiondb.core.execution.command

import cn.fusiondb.core.datasource.csv.OptionsCSVDataSource
import org.apache.spark.sql.{DataFrame, SparkSession}

case class ReigsterTableCommand(dataFrame: DataFrame, tableName: String) extends RunnableCommand{
  override def run(sparkSession: SparkSession): Unit = {
    dataFrame.createTempView(tableName)
  }
}

case class SelectTableCommand(cmd: String) extends RunnableCommand{
  override def run(sparkSession: SparkSession): DataFrame = {
    sparkSession.sql(cmd)
  }
}

case class InsertTableCommand() extends RunnableCommand{
  override def run(sparkSession: SparkSession): Unit = {

  }
}

case class LoadFileCommand(path: String, option: Map[String, String]) extends RunnableCommand{
  override def run(sparkSession: SparkSession): DataFrame = {
    OptionsCSVDataSource.readFile(sparkSession, path, option)
  }
}

case class LoadJdbcCommand() extends RunnableCommand{
  override def run(sparkSession: SparkSession): Unit = {

  }
}

case class SaveJdbcCommand() extends RunnableCommand{
  override def run(sparkSession: SparkSession): Unit = {

  }
}

case class SaveFileCommand(dataFrame: DataFrame, path: String, option: Map[String, String]) extends RunnableCommand{
  override def run(sparkSession: SparkSession): Unit = {
    OptionsCSVDataSource.writeFile(dataFrame, path, option)
  }
}