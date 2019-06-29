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

import cn.fusiondb.dsl.parser.SqlBaseParser
import cn.fusiondb.dsl.parser.SqlBaseParser.{LoadDataExtendsContext, SaveDataContext, TablePropertyListContext}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.fdb.parser.{AbstractSqlParser, AstBuilder}
import org.apache.spark.sql.internal.{SQLConf, VariableSubstitution}

class FqlParse(conf: SQLConf, sparkSession: SparkSession) extends AbstractSqlParser {
  val astBuilder = new FqlAstBuilder(conf, sparkSession)

  private val substitutor = new VariableSubstitution(conf)

  protected override def parse[T](command: String)(toResult: SqlBaseParser => T): T = {
    val cmd = substitutor.substitute(command)
    super.parse(cmd)(toResult)
  }
}

/**
  * Builder that converts an ANTLR ParseTree into a LogicalPlan/Expression/TableIdentifier.
  */
class FqlAstBuilder(conf: SQLConf, sparkSession: SparkSession) extends AstBuilder(conf) {
  import org.apache.spark.sql.catalyst.parser.ParserUtils._

  override def visitLoadDataExtends(ctx: LoadDataExtendsContext): LogicalPlan = withOrigin(ctx) {
    val options = Option(ctx.options).map(visitPropertyKeyValues).getOrElse(Map.empty)
    LoadDataExtendsCommand(
      source = ctx.source.getText.replace("'", "").toLowerCase,
      formatType = Option(ctx.`type`).map(st => st.getText.toLowerCase).getOrElse(""),
      tableName = visitTableIdentifier(ctx.tableIdentifier()),
      options)
  }

  override def visitSaveData(ctx: SaveDataContext) : LogicalPlan = withOrigin(ctx) {
    val options = Option(ctx.options).map(visitPropertyKeyValues).getOrElse(Map.empty)
    val partitionByColumn = ctx.identifier()
    SaveDataExtendsCommand(
      source = ctx.source.getText.replace("'", "").toLowerCase,
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
      map += (props.get(i).key.start.getText.replace("'", "").toLowerCase
        -> props.get(i).value.getStart.getText.replace("'", "").toLowerCase)
    }
    map
  }

}
