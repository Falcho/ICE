package Models;


import java.util.List;

public class PrimaryStats {
    protected Stat agility;
    protected Stat constitution;
    protected Stat empathy;
    protected Stat intuition;
    protected Stat memory;
    protected Stat presence;
    protected Stat quickness;
    protected Stat reasoning;
    protected Stat selfDiscipline;
    protected Stat strength;

    public PrimaryStats() {
        this.agility = new Stat("agility");
        this.constitution = new Stat("constitution");
        this.empathy = new Stat("empathy");
        this.intuition = new Stat("intuition");
        this.memory = new Stat("memory");
        this.presence = new Stat("presence");
        this.quickness = new Stat("quickness");
        this.reasoning = new Stat("reasoning");
        this.selfDiscipline = new Stat("selfDiscipline");
        this.strength = new Stat("strength");
    }

    public void setStat(String statNavn, int[] values) {
        if (statNavn.equals("agility")) {
            this.agility.setStat(values);
        }
        if (statNavn.equals("constitution")) {
            this.constitution.setStat(values);
        }
        if (statNavn.equals("empathy")) {
            this.empathy.setStat(values);
        }
        if (statNavn.equals("intuition")) {
            this.intuition.setStat(values);
        }
        if (statNavn.equals("memory")) {
            this.memory.setStat(values);
        }
        if (statNavn.equals("presence")) {
            this.presence.setStat(values);
        }
        if (statNavn.equals("quickness")) {
            this.quickness.setStat(values);
        }
        if (statNavn.equals("reasoning")) {
            this.reasoning.setStat(values);
        }
        if (statNavn.equals("selfDiscipline")) {
            this.selfDiscipline.setStat(values);
        }

        if (statNavn.equals("strength")) {
            this.strength.setStat(values);
        }


    }

    public void setStats(List<int[]> stats) {
        this.setStat("agility", stats.get(0));
        this.setStat("constitution", stats.get(1));
        this.setStat("empathy", stats.get(2));
        this.setStat("intuition", stats.get(3));
        this.setStat("memory", stats.get(4));
        this.setStat("presence", stats.get(5));
        this.setStat("quickness", stats.get(6));
        this.setStat("reasoning", stats.get(7));
        this.setStat("selfDiscipline", stats.get(8));
        this.setStat("strength", stats.get(9));

    }


    public Stat getStat(String statName){
        if(statName.equals("agility")){
            return this.agility;
        }
        if(statName.equals("constitution")){
            return this.constitution;
        }
        if (statName.equals("empathy")){
            return this.empathy;
        }
        if (statName.equals("intuition")) {
            return this.empathy;
        }
        if (statName.equals("memory")) {
            return this.empathy;
        }
        if (statName.equals("presence")) {
            return this.empathy;
        }
        if (statName.equals("quickness")) {
            return this.empathy;
        }
        if (statName.equals("reasoning")){
            return this.empathy;
        }
        if (statName.equals("selfDiscipline")) {
            return this.empathy;
        }
        if (statName.equals("strength")) {
            return this.empathy;
        }
        return null;
    }


}


