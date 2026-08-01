import java.util.Random;

public class TortoiseAndHare{
    private static final int FINISH = 70;

    public static void main(String[] args) {
        Random random = new Random();
        int tortoise = 1;
        int hare = 1;

        System.out.println("BANG !!!!!");
        System.out.println("AND THEY'RE OFF !!!!!");

        while (tortoise < FINISH && hare < FINISH) {
            // Move the tortoise
            int t = 1 + random.nextInt(10);
            if (t <= 5) {
                tortoise += 3; // fast plod
            } else if (t <= 7) {
                tortoise -= 6; // slip
            } else {
                tortoise += 1; // slow plod
            }
            if (tortoise < 1) {
                tortoise = 1;
            }

            // Move the hare
            int h = 1 + random.nextInt(10);
            if (h <= 2) {
                hare += 9; // fast plod
            } else if (h <= 3) {
                hare -= 12; // slip
            } else if (h <= 6) {
                hare += 1; // slow plod
            } else if (h <= 8) {
                // stays in place - sleeping/watching
            } else {
                hare -= 2; // slip
            }
            if (hare < 1) {
                hare = 1;
            }

            printPositions(tortoise, hare);

            if (tortoise >= FINISH && hare >= FINISH) {
                System.out.println("It's a tie!");
                return;
            } else if (tortoise >= FINISH) {
                System.out.println("TORTOISE WINS!!! YAY!!!");
                return;
            } else if (hare >= FINISH) {
                System.out.println("Hare wins. Yuch.");
                return;
            }
        }
    }

    private static void printPositions(int tortoise, int hare) {
        StringBuilder line = new StringBuilder();
        for (int position = 1; position <= FINISH; position++) {
            boolean isTortoise = position == tortoise;
            boolean isHare = position == hare;
            if (isTortoise && isHare) {
                line.append("OUCH!!!");
            } else if (isTortoise) {
                line.append('T');
            } else if (isHare) {
                line.append('H');
            } else {
                line.append(' ');
            }
        }
        System.out.println(line);
    }
}