package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class LexicalAnalyzer {
    InputStream is;
    int curChar;
    int curPos;
    Token curToken;

    public LexicalAnalyzer(InputStream is) throws ParseException {
        this.is = is;
        curPos = 0;
        nextChar();
    }

    private boolean isBlank(int c) {
        return Character.isWhitespace(c);
    }

    private void nextChar() throws ParseException {
        curPos++;
        try {
            curChar = is.read();
        } catch (IOException e) {
            throw new ParseException(e.getMessage(), curPos);
        }
    }

    private String nextWord() throws ParseException {
        while (curChar != -1 && isBlank(curChar)) {
            nextChar();
        }
        if (curChar == ')' || curChar == '('){
            return Character.toString(curChar);
        }
        StringBuilder word = new StringBuilder();
        while (curChar != -1 && !isBlank(curChar)  && curChar != ')' && curChar != '(') {
            word.append(Character.toString(curChar));
            nextChar();
        }
        return word.toString();
    }

    public void nextToken() throws ParseException {
        String curWord = nextWord();
        switch (curWord) {
            case "":
                curToken = Token.END;
                break;
            case "(":
                nextChar();
                curToken = Token.LPAREN;
                break;
            case ")":
                nextChar();
                curToken = Token.RPAREN;
                break;
            case "or":
                nextChar();
                curToken = Token.OR;
                break;
            case "and":
                nextChar();
                curToken = Token.AND;
                break;
            case "xor":
                nextChar();
                curToken = Token.XOR;
                break;
            case "not":
                nextChar();
                curToken = Token.NOT;
                break;
            default:
                if (curWord.length() == 1 && Character.isAlphabetic(curWord.toCharArray()[0])) {
                    curToken = Token.ALPHA;
                } else {
                    throw new ParseException("Illegal character"
                            + curWord, curPos);
                }

        }
    }

    public Token curToken() {
        return curToken;
    }

    public int curPos() {
        return curPos;
    }
}
