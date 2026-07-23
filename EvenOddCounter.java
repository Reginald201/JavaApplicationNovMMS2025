import java.util.Scanner;

public class EvenOddCounter{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];
        int evenCount = 0;
        int oddCount = 0;

        System.out.println("Enter 10 integer numbers:");
        
        // Store 10 elements in the array
        for (int i = 0; i < 10; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Count even and odd numbers
        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // Display the results
        System.out.println("\nResults:");
        System.out.println("Count of even numbers: " + evenCount);
        System.out.println("Count of odd numbers: " + oddCount);

        scanner.close();
    }
}