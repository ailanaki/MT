import antlr.GoodLangBaseListener;
import antlr.GoodLangParser;
import org.antlr.v4.runtime.tree.ParseTree;


import java.io.IOException;
import java.io.Writer;
import java.util.*;
import java.util.stream.Collectors;

public class GoodLangWalker extends GoodLangBaseListener {

    Writer writer;
    private final HashMap<String, String> variables;
    private final List<Node> types;
    private final List<String> names;
    private int indent = 0;

    private static class Node {
        String type, expr;

        public Node(String type, String expr) {
            this.type = type;
            this.expr = expr;
        }
    }

    public GoodLangWalker(final Writer writer) {
        this.writer = writer;
        variables = new HashMap<>();
        types = new ArrayList<>();
        names = new ArrayList<>();
    }

    @Override
    public void enterR(GoodLangParser.RContext ctx) {
        super.enterR(ctx);
        write("#include <stdio.h>\n\nint main() {\n");
        indent++;
    }

    @Override
    public void exitR(GoodLangParser.RContext ctx) {
        super.exitR(ctx);
        indent--;
        write("}");
    }

    @Override
    public void enterProg(GoodLangParser.ProgContext ctx) {
        names.clear();
        types.clear();
        super.enterProg(ctx);
    }

    @Override
    public void exitProg(GoodLangParser.ProgContext ctx) {
        if (names.isEmpty() && !types.isEmpty()) {
            write(types.get(0).expr + ";\n");
        }
        super.exitProg(ctx);
    }

    @Override
    public void enterExpr(GoodLangParser.ExprContext ctx) {
        super.enterExpr(ctx);

    }

    @Override
    public void exitExpr(GoodLangParser.ExprContext ctx) {
        if (ctx.NAME() != null) {
            String name = ctx.NAME().getText();
            String type = variables.get(name);
            if (type != null) types.add(new Node(type, name));
            else throw new RuntimeException("Undeclared variable " + name);
            return;
        }
        if (ctx.NUMBER() != null) {
            String name = ctx.NUMBER().getText();
            if (name.contains(".")) {
                types.add(new Node("float", name));
            } else {
                types.add(new Node("int", name));
            }
        }
        if (ctx.SIGN_1() != null || ctx.SIGN_2() != null) {
            String sign = ctx.SIGN_1() != null ? ctx.SIGN_1().getText() : ctx.SIGN_2().getText();
            Node two = types.remove(types.size() - 1);
            Node one = types.remove(types.size() - 1);
            types.add(new Node(chooseType(one.type, two.type), one.expr + " " + sign + " " + two.expr));
        }
        if (ctx.BKT_1() != null) {
            Node cur = types.remove(types.size() - 1);
            types.add(new Node(cur.type, "(" + cur.expr + ")"));
        }
        super.exitExpr(ctx);
    }


    @Override
    public void enterFun(GoodLangParser.FunContext ctx) {
        String funName = ctx.FUN_NAME_START().toString();
        if (funName.startsWith("read")) {
            types.add(new Node(switchPrimitive(funName.substring(0, funName.length() - 1), List.of("int", "float")), "read"));
        }
        super.enterFun(ctx);
    }

    @Override
    public void exitFun(GoodLangParser.FunContext ctx) {
        String funName = ctx.FUN_NAME_START().toString();
        if (funName.startsWith("print")) {
            Node cur = types.remove(types.size() - 1);
            print(cur.type, cur.expr);
        }
        super.exitFun(ctx);
    }

    @Override
    public void enterStart_assume(GoodLangParser.Start_assumeContext ctx) {
        super.enterStart_assume(ctx);
        names.clear();
        names.addAll(ctx.NAME().stream().map(ParseTree::getText).collect(Collectors.toList()));
    }

    @Override
    public void enterEnd_assume(GoodLangParser.End_assumeContext ctx) {
        super.enterEnd_assume(ctx);
        types.clear();
    }

    @Override
    public void exitEnd_assume(GoodLangParser.End_assumeContext ctx) {
        StringBuilder stringBuilder = new StringBuilder();
        super.exitEnd_assume(ctx);
        if (types.size() != names.size()) {
            writeAssume(stringBuilder, types.stream().map((node) -> node.expr).collect(Collectors.toList()));
            throw new RuntimeException("wrong number of arguments in: \n" + stringBuilder);
        }
        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);
            Node node = types.get(i);
            if (!variables.containsKey(name)) {
                write(node.type + " " + name + ";\n");
                variables.put(name, node.type);
            }
        }
        for (int i = 0; i < types.size(); i++) {
            Node cur = types.get(i);
            if (cur.expr.equals("read")) {
                read(names.get(i), cur.type, stringBuilder);
                names.remove(i);
                types.remove(i);
                i--;
            } else if (names.contains(cur.expr) && types.get(names.lastIndexOf(cur.expr)).expr.equals(names.get(i))) {
                int ind = names.lastIndexOf(cur.expr);
                swap(cur, types.get(ind));
                names.remove(ind);
                types.remove(ind);
                names.remove(i);
                types.remove(i);
                i--;
            }
        }
        writeAssume(stringBuilder, types.stream().map((node) -> node.expr).collect(Collectors.toList()));
        write(stringBuilder.toString());
    }

    @Override
    public void exitLogic(GoodLangParser.LogicContext ctx) {
        if (ctx.COMPARASON() != null && types.size() >= 2) {
            Node one = types.remove(types.size() - 1);
            Node two = types.remove(types.size() - 1);
            String comp = one.expr + ctx.COMPARASON().toString();
            types.add(new Node(chooseType(one.type, two.type), two.expr + " " + comp.substring(2, comp.length() - 1) + " " + one.expr));
        }
        super.exitLogic(ctx);
    }


    @Override
    public void enterOperatorIf(GoodLangParser.OperatorIfContext ctx) {
        super.enterOperatorIf(ctx);
    }

    public void exitOperatorIf(GoodLangParser.OperatorIfContext ctx) {
        indent--;
        write("}\n");
    }

    @Override
    public void exitStart_if(GoodLangParser.Start_ifContext ctx) {
        Node one = types.remove(types.size() - 1);
        if (one.expr.equals("read")) {
            String temp_name = "_temp_" + one.expr;
            while (variables.containsKey(temp_name) && !variables.get(temp_name).equals(one.type)) {
                temp_name += "1";
            }
            write(one.type + " " + temp_name + ";\n");
            StringBuilder s = new StringBuilder();
            read(temp_name, one.type, s);
            write(s.toString());
            write("if (" + temp_name + "){\n");

        } else {
            write("if (" + one.expr + "){\n");

        }
        indent++;
        super.exitStart_if(ctx);
    }

    private void write(String str) {
        try {
            for (int i = 0; i < indent; i++) {
                writer.write("\t");
            }
            writer.write(str);
            for (int i = 0; i < indent; i++) {
                System.out.print("\t");
            }
            System.out.print(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeArg(List<String> strs, StringBuilder stringBuilder) {
        stringBuilder.append(strs.get(0));
        for (int i = 1; i < strs.size(); i++) {
            stringBuilder.append(", ");
            stringBuilder.append(strs.get(i));
        }
    }

    private void read(String name, String type, StringBuilder stringBuilder) {
        stringBuilder.append("scanf(\"");
        stringBuilder.append(switchPrimitive(type, List.of("%d", "%f")));
        stringBuilder.append("\", &");
        stringBuilder.append(name);
        stringBuilder.append(");\n");
    }

    private void print(String type, String name) {
        write("printf(\"" + switchPrimitive(type, List.of("%d", "%f")) + "\", " + name + ");\n");

    }

    private void swap(Node one, Node two) {
        write(one.type + " " + "_temp_" + one.expr + " = " + one.expr + ";\n");
        write(two.type + " " + "_temp_" + two.expr + " = " + two.expr + ";\n");
        write(one.expr + " = " + "_temp_" + two.expr + ";\n");
        write(two.expr + " = " + "_temp_" + one.expr + ";\n");

    }

    private void writeAssume(StringBuilder stringBuilder, List<String> res) {
        if (names.size() == 0) return;
        writeArg(names, stringBuilder);
        stringBuilder.append(" = ");
        writeArg(res, stringBuilder);
        stringBuilder.append(";\n");
    }

    private String switchPrimitive(String fun, List<String> res) {
        if (fun.endsWith("int")) {
            return res.get(0);
        }
        if (fun.endsWith("float")) {
            return res.get(1);
        }
        throw new RuntimeException("Wrong primitive function: " + fun);
    }

    private String chooseType(String one, String two) {
        if (one.equals(two)) return one;
        return "float";
    }

}
