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
        this.stats = new PrimaryStats(this);
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

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public Culture getCulture() {
        return culture;
    }

    public void setCulture(Culture culture) {
        this.culture = culture;
    }

    public Defense getDefense() {
        return defense;
    }

    public void setDefense(Defense defense) {
        this.defense = defense;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ManeuversMovementAndEncumbrance getMME() {
        return MME;
    }

    public void setMME(ManeuversMovementAndEncumbrance MME) {
        this.MME = MME;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Map<String, SkillCategory> getSkillList() {
        return skillList;
    }

    public void setSkillList(Map<String, SkillCategory> skillList) {
        this.skillList = skillList;
    }

    public Map<String, Spell> getSpellList() {
        return spellList;
    }

    public void setSpellList(Map<String, Spell> spellList) {
        this.spellList = spellList;
    }

    public PrimaryStats getStats() {
        return stats;
    }

    public void setStats(PrimaryStats stats) {
        this.stats = stats;
    }

    public Set<TalentsAndFlaws> getTalentsAndFLaws() {
        return TalentsAndFLaws;
    }

    public void setTalentsAndFLaws(Set<TalentsAndFlaws> talentsAndFLaws) {
        TalentsAndFLaws = talentsAndFLaws;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }



    public Stat getStat(String statName){

        return stats.getStat(statName);
    }

    public String[][] getStatBlock() {
        String[][] statBlock = new String[10][7];
        int i=0;
        for (Stat stat : getStats()) {
            statBlock[i][0] = stat.getName();
            statBlock[i][1] = String.valueOf(stat.getPotentionel());
            statBlock[i][2] = String.valueOf(stat.getTemp());
            statBlock[i][3] = String.valueOf(stat.getBonus());
            statBlock[i][4] = String.valueOf(stat.getRaceBonus());
            statBlock[i][5] = ""; //String.valueOf(stat.getSpecial());
            statBlock[i][6] = String.valueOf(stat.getTotalBonus());
        }
        return statBlock;
    }



}
