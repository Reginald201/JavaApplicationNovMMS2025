import java.util.Scanner;

public class SentinelLoop {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int number;
        int positive = 0;
        int negative = 0;
        int zero = 0;

        System.out.println("Enter numbers one by one.");
        System.out.println("Enter -999 to stop.");

        number = input.nextInt();

        while (number != -999) {

            if (number > 0) {
                positive++;
            } else if (number < 0) {
                negative++;
            } else {
                zero++;
            }

            number = input.nextInt();
        }

        System.out.println("\nResults:");
        System.out.println("Positive numbers: " + positive);
        System.out.println("Negative numbers: " + negative);
        System.out.println("Zeros: " + zero);

        input.close();
    }
}