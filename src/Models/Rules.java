package Models;

import java.util.*;

public class Rules {
    public static Map<String, SkillCategory> getEmptySkillList() {
        Map<String, SkillCategory> emptySkillList = new TreeMap<>();
        emptySkillList.put("Delving", new SkillCategory("Delving") );
        return emptySkillList;
    }

    public static Map<String, String> getTalentsAndFlaws() {
        Map<String,String> talentsAndFlaws = new HashMap<>();
        return talentsAndFlaws;
    }
}
