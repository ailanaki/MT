package com.company;

import java.io.InputStream;
import java.text.ParseException;

public class Parser {
    LexicalAnalyzer lex;

    Tree E() throws ParseException {
        Token cur = lex.curToken();
        if (cur == Token.NOT || cur == Token.LPAREN || cur == Token.ALPHA) {
            Tree sub = T();
            Tree cont = EPrime();
            return new Tree("E", sub, cont);
        }
        if (cur == Token.END || cur == Token.RPAREN){
            return new Tree("E", new Tree("ε"));
        }
        throw new AssertionError();

    }

    Tree EPrime() throws ParseException {
        Token cur = lex.curToken();
        if (cur == Token.OR) {
            lex.nextToken();
            Tree sub = T();
            Tree cont = EPrime();
            return new Tree("E'", new Tree("or"), sub, cont);
        }
        if (cur == Token.END || cur == Token.RPAREN){
            return new Tree("E'", new Tree("ε"));
        }
        throw new AssertionError();
    }

    Tree T() throws ParseException {
        Token cur = lex.curToken();
        if (cur == Token.NOT || cur == Token.LPAREN || cur == Token.ALPHA) {
            Tree sub = X();
            Tree cont = TPrime();
            return new Tree("T", sub, cont);
        }
        throw new AssertionError();
    }

    Tree TPrime() throws ParseException {
        Token cur = lex.curToken();
        if (cur == Token.XOR) {
            lex.nextToken();
            Tree sub = X();
            Tree cont = TPrime();
            return new Tree("T'",new Tree("xor"), sub, cont);
        }
        if(cur == Token.END || cur == Token.OR || cur == Token.RPAREN){
            return new Tree("T'", new Tree("ε"));
        }
        throw new AssertionError();
    }

    Tree X() throws ParseException {
        Token cur = lex.curToken();
        if (cur == Token.NOT || cur == Token.LPAREN || cur == Token.ALPHA) {
            Tree sub = F();
            Tree cont = XPrime();
            return new Tree("X", sub, cont);
        }
        throw new AssertionError();
    }

    Tree XPrime() throws ParseException {
        Token cur = lex.curToken();
        if (cur == Token.AND) {
            lex.nextToken();
            Tree sub = F();
            Tree cont = XPrime();
            return new Tree("X'", new Tree ("and"),sub, cont);
        }if(cur == Token.END || cur == Token.RPAREN || cur == Token.OR || cur == Token.XOR){
            return new Tree("X'", new Tree("ε"));
        }
        throw new AssertionError();
    }

    Tree F() throws ParseException {
        Token cur = lex.curToken();
        if (cur == Token.NOT){
            lex.nextToken();
            Tree sub  = F();
            return new Tree("F", new Tree("not"), sub);
        }
        if (cur == Token.LPAREN) {
            lex.nextToken();
            Tree sub = T();
            Tree cont = EPrime();
            if (lex.curToken != Token.RPAREN){
                throw new ParseException("No right paren", lex.curPos);
            }
            lex.nextToken();
            return new Tree("F", new Tree("("),sub, cont, new Tree(")"));
        }
        if (cur == Token.ALPHA) {
            Tree ans =  new Tree("F", new Tree("alpha"));
            lex.nextToken();
            return ans;
        }
        throw new AssertionError();
    }

    Tree parse(InputStream is) throws ParseException {
        lex = new LexicalAnalyzer(is);
        lex.nextToken();
        return E();
    }
}