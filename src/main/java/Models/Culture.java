package Models;

import java.util.List;
import java.util.Map;

public class Culture {
    private String name;
    private String description;
    private List<String> crafts;
    private List<String> vocations;
    private Map<String, Integer> skills;

    public Culture() {
    }

    public Culture(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getCrafts() {
        return crafts;
    }

    public List<String> getVocations() {
        return vocations;
    }

    public Map<String, Integer> getSkills() {
        return skills;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCrafts(List<String> crafts) {
        this.crafts = crafts;
    }

    public void setVocations(List<String> vocations) {
        this.vocations = vocations;
    }

    public void setSkills(Map<String, Integer> skills) {
        this.skills = skills;
    }
}
