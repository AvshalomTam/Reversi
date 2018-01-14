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

    public void run() {
        this.gameController.setMouseInput();
        printScreen();
        printOptions();
    }

    public void playOneTurn(Coordinates move) {
        try {
            if (judge.isValidChoice(this.board, move, this.status.getCurrent())) {
                judge.turnTiles(this.board, move, this.status.getCurrent());
                this.status.changePlayers();
            }
            printScreen();
            printOptions();
            if (judge.boardIsFull(this.board) ||
                    (!judge.hasOptions(this.board, cell.first_player) && (!judge.hasOptions(this.board, cell.second_player)))) {
                endGame();
                return;
            }
            if (!this.judge.hasOptions(this.board, this.status.getCurrent())) {
                this.info.noMove();
                this.status.changePlayers();
            }
        } catch (Exception e) {}
    }

    public void printScreen() {
        this.info.printInfo();
        this.board.printBoard();
    }

    public void printOptions() {
        ArrayList<Coordinates> options = this.judge.getOptions(this.board, this.status.getCurrent());
        this.board.showOptions(options);
    }

    public void endGame() {
        this.info.endOfGame();
    }
}
