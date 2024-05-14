package Models;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CharacterSheet {
    private int level;
    private int xp;
    private String name;
    private String background;
    protected Culture culture;
    protected Race race;
    protected Profession profession;
    protected PrimaryStats stats;
    protected Defense defense;
    protected ManeuversMovementAndEncumbrance MME;
    protected Inventory inventory;
    protected Map<String, SkillCategory> skillList;
    protected Map<String, Spell> spellList;
    protected Set<TalentsAndFlaws> TalentsAndFLaws;


    public CharacterSheet() {
        this.level = 0;
        this.xp = 0;
        this.name = "";
        this.background = "";
        this.stats = new PrimaryStats();
        this.skillList = Rules.getEmptySkillList();
    }

    public CharacterSheet(int level, int xp, String name, String background, Culture culture, Race race, Profession profession, PrimaryStats stats, Defense defense, ManeuversMovementAndEncumbrance MME, Inventory inventory, Map skillList, Map spellList, Set<TalentsAndFlaws> talentsAndFLaws) {
        this.level = level;
        this.xp = xp;
        this.name = name;
        this.background = background;
        this.culture = culture;
        this.race = race;
        this.profession = profession;
        this.stats = stats;
        this.defense = defense;
        this.MME = MME;
        this.inventory = inventory;
        this.skillList = skillList;
        this.spellList = spellList;
        TalentsAndFLaws = talentsAndFLaws;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStat(String statName,int[]values){
        this.stats.setStat(statName,values);
    }

    public void setStats(List<int[]>liste){
        this.stats.setStats(liste);
    }
}
