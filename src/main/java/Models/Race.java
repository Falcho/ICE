package Models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Race {

    private String name;
    private String description;
    @JsonProperty("tAndFlawDescription")
    private String tAndFlawDescription;

    @JsonProperty("race_sizes")
    private RaceSizes raceSizes;

    @JsonProperty("stat_bonuses")
    private StatBonuses statBonuses;

    private Resistances resistances;

    @JsonProperty("health_and_dev")
    private HealthAndDev healthAndDev;



    // Getters and Setters

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getTAndFlawDescription() {
        return tAndFlawDescription;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTAndFlawDescription(String tAndFlawDescription) {
        this.tAndFlawDescription = tAndFlawDescription;
    }

    public void setRaceSizes(RaceSizes raceSizes) {
        this.raceSizes = raceSizes;
    }

    public void setStatBonuses(StatBonuses statBonuses) {
        this.statBonuses = statBonuses;
    }

    public void setResistances(Resistances resistances) {
        this.resistances = resistances;
    }

    public void setHealthAndDev(HealthAndDev healthAndDev) {
        this.healthAndDev = healthAndDev;
    }

    public String[][] sizeTable() {
        String[][] sizeTable = new String[4][4];
        sizeTable[0][0] = "Size";
        sizeTable[0][1] = this.raceSizes.getSize();
        sizeTable[0][2] = "Weight, Male";
        sizeTable[0][3] = this.raceSizes.getWeightMale();
        sizeTable[1][0] = "Stride";
        sizeTable[1][1] = this.raceSizes.getStride();
        sizeTable[1][2] = "Weight, Female";
        sizeTable[1][3] = this.raceSizes.getWeightFemale();
        sizeTable[2][0] = "Height";
        sizeTable[2][1] = this.raceSizes.getHeightMale();
        sizeTable[2][2] = "Variance";
        sizeTable[2][3] = this.raceSizes.getVariance();
        sizeTable[3][0] = "Height, Female";
        sizeTable[3][1] = this.raceSizes.getHeightFemale();
        sizeTable[3][2] = "";
        sizeTable[3][3] = "";

        return sizeTable;
    }

    public String[][] statBonusTable() {
        String[][] statBonusTable = new String[5][4];
        statBonusTable[0][0] = "Agility";
        statBonusTable[0][1] = "" + this.statBonuses.getAgility();
        statBonusTable[0][2] = "Presence";
        statBonusTable[0][3] = "" + this.statBonuses.getPresence();
        statBonusTable[1][0] = "Constitution";
        statBonusTable[1][1] = "" + this.statBonuses.getConstitution();
        statBonusTable[1][2] = "Quickness";
        statBonusTable[1][3] = "" + this.statBonuses.getQuickness();
        statBonusTable[2][0] = "Empathy";
        statBonusTable[2][1] = "" + this.statBonuses.getEmpathy();
        statBonusTable[2][2] = "Reasoning";
        statBonusTable[2][3] = "" + this.statBonuses.getReasoning();
        statBonusTable[3][0] = "Intuition";
        statBonusTable[3][1] = "" + this.statBonuses.getIntuition();
        statBonusTable[3][2] = "Self Discipline";
        statBonusTable[3][3] = "" + this.statBonuses.getSelfDisc();
        statBonusTable[4][0] = "Memory";
        statBonusTable[4][1] = "" + this.statBonuses.getMemory();
        statBonusTable[4][2] = "Strength";
        statBonusTable[4][3] = "" + this.statBonuses.getStrength();

        return statBonusTable;
    }

    public String[][] resistanceTable() {
        String[][] resistanceTable = new String[2][4];
        resistanceTable[0][0] = "Channeling";
        resistanceTable[0][1] = "" + this.resistances.getChanneling();
        resistanceTable[0][2] = "Mentalism";
        resistanceTable[0][3] = "" + this.resistances.getMentalism();
        resistanceTable[1][0] = "Essence";
        resistanceTable[1][1] = "" + this.resistances.getEssence();
        resistanceTable[1][2] = "Physical";
        resistanceTable[1][3] = "" + this.resistances.getPhysical();

        return resistanceTable;
    }

    public String[][] healthAndDevTable() {
        String[][] healthAndDevTable = new String[2][4];
        healthAndDevTable[0][0] = "Endurance";
        healthAndDevTable[0][1] = "" + this.healthAndDev.getEndurance();
        healthAndDevTable[0][2] = "Recovery Multiplier";
        healthAndDevTable[0][3] = this.healthAndDev.getRecoveryMult();
        healthAndDevTable[1][0] = "Base Hits";
        healthAndDevTable[1][1] = "" + this.healthAndDev.getBaseHits();
        healthAndDevTable[1][2] = "Bonus Dev. Points";
        healthAndDevTable[1][3] = "" + this.healthAndDev.getBonusDps();

        return healthAndDevTable;

    }

    public int getRaceBonus(String statName) {
        return switch (statName) {
            case "Agility", "Ag" -> statBonuses.getAgility();
            case "Constitution", "Co" -> statBonuses.getConstitution();
            case "Empathy", "Em" -> statBonuses.getEmpathy();
            case "Intuition", "In" -> statBonuses.getIntuition();
            case "Memory", "Me" -> statBonuses.getMemory();
            case "Presence", "Pr" -> statBonuses.getPresence();
            case "Quickness", "Qu" -> statBonuses.getQuickness();
            case "Reasoning", "Re" -> statBonuses.getReasoning();
            case "SelfDisc", "SD" -> statBonuses.getSelfDisc();
            case "Strength", "St" -> statBonuses.getStrength();
            case "Channeling" -> resistances.getChanneling();
            case "Essence" -> resistances.getEssence();
            case "Mentalism" -> resistances.getMentalism();
            case "Physical" -> resistances.getPhysical();
            case "Endurance " -> healthAndDev.getEndurance();
            case "Base Hits" -> healthAndDev.getBaseHits();
            //case "Recovery Mult" -> healthAndDev.getRecoveryMult();
            default -> 0;
        };

    }

    // Nested Classes for JSON properties

    public static class RaceSizes {
        private String size;
        private String weightMale;
        private String stride;
        private String weightFemale;
        private String heightMale;
        private String variance;
        private String heightFemale;

        // Getters and Setters

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        @JsonProperty("weight_male")
        public String getWeightMale() {
            return weightMale;
        }

        public void setWeightMale(String weightMale) {
            this.weightMale = weightMale;
        }

        public String getStride() {
            return stride;
        }

        public void setStride(String stride) {
            this.stride = stride;
        }

        @JsonProperty("weight_female")
        public String getWeightFemale() {
            return weightFemale;
        }

        public void setWeightFemale(String weightFemale) {
            this.weightFemale = weightFemale;
        }

        @JsonProperty("height_male")
        public String getHeightMale() {
            return heightMale;
        }

        public void setHeightMale(String heightMale) {
            this.heightMale = heightMale;
        }

        public String getVariance() {
            return variance;
        }

        public void setVariance(String variance) {
            this.variance = variance;
        }

        @JsonProperty("height_female")
        public String getHeightFemale() {
            return heightFemale;
        }

        public void setHeightFemale(String heightFemale) {
            this.heightFemale = heightFemale;
        }
    }

    public static class StatBonuses {
        private int agility;
        private int constitution;
        private int empathy;
        private int intuition;
        private int memory;
        private int presence;
        private int quickness;
        private int reasoning;

        @JsonProperty("self_discipline")
        private int selfDisc;

        private int strength;

        // Getters and Setters

        public int getAgility() {
            return agility;
        }

        public void setAgility(int agility) {
            this.agility = agility;
        }

        public int getConstitution() {
            return constitution;
        }

        public void setConstitution(int constitution) {
            this.constitution = constitution;
        }

        public int getEmpathy() {
            return empathy;
        }

        public void setEmpathy(int empathy) {
            this.empathy = empathy;
        }

        public int getIntuition() {
            return intuition;
        }

        public void setIntuition(int intuition) {
            this.intuition = intuition;
        }

        public int getMemory() {
            return memory;
        }

        public void setMemory(int memory) {
            this.memory = memory;
        }

        public int getPresence() {
            return presence;
        }

        public void setPresence(int presence) {
            this.presence = presence;
        }

        public int getQuickness() {
            return quickness;
        }

        public void setQuickness(int quickness) {
            this.quickness = quickness;
        }

        public int getReasoning() {
            return reasoning;
        }

        public void setReasoning(int reasoning) {
            this.reasoning = reasoning;
        }

        public int getSelfDisc() {
            return selfDisc;
        }

        public void setSelfDisc(int selfDisc) {
            this.selfDisc = selfDisc;
        }

        public int getStrength() {
            return strength;
        }

        public void setStrength(int strength) {
            this.strength = strength;
        }
    }

    public static class Resistances {
        private int channeling;
        private int mentalism;
        private int essence;
        private int physical;

        // Getters and Setters

        public int getChanneling() {
            return channeling;
        }

        public void setChanneling(int channeling) {
            this.channeling = channeling;
        }

        public int getMentalism() {
            return mentalism;
        }

        public void setMentalism(int mentalism) {
            this.mentalism = mentalism;
        }

        public int getEssence() {
            return essence;
        }

        public void setEssence(int essence) {
            this.essence = essence;
        }

        public int getPhysical() {
            return physical;
        }

        public void setPhysical(int physical) {
            this.physical = physical;
        }
    }

    public static class HealthAndDev {
        private int endurance;

        @JsonProperty("recovery_multiplier")
        private String recoveryMult;

        @JsonProperty("base_hits")
        private int baseHits;

        @JsonProperty("bonus_dev_points")
        private int bonusDps;

        // Getters and Setters

        public int getEndurance() {
            return endurance;
        }

        public void setEndurance(int endurance) {
            this.endurance = endurance;
        }

        public String getRecoveryMult() {
            return recoveryMult;
        }

        public void setRecoveryMult(String recoveryMult) {
            this.recoveryMult = recoveryMult;
        }

        public int getBaseHits() {
            return baseHits;
        }

        public void setBaseHits(int baseHits) {
            this.baseHits = baseHits;
        }

        public int getBonusDps() {
            return bonusDps;
        }

        public void setBonusDps(int bonusDps) {
            this.bonusDps = bonusDps;
        }
    }


}
