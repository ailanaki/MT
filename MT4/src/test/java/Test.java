import codeGen.LexerGenerator;
import codeGen.ParserGenerator;
import codeGen.TokenGenerator;
import gramm.Grammar;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import gen.GrammLexer;
import gen.GrammParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import treeGen.Tree;

public class Test {
    public static void main(String[] args) throws IOException {
        generateParser("Calculator");
 //       generateParser("PythonLogic", "treeGen.Tree");

    }

    private static void generateParser(String name, String... imports) throws IOException {
        String inFile = "gramm/" + name;
        String packageName = "result." + name;
        Path outFile = Paths.get("src/main/java/result", name);

        String outPath;
        if (Files.notExists(outFile)) {
            outPath = Files.createDirectory(outFile).toString();
        } else {
            outPath = outFile.toString();
        }

        GrammLexer lexer = new GrammLexer(CharStreams.fromFileName(inFile));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GrammParser parser = new GrammParser(tokens);

        Grammar grammar = parser.start().v;
        grammar.buildFirstAndFollowSets();

        if (grammar.isLL1()) {
            new TokenGenerator(packageName, name, grammar, outPath).printFile();
            new LexerGenerator(packageName, name, grammar, outPath, imports).printFile();
            new ParserGenerator(packageName, name, grammar, outPath, imports).printFile();
        } else {
            System.out.println("Input grammar is not LL(1)-Grammar");
        }
    }
}
