/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql.fdb.service.postgresql

import java.util.Locale

import scala.collection.JavaConverters._
import scala.collection.mutable.Buffer
import org.apache.spark.sql.catalyst.expressions._
import org.apache.spark.sql.catalyst.analysis._
import org.apache.spark.sql.catalyst.expressions.aggregate.{AggregateFunction, First}
import org.apache.spark.sql.catalyst.parser.ParseException
import org.apache.spark.sql.catalyst.plans.logical._
import org.apache.spark.sql.catalyst.FunctionIdentifier
import org.apache.spark.sql.internal.SQLConf
import org.apache.spark.sql.fdb.execution.{SparkSqlAstBuilder, SparkSqlParser}
import org.apache.spark.sql.fdb.catalyst.expressions.ParameterPlaceHolder
import org.apache.spark.sql.fdb.SQLServerConf._
import org.apache.spark.sql.fdb.service.postgresql.execution.command.BeginCommand
import org.apache.spark.sql.types._

import cn.fusiondb.dsl.parser.SqlBaseParser._
import cn.fusiondb.fql.parser.{LoadDataExtendsCommand, SaveDataExtendsCommand}

/**
 * Concrete parser for PostgreSQL statements.
 *
 * TODO: We just copy Spark parser files into `org.apache.spark.sql.server.parser.*` and build
 * a new parser for PostgreSQL. So, we should fix this in a pluggable way.
 */
private[postgresql] class PgParser(conf: SQLConf) extends SparkSqlParser(conf) {
  override val astBuilder = new PgAstBuilder(conf)
}

/**
 * Builder that converts an ANTLR ParseTree into a LogicalPlan/Expression/TableIdentifier.
 */
private[postgresql] class PgAstBuilder(conf: SQLConf) extends SparkSqlAstBuilder(conf)
    with PredicateHelper {
  import org.apache.spark.sql.catalyst.parser.ParserUtils._

  override def visitBeginTransaction(ctx: BeginTransactionContext): LogicalPlan = {
    BeginCommand()
  }

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
    val source = ctx.source.getText.replace("'", "").toLowerCase
    SaveDataExtendsCommand(
      source,
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
      map += (
        props.get(i).key.start
          .getText.replace("'", "") ->
        props.get(i).value.getStart
          .getText.replace("'", "")
        )
    }
    map
  }

  override def visitParamPlaceHolder(ctx: ParamPlaceHolderContext): Expression = withOrigin(ctx) {
    ParameterPlaceHolder(ctx.INTEGER_VALUE.getText.toInt)
  }

  override def visitPrimitiveDataType(ctx: PrimitiveDataTypeContext): DataType = withOrigin(ctx) {
    val dataType = ctx.identifier.getText.toLowerCase(Locale.ROOT)
    (dataType, ctx.INTEGER_VALUE().asScala.toList) match {
      case ("text", Nil) => StringType
      case _ => super.visitPrimitiveDataType(ctx)
    }
  }

  override def visitSubqueryExpression(
      ctx: SubqueryExpressionContext): Expression = withOrigin(ctx) {
    val subQuery = super.visitSubqueryExpression(ctx).asInstanceOf[ScalarSubquery]
    val proj = subQuery.plan.transformDown {
      // TODO: The PostgreSQL JDBC driver (`SQLSERVER_VERSION` = 8.4) issues a query below, but
      // Spark-v2.3 cannot correctly handle correlated sub-queries without aggregate.
      // So, we currently insert a `First` aggregate when hitting that kind of sub-queries.
      //
      // SELECT
      //   a.attname,
      //   pg_catalog.format_type(a.atttypid, a.atttypmod),
      //   (
      //     SELECT
      //       substring(pg_catalog.pg_get_expr(d.adbin, d.adrelid) for 128)
      //     FROM
      //       pg_catalog.pg_attrdef d
      //     WHERE
      //       d.adrelid = a.attrelid
      //         AND d.adnum = a.attnum
      //         AND a.atthasdef
      //   ),
      //   a.attnotnull,
      //   a.attnum,
      //   (
      //     SELECT
      //       c.collname
      //     FROM
      //       pg_catalog.pg_collation c, pg_catalog.pg_type t
      //     WHERE
      //       c.oid = a.attcollation
      //         AND t.oid = a.atttypid
      //         AND a.attcollation <> t.typcollation
      //   ) AS attcollation,
      //   NULL AS indexdef,
      //   NULL AS attfdwoptions
      // FROM
      //   pg_catalog.pg_attribute a
      // WHERE
      //   a.attrelid = '$relOid'
      //     AND a.attnum > 0
      //     AND NOT a.attisdropped;
      //
      case p @ Project(ne :: Nil, child)
        // Since `psql` is used for tests and this is a risky change, this patten is applied
        // when `conf.sqlServerPsqlEnabled` enabled.
        if conf.sqlServerPsqlEnabled &&
          ne.find(_.isInstanceOf[AggregateFunction]).isEmpty &&
          ne.find {
            // TODO: Strictly checks if this is a specific query generated by
            // PostgreSQL JDBC drivers.
            case uf: UnresolvedFunction =>
              uf.name.funcName == "pg_get_expr"
            case u: UnresolvedAttribute =>
              u.nameParts == Seq("c", "collname")
            case _ =>
              false
          }.isDefined =>
        ne.find(_.isInstanceOf[UnresolvedAttribute]).map { attr =>
          val first = First(attr, ignoreNullsExpr = Literal(true))
          val newChild = child.transform {
            case f @ Filter(cond, _) =>
              val origPreds = splitConjunctivePredicates(cond)
              val (newPreds, droppedPreds) = origPreds.partition { expr =>
                expr.isInstanceOf[EqualTo] || expr.isInstanceOf[EqualNullSafe]
              }
              if (droppedPreds.nonEmpty) {
                logWarning(
                  s"""Spark-2.3 does not allow correlated sub-queries to have non-equal predicates,
                     |so we drop non-supported predicates to pass JDBC metadata operations.
                     |The dropped predicates are:
                     |${droppedPreds.mkString(" ")}
                   """.stripMargin)
              }
              f.copy(condition = newPreds.reduce(And))
          }
          val projWithAggregate = Aggregate(
            groupingExpressions = Nil,
            aggregateExpressions = UnresolvedAlias(first.toAggregateExpression()) :: Nil,
            child = newChild)
          logWarning(
            s"""Found a sub-query without aggregate, so we add `First` in the projection:
               |$projWithAggregate
             """.stripMargin)
          projWithAggregate
        }.getOrElse {
          p
        }
    }
    ScalarSubquery(proj)
  }

  override def visitPgStyleCast(ctx: PgStyleCastContext): Expression = withOrigin(ctx) {
    val dataType = ctx.pgDataType.dataType.getText
    dataType.toLowerCase match {
      case "regproc" =>
        val extractName = """['|"](.*)['|"]""".r
        val funcName = ctx.primaryExpression.getText match {
          case extractName(n) => n
          case n => n
        }
        UnresolvedFunction(FunctionIdentifier(funcName), Seq.empty, false)
      case "regtype" =>
        val args = expression(ctx.primaryExpression()) :: Nil
        val funcName = if (ctx.pgDataType.identifier != null) {
          FunctionIdentifier(dataType, Some(ctx.pgDataType.identifier.getText))
        } else {
          FunctionIdentifier(dataType)
        }
        UnresolvedFunction(funcName, args, false)
      case "regclass" =>
        expression(ctx.primaryExpression)
      case _ =>
        Cast(expression(ctx.primaryExpression), typedVisit(ctx.pgDataType().dataType()))
    }
  }

  private def toSparkRange(start: Expression, end: Expression, intvl: Option[Expression]) = {
    // Fill a gap between PostgreSQL `generate_series` and Spark `range` here
    val e = Add(end, Literal(1, IntegerType))
    val args = intvl.map(i => start :: e :: i :: Nil).getOrElse(start :: e :: Nil)
    UnresolvedTableValuedFunction("range", args, Seq.empty)
  }

  override def visitSubstringInternalFunc(ctx: SubstringInternalFuncContext): Expression = {
    withOrigin(ctx) {
      val expr = expression(ctx.primaryExpression)
      val pos = Literal(0, IntegerType)
      val forNum = ctx.INTEGER_VALUE().asScala.toList match {
        case from :: Nil => from
        case _ => throw new ParseException("substring has not an enough parameter for `from`", ctx)
      }
      val len = Literal(forNum, IntegerType)
      Substring(expr, pos, len)
    }
  }

  override def visitTableValuedFunction(ctx: TableValuedFunctionContext): LogicalPlan = {
    withOrigin(ctx) {
      val funcName = ctx.functionTable.identifier.getText
      val args = ctx.functionTable.expression.asScala.map(expression)
      val funcPlan = (funcName, args) match {
        case ("generate_series", Buffer(start, end)) => toSparkRange(start, end, None)
        case ("generate_series", Buffer(start, end, step)) => toSparkRange(start, end, Some(step))
        case _ => super.visitTableValuedFunction(ctx)
      }
      if (ctx.functionTable.tableAlias() != null &&
          ctx.functionTable.tableAlias.strictIdentifier() != null) {
        val prefix = ctx.functionTable.tableAlias.strictIdentifier.getText
        // This workaround is needed to parse a SQL syntax below:
        //
        // SELECT
        //   s.r, (current_schemas(false))[s.r] AS nspname
        // FROM
        //   generate_series(1, array_upper(current_schemas(false), 1)) AS s(r)
        //
        if (ctx.functionTable.tableAlias.identifierList() != null) {
          val aliases = visitIdentifierList(ctx.functionTable.tableAlias.identifierList())
          // TODO: Since there is currently one table function `range`, we just assign an output
          // name here. But, we need to make this logic more general in future.
          val projectList = Alias(UnresolvedAttribute("id"), aliases.head)() :: Nil
          SubqueryAlias(prefix, Project(projectList, funcPlan))
        } else {
          SubqueryAlias(prefix, funcPlan)
        }
      } else {
        funcPlan
      }
    }
  }
}
