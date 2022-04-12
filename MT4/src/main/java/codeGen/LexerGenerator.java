package codeGen;

import gramm.Grammar;
import gramm.TermRule;

import java.io.IOException;

public class LexerGenerator extends ClassPrinter {

    public LexerGenerator(String packageName, String name, Grammar grammar, String path , String... strings) {
        super(packageName, name, grammar, path, name + "Lexer", strings);
    }

    @Override
    protected void printImports() throws IOException {
        for (String s:imports) {
            printImport(s);
        }
        printImport("java.text.ParseException");
        printImport("java.util.regex.Matcher");
        printImport("java.util.regex.Pattern");
        printImport("java.util.Map");
        printImport("java.util.HashMap");
        printLine();
    }

    @Override
    protected void printFields() throws IOException {
        printLine("private String input;");
        printLine("private int curPos;");
        printLine("private ", tokenClassName, " curToken;");
        printLine("private Map<", tokenClassName, ", Pattern> regex;");
        printLine("private Pattern skipPattern;");
        printLine("private Matcher matcher;");
        printLine();
    }

    @Override
    protected void printConstructor() throws IOException {
        printLine("public ", className , "(String input) {");
        indentIn();
        printLine("this.input = input;");
        printLine("skipPattern = Pattern.compile(\"[ \\n\\r\\t]+\");");
        printLine("initRegex();");
        printLine("matcher = Pattern.compile(\"\").matcher(input);");
        indentOut();
        printLine("}");
        printLine();
    }

    @Override
    protected void printMethods() throws IOException {
        printInitRegex();
        printSkip();
        printFindNextToken();
        printNextToken();
        printGetCurToken();
        printGetCurPos();
        printGetCurTokenString();
    }

    private void printInitRegex() throws IOException {
        printLine("private void initRegex() {");
        indentIn();
        printLine("regex = new HashMap<>();");
        for (TermRule termRule : grammar.getTermRules()) {
            StringBuilder builder = new StringBuilder();
            builder.append("regex.put(")
                    .append(tokenClassName).append('.').append(termRule.getName())
                    .append(", Pattern.compile(");

            if (termRule.isRegex())
                builder.append(termRule.getValue());
            else {
                String value = termRule.getValue();
                builder.append('\"');
                for (int i = 1; i < value.length() - 1; i++)
                    if (value.charAt(i) == '^' || value.charAt(i) == '$')
                        builder.append("\\\\").append(value.charAt(i));
                    else if (value.charAt(i) == '\\')
                        builder.append("\\\\\\\\");
                    else
                        builder.append('[').append(value.charAt(i)).append(']');
                builder.append('\"');
            }
            builder.append("));");
            printLine(builder.toString());
        }
        printLine("regex.put(", tokenClassName, ".END, Pattern.compile(\"$\"));");
        indentOut();
        printLine("}");
        printLine();
    }

    private void printSkip() throws IOException {
        printMethod("private void skip()", () -> {
            printLine("String text = input.substring(curPos);");
            printLine("matcher.usePattern(skipPattern);");
            printLine("matcher.region(curPos, input.length());");
            printLine("if (matcher.lookingAt()) {");
            indentIn();
            printLine("curPos += matcher.end() - matcher.start();");
            indentOut();
            printLine("}");
        });
        printLine();
    }

    private void printFindNextToken() throws IOException {
        printMethod("private boolean findNextToken()", () -> {
            printMethod("for (" + tokenClassName + " t : " + tokenClassName +
                    ".values())", () -> {
                printLine("matcher.usePattern(regex.get(t));");
                printLine("matcher.region(curPos, input.length());");
                printMethod("if (matcher.lookingAt())", () -> {
                    printLine("curToken = t;");
                    printLine("curPos += matcher.end() - matcher.start();");
                    printLine("return true;");
                });
            });
            printLine("return false;");
        });
    }

    private void printNextToken() throws IOException {
        printMethod("public void nextToken() throws ParseException ", () -> {
            printLine("skip();");
            printMethod("if (curPos == input.length()) ", () -> {
                printLine("curToken = ", tokenClassName, ".END;");
                printLine("return;");
            });
            printMethod("if (!findNextToken())", () ->
                printLine("throw new ParseException(\"Can't parse : curPos\", curPos);"));
        });
    }

    private void printGetCurToken() throws IOException {
        printMethod("public " + tokenClassName + " getCurToken()", () ->
            printLine("return curToken;")
        );
    }

    private void printGetCurPos() throws IOException {
        printMethod("public int getCurPos()", () ->
            printLine("return curPos;")
        );
    }

    private void printGetCurTokenString() throws IOException {
        printMethod("public String getCurTokenString()", () ->
            printLine("return matcher.group();")
        );
    }
}
