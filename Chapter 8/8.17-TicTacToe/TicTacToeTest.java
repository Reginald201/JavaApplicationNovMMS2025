// TicTacToeTest.java
// Demonstrates class TicTacToe with a scripted game (no console input
// needed) so it's easy to run and verify. For an interactive two-player
// game, call TicTacToe.play() from main instead.
public class TicTacToeTest {
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();

        // scripted moves: X wins across the top row
        int[][] xMoves = { {0, 0}, {0, 1}, {0, 2} };
        int[][] oMoves = { {1, 0}, {1, 1} };

        for (int i = 0; i < oMoves.length; i++) {
            game.move(xMoves[i][0], xMoves[i][1], TicTacToe.Mark.X);
            game.move(oMoves[i][0], oMoves[i][1], TicTacToe.Mark.O);
        }
        game.move(xMoves[2][0], xMoves[2][1], TicTacToe.Mark.X); // winning move

        game.printBoard();
        System.out.println("\nWinner: " + game.winner());

        // To play an interactive two-player game from the console, run:
        // TicTacToe.play();
    }
}
