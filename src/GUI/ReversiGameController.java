package GUI;

import Game.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

public class ReversiGameController implements Initializable {
    @FXML
    private HBox root;
    private GridPane grid;
    private Board board;
    private InfoController info;
    private int board_size;
    private Color color_pl1;
    private Color color_pl2;
    private String p1Name;
    private String p2Name;
    private cell starter;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            FileReader reader = new FileReader("settings.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("size")) {
                    this.board_size = Integer.parseInt(line.split(":")[1]);
                }
                if (line.startsWith("color_pl1")) {
                    this.p1Name = line.split(":")[1];
                }
                if (line.startsWith("color_pl2")) {
                    this.p2Name = line.split(":")[1];
                }
                if (line.startsWith("starting")) {
                    String s = line.split(":")[1];
                    if (s.equals("1st player")) {
                        this.starter = cell.first_player;
                    }
                    else {
                        this.starter = cell.second_player;
                    }
                }
            }
            bufferedReader.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
            System.exit(0);
        }

        GameStatus status = new GameStatus();
        this.info = new InfoController(status);
        ReversiBoard board = new ReversiBoard(this.board_size, Color.web(this.p1Name), Color.web(this.p2Name), info, status);

        this.grid = board.getGraphicBoard();
        this.grid.setPrefHeight(400);
        this.grid.setPrefWidth(400);

        this.board = board;

        status.setInfo(this.board, new BasicRules(), this.p1Name, this.p2Name, this.starter);

        root.getChildren().add(0, board.getGraphicBoard());
        root.getChildren().add(1, this.info);

        this.board.printBoard();
        this.info.printInfo();

        Game game = new Game();
        game.initialize(this.board, status, new BasicRules(), this.info);
        board.getGraphicBoard().setGame(game);
        game.run(this);
    }

    public void setMouseInput() {
        root.setOnMouseClicked(this.grid.getOnMouseClicked());

        /*root.widthProperty().addListener((observable, oldValue, newValue) -> {
            double boardNewWidth = newValue.doubleValue() - 120;
            this.board.setPrefWidth(boardNewWidth);
            this.info.setPrefWidth(boardNewWidth);
            this.board.printBoard();
            this.info.printInfo();
        });

        root.heightProperty().addListener((observable, oldValue, newValue) -> {
            this.board.setPrefHeight(newValue.doubleValue());
            this.info.setPrefHeight(newValue.doubleValue());
            this.board.printBoard();;
            this.info.printInfo();
        });*/
    }
}