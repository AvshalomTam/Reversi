package ReversiApp;

import Game.Board;
import Game.Display;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import Game.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

public class ReversiGameController implements Initializable {
    @FXML
    private HBox root;
    private ReversiBoard board;

    private int board_size;
    private Color color_pl1;
    private Color color_pl2;
    private Color starter;


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
                    this.color_pl1 = Color.web(line.split(":")[1]);
                }
                if (line.startsWith("color_pl2")) {
                    this.color_pl2 = Color.web(line.split(":")[1]);
                }
                if (line.startsWith("starting")) {
                    this.starter = Color.web(line.split(":")[1]);
                }
            }
            bufferedReader.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
            System.exit(0);
        }
        this.board = new ReversiBoard(this.board_size, this.color_pl1, this.color_pl2);
        this.board.getBoard().setPrefWidth(400);
        this.board.getBoard().setPrefHeight(400);
        root.getChildren().add(0, this.board.getBoard());

        this.board.printBoard();
        Display display = new GraphicDisplay(this.board);

        Game game = new Game();
        game.initialize(this.board, display);
        game.run();
    }
}
