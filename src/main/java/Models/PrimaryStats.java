package Models;


import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PrimaryStats implements Iterable<Stat>{
    private CharacterSheet cs;
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

    public PrimaryStats(CharacterSheet cs) {
        this.cs = cs;
        this.agility = new Stat("agility", cs);
        this.constitution = new Stat("constitution", cs);
        this.empathy = new Stat("empathy", cs);
        this.intuition = new Stat("intuition", cs);
        this.memory = new Stat("memory", cs);
        this.presence = new Stat("presence", cs);
        this.quickness = new Stat("quickness", cs);
        this.reasoning = new Stat("reasoning", cs);
        this.selfDiscipline = new Stat("selfDiscipline", cs);
        this.strength = new Stat("strength", cs);
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
        return switch (statName) {
            case "agility", "Ag" -> this.agility;
            case "constitution", "Co" -> this.constitution;
            case "empathy", "Em" -> this.empathy;
            case "intuition", "In" -> this.empathy;
            case "memory", "Me" -> this.memory;
            case "presence", "Pr" -> this.presence;
            case "quickness", "Qu" -> this.quickness;
            case "reasoning", "Re" -> this.reasoning;
            case "selfDiscipline", "SD" -> this.selfDiscipline;
            case "strength", "St" -> this.strength;
            default -> null;
        };
    }


    @Override
    public Iterator<Stat> iterator() {
        return new PrimaryStatsIterator();
    }

    private class PrimaryStatsIterator implements Iterator<Stat> {
        private int index = 0;
        private final Stat[] stats = {
                agility, constitution, empathy, intuition, memory,
                presence, quickness, reasoning, selfDiscipline, strength
        };

        @Override
        public boolean hasNext() {
            return index < stats.length;
        }

        @Override
        public Stat next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return stats[index++];
        }
    }
}


