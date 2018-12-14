// Generated from FQL.g4 by ANTLR 4.7.1

package cn.fusiondb.dsl.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FQLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FQLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FQLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(FQLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#sql}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql(FQLParser.SqlContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#overwrite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOverwrite(FQLParser.OverwriteContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#append}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAppend(FQLParser.AppendContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#errorIfExists}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorIfExists(FQLParser.ErrorIfExistsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#ignore}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnore(FQLParser.IgnoreContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#booleanExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpression(FQLParser.BooleanExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(FQLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#ender}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnder(FQLParser.EnderContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#format}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormat(FQLParser.FormatContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#path}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPath(FQLParser.PathContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#setValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetValue(FQLParser.SetValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#setKey}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetKey(FQLParser.SetKeyContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#db}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDb(FQLParser.DbContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#asTableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsTableName(FQLParser.AsTableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#tableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTableName(FQLParser.TableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(FQLParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#col}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCol(FQLParser.ColContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(FQLParser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(FQLParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#strictIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrictIdentifier(FQLParser.StrictIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link FQLParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuotedIdentifier(FQLParser.QuotedIdentifierContext ctx);
}