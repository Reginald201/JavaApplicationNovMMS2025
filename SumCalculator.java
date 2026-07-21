import java.util.Scanner;

public class SumCalculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];
        
        System.out.println("Enter 10 numbers one by one:");
        for (int i = 0; i < 10; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextDouble();
        }
        
        double result = calculateResult(numbers);
        System.out.println("\nResult: " + result);
        
        scanner.close();
    }
    
    /**
     * Java method that accepts 10 numbers and performs the required calculation.
     * Returns (sum of 6th-9th + sum of 2nd+4th+9th) / sum of 2nd-5th
     */
    public static double calculateResult(double[] nums) {
        if (nums.length != 10) {
            throw new IllegalArgumentException("Array must contain exactly 10 numbers.");
        }
        
        // 0-based array indices:
        // 2nd number = index 1, 4th = 3, 6th = 5, 9th = 8
        // Sum 6th to 9th: indices 5,6,7,8
        // Sum 2nd to 5th: indices 1,2,3,4
        
        double sum6to9 = nums[5] + nums[6] + nums[7] + nums[8];
        double sum2_4_9 = nums[1] + nums[3] + nums[8];
        double total = sum6to9 + sum2_4_9;
        
        double sum2to5 = nums[1] + nums[2] + nums[3] + nums[4];
        
        if (sum2to5 == 0) {
            System.out.println("Warning: Cannot divide by zero (sum of 2nd to 5th is 0).");
            return Double.NaN;
        }
        
        return total / sum2to5;
    }
}