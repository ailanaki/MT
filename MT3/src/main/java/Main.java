import antlr.GoodLangLexer;
import antlr.GoodLangParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GoodLangLexer lexer = new GoodLangLexer(CharStreams.fromFileName("/Users/aishayakupova/Documents/MT3/src/main/java/programm.txt"));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GoodLangParser parser = new GoodLangParser(tokens);
        ParseTree tree = parser.r();
        GoodLangWalker walk = new GoodLangWalker(new BufferedWriter
                (new FileWriter("/Users/aishayakupova/CLionProjects/c_test/main.c")));
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(walk, tree);
        walk.writer.close();
    }
}
