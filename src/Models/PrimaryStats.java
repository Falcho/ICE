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

    public void setStat(String statNavn,int[] values){
        if(statNavn.equals("agility")){
            this.agility.setStat(values);
        }
        if(statNavn.equals("contitition")){
            this.constitution.setStat(values);
        }
        if (statNavn.equals("empathy")){
            this.empathy.setStat(values);
        }
        if(statNavn.equals("intuition")){
            this.intuition.setStat(values);
        }
        if(statNavn.equals("memory")){
            this.memory.setStat(values);
        }
        if(statNavn.equals("presence")){
            this.presence.setStat(values);
        }
        if(statNavn.equals("quickness")){
            this.quickness.setStat(values);
        }
        if(statNavn.equals("reasoning")){
            this.reasoning.setStat(values);
        }
        if(statNavn.equals("selfDiscipline")){
        this.selfDiscipline.setStat(values);
        }

        if(statNavn.equals("strength")){
            this.strength.setStat(values);
        }






    }


