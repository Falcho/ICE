package Models;

import java.util.Map;

public class Culture {
    String cultureName;
    Map<String, Integer> skillMap;

    public Culture(String cultureName, Map<String, Integer> skillMap) {
        this.cultureName = cultureName;
        this.skillMap = skillMap;
    }

    public Map<String, Integer> getSkillMap() {
        return skillMap;
    }
}
