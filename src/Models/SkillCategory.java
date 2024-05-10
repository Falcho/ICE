package Models;

import java.sql.Array;
import java.util.HashMap;
import java.util.Map;

public class SkillCategory {
    protected String name;
    protected String[]stats;
    protected int DPCostFirst;
    protected int DPCostSecond;
    Map<String,Skill> skillList;

    public SkillCategory(String name){
        this.name=name;
        this.stats = new String[2];
        this.DPCostFirst= 0;
        this.DPCostSecond=0;
        this.skillList=new HashMap<>();

    }
    public SkillCategory(String name,String[]stats,int DPCostFirst,int DPCostSecond, Map<String,Skill> skillList){
        this.name=name;
        this.stats=stats;
        this.DPCostFirst=DPCostFirst;
        this.DPCostSecond=DPCostSecond;
        this.skillList=skillList;


    }

    public String getName(){
        return name;
    }
    public String[] getStats(){
        return stats;
    }
    public int getDPCostFirst(){
        return DPCostFirst;
    }
    public int getDPCostSecond(){
        return DPCostSecond;
    }
    public Map<String,Skill> getSkills(){
        return skillList;
    }
    public void addSkill(String name,Skill skill) {
        skillList.put(name,skill);


}
}
