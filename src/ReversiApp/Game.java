package ReversiApp;

import Game.*;

public class Game {
    private Board board;
    private GameStatus status;
    private GameLogic judge;
    private InfoController info;

    public void initialize(Board board, GameStatus status, GameLogic judge, InfoController info) {
        this.board = board;
        this.status = status;
        this.judge = judge;
        this.info = info;
    }

    public void run(ReversiGameController controller) {
        controller.setMouseInput();
    }

    public void playOneTurn(Coordinates move) {
        try {
            if (judge.isValidChoice(this.board, move, this.status.getCurrent())) {
                judge.turnTiles(this.board, move, this.status.getCurrent());
                this.status.changePlayers();
            }
            else {
                if (!judge.hasOptions(this.board, this.status.getCurrent())) {
                    this.status.changePlayers();
                }
            }
            printScreen();
            if (judge.boardIsFull(this.board) ||
                    (!judge.hasOptions(this.board, cell.first_player) && (!judge.hasOptions(this.board, cell.second_player)))) {
                endGame();
            }
        } catch (Exception e) {}
    }

    public void printScreen() {
        this.info.printInfo();
        this.board.printBoard();
    }

    public void endGame() {
        System.exit(0);
    }
}
