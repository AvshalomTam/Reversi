package GUI;

import Game.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class ReversiBoard extends Board {
    private GraphicBoard board;

    public ReversiBoard(int size, Color colorPl1, Color colorPl2, InfoController info, GameStatus status) {
        super(size);
        this.board = new GraphicBoard(this, colorPl1, colorPl2, info, status);
    }

    public void printBoard() {
        this.board.drawOn();
    }

    public void showOptions(ArrayList<Coordinates> options) {
        this.board.drawOptions(options);
    }

    public GraphicBoard getGraphicBoard() {
        return this.board;
    }
}
