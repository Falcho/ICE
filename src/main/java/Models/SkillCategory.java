package Models;

import java.util.HashMap;
import java.util.Map;

public class SkillCategory {
    protected String name;
    protected String[] stats;
    protected int cost1;
    protected int cost2;
    Map<String, Skill> skillList;

    public SkillCategory(String name) {
        this.name = name;
        this.stats = new String[2];
        this.cost1 = 0;
        this.cost2 = 0;
        this.skillList = new HashMap<>();

    }

    public SkillCategory(String name, String[] stats) {
        this.name = name;
        this.stats = stats;
        this.cost1 = 0;
        this.cost2 = 0;
        this.skillList = new HashMap<>();
    }

    public SkillCategory(String name, String[] stats, int cost1, int cost2, Map<String, Skill> skillList) {
        this.name = name;
        this.stats = stats;
        this.cost1 = cost1;
        this.cost2 = cost2;
        this.skillList = skillList;


    }

    public String getName() {
        return name;
    }

    public String[] getStats() {
        return stats;
    }

    public int getCost1() {
        return cost1;
    }

    public int getCost2() {
        return cost2;
    }

    public Map<String, Skill> getSkills() {
        return skillList;
    }

    public void addSkill(String name, Skill skill) {
        skillList.put(name, skill);


    }

    public void setCost1(int cost1) {
        this.cost1 = cost1;
    }

    public void setCost2(int cost2) {
        this.cost2 = cost2;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSkillList(Map<String, Skill> skillList) {
        this.skillList = skillList;
    }

    public void setStats(String[] stats) {
        this.stats = stats;
    }
}
