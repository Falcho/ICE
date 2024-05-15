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
    protected List<Skill> ProfessionalSkills;
    protected List<Skill> Knacks;
    protected List<Skill> Realms;

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

    public Map<String, List<Integer>> getProfessionSkillCost() {
        return professionSkillCost;
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

    public List<Skill> getProfessionalSkills() {
        return ProfessionalSkills;
    }

    public List<Skill> getKnacks() {
        return Knacks;
    }

    public List<Skill> getRealms() {
        return Realms;
    }

    public Map<String, List<Spell>> getProfessionSpell() {
        return professionSpell;
    }
}
