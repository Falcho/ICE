package Models;

import java.util.TreeMap;
import java.util.Map;

public class Rules {
    public static Map<String, SkillCategory> getEmptySkillList() {
        Map<String, SkillCategory> emptySkillList = new TreeMap<>();
        emptySkillList.put("Delving", new SkillCategory("Delving") );
        return emptySkillList;
    }
}
