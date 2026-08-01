import java.util.Random;

public class KnightsTourBruteForce{
    private static final int BOARD_SIZE = 8;
    private static final int[] HORIZONTAL = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] VERTICAL = {-1, -2, -2, -1, 1, 2, 2, 1};
    private static final Random random = new Random();

    public static void main(String[] args) {
        String part = args.length > 0 ? args[0] : "a";

        switch (part) {
            case "a":
                partA();
                break;
            case "b":
                partB();
                break;
            case "c":
                partC();
                break;
            default:
                System.out.println("Unknown part: use a, b, or c");
        }
    }

    private static void partA() {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        int moves = runRandomTour(board);
        displayBoard(board);
        System.out.println("\nThe knight made " + moves + " moves.");
    }

    private static void partB() {
        int[] tourLengthCounts = new int[65]; // lengths 1-64
        int best = 0;

        for (int i = 0; i < 1000; i++) {
            int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
            int moves = runRandomTour(board);
            tourLengthCounts[moves]++;
            best = Math.max(best, moves);
        }

        System.out.printf("%-8s%s%n", "Length", "Count");
        for (int length = 1; length <= 64; length++) {
            if (tourLengthCounts[length] > 0) {
                System.out.printf("%-8d%d%n", length, tourLengthCounts[length]);
            }
        }
        System.out.println("\nBest tour length out of 1,000: " + best);
    }

    private static void partC() {
        int[] tourLengthCounts = new int[65];
        long attempts = 0;
        long startTime = System.currentTimeMillis();

        int moves;
        do {
            int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
            moves = runRandomTour(board);
            tourLengthCounts[moves]++;
            attempts++;
        } while (moves < 64);

        long elapsedMs = System.currentTimeMillis() - startTime;

        System.out.printf("%-8s%s%n", "Length", "Count");
        for (int length = 1; length <= 64; length++) {
            if (tourLengthCounts[length] > 0) {
                System.out.printf("%-8d%d%n", length, tourLengthCounts[length]);
            }
        }
        System.out.println("\nFull tour found after " + attempts + " attempts.");
        System.out.println("Elapsed time: " + elapsedMs + " ms");
    }

    /** Performs one random-walk tour; returns the number of moves made. */
    private static int runRandomTour(int[][] board) {
        int currentRow = 0, currentColumn = 0;
        board[currentRow][currentColumn] = 1;
        int moveCount = 1;

        for (int moveNumber = 2; moveNumber <= 64; moveNumber++) {
            int validMoveCount = 0;
            int[] validMoves = new int[8];
            for (int move = 0; move < 8; move++) {
                int r = currentRow + VERTICAL[move];
                int c = currentColumn + HORIZONTAL[move];
                if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE && board[r][c] == 0) {
                    validMoves[validMoveCount++] = move;
                }
            }
            if (validMoveCount == 0) {
                break;
            }
            int chosen = validMoves[random.nextInt(validMoveCount)];
            currentRow += VERTICAL[chosen];
            currentColumn += HORIZONTAL[chosen];
            board[currentRow][currentColumn] = moveNumber;
            moveCount = moveNumber;
        }
        return moveCount;
    }

    private static void displayBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.printf("%3d", cell);
            }
            System.out.println();
        }
    }
}