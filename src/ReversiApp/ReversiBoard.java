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

public class ReversiBoard extends GridPane {
    private Board board;
    private Color color_pl1;
    private Color color_pl2;
    private Coordinates input = null;
    private FXMLLoader loader;
    public GameStatus status;
    public InfoController info_controller;

    public ReversiBoard(int size, Color colorPl1, Color colorPl2, InfoController info) {
        this.board = new GraphicBoard(size);
        this.color_pl1 = colorPl1;
        this.color_pl2 = colorPl2;
        this.info_controller = info;
        this.loader = new FXMLLoader(getClass().getResource("ReversiBoard.fxml"));
        this.loader.setRoot(this);
        this.loader.setController(this);

        try {
            this.loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
        runGame();
    }

    public void runGame() {
        try {
            this.loader.load();
            this.setOnMouseClicked(event -> {
                GameLogic judge = new BasicRules();
                if (!judge.hasOptions(this.board, this.status.getCurrent())) {
                    this.status.changePlayers();
                    this.info_controller.printInfo();
                }
                int x = (int) event.getX();
                int y = (int) event.getY();
                x = (int) (x / (this.getPrefWidth() / this.board.getSize()));
                y = (int) (y / (this.getPrefHeight() / this.board.getSize()));
                this.input = new Coordinates(x, y);
                try {
                    if (judge.isValidChoice(this.board, this.input, this.status.getCurrent())) {
                        judge.turnTiles(this.board, this.input, this.status.getCurrent());
                        this.status.changePlayers();
                        this.info_controller.printInfo();
                    }
                } catch (Exception e) {}
                this.printBoard();
                event.consume();
                if (judge.boardIsFull(this.board) ||
                        (!judge.hasOptions(this.board, cell.first_player) && (!judge.hasOptions(this.board, cell.second_player)))) {
                    this.printBoard();
                    this.info_controller.printInfo();
                    System.exit(0);
                }
            });
        } catch (Exception e) {}
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

    public void setGameStatus(GameStatus status) {
        this.status = status;
    }

    public Board getBoard() {
        return this.board;
    }
}
