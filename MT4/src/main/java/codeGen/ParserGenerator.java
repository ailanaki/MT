package codeGen;

import gramm.*;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public class ParserGenerator extends ClassPrinter {
    private final String exceptionString = "throw new ParseException(\"Unexpected token : \" + lexer.getCurToken(), lexer.getCurPos());";

    public ParserGenerator(String packageName, String name, Grammar grammar, String path, String... strings) {
        super(packageName, name, grammar, path, name + "Parser", strings);
    }

    @Override
    protected void printImports() throws IOException {
        for (String s:imports) {
            printImport(s);
        }
        printImport("java.text.ParseException");
    }

    @Override
    protected void printClass() throws IOException {
        printMethod("public class " + parserClassName, () -> {
            printFields();
            printMethods();
            printNonTermClasses();
        });
    }

    private String toUpperFirstLetter(String s) {
        return Character.toUpperCase(s.charAt(0)) + s.substring(1);
    }

    @Override
    protected void printFields() throws IOException {
        printLine(lexerClassName, " lexer;");
    }

    @Override
    protected void printConstructor() {
    }

    @Override
    protected void printMethods() throws IOException {
        printMethod("public " + toUpperFirstLetter(grammar.getStartNonTerm()) + " parse(String input) throws ParseException", () -> {
            printLine("lexer = new ", lexerClassName, "(input);");
            printLine("lexer.nextToken();");
            String startNonTerm = grammar.getStartNonTerm();
            String startNonTermClass = toUpperFirstLetter(startNonTerm);
            printLine(startNonTermClass, " result = ", startNonTerm, "();");
            printLine("if(lexer.getCurToken() != ", tokenClassName, ".END) {");
            indentIn();
            printLine(exceptionString);
            indentOut();
            printLine("}");
            printLine("return result;");
        });

        for (NonTermRule nonTermRule : grammar.getNonTermRules()) {
            printRuleMethod(nonTermRule);
        }

        printMethod("private String check(" + tokenClassName + " token) throws ParseException ", () -> {
            printLine("if (token != lexer.getCurToken()) {");
            indentIn();
            printLine(exceptionString);
            indentOut();
            printLine("}");
            printLine("String res = \"\";");
            printLine("if (lexer.getCurToken() != ", tokenClassName, ".END) {");
            indentIn();
            printLine("res = lexer.getCurTokenString();");
            printLine("lexer.nextToken();");
            indentOut();
            printLine("}");
            printLine("return res;");
        });
        printLine();
    }

    private void printRuleMethod(NonTermRule rule) throws IOException {
        String returnType = toUpperFirstLetter(rule.getName());
        printMethod("private " + returnType + " " + rule.getName() + "("
                + argumentsToString(rule) + ") throws ParseException", () -> {
            printLine(returnType, " result = new ", returnType, "();");
            printLine("switch(lexer.getCurToken()) {");
            printCases(rule);
            printLine("}");
            printLine("return result;");
        });
        printLine();
    }

    private String argumentsToString(NonTermRule rule) {
        StringBuilder builder = new StringBuilder();
        boolean needComma = false;
        for (Argument arg : rule.getArguments()) {
            if (needComma) {
                builder.append(", ");
            }
            needComma = true;
            builder.append(arg.getType()).append(" ").append(arg.getName());
        }
        return builder.toString();
    }

    private void printCases(NonTermRule rule) throws IOException {
        List<RuleToken> rightPartWithEps = null;

        for (List<RuleToken> rightPart : rule.getRightParts()) {
            Set<String> firstSet = grammar.getFirstSetByRightPart(rightPart);
            if (firstSet.contains("")) {
                rightPartWithEps = rightPart;
                continue;
            }
            for (String firstToken : firstSet) {
                printLine("case ", firstToken, ":");
            }
            printCase(rightPart);
        }

        if (rightPartWithEps != null) {
            for (String followToken : grammar.getFollowSet(rule.getName())) {
                printLine("case ", followToken, ":");
            }
            printCase(rightPartWithEps);
        }
        printLine("default:");
        indentIn();
        printLine(exceptionString);
        indentOut();
    }

    private void printCase(List<RuleToken> rightPart) throws IOException {
        printLine("{");
        indentIn();
        for (RuleToken ruleToken : rightPart) {
            if (ruleToken instanceof Code) {
                printLine(normalizeCode(ruleToken.getName()));
            } else if (ruleToken instanceof Term) {
                printLine("String ", ruleToken.getName(), " = check(", tokenClassName, ".", ruleToken.getName(), ");");
            } else {
                printLine(toUpperFirstLetter(ruleToken.getName()), " ", ruleToken.getName(), " = ",
                        ruleToken.getName(), "(", parametersToString((NonTerm) ruleToken), ");");
            }
        }

        printLine("break;");
        indentOut();
        printLine("}");
    }

    private String normalizeCode(String code) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '$') {
                builder.append("result.");
            } else {
                builder.append(code.charAt(i));
            }
        }
        return builder.toString();
    }

    private String parametersToString(NonTerm nonTerm) {
        StringBuilder builder = new StringBuilder();
        boolean needComma = false;
        for (String parameter : nonTerm.getParameters()) {
            if (needComma) {
                builder.append(", ");
            }
            needComma = true;
            builder.append(parameter);
        }
        return builder.toString();
    }

    private void printNonTermClasses() throws IOException {
        for (NonTermRule nonTermRule : grammar.getNonTermRules()) {
            printMethod("public class " + toUpperFirstLetter(nonTermRule.getName()), () -> {
                indentIn();
                for (Argument arg : nonTermRule.getReturns()) {
                    printLine("public ", arg.getType(), " ", arg.getName(), ";");
                }
                indentOut();
            });
        }
    }
}
