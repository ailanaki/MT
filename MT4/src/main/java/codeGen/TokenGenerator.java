package codeGen;

import gramm.Grammar;
import gramm.TermRule;

import java.io.IOException;

public class TokenGenerator extends ClassPrinter {
    public TokenGenerator(String packageName, String name, Grammar grammar, String path) {
        super(packageName,name, grammar, path, name + "Token");
    }

    @Override
    protected void printImports() {
    }

    @Override
    protected void printFields()  {
    }

    @Override
    protected void printConstructor(){
    }

    @Override
    protected void printMethods() {
    }

    @Override
    protected void printClass() throws IOException {
        printLine( "public enum ", tokenClassName, "{");
        printTokens();
        printLine("}");
    }

    private void printTokens() throws IOException {
        indentIn();
        for (TermRule termRule : grammar.getTermRules()) {
            printLine( termRule.getName(), ",");
        }
        indentOut();
    }
}
