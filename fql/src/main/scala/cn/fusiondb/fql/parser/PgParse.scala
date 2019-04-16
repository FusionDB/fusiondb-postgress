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

import cn.fusiondb.dsl.parser.SqlBaseParser.{LoadDataExtendsContext, SaveDataContext, TablePropertyListContext}
import org.apache.spark.sql.catalyst.expressions.PredicateHelper
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.fdb.execution.{SparkSqlAstBuilder, SparkSqlParser}
import org.apache.spark.sql.internal.SQLConf

/**
  * Concrete parser for PostgreSQL statements.
  *
  * TODO: We just copy Spark parser files into `org.apache.spark.sql.server.parser.*` and build
  * a new parser for PostgreSQL. So, we should fix this in a pluggable way.
  */
private[fql] class PgParse(conf: SQLConf) extends SparkSqlParser(conf) {
  override val astBuilder = new PgAstBuilder(conf)
}

/**
  * Builder that converts an ANTLR ParseTree into a LogicalPlan/Expression/TableIdentifier.
  */
private[fql] class PgAstBuilder(conf: SQLConf) extends SparkSqlAstBuilder(conf)
  with PredicateHelper {
  import org.apache.spark.sql.catalyst.parser.ParserUtils._

  override def visitLoadDataExtends(ctx: LoadDataExtendsContext): LogicalPlan = withOrigin(ctx) {
    val options = Option(ctx.options).map(visitPropertyKeyValues).getOrElse(Map.empty)
    LoadDataExtendsCommand(
      source = ctx.source.getText.replace("'","").toLowerCase,
      formatType = Option(ctx.`type`).map(st => st.getText.toLowerCase).getOrElse(""),
      tableName = visitTableIdentifier(ctx.tableIdentifier()),
      options)
  }

  override def visitSaveData(ctx: SaveDataContext) : LogicalPlan = withOrigin(ctx) {
    val options = Option(ctx.options).map(visitPropertyKeyValues).getOrElse(Map.empty)
    val partitionByColumn = ctx.identifier()
    SaveDataExtendsCommand(
      source = ctx.source.getText.replace("'","").toLowerCase,
      mode = Option(ctx.saveMode).map(st => st.getText.toLowerCase).getOrElse(""),
      formatType = Option(ctx.`type`).map(st => st.getText.toLowerCase).getOrElse(""),
      viewTable = visitTableIdentifier(ctx.tableName),
      options)
  }

  /**
    * Parse a key-value map from a [[TablePropertyListContext]], assuming all values are specified.
    */
  private def visitPropertyKeyValues(ctx: TablePropertyListContext): Map[String, String] = {
    val props = ctx.tableProperty()
    var map: Map[String, String] = Map()
    for (i <- 0 to props.size()-1) {
      map += (props.get(i).key.start.getText.replace("'","").toLowerCase
        -> props.get(i).value.getStart.getText.replace("'","").toLowerCase)
    }
    map
  }
}