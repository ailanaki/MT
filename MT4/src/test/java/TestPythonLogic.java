import result.PythonLogic.PythonLogicParser;
import treeGen.Tree;

import java.io.*;
import java.text.ParseException;

public class TestPythonLogic {
    public static void main(String[] args) throws ParseException {
        test("a and b", "result1");
        test("not (not a)", "result2");
        test("or and b", "result3");
        test("a               xor b", "result4");
        test("(a xor b xor c xor d)", "result5");
        test("a or (b or c and (d))", "result6");
        test("a or b", "result7");
    }

    private static void test(String input, String file) throws ParseException {
        PythonLogicParser p = new PythonLogicParser();
        try {
            Tree result = p.parse(input).v;
            FileOutputStream fileOutputStream = new FileOutputStream(file + ".gv");
            fileOutputStream.write("digraph res{".getBytes());
            StringBuilder s = new StringBuilder();
            result.build_graph(s, 0);
            fileOutputStream.write(s.toString().getBytes());
            fileOutputStream.write("}".getBytes());
            fileOutputStream.close();
            Process proc = Runtime.getRuntime().exec("dot -Tpng " + file + ".gv -o" + file + ".png");
            proc.waitFor();
            proc.destroy();
            s = new StringBuilder();
            result.graph_print(s);
            System.out.println("(" + input + ") = " + s);
        } catch (ParseException e) {
            System.err.println("test " + "(" + input + ") " + " is not succeed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
