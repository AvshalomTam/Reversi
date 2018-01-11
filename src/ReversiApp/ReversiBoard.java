package ReversiApp;

import Game.Board;
import Game.Coordinates;
import Game.cell;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.awt.*;

public class ReversiBoard extends Board {
    private GraphicBoard board;
    private Color color_pl1;
    private Color color_pl2;

    public ReversiBoard(int size, Color colorPl1, Color colorPl2) {
        super(size);
        this.board = new GraphicBoard();
        this.color_pl1 = colorPl1;
        this.color_pl2 = colorPl2;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ReversiBoard.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
    }

    public void printBoard() {
        this.board.getChildren().clear();

        int height = (int)this.board.getPrefHeight();

        int cellHeight = height / this.getSize();
        int cellWidth = cellHeight;

        Color cell_collor;
        int size = this.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (this.getCell(new Coordinates(i, j)) == cell.empty)
                    cell_collor = Color.BEIGE;
                else {
                    if (this.getCell(new Coordinates(i, j)) == cell.first_player) {
                        cell_collor = this.color_pl1;
                    }
                    else {
                        cell_collor = this.color_pl2;
                    }
                }
                this.board.add(new Rectangle(cellWidth, cellHeight, cell_collor), j, i);
            }
        }
        this.board.setGridLinesVisible(true);
    }

    public GridPane getBoard() {
        return this.board;
    }

    public Coordinates getClick() {
        EventHandler handler = new EventHandler() {
            @Override
            public void handle(Event event) {

            }

            public void handle(MouseEvent mouseEvent) {
                System.out.println(mouseEvent.getX());
                System.out.println(mouseEvent.getY());
            }
        };

        return null;
    }
}
