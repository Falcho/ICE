import Models.Culture;
import Models.PrimaryStats;
import Models.Race;

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
    protected Map SkillList<String,Skill>;
    protected  Map SpellListz <String,Spell>;
    protected Set<TalentsAndFlaws>TalentsAndFLaws;


    public CharacterSheet(int level, int xp, String name, String background, Culture culture, Race race, Profession profession, PrimaryStats stats, Defense defense, ManeuversMovementAndEncumbrance MME, Inventory inventory, Map skillList, Map spellListz, Set<TalentsAndFlaws> talentsAndFLaws) {
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
        SkillList = skillList;
        SpellListz = spellListz;
        TalentsAndFLaws = talentsAndFLaws;
    }
}
