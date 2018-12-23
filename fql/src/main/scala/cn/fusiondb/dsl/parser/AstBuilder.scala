package cn.fusiondb.dsl.parser

import cn.fusiondb.dsl.parser.SqlBaseParser._

import org.antlr.v4.runtime.tree.ParseTree
import org.apache.spark.internal.Logging
import org.apache.spark.sql.catalyst.plans.logical._
import org.apache.spark.sql.internal.SQLConf

class AstBuilder(conf: SQLConf) extends SqlBaseBaseVisitor[AnyRef] with Logging {

  def this() = this(new SQLConf())

  protected def typedVisit[T](ctx: ParseTree): T = {
    ctx.accept(this).asInstanceOf[T]
  }

  /**
    * {@inheritDoc }
    *
    * <p>The default implementation returns the result of calling
    * {@link #visitChildren} on {@code ctx}.</p>
    */
  override def visitSaveData(ctx: SaveDataContext) = super.visitSaveData(ctx)

  /**
    * {@inheritDoc }
    *
    * <p>The default implementation returns the result of calling
    * {@link #visitChildren} on {@code ctx}.</p>
    */
  override def visitLoadDataExtends(ctx: LoadDataExtendsContext) = super.visitLoadDataExtends(ctx)
}
