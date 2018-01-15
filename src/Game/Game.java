package Game;

import GUI.InfoController;
import GUI.ReversiGameController;

import java.util.ArrayList;

public class Game {
    private Board board;
    private GameStatus status;
    private GameLogic judge;
    private InfoController info;
    private ReversiGameController gameController;

    public void initialize(ReversiGameController gameController, Board board, GameStatus status, GameLogic judge, InfoController info) {
        this.gameController = gameController;
        this.board = board;
        this.status = status;
        this.judge = judge;
        this.info = info;
    }

    /**
     * Runs a game of Reversi.
     */
    public void run() {
        this.gameController.setMouseInput();
        printScreen();
        printOptions();
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

            if (judge.isValidChoice(this.board, move, this.status.getCurrent())) {
                judge.turnTiles(this.board, move, this.status.getCurrent());
            }
            this.status.changePlayers();
            printScreen();
            printOptions();

            //checking if game has to be finished
            if (judge.boardIsFull(this.board) ||
                    (!judge.hasOptions(this.board, cell.first_player) && (!judge.hasOptions(this.board, cell.second_player)))) {
                this.status.setFinished();
                endGame();
                return;
            }
            if (!this.judge.hasOptions(this.board, this.status.getCurrent())) {
                this.info.noMove();
                return;
            }
        } catch (Exception e) {}
    }

    /**
     * Prints the board and the info on its right.
     */
    public void printScreen() {
        this.info.printInfo();
        this.board.printBoard();
    }

    /**
     * Prints the options for the player.
     */
    public void printOptions() {
        ArrayList<Coordinates> options = this.judge.getOptions(this.board, this.status.getCurrent());
        this.board.showOptions(options);
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

        this.info.endOfGame(result);
    }
}
