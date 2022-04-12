package codeGen;

import gramm.Grammar;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class ClassPrinter {
    protected String packageName;
    protected String className;
    private int tab;
    protected Grammar grammar;
    protected ArrayList<String> imports;

    protected String lexerClassName;
    protected String parserClassName;
    protected String tokenClassName;

    private BufferedWriter writer;

    public ClassPrinter(String packageName, String name, Grammar grammar, String path, String file, String... strings) {
        try {
            writer = new BufferedWriter(new FileWriter(new File(path, file + ".java")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.lexerClassName = name + "Lexer";
        this.parserClassName = name + "Parser";
        this.tokenClassName = name + "Token";
        this.className = file;
        this.grammar = grammar;
        this.packageName = packageName;
        this.imports = new ArrayList<>();
        imports.addAll(Arrays.asList(strings));
    }

    protected void indentIn() {
        tab++;
    }

    protected void indentOut() {
        tab--;
    }

    protected void printLine(String... strings) throws IOException {
        for (int i = 0; i < tab; i++) {
            writer.write("\t");
        }

        for (String s : strings) {
            writer.write(s);
        }
        writer.write("\n");
    }

    private void printPackage() throws IOException {
        printLine("package ", packageName, ";");
        writer.write("\n");
    }

    public void printFile() throws IOException {
        printPackage();
        printImports();
        printClass();
        writer.close();
    }

    protected void printImport(String file) throws IOException {
        printLine("import ", file, ";");
    }

    protected abstract void printImports() throws IOException;

    protected abstract void printFields() throws IOException;

    protected abstract void printConstructor() throws IOException;

    protected abstract void printMethods()throws IOException;

    protected void printClass() throws IOException {
        printMethod("public class " + className, () -> {
            printFields();
            printConstructor();
            printMethods();
        });
    }

    protected void printMethod(String start, RunnableWithIO content) throws IOException {
        printLine(start + " {");
        indentIn();
        content.run();
        indentOut();
        printLine("}");
    }
}
