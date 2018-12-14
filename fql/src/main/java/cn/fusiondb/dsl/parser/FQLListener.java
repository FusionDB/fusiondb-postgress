// Generated from FQL.g4 by ANTLR 4.7.1

package cn.fusiondb.dsl.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FQLParser}.
 */
public interface FQLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FQLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(FQLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(FQLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void enterSql(FQLParser.SqlContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#sql}.
	 * @param ctx the parse tree
	 */
	void exitSql(FQLParser.SqlContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#overwrite}.
	 * @param ctx the parse tree
	 */
	void enterOverwrite(FQLParser.OverwriteContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#overwrite}.
	 * @param ctx the parse tree
	 */
	void exitOverwrite(FQLParser.OverwriteContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#append}.
	 * @param ctx the parse tree
	 */
	void enterAppend(FQLParser.AppendContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#append}.
	 * @param ctx the parse tree
	 */
	void exitAppend(FQLParser.AppendContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#errorIfExists}.
	 * @param ctx the parse tree
	 */
	void enterErrorIfExists(FQLParser.ErrorIfExistsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#errorIfExists}.
	 * @param ctx the parse tree
	 */
	void exitErrorIfExists(FQLParser.ErrorIfExistsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#ignore}.
	 * @param ctx the parse tree
	 */
	void enterIgnore(FQLParser.IgnoreContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#ignore}.
	 * @param ctx the parse tree
	 */
	void exitIgnore(FQLParser.IgnoreContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpression(FQLParser.BooleanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#booleanExpression}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpression(FQLParser.BooleanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(FQLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(FQLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#ender}.
	 * @param ctx the parse tree
	 */
	void enterEnder(FQLParser.EnderContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#ender}.
	 * @param ctx the parse tree
	 */
	void exitEnder(FQLParser.EnderContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#format}.
	 * @param ctx the parse tree
	 */
	void enterFormat(FQLParser.FormatContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#format}.
	 * @param ctx the parse tree
	 */
	void exitFormat(FQLParser.FormatContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#path}.
	 * @param ctx the parse tree
	 */
	void enterPath(FQLParser.PathContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#path}.
	 * @param ctx the parse tree
	 */
	void exitPath(FQLParser.PathContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#setValue}.
	 * @param ctx the parse tree
	 */
	void enterSetValue(FQLParser.SetValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#setValue}.
	 * @param ctx the parse tree
	 */
	void exitSetValue(FQLParser.SetValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#setKey}.
	 * @param ctx the parse tree
	 */
	void enterSetKey(FQLParser.SetKeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#setKey}.
	 * @param ctx the parse tree
	 */
	void exitSetKey(FQLParser.SetKeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#db}.
	 * @param ctx the parse tree
	 */
	void enterDb(FQLParser.DbContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#db}.
	 * @param ctx the parse tree
	 */
	void exitDb(FQLParser.DbContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#asTableName}.
	 * @param ctx the parse tree
	 */
	void enterAsTableName(FQLParser.AsTableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#asTableName}.
	 * @param ctx the parse tree
	 */
	void exitAsTableName(FQLParser.AsTableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void enterTableName(FQLParser.TableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#tableName}.
	 * @param ctx the parse tree
	 */
	void exitTableName(FQLParser.TableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#functionName}.
	 * @param ctx the parse tree
	 */
	void enterFunctionName(FQLParser.FunctionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#functionName}.
	 * @param ctx the parse tree
	 */
	void exitFunctionName(FQLParser.FunctionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#col}.
	 * @param ctx the parse tree
	 */
	void enterCol(FQLParser.ColContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#col}.
	 * @param ctx the parse tree
	 */
	void exitCol(FQLParser.ColContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void enterQualifiedName(FQLParser.QualifiedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#qualifiedName}.
	 * @param ctx the parse tree
	 */
	void exitQualifiedName(FQLParser.QualifiedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(FQLParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(FQLParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterStrictIdentifier(FQLParser.StrictIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#strictIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitStrictIdentifier(FQLParser.StrictIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link FQLParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterQuotedIdentifier(FQLParser.QuotedIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link FQLParser#quotedIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitQuotedIdentifier(FQLParser.QuotedIdentifierContext ctx);
}