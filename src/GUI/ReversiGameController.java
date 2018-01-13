package GUI;

import Game.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class ReversiGameController implements Initializable {
    @FXML
    private HBox root;
    private GridPane grid;
    private Board board;
    private InfoController info;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GameSettings settings = GameSettings.getInstance();
        GameStatus status = new GameStatus();
        this.info = new InfoController(status);
        ReversiBoard board = new ReversiBoard(settings.getBoardSize(), Color.web(settings.getPl1()), Color.web(settings.getPl2()), info, status);

        this.grid = board.getGraphicBoard();
        this.grid.setPrefHeight(400);
        this.grid.setPrefWidth(400);

        this.board = board;

        status.setInfo(this.board, new BasicRules(), settings.getPl1(), settings.getPl2(), settings.getStarter());

        root.getChildren().add(0, board.getGraphicBoard());
        root.getChildren().add(1, this.info);

        this.board.printBoard();
        this.info.printInfo();

        Game game = new Game();
        game.initialize(this, this.board, status, new BasicRules(), this.info);
        board.getGraphicBoard().setGame(game);
        game.run(this);
    }

    public void setMouseInput() {
        root.heightProperty().addListener((observable, oldValue, newValue) -> {
            this.grid.setPrefHeight(newValue.doubleValue() - 10);
            this.grid.setPrefWidth(newValue.doubleValue() - 10);
            this.info.setPrefHeight(newValue.doubleValue());
            this.board.printBoard();;
            this.info.printInfo();
        });

        root.setOnMouseClicked(this.grid.getOnMouseClicked());
    }
}
