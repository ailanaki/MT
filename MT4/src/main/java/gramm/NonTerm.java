package gramm;

import java.util.ArrayList;
import java.util.List;

public class NonTerm implements RuleToken {
    private final String name;
    private final List<String> parameters = new ArrayList<>();

    public NonTerm(String name) {
        this.name = name;
    }

    public void addParameter(String parameter) {
        parameters.add(parameter);
    }

    public List<String> getParameters() {
        return parameters;
    }

    @Override
    public String getName() {
        return name;
    }
}
