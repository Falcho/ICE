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

    public Profession(String name, String description, Map<String, List<Integer>> professionSkillCost, List<String> chosenRealms, List<Skill> availableProfessionalSkillList) {
        this.name = name;
        this.description = description;
        this.professionSkillCost = professionSkillCost;
        this.availableRealms = chosenRealms;
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

    public List<Skill> getChosenProfessionalSkills() {
        return chosenProfessionalSkills;
    }

    public List<Skill> getChosenKnacks() {
        return chosenKnacks;
    }

    public List<Skill> getChosenRealms() {
        return chosenRealms;
    }

    public Map<String, List<Spell>> getProfessionSpell() {
        return professionSpell;
    }

    public List<Skill> getAvailableProfessionalSkillList() {
        return availableProfessionalSkillList;
    }

    public void setAvailableProfessionalSkillList(List<Skill> availableProfessionalSkillList) {
        this.availableProfessionalSkillList = availableProfessionalSkillList;
    }

    public void setAvailableRealms(List<String> availableRealms) {
        this.availableRealms = availableRealms;
    }

    public void setChosenKnacks(List<Skill> chosenKnacks) {
        this.chosenKnacks = chosenKnacks;
    }

    public void setChosenProfessionalSkills(List<Skill> chosenProfessionalSkills) {
        this.chosenProfessionalSkills = chosenProfessionalSkills;
    }

    public void setChosenRealms(List<Skill> chosenRealms) {
        this.chosenRealms = chosenRealms;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfessionSkillCost(Map<String, List<Integer>> professionSkillCost) {
        this.professionSkillCost = professionSkillCost;
    }

    public void setProfessionSpell(Map<String, List<Spell>> professionSpell) {
        this.professionSpell = professionSpell;
    }
}
