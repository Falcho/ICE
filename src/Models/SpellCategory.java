package Models;

import java.util.HashMap;
import java.util.Map;

public class SpellCategory {

    protected String name;
    protected String[] stats;
    protected int DPCostFirst;
    protected int DPCostSecond;
    Map<String, Spell> spellList;

    public SpellCategory(String name) {
        this.name = name;
        this.stats = new String[2];
        this.DPCostFirst = 0;
        this.DPCostSecond = 0;
        this.spellList = new HashMap<>();
    }

    public SpellCategory(String name, String[] stats, int DPCostFirst, int DPCostSecond, Map<String, Spell> spellList) {
        this.name = name;
        this.stats = stats;
        this.DPCostFirst = DPCostFirst;
        this.DPCostSecond = DPCostSecond;
        this.spellList = spellList;

    }

    public String getName() {
        return name;
    }

    public String[] getStats() {
        return stats;
    }

    public int getDPCostFirst() {
        return DPCostFirst;
    }

    public int getDPCostSecond() {
        return DPCostSecond;
    }

    public Map<String, Spell> getSkills() {
        return spellList;
    }

    public void addSpell(String name, Spell spell) {
        spellList.put(name, spell);
    }
}