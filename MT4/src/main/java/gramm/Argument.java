package gramm;

public class Argument {
    private final String name;
    private final String type;

    public Argument(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }
}
