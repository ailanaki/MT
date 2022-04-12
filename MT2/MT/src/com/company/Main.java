package com.company;

import java.io.*;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException, IOException {
        for (int i = 1; i <= 13; i++) {
            Parser p = new Parser();
            try {
                Tree result = p.parse(new FileInputStream("test" + i + ".txt"));
                FileOutputStream fileOutputStream = new FileOutputStream(new File("result" + i + ".gv"));
                fileOutputStream.write("digraph res{".getBytes());
                StringBuilder s = new StringBuilder();
                result.build_graph(s, 0);
                fileOutputStream.write(s.toString().getBytes());
                fileOutputStream.write("}".getBytes());
                fileOutputStream.close();
                Process proc = Runtime.getRuntime().exec("dot -Tpng result" + i+ ".gv -oresult" + i+".png");
                proc.waitFor();
                proc.destroy();
                s = new StringBuilder();
                result.graph_print(s);
                System.out.println("("+i+") "+s);
            }catch (AssertionError er){
                System.err.println("test " + i + " is not succeed");
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
       }
    }
}
