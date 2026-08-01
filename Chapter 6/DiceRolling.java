import java.util.Random;

public class DiceRolling{
    public static void main(String[] args) {
        Random randomNumbers = new Random();
        int[] frequency = new int[13]; // indices 2-12 used
        final int ROLLS = 36_000_000;

        for (int i = 0; i < ROLLS; i++) {
            int die1 = 1 + randomNumbers.nextInt(6);
            int die2 = 1 + randomNumbers.nextInt(6);
            frequency[die1 + die2]++;
        }

        System.out.printf("%-6s%s%n", "Sum", "Frequency");
        for (int sum = 2; sum <= 12; sum++) {
            System.out.printf("%-6d%d%n", sum, frequency[sum]);
        }
    }
}