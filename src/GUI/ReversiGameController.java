package GUI;

import Game.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
        ReversiBoard board = new ReversiBoard(settings.getBoardSize(), Color.web(settings.getPl1()), Color.web(settings.getPl2()), info, status);

        this.grid = board.getGraphicBoard();
        this.grid.setPrefHeight(500);
        this.grid.setPrefWidth(500);

        this.board = board;

        status.setInfo(this.board, new BasicRules(), settings.getPl1(), settings.getPl2(), settings.getStarter());

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
        try {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Reversi");
            AnchorPane set = (AnchorPane) FXMLLoader.load(getClass().getResource("NoMove.fxml"));
            stage.setScene(new Scene(set, 300, 200));
            stage.show();
        } catch (Exception e) {
            System.exit(0);
        }
    }

    /**
     * Printing the results of the game.
     * @param result String containing the result.
     */
    public void printGameResults(String result) {
        this.info.endOfGame(result);
    }
}
