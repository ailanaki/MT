package gramm;

import java.util.ArrayList;
import java.util.List;

public class NonTermRule {
    private final String name;
    private final List<List<RuleToken>> rightParts = new ArrayList<>();
    private final List<Argument> arguments;
    private final List<Argument> returns;

    public NonTermRule(String name, List<Argument> arguments, List<Argument> returns) {
        this.name = name;
        this.arguments = arguments;
        this.returns = returns;
    }

    public void addRule(List<RuleToken> rule) {
        rightParts.add(rule);
    }

    public String getName() {
        return name;
    }

    public List<List<RuleToken>> getRightParts() {
        return rightParts;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public List<Argument> getReturns() {
        return returns;
    }
}
