// Generated from /Users/aishayakupova/Documents/MT4/src/main/antlr/Gramm.g4 by ANTLR 4.9.2
package gen;
import gramm.*; 
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammParser}.
 */
public interface GrammListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(GrammParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(GrammParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#choose_rule}.
	 * @param ctx the parse tree
	 */
	void enterChoose_rule(GrammParser.Choose_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#choose_rule}.
	 * @param ctx the parse tree
	 */
	void exitChoose_rule(GrammParser.Choose_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#non_term_rule}.
	 * @param ctx the parse tree
	 */
	void enterNon_term_rule(GrammParser.Non_term_ruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#non_term_rule}.
	 * @param ctx the parse tree
	 */
	void exitNon_term_rule(GrammParser.Non_term_ruleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(GrammParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(GrammParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#non_term_returns}.
	 * @param ctx the parse tree
	 */
	void enterNon_term_returns(GrammParser.Non_term_returnsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#non_term_returns}.
	 * @param ctx the parse tree
	 */
	void exitNon_term_returns(GrammParser.Non_term_returnsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(GrammParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(GrammParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#var_or_type}.
	 * @param ctx the parse tree
	 */
	void enterVar_or_type(GrammParser.Var_or_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#var_or_type}.
	 * @param ctx the parse tree
	 */
	void exitVar_or_type(GrammParser.Var_or_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#rightPart}.
	 * @param ctx the parse tree
	 */
	void enterRightPart(GrammParser.RightPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#rightPart}.
	 * @param ctx the parse tree
	 */
	void exitRightPart(GrammParser.RightPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#ruleToken}.
	 * @param ctx the parse tree
	 */
	void enterRuleToken(GrammParser.RuleTokenContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#ruleToken}.
	 * @param ctx the parse tree
	 */
	void exitRuleToken(GrammParser.RuleTokenContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(GrammParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(GrammParser.ParamContext ctx);
}