package ReversiApp;

import Game.*;
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ReversiGameController implements Initializable {
    @FXML
    private HBox root;
    private ReversiBoard board;
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

        this.info = new InfoController();
        this.board = new ReversiBoard(this.board_size, Color.web(this.p1Name), Color.web(this.p2Name), info);
        GameStatus status = new GameStatus(this.board.getBoard(), this.p1Name, this.p2Name, this.starter);
        this.info.setGameStatus(status);
        this.board.setGameStatus(status);
        this.board.setPrefWidth(400);
        this.board.setPrefHeight(400);
        root.getChildren().add(0, this.board);
        root.getChildren().add(1, this.info);

        this.board.printBoard();
        this.info.printInfo();
        root.setOnMouseClicked(this.board.getOnMouseClicked());

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


    /*
    public void initializeGame() {
        //this.display_ = ;
        this.judge_ = new BasicRules();
        this.listener = new MoveTracker();
        //this.pl1_ = new HumanPlayer(cell.first_player, this.board.getBoard(), this.judge_, this.display_, this.listener);
        //this.pl2_ = new HumanPlayer(cell.second_player, this.board.getBoard(), this.judge_, this.display_, this.listener);
        this.pl1_.setName("X");
        this.pl2_.setName("O");
        this.frst_player_ = true;
    }

    public void run() {
        do {
            if (this.frst_player_) {
                this.playOneTurn(this.pl1_);
            } else {
                this.playOneTurn(this.pl2_);
            }
            this.frst_player_ = !this.frst_player_;
        } while ((this.pl1_.played() || this.pl2_.played()) && !this.judge_.boardIsFull(this.board.getBoard()));

        this.board.printBoard();
        //printing the game results
        cell winner = this.judge_.checkWinner(this.board.getBoard());
        if (winner == cell.empty) {
            this.display_.printResult("draw");
        }
        else {
            if (winner == cell.first_player) {
                this.display_.printResult(this.pl1_.getName());
            }
            else {
                this.display_.printResult(this.pl2_.getName());
            }
        }
    }

    public void playOneTurn(Player pl) {
        this.board.printBoard();

        pl.message();

        Coordinates input = pl.getMove();
        if (!NO_MOVE.isEqual(input)) {
            this.judge_.turnTiles(this.board.getBoard(), input, pl.getId());
        }
    }*/
}
