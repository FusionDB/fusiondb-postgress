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
import org.apache.spark.sql.functions._
import org.apache.spark.sql.streaming.StreamingQueryListener
import org.apache.spark.sql.streaming.StreamingQueryListener.{QueryProgressEvent, QueryStartedEvent, QueryTerminatedEvent}
import org.apache.spark.sql.types._

case class LoadDataExtendsCommand(
          source: String,
          formatType: String,
          tableName: TableIdentifier,
          options: Map[String, String]) extends RunnableCommand {
  override def run(sparkSession: SparkSession): Seq[Row] = {
    source.split(":")(0) match {
      case "mysql" | "oracle" | "postgresql" | "db2" | "teradata" | "sqlserver" =>
        sparkSession.read.format("jdbc")
          .options(options)
          .load()
          .createOrReplaceTempView(tableName.table)
      case "hdfs" | "s3" | "adls" | "file" =>
        sparkSession.read.format(formatType)
          .options(options)
          .load(source)
          .createOrReplaceTempView(tableName.table)
      case "kafka" =>
        import sparkSession.implicits._

        val table = tableName.table

        val struct = new StructType()
          .add("user", DataTypes.StringType)
          .add("age", DataTypes.StringType)
          .add("ts", DataTypes.StringType)
          .add("record_time", DataTypes.StringType)
          .add("sex", DataTypes.StringType)

        val st = sparkSession.readStream.format("kafka")
          .options(options)
          .load()
          .withWatermark("timestamp", "1 minutes")
          .selectExpr("CAST(value AS STRING)")
          .select(from_json($"value", struct).as(table))
          .selectExpr(s"$table.*")
          .createOrReplaceTempView(table)

        val ds = sparkSession.sql(s"select count(*) from $table")
            ds.writeStream
              .outputMode("complete")
              .format("console")
              .start()
              .awaitTermination()
      case _ =>
        throw new Exception(s"Unsupported datasource $source")
    }
    Seq.empty[Row]
  }
}

case class SaveDataExtendsCommand(
          source: String,
          mode: String,
          formatType: String,
          viewTable: TableIdentifier,
          options: Map[String, String]) extends RunnableCommand {
  override def run(sparkSession: SparkSession): Seq[Row] = {
    val tableViewName = viewTable.table
    val vt = sparkSession.sql(s"select * from $tableViewName")
    source.split(":")(0) match {
      case "mysql" | "oracle" | "postgresql" | "db2" | "teradata" | "sqlserver" =>
        if (mode.isEmpty) {
          vt.write.format("jdbc")
            .options(options)
            .save()
        } else {
          vt.write.format("jdbc")
            .options(options)
            .mode(mode)
            .save()
        }
      case "hdfs" | "s3" | "adls" | "file" =>
        if (mode.isEmpty) {
          vt.write.format(formatType).options(options).save(source)
        } else {
          vt.write.format(formatType).options(options).mode(mode).save(source)
        }
      case _ =>
        throw new Exception(s"Unsupported datasource $source")
    }
    Seq.empty[Row]
  }
}