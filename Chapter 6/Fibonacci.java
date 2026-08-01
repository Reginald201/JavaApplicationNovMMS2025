import java.util.Scanner;

public class Fibonacci{
    public static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long previous = 0, current = 1;
        for (int i = 2; i <= n; i++) {
            long next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }

    public static double fibonacciDouble(int n) {
        if (n == 0) {
            return 0.0;
        }
        if (n == 1) {
            return 1.0;
        }
        double previous = 0.0, current = 1.0;
        for (int i = 2; i <= n; i++) {
            double next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the value of n: ");
        int n = input.nextInt();
        System.out.println("fibonacci(" + n + ") = " + fibonacci(n));

        // b) Find the largest Fibonacci number representable with a long
        // (using long instead of int here for a meaningful, non-overflowing demo).
        int i = 0;
        long value = fibonacci(i);
        while (value >= 0 && fibonacci(i + 1) >= value) {
            i++;
            long next = fibonacci(i);
            if (next < value) { // overflow occurred
                break;
            }
            value = next;
        }
        System.out.println("Largest fibonacci(n) before overflow (long): n=" + i + ", value=" + value);

        // c) double version, can go much further
        System.out.print("Enter n for the double version: ");
        int nd = input.nextInt();
        System.out.println("fibonacciDouble(" + nd + ") = " + fibonacciDouble(nd));

        input.close();
    }
}