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

import java.sql.ResultSet
import java.util.Optional

import ru.yandex.clickhouse.{BalancedClickhouseDataSource, ClickHouseConnection}
import ru.yandex.clickhouse.settings.ClickHouseProperties

import org.apache.spark.internal.Logging
import org.apache.spark.sql.SaveMode
import org.apache.spark.sql.catalyst.InternalRow
import org.apache.spark.sql.catalyst.util.DateTimeUtils
import org.apache.spark.sql.execution.datasources.jdbc.JdbcUtils
import org.apache.spark.sql.jdbc.JdbcDialects
import org.apache.spark.sql.sources.v2._
import org.apache.spark.sql.sources.v2.reader._
import org.apache.spark.sql.sources.v2.writer._
import org.apache.spark.sql.types._

class Clickhouse extends DataSourceV2 with ReadSupport with WriteSupport {

  override def createReader(options: DataSourceOptions) : DataSourceReader = {
    new ClickHouseJdbcReader(options.asMap())
  }

  override def createWriter(
               writeUUID: String,
               schema: StructType,
               mode: SaveMode,
               options: DataSourceOptions): Optional[DataSourceWriter] = {
    Optional.of(new JdbcDataSourceWriter(schema, mode, options.asMap()))
  }
}

class ClickHouseJdbcReader(options: java.util.Map[String, String])
  extends DataSourceReader with SupportsPushDownRequiredColumns with Logging {
  val conn = new ClickhouseUtil(options).init()

  logInfo("Connected to ClickHouse successfully.")

  val rs = conn.createStatement().executeQuery(s"SELECT * FROM ${options.get("dbtable")} WHERE 1=0")

  override def readSchema(): StructType =
    JdbcUtils.getSchema(rs, JdbcDialects.get("jdbc:clickhouse"))

  override def planInputPartitions(): java.util.ArrayList[InputPartition[InternalRow]] = {
    val factoryList = new java.util.ArrayList[InputPartition[InternalRow]]
    factoryList.add(new ClickHouseDataSourcePartition(options))
    factoryList
  }

  override def pruneColumns(requiredSchema: StructType): Unit = {
    this.readSchema()
  }
}

class ClickHouseDataSourcePartition(options: java.util.Map[String, String])
  extends InputPartition[InternalRow]  {
  override def createPartitionReader():
    InputPartitionReader[InternalRow] = new ClickHousePartitionReader(options)
}

class ClickHousePartitionReader(options: java.util.Map[String, String])
  extends InputPartitionReader[InternalRow] {
  val conn = new ClickhouseUtil(options).init()
  val rs = conn.createStatement().executeQuery("select * from test_all limit 110")

  override def next: Boolean = rs.next()

  override def get: InternalRow = {
    InternalRow.fromSeq(resultSetToObjectArray(rs))
  }

  override def close(): Unit = {
    conn.close()
  }

  private def resultSetToObjectArray(rs: ResultSet): Array[Any] = {
    Array.tabulate[Any](rs.getMetaData.getColumnCount)(
      i => {
        val col = rs.getMetaData.getColumnTypeName(i + 1)
        col match {
          case "UInt8" => rs.getLong(i + 1)
          case "UInt16" => rs.getLong(i + 1)
          case "UInt32" => rs.getLong(i + 1)
          case "UInt64" => Decimal.apply(rs.getBigDecimal(i + 1))
          case "Int8" => rs.getInt(i + 1)
          case "Int16" => rs.getInt(i + 1)
          case "Int32" => rs.getInt(i + 1)
          case "Int64" => rs.getLong(i + 1)
          case "String" => org.apache.spark.unsafe.types.UTF8String
            .fromBytes(rs.getString(i + 1).getBytes)
          case "Float32" => rs.getFloat(i + 1)
          case "Float64" => rs.getDouble(i + 1)
          case col if col.startsWith("Decimal") => Decimal.apply(rs.getBigDecimal(i + 1))
          case "Date" => DateTimeUtils.fromJavaDate(rs.getDate(i + 1))
          case "DateTime" => DateTimeUtils.fromJavaTimestamp(rs.getTimestamp(i + 1))
          case _ => throw new IllegalArgumentException(s"Unsupported type ${col}")
        }
      }
    )
  }
}

class JdbcDataSourceWriter(
                            schema: StructType,
                            mode: SaveMode,
                            options: java.util.Map[String, String]
                          )
  extends DataSourceWriter with Logging {

  override def commit(messages: Array[WriterCommitMessage]): Unit = {
    logInfo("Write data to clickhouse successfully.")
  }

  override def createWriterFactory(): DataWriterFactory[InternalRow] = {
    new JdbcDataWriterFactory(schema, mode, options)
  }

  override def abort(messages: Array[WriterCommitMessage]): Unit = {
    logError("Write data to clickhouse failed.")
  }
}

class JdbcDataWriterFactory (
                              schema: StructType,
                              mode: SaveMode,
                              options: java.util.Map[String, String]
                            )
  extends DataWriterFactory[InternalRow] {

  override def createDataWriter(partitionId: Int, taskId: Long, epochId: Long):
  DataWriter[InternalRow] = {
    new JdbcDataWriter(schema, mode, options)
  }
}

class JdbcDataWriter (schema: StructType, mode: SaveMode, options: java.util.Map[String, String])
  extends DataWriter[InternalRow] with Logging {
  var counter = 0
  var batchSize = options.getOrDefault("batchsize", "10000").toInt
  val conn = new ClickhouseUtil(options).init()
  val dbtable = options.get("dbtable")

  val statement = conn.prepareStatement(generateInsertStatment(schema, dbtable))
  schema.printTreeString()

  override def commit(): WriterCommitMessage = {
    statement.executeBatch()
    conn.commit()
    conn.close()
    null
  }

  override def abort(): Unit = {
    conn.rollback()
    conn.close()
    logError("Write failed, rollback this write.")
  }

  override def write(record: InternalRow): Unit = {
    counter += 1

    schema.foreach{
      s =>
        val fieldIdx = schema.fieldIndex(s.name)
        val fieldVal = convertDateType(s.dataType, record, fieldIdx)

        if(fieldVal != null) {
          statement.setObject(fieldIdx + 1, fieldVal)
        }
        else {
          val defVal = nullSafeConvert(s.dataType, fieldVal)
          statement.setObject(fieldIdx, defVal)
        }
    }
    statement.addBatch()

    if(counter >= batchSize) {
      val r = statement.executeBatch()
      conn.commit()
      statement.clearBatch()
      counter = 0
    }
  }

  private def generateInsertStatment(
                                      schema: StructType,
                                      dbtable: String
                                    ) = {
    val columns = schema.map(f => f.name).toList
    val vals = 1 to (columns.length) map (i => "?")
    s"INSERT INTO $dbtable (${columns.mkString(",")}) VALUES (${vals.mkString(",")})"
  }

  private def nullSafeConvert(sparkType: DataType, v: Any) = sparkType match {
    case DoubleType => null
    case LongType => null
    case FloatType => null
    case IntegerType => null
    case StringType => null
    case BooleanType => false
    case _ => null
  }

  // Convert the clickhouse datatype from spark datatype.
  private def convertDateType(
                               sparkType: DataType,
                               row: InternalRow,
                               ordinal: Int
                             ) = sparkType match {
    case StringType => row.getString(ordinal)
    case IntegerType => row.getInt(ordinal)
    case FloatType => row.getFloat(ordinal)
    case LongType => row.getLong(ordinal)
    case BooleanType => row.getBoolean(ordinal)
    case DoubleType => row.getDouble(ordinal)
    case DateType =>
      DateTimeUtils.toJavaDate(row.get(ordinal, sparkType).asInstanceOf[Integer])
    case TimestampType =>
      DateTimeUtils.toJavaTimestamp(row.get(ordinal, sparkType).asInstanceOf[Long])
    case _ : DecimalType => Decimal.apply(row.get(ordinal, sparkType).toString).toJavaBigDecimal
    case _ => throw new IllegalArgumentException(s"Unsupported type ${sparkType.typeName}")
  }
}

class ClickhouseUtil(options: java.util.Map[String, String]) {

  def init(): ClickHouseConnection = {
    val properties = new ClickHouseProperties
    properties.setMaxThreads(3)
    properties.setSocketTimeout(67890)
    properties.setUser(options.get("user"))
    properties.setPassword(options.get("password"))

    val dataSource = new BalancedClickhouseDataSource(options.get("url"), properties)
    dataSource.getConnection
  }

}