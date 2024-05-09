package Models;

public class Race {
    private String race;
    private int bonusDps;
    private int agility;
    private int constitution;
    private int empathy;
    private int intuition;
    private int memory;
    private int presence;
    private int quickness;
    private int reasoning;
    private int selfDisc;
    private int strength;
    private int channeling;
    private int essence;
    private int mentalism;
    private int physical;
    private int endurance;
    private int baseHits;
    private int recoveryMult;

    public Race(String race, int bonusDps, int agility, int constitution, int empathy, int intuition, int memory, int presence, int quickness, int reasoning, int selfDisc, int strength, int channeling, int essence, int mentalism, int physical, int endurance, int baseHits, int recoveryMult) {
        this.race = race;
        this.bonusDps = bonusDps;
        this.agility = agility;
        this.constitution = constitution;
        this.empathy = empathy;
        this.intuition = intuition;
        this.memory = memory;
        this.presence = presence;
        this.quickness = quickness;
        this.reasoning = reasoning;
        this.selfDisc = selfDisc;
        this.strength = strength;
        this.channeling = channeling;
        this.essence = essence;
        this.mentalism = mentalism;
        this.physical = physical;
        this.endurance = endurance;
        this.baseHits = baseHits;
        this.recoveryMult = recoveryMult;
    }


    public int getBonusDps() {
        return bonusDps;
    }

    public int getAgility() {
        return agility;
    }

    public int getConstitution() {
        return constitution;
    }

    public int getEmpathy() {
        return empathy;
    }

    public int getIntuition() {
        return intuition;
    }

    public int getMemory() {
        return memory;
    }

    public int getPresence() {
        return presence;
    }

    public int getQuickness() {
        return quickness;
    }

    public int getReasoning() {
        return reasoning;
    }

    public int getSelfDisc() {
        return selfDisc;
    }

    public int getStrength() {
        return strength;
    }

    public int getChanneling() {
        return channeling;
    }

    public int getEssence() {
        return essence;
    }

    public int getMentalism() {
        return mentalism;
    }

    public int getPhysical() {
        return physical;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getBaseHits() {
        return baseHits;
    }

    public int getRecoveryMult() {
        return recoveryMult;
    }

    public int getRaceBonus(String statName) {
        return switch (statName) {
            case "Agility", "Ag" -> getAgility();
            case "Constitution", "Co" -> getConstitution();
            case "Empathy", "Em" -> getEmpathy();
            case "Intuition", "In" -> getIntuition();
            case "Memory", "Me" -> getMemory();
            case "Presence", "Pr" -> getPresence();
            case "Quickness", "Qu" -> getQuickness();
            case "Reasoning", "Re" -> getReasoning();
            case "SelfDisc", "SD" -> getSelfDisc();
            case "Strength", "St" -> getStrength();
            case "Channeling" -> getChanneling();
            case "Essence" -> getEssence();
            case "Mentalism" -> getMentalism();
            case "Physical" -> getPhysical();
            case "Endurance " -> getEndurance();
            case "Base Hits" -> getBaseHits();
            case "Recovery Mult" -> getRecoveryMult();
            default -> 0;
        };

    }
}
