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

import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.catalyst.TableIdentifier
import org.apache.spark.sql.execution.command.RunnableCommand

case class LoadDataExtendsCommand(
          sourceType: String,
          formatType: String,
          path: String,
          tableName: TableIdentifier,
          options: Map[String, String]) extends RunnableCommand {
  override def run(sparkSession: SparkSession): Seq[Row] = {
    if (path != null) {
      val df = sparkSession.read.format(formatType).options(options).load(path)
      df.createTempView(tableName.table)

    } else {
      val df = sparkSession.read.format(formatType).options(options).load()
      df.createTempView(tableName.table)
    }
    Seq.empty[Row]
  }
}

case class SaveDataExtendsCommand(
          sourceType: String,
          mode: String,
          formatType: String,
          path: String,
          viewTable: TableIdentifier,
          options: Map[String, String]) extends RunnableCommand {
  override def run(sparkSession: SparkSession): Seq[Row] = {
    if (path != null) {
      val vt = sparkSession.sql("select * from "+viewTable.table)
      if (mode.isEmpty) {
        vt.write.format(formatType).options(options).mode("errorifexists").save(path)
      } else {
        vt.write.format(formatType).options(options).mode(mode).save(path)
      }
    } else {
      val vt = sparkSession.sql("select * from "+viewTable.table)
      if (mode.isEmpty) {
        vt.write.format(formatType).options(options).mode("errorifexists").save()
      } else {
        vt.write.format(formatType).options(options).mode(mode).save()
      }
    }
    Seq.empty[Row]
  }
}