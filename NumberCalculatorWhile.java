import java.util.Scanner;

public class NumberCalculatorWhile {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Initialize variables
        double sum = 0;
        double product = 1;
        int count = 1;

        System.out.println("Please enter 10 numbers:");

        // While loop to accept and process 10 numbers
        while (count <= 10) {

            System.out.print("Enter number " + count + ": ");
            double num = scanner.nextDouble();

            // Perform running calculations
            sum += num;
            product *= num;

            count++; // Increment counter
        }

        // Calculate average
        double average = sum / 10;

        // Display results
        System.out.println("\n--- Results ---");
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        System.out.println("Product: " + product);

        // Close scanner
        scanner.close();
    }
}