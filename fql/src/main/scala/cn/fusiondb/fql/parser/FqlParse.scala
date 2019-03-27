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

import cn.fusiondb.core.execution.command.LoadDataCommand
import cn.fusiondb.dsl.parser.SqlBaseParser
import org.apache.spark.sql.catalyst.plans.logical.LogicalPlan
import org.apache.spark.sql.execution.command.ResetCommand
import org.apache.spark.sql.fdb.parser.{AbstractSqlParser, AstBuilder}
import org.apache.spark.sql.internal.{SQLConf, VariableSubstitution}

class FqlParse(conf: SQLConf) extends AbstractSqlParser {
  val astBuilder = new FqlAstBuilder(conf)

  private val substitutor = new VariableSubstitution(conf)

  protected override def parse[T](command: String)(toResult: SqlBaseParser => T): T = {
    val cmd = substitutor.substitute(command)
    super.parse(cmd)(toResult)
  }
}

/**
  * Builder that converts an ANTLR ParseTree into a LogicalPlan/Expression/TableIdentifier.
  */
class FqlAstBuilder(conf: SQLConf) extends AstBuilder(conf) {
  import org.apache.spark.sql.catalyst.parser.ParserUtils._

  override def visitLoadDataExtends(ctx: SqlBaseParser.LoadDataExtendsContext): LogicalPlan = withOrigin(ctx) {
    val options = Option(ctx.options)
    LoadDataCommand(
      dataSource = ctx.dataSource.getText,
      formatType = ctx.`type`.getText,
      path = ctx.path.getText,
      tableName = visitTableIdentifier(ctx.tableIdentifier()),
      Map("a" -> "b"))
    ResetCommand
  }

  override def visitSaveData(ctx: SqlBaseParser.SaveDataContext) : LogicalPlan = withOrigin(ctx) {
    ResetCommand
  }
}
