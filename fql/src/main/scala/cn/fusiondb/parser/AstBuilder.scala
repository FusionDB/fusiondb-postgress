package cn.fusiondb.parser

import cn.fusiondb.dsl.parser.SqlBaseParser.SingleStatementContext
import cn.fusiondb.dsl.parser.{SqlBaseBaseVisitor, SqlBaseParser}
import org.antlr.v4.runtime.tree.ParseTree
import org.apache.spark.internal.Logging
import org.apache.spark.sql.internal.SQLConf

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
