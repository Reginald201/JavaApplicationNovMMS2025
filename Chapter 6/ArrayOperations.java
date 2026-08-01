import java.util.Random;

public class ArrayOperations{
    public static void main(String[] args) {
        // a) Set the 10 elements of integer array counts to zero.
        int[] counts = new int[10];
        for (int i = 0; i < counts.length; i++) {
            counts[i] = 0;
        }

        // b) Add one to each of the 15 elements of integer array bonus.
        int[] bonus = new int[15]; // starts at 0 by default
        for (int i = 0; i < bonus.length; i++) {
            bonus[i] += 1;
        }

        // c) Display the five values of integer array bestScores in column format.
        int[] bestScores = new int[5];
        Random random = new Random();
        for (int i = 0; i < bestScores.length; i++) {
            bestScores[i] = 60 + random.nextInt(41); // sample data 60-100
        }

        System.out.println("counts: ");
        for (int value : counts) {
            System.out.print(value + " ");
        }

        System.out.println("\n\nbonus: ");
        for (int value : bonus) {
            System.out.print(value + " ");
        }

        System.out.println("\n\nbestScores (column format):");
        for (int value : bestScores) {
            System.out.printf("%d%n", value);
        }
    }
}