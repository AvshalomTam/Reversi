package GUI;

import Game.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
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
    private static final Color board_color_1 = Color.ANTIQUEWHITE;
    private static final Color board_color_2 = Color.SANDYBROWN;
    private static final Color option_color = Color.DARKOLIVEGREEN;

    /**
     * Constructor.
     * @param board game board
     * @param colorPl1 color of first player
     * @param colorPl2 color of second player
     * @param info info of the game (on the right of the screen)
     * @param status status of game
     */
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


    /**
     * Draws the board on the screen.
     */
    public void drawOn() {
        this.getChildren().clear();
        int height = (int)this.getPrefHeight();
        int cellHeight = height / board.getSize();

        Rectangle rect;
        Piece piece;
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Color back;
                if ((i + j) %  2 == 0) {
                    back = board_color_1;
                }
                else {
                    back = board_color_2;
                }
                rect = new Rectangle(cellHeight, cellHeight, back);
                rect.setStroke(Color.DIMGRAY);
                rect.setStrokeWidth(0.5);
                this.add(rect, i, j);
                if (board.getCell(new Coordinates(i, j)) != cell.empty) {
                    if (board.getCell(new Coordinates(i, j)) == cell.first_player) {
                        piece = new Piece(0.4 * cellHeight, this.color_pl1, this.color_pl2, Color.BLACK);
                        setHalignment(piece, HPos.CENTER);
                        this.add(piece, i, j);
                    }
                    else {
                        piece = new Piece(0.4 * cellHeight, this.color_pl2, this.color_pl1, Color.BLACK);
                        setHalignment(piece, HPos.CENTER);
                        this.add(piece, i, j);
                    }
                }
            }
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * Draws the list of options the player has.
     * @param options list of options
     */
    public void drawOptions(ArrayList<Coordinates> options) {
        int height = (int)this.getPrefHeight();
        int cellHeight = height / board.getSize();
        Piece piece;
        for (Coordinates option : options) {
            Color back;
            if ((option.getX() + option.getY()) %  2 == 0) {
                back = board_color_1;
            }
            else {
                back = board_color_2;
            }
            piece = new Piece(0.4 * cellHeight, back, back, option_color);
            setHalignment(piece, HPos.CENTER);
            this.add(piece, option.getX(), option.getY());
        }
    }
}
