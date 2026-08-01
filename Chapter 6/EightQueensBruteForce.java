import java.util.Random;

public class EightQueensBruteForce{
    private static final int SIZE = 8;

    public static void main(String[] args) {
        String part = args.length > 0 ? args[0] : "b";

        if (part.equals("a")) {
            randomBruteForce();
        } else {
            exhaustiveBruteForce();
        }
    }

    /** a) Randomly places one queen per column until a non-attacking layout is found. */
    private static void randomBruteForce() {
        Random random = new Random();
        int[] queenRow = new int[SIZE]; // queenRow[col] = row of queen in that column
        long attempts = 0;

        while (true) {
            attempts++;
            for (int col = 0; col < SIZE; col++) {
                queenRow[col] = random.nextInt(SIZE);
            }
            if (isValidPlacement(queenRow)) {
                break;
            }
        }

        System.out.println("Random brute force found a solution after " + attempts + " attempts:");
        displayBoard(queenRow);
    }

    /** b) Exhaustive backtracking search: tries all combinations, one queen per column. */
    private static void exhaustiveBruteForce() {
        int[] queenRow = new int[SIZE];
        long[] attempts = {0};

        boolean found = placeQueens(queenRow, 0, attempts);

        if (found) {
            System.out.println("Exhaustive brute force found a solution after "
                    + attempts[0] + " placements tried:");
            displayBoard(queenRow);
        } else {
            System.out.println("No solution found.");
        }
    }

    private static boolean placeQueens(int[] queenRow, int col, long[] attempts) {
        if (col == SIZE) {
            return true; // all columns filled with non-attacking queens
        }
        for (int row = 0; row < SIZE; row++) {
            attempts[0]++;
            queenRow[col] = row;
            if (isSafe(queenRow, col)) {
                if (placeQueens(queenRow, col + 1, attempts)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isSafe(int[] queenRow, int col) {
        for (int otherCol = 0; otherCol < col; otherCol++) {
            int rowDiff = Math.abs(queenRow[otherCol] - queenRow[col]);
            int colDiff = Math.abs(otherCol - col);
            if (queenRow[otherCol] == queenRow[col] || rowDiff == colDiff) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidPlacement(int[] queenRow) {
        for (int col1 = 0; col1 < SIZE; col1++) {
            for (int col2 = col1 + 1; col2 < SIZE; col2++) {
                int rowDiff = Math.abs(queenRow[col1] - queenRow[col2]);
                int colDiff = col2 - col1;
                if (queenRow[col1] == queenRow[col2] || rowDiff == colDiff) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void displayBoard(int[] queenRow) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(queenRow[col] == row ? " Q " : " . ");
            }
            System.out.println();
        }
    }
}