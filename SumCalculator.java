import java.util.Scanner;

public class SumCalculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter 10 numbers one by one:");
        
        double num1 = readNumber(scanner, 1);
        double num2 = readNumber(scanner, 2);
        double num3 = readNumber(scanner, 3);
        double num4 = readNumber(scanner, 4);
        double num5 = readNumber(scanner, 5);
        double num6 = readNumber(scanner, 6);
        double num7 = readNumber(scanner, 7);
        double num8 = readNumber(scanner, 8);
        double num9 = readNumber(scanner, 9);
        double num10 = readNumber(scanner, 10);
        
        double result = calculateResult(num1, num2, num3, num4, num5, 
                                        num6, num7, num8, num9, num10);
        
        System.out.println("\nResult: " + result);
        scanner.close();
    }
    
    // Helper method to read one number
    private static double readNumber(Scanner scanner, int position) {
        System.out.print("Number " + position + ": ");
        return scanner.nextDouble();
    }
    
    /**
     * Java method that accepts 10 numbers (without using array)
     * and returns: (sum of 6th-9th + sum of 2nd+4th+9th) / sum of 2nd-5th
     */
    public static double calculateResult(double n1, double n2, double n3, double n4,
                                         double n5, double n6, double n7, double n8,
                                         double n9, double n10) {
        
        // Sum of 6th to 9th numbers
        double sum6to9 = n6 + n7 + n8 + n9;
        
        // Sum of 2nd + 4th + 9th numbers
        double sum2_4_9 = n2 + n4 + n9;
        
        double total = sum6to9 + sum2_4_9;
        
        // Sum of 2nd to 5th numbers
        double sum2to5 = n2 + n3 + n4 + n5;
        
        if (sum2to5 == 0) {
            System.out.println("Warning: Cannot divide by zero (sum of 2nd to 5th is 0).");
            return Double.NaN;
        }
        
        return total / sum2to5;
    }
}