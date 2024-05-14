package Models;

public class TalentsAndFlaws {
    private final String name;
    private final String description;

    public TalentsAndFlaws(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
