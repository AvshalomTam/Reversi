package Game;

import java.util.ArrayList;

public class Game {
    private Board board;
    private GameStatus status;
    private GameLogic judge;
    private Display display;

    public void initialize(Display display, Board board, GameStatus status, GameLogic judge) {
        this.display = display;
        this.board = board;
        this.status = status;
        this.judge = judge;
    }

    /**
     * Runs a game of Reversi.
     */
    public void run() {
        this.printScreen();
        this.printOptions();
    }

    /**
     * Makes one turn for a single player.
     * @param move Coordinates of the player
     */
    public void playOneTurn(Coordinates move) {
        try {
            //if game is finished, ignoring incoming clicks
            if (this.status.isFinished()) {
                return;
            }
            if (judge.hasOptions(this.board, this.status.getCurrent())) {
                if (judge.isValidChoice(this.board, move, this.status.getCurrent())) {
                    judge.turnTiles(this.board, move, this.status.getCurrent());
                } else {
                    return;
                }
            }
            this.status.changePlayers();
            this.printScreen();
            this.printOptions();

            //checking if game has to be finished
            if (judge.boardIsFull(this.board) ||
                    (!judge.hasOptions(this.board, cell.first_player) && (!judge.hasOptions(this.board, cell.second_player)))) {
                this.status.setFinished();
                endGame();
                return;
            }
            if (!this.judge.hasOptions(this.board, this.status.getCurrent())) {
                this.display.printNoMove();
                return;
            }
        } catch (Exception e) {}
    }

    /**
     * Prints the board and the info on its right.
     */
    public void printScreen() {
        this.display.printBoard();
        this.display.printGameInfo();
    }

    /**
     * Prints the options for the player.
     */
    public void printOptions() {
        ArrayList<Coordinates> options = this.judge.getOptions(this.board, this.status.getCurrent());
        this.display.showOptions(options);
    }

    /**
     * Finishes the game.
     */
    public void endGame() {
        String result;
        cell winner = this.judge.checkWinner(this.board);
        if (winner == cell.first_player) {
            result = this.status.getPl1Name() + " wins the game!";
        } else {
            if (winner == cell.second_player) {
                result = this.status.getPl2Name() + " wins the game!";
            } else {
                result = "It's a draw game!!";
            }
        }
        this.display.printGameResults(result);
    }
}
