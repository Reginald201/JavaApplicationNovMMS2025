public class KnightsTour{
    private static final int BOARD_SIZE = 8;
    private static final int[] HORIZONTAL = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] VERTICAL = {-1, -2, -2, -1, 1, 2, 2, 1};

    public static void main(String[] args) {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        int currentRow = 0;
        int currentColumn = 0;
        board[currentRow][currentColumn] = 1;

        int moveCount = 1;
        for (int moveNumber = 2; moveNumber <= 64; moveNumber++) {
            int nextMove = findValidMove(board, currentRow, currentColumn);
            if (nextMove == -1) {
                break; // no legal move available
            }
            currentRow += VERTICAL[nextMove];
            currentColumn += HORIZONTAL[nextMove];
            board[currentRow][currentColumn] = moveNumber;
            moveCount = moveNumber;
        }

        displayBoard(board);
        System.out.println("\nThe knight made " + moveCount + " moves.");
    }

    private static int findValidMove(int[][] board, int currentRow, int currentColumn) {
        for (int move = 0; move < 8; move++) {
            int nextRow = currentRow + VERTICAL[move];
            int nextColumn = currentColumn + HORIZONTAL[move];
            if (isValidMove(board, nextRow, nextColumn)) {
                return move;
            }
        }
        return -1;
    }

    private static boolean isValidMove(int[][] board, int row, int column) {
        return row >= 0 && row < BOARD_SIZE && column >= 0 && column < BOARD_SIZE
                && board[row][column] == 0;
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