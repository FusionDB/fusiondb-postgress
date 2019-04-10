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

import cn.fusiondb.core.execution.command.{LoadDataCommand, SaveDataCommand}
import cn.fusiondb.dsl.parser.SqlBaseParser
import cn.fusiondb.dsl.parser.SqlBaseParser.TablePropertyListContext
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.execution.command.ResetCommand
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

  override def visitLoadDataExtends(ctx: SqlBaseParser.LoadDataExtendsContext): LogicalPlan = withOrigin(ctx) {
    val options = Option(ctx.options).map(visitPropertyKeyValues).getOrElse(Map.empty)
    LoadDataCommand(
      sourceType = Option(ctx.sourceType).map(st => st.getText.toLowerCase).getOrElse(""),
      formatType = Option(ctx.`type`).map(st => st.getText.toLowerCase).getOrElse(""),
      path = Option(ctx.path).map(st => st.getText.toLowerCase).getOrElse("").replace("'",""),
      tableName = visitTableIdentifier(ctx.tableIdentifier()),
      options).run(sparkSession)
    ResetCommand
  }

  override def visitSaveData(ctx: SqlBaseParser.SaveDataContext) : LogicalPlan = withOrigin(ctx) {
    val options = Option(ctx.options).map(visitPropertyKeyValues).getOrElse(Map.empty)
    val partitionByColumn = ctx.identifier()
    SaveDataCommand(
      sourceType = Option(ctx.sourceType).map(st => st.getText.toLowerCase).getOrElse(""),
      mode = Option(ctx.saveMode).map(st => st.getText.toLowerCase).getOrElse(""),
      formatType = Option(ctx.`type`).map(st => st.getText.toLowerCase).getOrElse(""),
      path = Option(ctx.path).map(st => st.getText.toLowerCase).getOrElse("").replace("'",""),
      viewTable = visitTableIdentifier(ctx.tableName),
      options).run(sparkSession)
    ResetCommand
  }

  /**
    * Parse a key-value map from a [[TablePropertyListContext]], assuming all values are specified.
    */
  private def visitPropertyKeyValues(ctx: TablePropertyListContext): Map[String, String] = {
    val props = ctx.tableProperty()
    var map: Map[String, String] = Map()
    for (i <- 0 to props.size()-1) {
      map += (props.get(i).key.start.getText -> props.get(i).value.getStart.getText)
    }
    map
  }

}
