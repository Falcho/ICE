public class Stat {
    private String name;
   private int potentionel;
   private int temp;
    protected int bonus() {
        int bonus = 0;
        if (this.temp == 1)
            bonus = -15;
        else if (this.temp == 2)
            bonus = -14;
        else if(this.temp == 3)
            bonus = -13;
        else if (this.temp == 4)
            bonus = -12;
        else if(this.temp == 5)
            bonus = -11;
        else if (this.temp == 6)
            bonus = -10;
        else if(this.temp == 7-8)
            bonus = -9;
        else if (this.temp==9-11)
            bonus = -8;
        else if (this.temp == 12-14)
            bonus = -7;
        else if (this.temp == 15-17)
            bonus = -6;
        else if (this.temp == 18-23)
            bonus = -5;
        else if (this.temp == 24-29)
            bonus = -4;
        else if (this.temp == 30-35)
            bonus = -3;
        else if (this.temp == 36-41)
            bonus = -2;
        else if (this.temp == 42-47)
            bonus = -1;
        else if (this.temp == 48-53)
            bonus = 0;
        else if (this.temp == 54-59)
            bonus = 1;
        else if (this.temp == 60-65)
            bonus = 2;
        else if (this.temp == 66-71)
            bonus = 3;
        else if (this.temp == 72-77)
            bonus = 4;
        else if (this.temp == 78-83)
            bonus = 5;
        else if (this.temp == 84-86)
            bonus = 6;
        else if (this.temp == 87-89)
            bonus = 7;
        else if (this.temp == 90-92)
            bonus = 8;
        else if (this.temp == 93-94)
            bonus = 9;
        else if (this.temp == 95)
            bonus = 10;
        else if (this.temp == 96)
            bonus = 11;
        else if (this.temp == 97)
            bonus = 12;
        else if (this.temp == 98)
            bonus = 13;
        else if (this.temp == 99)
            bonus = 14;
        else if (this.temp == 100)
            bonus = 15;

        return bonus;
    }

    protected int getRaceBonus(){
        return charactersheet.race.getBonus(this.name);
        }
}

