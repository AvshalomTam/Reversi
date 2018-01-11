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

    private int board_size;
    private Color color_pl1;
    private Color color_pl2;
    private Color starter;
    private static final Coordinates NO_MOVE = new Coordinates(-1, -1);
    private GameLogic judge_;
    private Display display_;
    private Listener listener;
    private Player pl1_;
    private Player pl2_;
    private boolean frst_player_;


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
        this.board.setPrefWidth(400);
        this.board.setPrefHeight(400);
        root.getChildren().add(0, this.board);

        this.board.printBoard();
        root.setOnMouseClicked(this.board.getOnMouseClicked());
    }



    public void initializeGame() {
        //this.display_ = ;
        this.judge_ = new BasicRules();
        this.listener = new MoveTracker();
        this.pl1_ = new HumanPlayer(cell.first_player, this.board.getBoard(), this.judge_, this.display_, this.listener);
        this.pl2_ = new HumanPlayer(cell.second_player, this.board.getBoard(), this.judge_, this.display_, this.listener);
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
    }
}
