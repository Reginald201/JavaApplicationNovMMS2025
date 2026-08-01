public class EightQueens{
    private static final int SIZE = 8;

    public static void main(String[] args) {
        int[][] board = new int[SIZE][SIZE]; // 1 = queen present
        int queensPlaced = 0;

        for (int q = 0; q < SIZE && queensPlaced < SIZE; q++) {
            int bestRow = -1, bestCol = -1;
            int bestElimination = Integer.MAX_VALUE;

            for (int row = 0; row < SIZE; row++) {
                for (int col = 0; col < SIZE; col++) {
                    if (board[row][col] == 0 && !isAttacked(board, row, col)) {
                        int elimination = countEliminated(board, row, col);
                        if (elimination < bestElimination) {
                            bestElimination = elimination;
                            bestRow = row;
                            bestCol = col;
                        }
                    }
                }
            }

            if (bestRow == -1) {
                break; // no safe square found
            }
            board[bestRow][bestCol] = 1;
            queensPlaced++;
        }

        displayBoard(board);
        System.out.println("\nQueens placed: " + queensPlaced + " out of " + SIZE);
    }

    private static boolean isAttacked(int[][] board, int row, int col) {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (board[r][c] == 1 && attacks(r, c, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean attacks(int r1, int c1, int r2, int c2) {
        return r1 == r2 || c1 == c2 || Math.abs(r1 - r2) == Math.abs(c1 - c2);
    }

    /** Counts currently-empty, unattacked squares that would become attacked
     *  if a queen were placed at (row, col). Lower is "less disruptive." */
    private static int countEliminated(int[][] board, int row, int col) {
        int count = 0;
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                if (board[r][c] == 0 && !(r == row && c == col)
                        && !isAttacked(board, r, c) && attacks(row, col, r, c)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void displayBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell == 1 ? " Q " : " . ");
            }
            System.out.println();
        }
    }
}