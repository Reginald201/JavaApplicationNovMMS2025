
public class KnightsTourHeuristic{
    private static final int BOARD_SIZE = 8;
    private static final int[] HORIZONTAL = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] VERTICAL = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        int[][] accessibility = new int[BOARD_SIZE][BOARD_SIZE];
        initializeAccessibility(accessibility);

        int startRow = 0, startColumn = 0;
        int currentRow = startRow, currentColumn = startColumn;

        board[currentRow][currentColumn] = 1;
        reduceNeighborsAccessibility(accessibility, currentRow, currentColumn);
        accessibility[currentRow][currentColumn] = -1; // mark visited

        int moveCount = 1;
        for (int moveNumber = 2; moveNumber <= 64; moveNumber++) {
            int nextMove = chooseMoveWithLookahead(board, accessibility, currentRow, currentColumn);
            if (nextMove == -1) {
                break;
            }
            int nextRow = currentRow + VERTICAL[nextMove];
            int nextColumn = currentColumn + HORIZONTAL[nextMove];

            currentRow = nextRow;
            currentColumn = nextColumn;
            board[currentRow][currentColumn] = moveNumber;
            // Newly visited square is no longer reachable, so reduce the
            // accessibility of every square that could have moved here.
            reduceNeighborsAccessibility(accessibility, currentRow, currentColumn);
            accessibility[currentRow][currentColumn] = -1; // visited
            moveCount = moveNumber;
        }

        displayBoard(board);
        System.out.println("\nThe knight made " + moveCount + " moves.");

        if (moveCount == 64) {
            System.out.println("Full tour achieved!");
            boolean closed = isClosedTour(currentRow, currentColumn, startRow, startColumn);
            System.out.println(closed ? "This is a CLOSED tour." : "This is an OPEN tour.");
        } else {
            System.out.println("The tour was not completed.");
        }
    }

    /** Chooses the legal move with the lowest accessibility; ties broken via one-move lookahead. */
    private static int chooseMoveWithLookahead(int[][] board, int[][] accessibility, int row, int col) {
        int bestMove = -1;
        int bestAccessibility = Integer.MAX_VALUE;
        java.util.List<Integer> tied = new java.util.ArrayList<>();

        for (int move = 0; move < 8; move++) {
            int r = row + VERTICAL[move];
            int c = col + HORIZONTAL[move];
            if (isValidMove(board, r, c)) {
                int access = accessibility[r][c];
                if (access < bestAccessibility) {
                    bestAccessibility = access;
                    tied.clear();
                    tied.add(move);
                } else if (access == bestAccessibility) {
                    tied.add(move);
                }
            }
        }

        if (tied.isEmpty()) {
            return -1;
        }
        if (tied.size() == 1) {
            return tied.get(0);
        }

        // Lookahead: among tied candidates, pick the one whose best next-move
        // accessibility (from the candidate square) is lowest.
        int bestLookaheadMove = tied.get(0);
        int bestLookaheadValue = Integer.MAX_VALUE;

        for (int move : tied) {
            int r = row + VERTICAL[move];
            int c = col + HORIZONTAL[move];
            int lowestFromCandidate = lowestAccessibilityFrom(board, accessibility, r, c);
            if (lowestFromCandidate < bestLookaheadValue) {
                bestLookaheadValue = lowestFromCandidate;
                bestLookaheadMove = move;
            }
        }
        return bestLookaheadMove;
    }

    private static int lowestAccessibilityFrom(int[][] board, int[][] accessibility, int row, int col) {
        int lowest = Integer.MAX_VALUE;
        for (int move = 0; move < 8; move++) {
            int r = row + VERTICAL[move];
            int c = col + HORIZONTAL[move];
            if (isValidMove(board, r, c) && accessibility[r][c] < lowest) {
                lowest = accessibility[r][c];
            }
        }
        return lowest;
    }

    private static boolean isClosedTour(int lastRow, int lastCol, int startRow, int startCol) {
        for (int move = 0; move < 8; move++) {
            if (lastRow + VERTICAL[move] == startRow && lastCol + HORIZONTAL[move] == startCol) {
                return true;
            }
        }
        return false;
    }

    private static boolean isValidMove(int[][] board, int row, int column) {
        return row >= 0 && row < BOARD_SIZE && column >= 0 && column < BOARD_SIZE
                && board[row][column] == 0;
    }

    private static void initializeAccessibility(int[][] accessibility) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                int count = 0;
                for (int move = 0; move < 8; move++) {
                    int r = row + VERTICAL[move];
                    int c = col + HORIZONTAL[move];
                    if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE) {
                        count++;
                    }
                }
                accessibility[row][col] = count;
            }
        }
    }

    /** Reduces the accessibility of all squares reachable from (row, col) by one. */
    private static void reduceNeighborsAccessibility(int[][] accessibility, int row, int col) {
        for (int move = 0; move < 8; move++) {
            int r = row + VERTICAL[move];
            int c = col + HORIZONTAL[move];
            if (r >= 0 && r < BOARD_SIZE && c >= 0 && c < BOARD_SIZE && accessibility[r][c] > 0) {
                accessibility[r][c]--;
            }
        }
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