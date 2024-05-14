package Models;

import java.util.List;
import java.util.Map;

public class Profession {

    protected String name;
    protected String description;
    protected Map<String, List<Integer>> professionSkillCost;
    protected List<String> availableRealms;
    protected List<Skill> availableProfessionalSkillList;
    protected Map<String, List<Spell>> professionSpell;
    protected List<Skill> chosenProfessionalSkills;
    protected List<Skill> chosenKnacks;
    protected List<Skill> chosenRealms;

    public Profession(String name, String description, Map<String, List<Integer>> professionSkillCost, List<String> realms, List<Skill> availableProfessionalSkillList) {
        this.name = name;
        this.description = description;
        this.professionSkillCost = professionSkillCost;
        this.availableRealms = realms;
        this.availableProfessionalSkillList = availableProfessionalSkillList;
    }

    public Map<String, List<Integer>> getSkillCost() {
        return professionSkillCost;
    }

    public List<Skill> getProfessionalSkill() {
        return availableProfessionalSkillList;
    }

    public List<String> getAvailableRealms() {
        return availableRealms;
    }

    public Map<String, List<Spell>> getSpellList() {
        return professionSpell;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Skill> getChosenProfessionalSkills() {
        return chosenProfessionalSkills;
    }

    public List<Skill> getChosenKnacks() {
        return chosenKnacks;
    }

    public List<Skill> getChosenRealms() {
        return chosenRealms;
    }
}
