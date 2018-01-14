package GUI;

import Game.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.NodeOrientation;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.ArrayList;

public class GraphicBoard extends GridPane {
    private Color color_pl1;
    private Color color_pl2;
    private Coordinates input = null;
    private FXMLLoader loader;
    public GameStatus status;
    public InfoController info_controller;
    private Game game;
    private Board board;

    public GraphicBoard(Board board, Color colorPl1, Color colorPl2, InfoController info, GameStatus status) {
        this.board = board;
        this.status = status;
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

        try {
            this.loader.load();
            this.setOnMouseClicked(event -> {
                int x = (int) event.getX();
                int y = (int) event.getY();
                x = (int) (x / (this.getPrefWidth() / board.getSize()));
                y = (int) (y / (this.getPrefHeight() / board.getSize()));
                this.input = new Coordinates(x, y);
                this.game.playOneTurn(this.input);
                event.consume();
            });
        } catch (Exception e) {}
    }
        
    
    public void drawOn() {
        this.getChildren().clear();
        int height = (int)this.getPrefHeight();
        int cellHeight = height / board.getSize();

        Rectangle rect;
        Circle circle;
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rect = new Rectangle(cellHeight, cellHeight, Color.ANTIQUEWHITE);
                rect.setStroke(Color.DIMGRAY);
                rect.setStrokeWidth(0.5);
                this.add(rect, i, j);
                if (board.getCell(new Coordinates(i, j)) != cell.empty) {
                    if (board.getCell(new Coordinates(i, j)) == cell.first_player) {
                        circle = new Circle(0.4 * cellHeight, this.color_pl1);
                        setHalignment(circle, HPos.CENTER);
                        this.add(circle, i, j);
                    }
                    else {
                        circle = new Circle(0.4 * cellHeight, this.color_pl2);
                        setHalignment(circle, HPos.CENTER);
                        this.add(circle, i, j);
                    }
                }
            }
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void drawOptions(ArrayList<Coordinates> options) {
        int height = (int)this.getPrefHeight();
        int cellHeight = height / board.getSize();
        Circle circle;
        for (Coordinates option : options) {
            circle = new Circle(0.4 * cellHeight, Color.ANTIQUEWHITE);
            setHalignment(circle, HPos.CENTER);
            circle.setStroke(Color.GOLD);
            this.add(circle, option.getX(), option.getY());
        }
    }
}
