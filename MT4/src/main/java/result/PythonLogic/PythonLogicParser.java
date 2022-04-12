package result.PythonLogic;

import treeGen.Tree;
import java.text.ParseException;
public class PythonLogicParser {
	PythonLogicLexer lexer;
	public Expr parse(String input) throws ParseException {
		lexer = new PythonLogicLexer(input);
		lexer.nextToken();
		Expr result = expr();
		if(lexer.getCurToken() != PythonLogicToken.END) {
			throw new ParseException("Unexpected token : " + lexer.getCurToken(), lexer.getCurPos());
		}
		return result;
	}
	private Expr expr() throws ParseException {
		Expr result = new Expr();
		switch(lexer.getCurToken()) {
		case NOT:
		case LPAREN:
		case ALPHA:
		{
			OrXor orXor = orXor();
			result.v = orXor.v;
			String END = check(PythonLogicToken.END);
			break;
		}
		default:
			throw new ParseException("Unexpected token : " + lexer.getCurToken(), lexer.getCurPos());
		}
		return result;
	}
	
	private OrXor orXor() throws ParseException {
		OrXor result = new OrXor();
		switch(lexer.getCurToken()) {
		case NOT:
		case LPAREN:
		case ALPHA:
		{
			And and = and();
			OrXor_ orXor_ = orXor_(and.v);
			result.v = orXor_.v;
			break;
		}
		default:
			throw new ParseException("Unexpected token : " + lexer.getCurToken(), lexer.getCurPos());
		}
		return result;
	}
	
	private OrXor_ orXor_(Tree left) throws ParseException {
		OrXor_ result = new OrXor_();
		switch(lexer.getCurToken()) {
		case OR:
		{
			String OR = check(PythonLogicToken.OR);
			And and = and();
			Tree next = new Tree("orXor",  left,new Tree("or"), and.v);
			OrXor_ orXor_ = orXor_(next);
			result.v = orXor_.v;
			break;
		}
		case XOR:
		{
			String XOR = check(PythonLogicToken.XOR);
			And and = and();
			Tree next = new Tree("orXor", left,new Tree("xor"),  and.v);
			OrXor_ orXor_ = orXor_(next);
			result.v = orXor_.v;
			break;
		}
		case END:
		case RPAREN:
		{
			result.v = left;
			break;
		}
		default:
			throw new ParseException("Unexpected token : " + lexer.getCurToken(), lexer.getCurPos());
		}
		return result;
	}
	
	private And and() throws ParseException {
		And result = new And();
		switch(lexer.getCurToken()) {
		case NOT:
		case LPAREN:
		case ALPHA:
		{
			Unary unary = unary();
			And_ and_ = and_(unary.v);
			result.v = and_.v;
			break;
		}
		default:
			throw new ParseException("Unexpected token : " + lexer.getCurToken(), lexer.getCurPos());
		}
		return result;
	}
	
	private And_ and_(Tree left) throws ParseException {
		And_ result = new And_();
		switch(lexer.getCurToken()) {
		case AND:
		{
			String AND = check(PythonLogicToken.AND);
			Unary unary = unary();
			And_ and_ = and_(new Tree("and", left, new Tree("and"), unary.v));
			result.v = and_.v;
			break;
		}
		case OR:
		case XOR:
		case END:
		case RPAREN:
		{
			result.v = left;
			break;
		}
		default:
			throw new ParseException("Unexpected token : " + lexer.getCurToken(), lexer.getCurPos());
		}
		return result;
	}
	
	private Unary unary() throws ParseException {
		Unary result = new Unary();
		switch(lexer.getCurToken()) {
		case LPAREN:
		{
			String LPAREN = check(PythonLogicToken.LPAREN);
			OrXor orXor = orXor();
			String RPAREN = check(PythonLogicToken.RPAREN);
			result.v = new Tree("unary", new Tree("("), orXor.v, new Tree(")"));
			break;
		}
		case ALPHA:
		{
			String ALPHA = check(PythonLogicToken.ALPHA);
			result.v = new Tree("unary", new Tree("alpha"));
			break;
		}
		case NOT:
		{
			String NOT = check(PythonLogicToken.NOT);
			Unary unary = unary();
			result.v = new Tree("unary", new Tree("not"), unary.v);
			break;
		}
		default:
			throw new ParseException("Unexpected token : " + lexer.getCurToken(), lexer.getCurPos());
		}
		return result;
	}
	
	private String check(PythonLogicToken token) throws ParseException  {
		if (token != lexer.getCurToken()) {
			throw new ParseException("Unexpected token : " + lexer.getCurToken(), lexer.getCurPos());
		}
		String res = "";
		if (lexer.getCurToken() != PythonLogicToken.END) {
			res = lexer.getCurTokenString();
			lexer.nextToken();
		}
		return res;
	}
	
	public class Expr {
			public Tree v;
	}
	public class OrXor {
			public Tree v;
	}
	public class OrXor_ {
			public Tree v;
	}
	public class And {
			public Tree v;
	}
	public class And_ {
			public Tree v;
	}
	public class Unary {
			public Tree v;
	}
}
