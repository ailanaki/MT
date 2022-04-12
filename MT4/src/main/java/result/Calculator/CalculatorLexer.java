package result.Calculator;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Map;
import java.util.HashMap;

public class CalculatorLexer {
	private String input;
	private int curPos;
	private CalculatorToken curToken;
	private Map<CalculatorToken, Pattern> regex;
	private Pattern skipPattern;
	private Matcher matcher;
	
	public CalculatorLexer(String input) {
		this.input = input;
		skipPattern = Pattern.compile("[ \n\r\t]+");
		initRegex();
		matcher = Pattern.compile("").matcher(input);
	}
	
	private void initRegex() {
		regex = new HashMap<>();
		regex.put(CalculatorToken.ADD, Pattern.compile("[+]"));
		regex.put(CalculatorToken.SUB, Pattern.compile("[-]"));
		regex.put(CalculatorToken.MUL, Pattern.compile("[*]"));
		regex.put(CalculatorToken.LOG, Pattern.compile("[l][g]"));
		regex.put(CalculatorToken.DIV, Pattern.compile("[/]"));
		regex.put(CalculatorToken.LPAREN, Pattern.compile("[(]"));
		regex.put(CalculatorToken.RPAREN, Pattern.compile("[)]"));
		regex.put(CalculatorToken.NUM, Pattern.compile("([1-9][0-9]*)|(0)"));
		regex.put(CalculatorToken.END, Pattern.compile("\\$"));
		regex.put(CalculatorToken.END, Pattern.compile("$"));
	}
	
	private void skip() {
		String text = input.substring(curPos);
		matcher.usePattern(skipPattern);
		matcher.region(curPos, input.length());
		if (matcher.lookingAt()) {
			curPos += matcher.end() - matcher.start();
		}
	}
	
	private boolean findNextToken() {
		for (CalculatorToken t : CalculatorToken.values()) {
			matcher.usePattern(regex.get(t));
			matcher.region(curPos, input.length());
			if (matcher.lookingAt()) {
				curToken = t;
				curPos += matcher.end() - matcher.start();
				return true;
			}
		}
		return false;
	}
	public void nextToken() throws ParseException  {
		skip();
		if (curPos == input.length())  {
			curToken = CalculatorToken.END;
			return;
		}
		if (!findNextToken()) {
			throw new ParseException("Can't parse : curPos", curPos);
		}
	}
	public CalculatorToken getCurToken() {
		return curToken;
	}
	public int getCurPos() {
		return curPos;
	}
	public String getCurTokenString() {
		return matcher.group();
	}
}
