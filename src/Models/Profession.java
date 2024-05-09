package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Profession {

    private Map<String,Integer> professions;
    private List<String>realms;
    private List<Skill>professionSkills;
    private Map<String,List<Spell>>professionSpell;
    String description;

    public Profession(Map<String, Integer> professions, List<String> realms, List<Skill> professionSkills, Map<String, List<Spell>> professionSpell, String description) {
        this.professions = professions;
        this.realms = realms;
        this.professionSkills = professionSkills;
        this.professionSpell = professionSpell;
        this.description = description;
    }

    public Map<String,Integer>getSkillCost(){
        return professions;
    }

    public List<Skill>getProfessionalSkill(){
        return professionSkills;
    }

    public List<String>getRealms(){
        return realms;
    }

    public Map<String,List<Spell>>getSpellList(){
        return professionSpell;
    }
}
