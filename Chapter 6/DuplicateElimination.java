import java.util.Scanner;

public class DuplicateElimination{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] uniqueNumbers = new int[5]; // worst case: all five are different
        int uniqueCount = 0;

        for (int i = 1; i <= 5; i++) {
            System.out.printf("Enter number %d (10-100): ", i);
            int number = input.nextInt();

            boolean isDuplicate = false;
            for (int j = 0; j < uniqueCount; j++) {
                if (uniqueNumbers[j] == number) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                System.out.println(number + " is a duplicate - not added.");
            } else {
                uniqueNumbers[uniqueCount] = number;
                uniqueCount++;
                System.out.println(number + " added.");
            }

            System.out.print("Current unique values: ");
            for (int j = 0; j < uniqueCount; j++) {
                System.out.print(uniqueNumbers[j] + " ");
            }
            System.out.println("\n");
        }

        input.close();
    }
}