public class SieveOfEratosthenes{
    public static void main(String[] args) {
        final int SIZE = 1000;
        boolean[] isPrimeCandidate = new boolean[SIZE];

        for (int i = 2; i < SIZE; i++) {
            isPrimeCandidate[i] = true;
        }

        for (int i = 2; i < SIZE; i++) {
            if (isPrimeCandidate[i]) {
                for (int multiple = i * 2; multiple < SIZE; multiple += i) {
                    isPrimeCandidate[multiple] = false;
                }
            }
        }

        System.out.println("Prime numbers between 2 and 999:\n");
        int count = 0;
        for (int i = 2; i < SIZE; i++) {
            if (isPrimeCandidate[i]) {
                System.out.printf("%-6d", i);
                count++;
                if (count % 10 == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println("\n\nTotal primes found: " + count);
    }
}