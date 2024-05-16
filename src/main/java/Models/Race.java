package Models;

import java.util.Map;

public class Race {
    private String name;
    private String size;
    private String weight_male;
    private String stride;
    private String weight_female;
    private String height_male;
    private String variance;
    private String height_female;
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
    private int mentalism;
    private int essence;
    private int physical;
    private int endurance;
    private int recoveryMult;
    private int baseHits;
    private int bonusDps;
    private String description;
    private String tAndFlawDescription;




    public Race(){

    }


    public String[][] sizeTable(){
        String[][] sizeTable = new String[4][4];
        sizeTable[0][0] = "Size";
        sizeTable[0][1] = this.size;
        sizeTable[0][2] = "Weight, Male";
        sizeTable[0][3] = this.weight_male;
        sizeTable[1][0] = "Stride";
        sizeTable[1][1] = this.stride;
        sizeTable[1][2] = "Weight, Female";
        sizeTable[1][3] = this.weight_female;
        sizeTable[2][0] = "Height";
        sizeTable[2][1] = this.height_male;
        sizeTable[2][2] = "Variance";
        sizeTable[2][3] = this.variance;
        sizeTable[3][0] = "Height, Female";
        sizeTable[3][1] = this.height_female;
        sizeTable[3][2] = "";
        sizeTable[3][3] = "";

        return sizeTable;
    }

    public String[][] statBonusTable(){
        String[][] statBonusTable = new String[5][4];
        statBonusTable[0][0] = "Agility";
        statBonusTable[0][1] = "" + this.agility;
        statBonusTable[0][2] = "Presence";
        statBonusTable[0][3] = "" + this.presence;
        statBonusTable[1][0] = "Constitution";
        statBonusTable[1][1] = "" + this.constitution;
        statBonusTable[1][2] = "Quickness";
        statBonusTable[1][3] = "" + this.quickness;
        statBonusTable[2][0] = "Empathy";
        statBonusTable[2][1] = "" + this.empathy;
        statBonusTable[2][2] = "Reasoning";
        statBonusTable[2][3] = "" + this.reasoning;
        statBonusTable[3][0] = "Intuition";
        statBonusTable[3][1] = "" + this.intuition;
        statBonusTable[3][2] = "Self Discipline";
        statBonusTable[3][3] = "" + this.selfDisc;
        statBonusTable[4][0] = "Memory";
        statBonusTable[4][1] = "" + this.memory;
        statBonusTable[4][2] = "Strength";
        statBonusTable[4][3] = "" + this.strength;

        return statBonusTable;
    }

    public String[][] resistanceTable(){
        String[][] resistanceTable = new String[2][4];
        resistanceTable[0][0] = "Channeling";
        resistanceTable[0][1] = "" + this.channeling;
        resistanceTable[0][2] = "Mentalism";
        resistanceTable[0][3] = "" + this.mentalism;
        resistanceTable[1][0] = "Essence";
        resistanceTable[1][1] = "" + this.essence;
        resistanceTable[1][2] = "Physical";
        resistanceTable[1][3] = "" + this.physical;

        return resistanceTable;
    }

    public String[][] healthAndDevTable(){
        String[][] healthAndDevTable = new String[2][4];
        healthAndDevTable[0][0] = "Endurance";
        healthAndDevTable[0][1] = "" + this.endurance;
        healthAndDevTable[0][2] = "Recovery Multiplier";
        healthAndDevTable[0][3] = "" + this.recoveryMult;
        healthAndDevTable[1][0] = "Base Hits";
        healthAndDevTable[1][1] = "" + this.baseHits;
        healthAndDevTable[1][2] = "Bonus Dev. Points";
        healthAndDevTable[1][3] = "" + this.bonusDps;

        return healthAndDevTable;

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

    public String getDescription() {
        return description;
    }

    public String getTAndFlawDescription() {
        return tAndFlawDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setWeight_male(String weight_male) {
        this.weight_male = weight_male;
    }

    public void setStride(String stride) {
        this.stride = stride;
    }

    public void setWeight_female(String weight_female) {
        this.weight_female = weight_female;
    }

    public void setHeight_male(String height_male) {
        this.height_male = height_male;
    }

    public void setVariance(String variance) {
        this.variance = variance;
    }

    public void setHeight_female(String height_female) {
        this.height_female = height_female;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public void setEmpathy(int empathy) {
        this.empathy = empathy;
    }

    public void setIntuition(int intuition) {
        this.intuition = intuition;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setPresence(int presence) {
        this.presence = presence;
    }

    public void setQuickness(int quickness) {
        this.quickness = quickness;
    }

    public void setReasoning(int reasoning) {
        this.reasoning = reasoning;
    }

    public void setSelfDisc(int selfDisc) {
        this.selfDisc = selfDisc;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setChanneling(int channeling) {
        this.channeling = channeling;
    }

    public void setMentalism(int mentalism) {
        this.mentalism = mentalism;
    }

    public void setEssence(int essence) {
        this.essence = essence;
    }

    public void setPhysical(int physical) {
        this.physical = physical;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public void setRecoveryMult(int recoveryMult) {
        this.recoveryMult = recoveryMult;
    }

    public void setBaseHits(int baseHits) {
        this.baseHits = baseHits;
    }

    public void setBonusDps(int bonusDps) {
        this.bonusDps = bonusDps;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void settAndFlawDescription(String tAndFlawDescription) {
        this.tAndFlawDescription = tAndFlawDescription;
    }
}
