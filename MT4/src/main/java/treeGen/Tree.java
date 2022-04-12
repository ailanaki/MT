package treeGen;

import java.util.Arrays;
import java.util.List;

public class Tree {
    String node;
    List<Tree> children;

    public Tree(String node, Tree... children) {
        this.node = node;
        this.children = Arrays.asList(children);
    }

    public Tree(String node) {
        this.node = node;
    }

    public int build_graph(StringBuilder s, int n) {
        int n1 = n;
        s.append(n1);
        s.append(" [label = \" ");
        s.append(node);
        s.append("\"]\n");
        if (children != null) {
            for (Tree child : children) {
                s.append(n1);
                s.append("->");
                n++;
                s.append(n);
                s.append(";\n");
                n = child.build_graph(s, n);
            }
        }
        return n;
    }

    public void graph_print(StringBuilder s) {
        if (children == null && !node.equals("ε")) {
            s.append(node).append(" ");
        } else {
            if (children != null) {
                for (Tree child : children) {
                    child.graph_print(s);
                }
            }

        }
    }
}

