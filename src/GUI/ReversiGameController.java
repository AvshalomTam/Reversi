package GUI;

import Game.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReversiGameController implements Initializable, Display {
    @FXML
    private HBox root;
    private GraphicBoard grid;
    private Board board;
    private InfoController info;
    private Game game;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GameSettings settings = GameSettings.getInstance();
        GameStatus status = new GameStatus();
        this.info = new InfoController(status);
        ReversiBoard board = new ReversiBoard(settings.getBoardSize(), Color.web(settings.getPl1()), Color.web(settings.getPl2()));

        this.grid = board.getGraphicBoard();
        this.grid.setPrefHeight(500);
        this.grid.setPrefWidth(500);

        this.board = board;

        Player p1 = new HumanPlayer(cell.first_player, settings.getPl1());
        Player p2 = new HumanPlayer(cell.second_player, settings.getPl2());
        status.setInfo(this.board, new BasicRules(), p1, p2, settings.getStarter());

        root.getChildren().add(0, board.getGraphicBoard());
        root.getChildren().add(1, this.info);

        this.game = new Game();
        this.game.initialize(this, this.board, status, new BasicRules());
        board.getGraphicBoard().setGame(game);
        this.setMouseInput();
        this.game.run();
    }

    /**
     * Enabeling mouse input on the board.
     */
    public void setMouseInput() {
        root.heightProperty().addListener((observable, oldValue, newValue) -> {
            this.grid.setPrefHeight(newValue.doubleValue() - 10);
            this.grid.setPrefWidth(newValue.doubleValue() - 10);
            this.info.setPrefHeight(newValue.doubleValue());
            this.game.printScreen();
            this.game.printOptions();
        });

        root.setOnMouseClicked(this.grid.getOnMouseClicked());
    }

    /**
     * Prints the board.
     */
    public void printBoard() {
        this.board.printBoard();
    }

    /**
     * Prints the info about the game (player's score etc.).
     */
    public void printGameInfo() {
        this.info.printInfo();
    }

    /**
     * Printing the options the player has.
     * @param options list of options
     */
    public void showOptions(ArrayList<Coordinates> options) {
        this.board.showOptions(options);
    }

    /**
     * Printing a message that the player has no move.
     */
    public void printNoMove() {
        Alert alert = new Alert(Alert.AlertType.NONE, "OK", ButtonType.OK);
        alert.setContentText("Uh oh! No Move!\nPlay passes to other player.");
        alert.setTitle("NO MOVE");
        alert.showAndWait();
    }

    /**
     * Printing the results of the game.
     * @param result String containing the result.
     */
    public void printGameResults(String result) {
        Alert alert = new Alert(Alert.AlertType.NONE, null, ButtonType.OK);
        alert.setContentText(result);
        alert.setTitle("GAME OVER");
        alert.showAndWait();
    }
}
