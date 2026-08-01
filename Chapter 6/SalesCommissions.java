import java.util.Scanner;

public class SalesCommissions{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // counts[0] -> $200-299, counts[1] -> $300-399, ... counts[7] -> $900-999,
        // counts[8] -> $1000 and over
        int[] counts = new int[9];

        System.out.print("Enter the number of salespeople: ");
        int numberOfSalespeople = input.nextInt();

        for (int i = 1; i <= numberOfSalespeople; i++) {
            System.out.printf("Enter gross sales for salesperson %d: ", i);
            double grossSales = input.nextDouble();

            int salary = (int) (200 + 0.09 * grossSales); // truncated to int

            int index;
            if (salary >= 1000) {
                index = 8;
            } else {
                index = (salary - 200) / 100;
            }
            counts[index]++;
        }

        System.out.println("\nSalary ranges:            Number of salespeople");
        for (int i = 0; i < 8; i++) {
            System.out.printf("$%d-%d:                  %d%n", 200 + i * 100, 299 + i * 100, counts[i]);
        }
        System.out.printf("$1000 and over:            %d%n", counts[8]);

        input.close();
    }
}