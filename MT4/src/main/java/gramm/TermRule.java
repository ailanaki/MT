package gramm;

public class TermRule {
    private final String name;
    private final String value;
    private final boolean isRegex;

    public TermRule(boolean isRegex, String name, String data) {
        this.name = name;
        this.value = data;
        this.isRegex = isRegex;
    }

    public String getName() {
        return name;
    }

    public boolean isRegex() {
        return isRegex;
    }

    public String getValue() {
        return value;
    }
}
