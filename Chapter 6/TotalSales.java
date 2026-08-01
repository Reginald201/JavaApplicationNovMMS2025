import java.util.Scanner;

public class TotalSales{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int PRODUCTS = 5;
        final int SALESPEOPLE = 4;
        double[][] sales = new double[PRODUCTS][SALESPEOPLE];

        System.out.println("Enter sales slips (salesperson 1-4, product 1-5, amount)."
                + " Enter salesperson 0 to stop.");

        while (true) {
            System.out.print("Salesperson: ");
            int salesperson = input.nextInt();
            if (salesperson == 0) {
                break;
            }
            System.out.print("Product: ");
            int product = input.nextInt();
            System.out.print("Amount: ");
            double amount = input.nextDouble();

            sales[product - 1][salesperson - 1] += amount;
        }

        // Header
        System.out.printf("%-10s", "Product");
        for (int s = 1; s <= SALESPEOPLE; s++) {
            System.out.printf("SP%-8d", s);
        }
        System.out.println("Total");

        double[] salespersonTotals = new double[SALESPEOPLE];
        double grandTotal = 0.0;

        for (int p = 0; p < PRODUCTS; p++) {
            System.out.printf("%-10d", p + 1);
            double productTotal = 0.0;
            for (int s = 0; s < SALESPEOPLE; s++) {
                System.out.printf("%-10.2f", sales[p][s]);
                productTotal += sales[p][s];
                salespersonTotals[s] += sales[p][s];
            }
            System.out.printf("%.2f%n", productTotal);
            grandTotal += productTotal;
        }

        System.out.printf("%-10s", "Totals");
        for (int s = 0; s < SALESPEOPLE; s++) {
            System.out.printf("%-10.2f", salespersonTotals[s]);
        }
        System.out.printf("%.2f%n", grandTotal);

        input.close();
    }
}