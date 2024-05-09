package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Profession {

    private Map<String,Integer> professions;
    private List<String>realms;
    private List<String>professionSkills;
    private Map<String,List>professionSpell;
    String description;

    public Profession(Map<String, Integer> professions, List<String> realms, List<String> professionSkills, Map<String, List> professionSpell, String description) {
        this.professions = professions;
        this.realms = realms;
        this.professionSkills = professionSkills;
        this.professionSpell = professionSpell;
        this.description = description;
    }

    public Map getSkillCost(){
        return skillCost;
    }

    public List getProfessionalSkill(){
        return professionSkill;
    }

    public List getRealms(){
        return realms;
    }

    public Map getSpellList(){
        return spellList;
    }
}
