// TicTacToe.java
// A two-player, console-based Tic-Tac-Toe game.
import java.util.Scanner;

public class TicTacToe {
    public enum Mark { X, O, EMPTY }

    private Mark[][] board;

    public TicTacToe() {
        board = new Mark[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = Mark.EMPTY;
            }
        }
    }

    // attempts a move; returns true if it succeeded (square was empty)
    public boolean move(int row, int col, Mark mark) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        if (board[row][col] != Mark.EMPTY) {
            return false;
        }
        board[row][col] = mark;
        return true;
    }

    // returns the winning Mark, or EMPTY if there's no winner yet
    public Mark winner() {
        // rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != Mark.EMPTY && board[i][0] == board[i][1] &&
                board[i][1] == board[i][2]) {
                return board[i][0];
            }
            if (board[0][i] != Mark.EMPTY && board[0][i] == board[1][i] &&
                board[1][i] == board[2][i]) {
                return board[0][i];
            }
        }
        // diagonals
        if (board[0][0] != Mark.EMPTY && board[0][0] == board[1][1] &&
            board[1][1] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != Mark.EMPTY && board[0][2] == board[1][1] &&
            board[1][1] == board[2][0]) {
            return board[0][2];
        }
        return Mark.EMPTY;
    }

    public boolean isFull() {
        for (Mark[] row : board) {
            for (Mark cell : row) {
                if (cell == Mark.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(symbol(board[row][col]));
                if (col < 2) System.out.print(" | ");
            }
            System.out.println();
            if (row < 2) System.out.println("---------");
        }
    }

    private String symbol(Mark mark) {
        switch (mark) {
            case X: return "X";
            case O: return "O";
            default: return " ";
        }
    }

    // Runs a simple two-human-player game in the console.
    public static void play() {
        TicTacToe game = new TicTacToe();
        Scanner input = new Scanner(System.in);
        Mark currentMark = Mark.X;

        while (true) {
            game.printBoard();
            System.out.printf("%nPlayer %s, enter row and column (0-2 0-2): ", currentMark);

            int row = input.nextInt();
            int col = input.nextInt();

            if (!game.move(row, col, currentMark)) {
                System.out.println("Invalid move, try again.");
                continue;
            }

            Mark winner = game.winner();
            if (winner != Mark.EMPTY) {
                game.printBoard();
                System.out.println("\nPlayer " + winner + " wins!");
                break;
            }

            if (game.isFull()) {
                game.printBoard();
                System.out.println("\nIt's a draw!");
                break;
            }

            currentMark = (currentMark == Mark.X) ? Mark.O : Mark.X;
        }

        input.close();
    }
}
