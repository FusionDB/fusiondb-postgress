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

import cn.fusiondb.common.internal.Logging
import cn.fusiondb.dsl.parser.SqlBaseParser.SingleStatementContext
import cn.fusiondb.dsl.parser.{SqlBaseBaseVisitor, SqlBaseParser}
import cn.fusiondb.fql.internal.SQLConf
import org.antlr.v4.runtime.tree.ParseTree

class AstBuilder(conf: SQLConf) extends SqlBaseBaseVisitor[AnyRef] with Logging {

  def this() = this(new SQLConf())

  protected def typedVisit[T](ctx: ParseTree): T = {
    ctx.accept(this).asInstanceOf[T]
  }

  /**
    * @param ctx the parse tree
    *     */
  override def visitSingleStatement(ctx: SingleStatementContext): SqlBaseParser = {
    visit(ctx.statement).asInstanceOf[SqlBaseParser]
  }
}
