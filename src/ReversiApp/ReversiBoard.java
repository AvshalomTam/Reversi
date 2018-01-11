package ReversiApp;

import Game.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.IOException;

public class ReversiBoard extends GridPane {
    private Board board;
    private Color color_pl1;
    private Color color_pl2;
    private Coordinates input = null;
    private FXMLLoader loader;
    private cell current = cell.first_player;

    public ReversiBoard(int size, Color colorPl1, Color colorPl2) {
        this.board = new GraphicBoard(size);
        this.color_pl1 = colorPl1;
        this.color_pl2 = colorPl2;
        this.loader = new FXMLLoader(getClass().getResource("ReversiBoard.fxml"));
        this.loader.setRoot(this);
        this.loader.setController(this);

        try {
            this.loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        getClick();
    }

    public void getClick() {
        try {
            this.loader.load();
            this.setOnMouseClicked(event -> {
                GameLogic judge = new BasicRules();
                if (!judge.hasOptions(this.board, this.current)) {
                    changePlayers();
                }
                int x = (int) event.getX();
                int y = (int) event.getY();
                x = (int) (x / (this.getPrefWidth() / this.board.getSize()));
                y = (int) (y / (this.getPrefHeight() / this.board.getSize()));
                this.input = new Coordinates(x, y);
                try {
                    if (judge.isValidChoice(this.board, this.input, this.current)) {
                        judge.turnTiles(this.board, this.input, this.current);
                        changePlayers();
                    }
                } catch (Exception e) {}
                this.printBoard();
                event.consume();
                if (judge.boardIsFull(this.board) ||
                        (!judge.hasOptions(this.board, cell.first_player) && (!judge.hasOptions(this.board, cell.second_player)))) {
                    System.exit(0);
                }
            });
        } catch (Exception e) {}
    }

    public void changePlayers() {
        if (this.current == cell.first_player) {
            this.current = cell.second_player;
        } else {
            this.current = cell.first_player;
        }
    }

    public void printBoard() {
        this.getChildren().clear();

        int height = (int)this.getPrefHeight();

        int cellHeight = height / this.board.getSize();
        int cellWidth = cellHeight;

        Color cell_collor;
        int size = this.board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.board.getCell(new Coordinates(i, j)) == cell.empty)
                    cell_collor = Color.BEIGE;
                else {
                    if (this.board.getCell(new Coordinates(i, j)) == cell.first_player) {
                        cell_collor = this.color_pl1;
                    }
                    else {
                        cell_collor = this.color_pl2;
                    }
                }
                Rectangle rect = new Rectangle(cellWidth, cellHeight, cell_collor);
                rect.setStroke(Color.DIMGRAY);
                rect.setStrokeWidth(0.5);
                this.add(rect, i, j);
            }
        }
    }

    public Board getBoard() {
        return this.board;
    }
}
