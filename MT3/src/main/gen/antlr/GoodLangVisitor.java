// Generated from /Users/aishayakupova/Documents/MT3/src/main/java/antlr/GoodLang.g4 by ANTLR 4.9.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GoodLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GoodLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GoodLangParser#r}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitR(GoodLangParser.RContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoodLangParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(GoodLangParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoodLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(GoodLangParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoodLangParser#fun}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFun(GoodLangParser.FunContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoodLangParser#start_assume}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_assume(GoodLangParser.Start_assumeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoodLangParser#end_assume}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnd_assume(GoodLangParser.End_assumeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoodLangParser#assume}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssume(GoodLangParser.AssumeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoodLangParser#logic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic(GoodLangParser.LogicContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoodLangParser#logExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogExpr(GoodLangParser.LogExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoodLangParser#operatorIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorIf(GoodLangParser.OperatorIfContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoodLangParser#start_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart_if(GoodLangParser.Start_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link GoodLangParser#enter_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnter_if(GoodLangParser.Enter_ifContext ctx);
}