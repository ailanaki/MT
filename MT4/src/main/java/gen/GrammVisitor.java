// Generated from /Users/aishayakupova/Documents/MT4/src/main/antlr/Gramm.g4 by ANTLR 4.9.2
package gen;
import gramm.*; 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(GrammParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammParser#choose_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChoose_rule(GrammParser.Choose_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammParser#non_term_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNon_term_rule(GrammParser.Non_term_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(GrammParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammParser#non_term_returns}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNon_term_returns(GrammParser.Non_term_returnsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(GrammParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammParser#var_or_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_or_type(GrammParser.Var_or_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammParser#rightPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightPart(GrammParser.RightPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammParser#ruleToken}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleToken(GrammParser.RuleTokenContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(GrammParser.ParamContext ctx);
}