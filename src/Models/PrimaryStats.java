package Models;

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

    public PrimaryStats(){
        this.agility= new Stat("agility");
        this.constitution = new Stat("contitition");
        this.empathy= new Stat ("empathy");
        this.intuition= new Stat("intuition");
        this.memory= new Stat("memory");
        this.presence=new Stat("presence");
        this.quickness= new Stat("quickness");
        this.reasoning = new Stat("reasoning");
        this.selfDiscipline= new Stat("selfDiscipline");
        this.strength= new Stat("strength");
    }

}
