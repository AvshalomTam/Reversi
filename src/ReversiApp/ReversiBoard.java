package ReversiApp;

import Game.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class ReversiBoard extends Board {
    private GraphicBoard board;

    public ReversiBoard(int size, Color colorPl1, Color colorPl2, InfoController info, GameStatus status) {
        super(size);
        this.board = new GraphicBoard(this, colorPl1, colorPl2, info, status);
    }

    public void printBoard() {
        this.board.drawOn(this);
    }

    public GraphicBoard getGraphicBoard() {
        return this.board;
    }
}
