package result.Calculator;

import java.text.ParseException;
public class CalculatorParser {
	CalculatorLexer lexer;
	public Expr parse(String input) throws ParseException {
		lexer = new CalculatorLexer(input);
		lexer.nextToken();
		Expr result = expr();
		if(lexer.getCurToken() != CalculatorToken.END) {
			throw new ParseException("Unexpected token : " + lexer.getCurToken(), lexer.getCurPos());
		}
		return result;
	}
	private Expr expr() throws ParseException {
		Expr result = new Expr();
		switch(lexer.getCurToken()) {
		case SUB:
		case NUM:
		case LPAREN:
		{
			AddSub addSub = addSub();
			result.val = addSub.val;
			String END = check(CalculatorToken.END);
			break;
		}
		default:
			throw new ParseException("Unexpected token : " + lexer.getCurToken(), lexer.getCurPos());
		}
		return result;
	}
	
	private AddSub addSub() throws ParseException {
		AddSub result = new AddSub();
		switch(lexer.getCurToken()) {
		case SUB:
		case NUM:
		case LPAREN:
		{
			MulDiv mulDiv = mulDiv();
			AddSubP addSubP = addSubP(mulDiv.val);
			result.val = addSubP.val;
			break;
		}
		default:
			throw new ParseException("Unexpected token : " + lexer.getCurToken(), lexer.getCurPos());
		}
		return result;
	}
	
	private AddSubP addSubP(int left) throws ParseException {
		AddSubP result = new AddSubP();
		switch(lexer.getCurToken()) {
		case ADD:
		{
			String ADD = check(CalculatorToken.ADD);
			MulDiv mulDiv = mulDiv();
			int next = left + mulDiv.val;
			AddSubP addSubP = addSubP(next);
			result.val = addSubP.val;
			break;
		}
		case SUB:
		{
			String SUB = check(CalculatorToken.SUB);
			MulDiv mulDiv = mulDiv();
			int next = left - mulDiv.val;
			AddSubP addSubP = addSubP(next);
			result.val = addSubP.val;
			break;
		}
		case END:
		case RPAREN:
		{
			result.val = left;
			break;
		}
		default:
			throw new ParseException("Unexpected token : " + lexer.getCurToken(), lexer.getCurPos());
		}
		return result;
	}
	
	private MulDiv mulDiv() throws ParseException {
		MulDiv result = new MulDiv();
		switch(lexer.getCurToken()) {
		case SUB:
		case NUM:
		case LPAREN:
		{
			Log log = log();
			MulDivP mulDivP = mulDivP(log.val);
			result.val = mulDivP.val;
			break;
		}
		default:
			throw new ParseException("Unexpected token : " + lexer.getCurToken(), lexer.getCurPos());
		}
		return result;
	}
	
	private MulDivP mulDivP(int left) throws ParseException {
		MulDivP result = new MulDivP();
		switch(lexer.getCurToken()) {
		case MUL:
		{
			String MUL = check(CalculatorToken.MUL);
			Log log = log();
			int next = left * log.val;
			MulDivP mulDivP = mulDivP(next);
			result.val = mulDivP.val;
			break;
		}
		case DIV:
		{
			String DIV = check(CalculatorToken.DIV);
			Log log = log();
			int next = left / log.val;
			MulDivP mulDivP = mulDivP(next);
			result.val = mulDivP.val;
			break;
		}
		case ADD:
		case SUB:
		case END:
		case RPAREN:
		{
			result.val = left;
			break;
		}
		default:
			throw new ParseException("Unexpected token : " + lexer.getCurToken(), lexer.getCurPos());
		}
		return result;
	}
	
	private Log log() throws ParseException {
		Log result = new Log();
		switch(lexer.getCurToken()) {
		case SUB:
		case NUM:
		case LPAREN:
		{
			Unary unary = unary();
			Log_ log_ = log_(unary.val);
			result.val = log_.val;
			break;
		}
		default:
			throw new ParseException("Unexpected token : " + lexer.getCurToken(), lexer.getCurPos());
		}
		return result;
	}
	
	private Log_ log_(int left) throws ParseException {
		Log_ result = new Log_();
		switch(lexer.getCurToken()) {
		case LOG:
		{
			String LOG = check(CalculatorToken.LOG);
			Log log = log();
			result.val = (int) (Math.log(left)/Math.log(log.val));
			break;
		}
		case DIV:
		case ADD:
		case SUB:
		case MUL:
		case END:
		case RPAREN:
		{
			result.val = left;
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
		case SUB:
		{
			String SUB = check(CalculatorToken.SUB);
			Unary unary = unary();
			result.val = -unary.val;
			break;
		}
		case LPAREN:
		{
			String LPAREN = check(CalculatorToken.LPAREN);
			AddSub addSub = addSub();
			String RPAREN = check(CalculatorToken.RPAREN);
			result.val = addSub.val;
			break;
		}
		case NUM:
		{
			String NUM = check(CalculatorToken.NUM);
			result.val = Integer.valueOf(NUM);
			break;
		}
		default:
			throw new ParseException("Unexpected token : " + lexer.getCurToken(), lexer.getCurPos());
		}
		return result;
	}
	
	private String check(CalculatorToken token) throws ParseException  {
		if (token != lexer.getCurToken()) {
			throw new ParseException("Unexpected token : " + lexer.getCurToken(), lexer.getCurPos());
		}
		String res = "";
		if (lexer.getCurToken() != CalculatorToken.END) {
			res = lexer.getCurTokenString();
			lexer.nextToken();
		}
		return res;
	}
	
	public class Expr {
			public int val;
	}
	public class AddSub {
			public int val;
	}
	public class AddSubP {
			public int val;
	}
	public class MulDiv {
			public int val;
	}
	public class MulDivP {
			public int val;
	}
	public class Log {
			public int val;
	}
	public class Log_ {
			public int val;
	}
	public class Unary {
			public int val;
	}
}
