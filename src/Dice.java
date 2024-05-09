import java.util.Random;

public class Dice {


    public class DiceRoll {


        public static int rollD4() {
            Random random = new Random();
            return random.nextInt(4) + 1;
        }

        public static int rollD6() {
            Random random = new Random();
            return random.nextInt(6) + 1;
        }

        public static int rollD8() {
            Random random = new Random();
            return random.nextInt(8) + 1;
        }

        public static int rollD10() {
            Random random = new Random();
            return random.nextInt(10) + 1;
        }

        public static int rollD12() {
            Random random = new Random();
            return random.nextInt(12) + 1;
        }

        public static int rollD20() {
            Random random = new Random();
            return random.nextInt(20) + 1;
        }

        public static int rollD100() {
            Random random = new Random();
            return random.nextInt(100) + 1;
        }
    }

}
