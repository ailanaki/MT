// Generated from /Users/aishayakupova/Documents/MT3/src/main/java/antlr/GoodLang.g4 by ANTLR 4.9.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GoodLangParser}.
 */
public interface GoodLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GoodLangParser#r}.
	 * @param ctx the parse tree
	 */
	void enterR(GoodLangParser.RContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoodLangParser#r}.
	 * @param ctx the parse tree
	 */
	void exitR(GoodLangParser.RContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoodLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(GoodLangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoodLangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(GoodLangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoodLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GoodLangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoodLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GoodLangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoodLangParser#fun}.
	 * @param ctx the parse tree
	 */
	void enterFun(GoodLangParser.FunContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoodLangParser#fun}.
	 * @param ctx the parse tree
	 */
	void exitFun(GoodLangParser.FunContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoodLangParser#start_assume}.
	 * @param ctx the parse tree
	 */
	void enterStart_assume(GoodLangParser.Start_assumeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoodLangParser#start_assume}.
	 * @param ctx the parse tree
	 */
	void exitStart_assume(GoodLangParser.Start_assumeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoodLangParser#end_assume}.
	 * @param ctx the parse tree
	 */
	void enterEnd_assume(GoodLangParser.End_assumeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoodLangParser#end_assume}.
	 * @param ctx the parse tree
	 */
	void exitEnd_assume(GoodLangParser.End_assumeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoodLangParser#assume}.
	 * @param ctx the parse tree
	 */
	void enterAssume(GoodLangParser.AssumeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoodLangParser#assume}.
	 * @param ctx the parse tree
	 */
	void exitAssume(GoodLangParser.AssumeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoodLangParser#logic}.
	 * @param ctx the parse tree
	 */
	void enterLogic(GoodLangParser.LogicContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoodLangParser#logic}.
	 * @param ctx the parse tree
	 */
	void exitLogic(GoodLangParser.LogicContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoodLangParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogExpr(GoodLangParser.LogExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoodLangParser#logExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogExpr(GoodLangParser.LogExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoodLangParser#operatorIf}.
	 * @param ctx the parse tree
	 */
	void enterOperatorIf(GoodLangParser.OperatorIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoodLangParser#operatorIf}.
	 * @param ctx the parse tree
	 */
	void exitOperatorIf(GoodLangParser.OperatorIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoodLangParser#start_if}.
	 * @param ctx the parse tree
	 */
	void enterStart_if(GoodLangParser.Start_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoodLangParser#start_if}.
	 * @param ctx the parse tree
	 */
	void exitStart_if(GoodLangParser.Start_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link GoodLangParser#enter_if}.
	 * @param ctx the parse tree
	 */
	void enterEnter_if(GoodLangParser.Enter_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link GoodLangParser#enter_if}.
	 * @param ctx the parse tree
	 */
	void exitEnter_if(GoodLangParser.Enter_ifContext ctx);
}