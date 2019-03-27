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

import org.apache.spark.sql.catalyst.TableIdentifier
import org.apache.spark.sql.{DataFrame, SparkSession}

case class ReigsterTableCommand(dataFrame: DataFrame, tableName: String) extends RunnableCommand {
  override def run(sparkSession: SparkSession): Unit = {
    dataFrame.createTempView(tableName)
  }
}

case class LoadDataCommand(
     dataSource: String,
     formatType: String,
     path: String,
     tableName: TableIdentifier,
     options: Map[String, String]) extends RunnableCommand {
  override def run(sparkSession: SparkSession): Unit = {
    if (path != null) {
      val df = sparkSession.read.format(formatType).options(options).load(path)
      df.createTempView(tableName.table)
    } else {
      val df = sparkSession.read.format(formatType).options(options).load()
      df.createTempView(tableName.table)
    }
  }
}

case class SaveDataCommand(
                            dataSource: String,
                            formatType: String,
                            path: String,
                            viewTable: TableIdentifier,
                            tableName: TableIdentifier,
                            options: Map[String, String]) extends RunnableCommand {
  override def run(sparkSession: SparkSession): Unit = {
    if (path != null) {
      val vTable = sparkSession.sql("select * from "+viewTable.table)
      vTable.write.format(formatType).options(options).save(path)
    } else {
      val vTable = sparkSession.sql("select * from "+viewTable.table)
      vTable.write.format(formatType).options(options).save()
    }
  }
}

case class SelectTableCommand(cmd: String) extends RunnableCommand {
  override def run(sparkSession: SparkSession): DataFrame = {
    sparkSession.sql(cmd)
  }
}

case class InsertTableCommand() extends RunnableCommand {
  override def run(sparkSession: SparkSession): Unit = {

  }
}