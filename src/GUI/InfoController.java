package GUI;

import Game.GameStatus;
import Game.cell;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class InfoController extends VBox {
    private FXMLLoader loader;
    public GameStatus status;
    public Button btn;

    public InfoController(GameStatus status) {
        this.status = status;
        this.loader = new FXMLLoader(getClass().getResource("Info.fxml"));
        this.loader.setRoot(this);
        this.loader.setController(this);

        try {
            this.loader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void printInfo() {
        this.getChildren().clear();

        Label lbl = new Label("Current player: " + this.status.getCurrentName());
        this.getChildren().add(0, lbl);

        lbl = new Label(this.status.getPl1Name() + " player score is: " + this.status.getScore(cell.first_player));
        this.getChildren().add(1, lbl);

        lbl = new Label(this.status.getPl2Name() + " player score is: " + this.status.getScore(cell.second_player));
        this.getChildren().add(2, lbl);

        this.btn = new Button("New Game");
        this.btn.setFont(new Font(18));
        this.btn.setPrefWidth(150);
        this.btn.setPrefHeight(15);

        this.btn.setOnAction(event -> {
            Stage stage = (Stage) this.btn.getScene().getWindow();
            stage.setTitle("Reversi");
            double width = this.btn.getScene().getWidth();
            double height = this.btn.getScene().getHeight();
            stage.setScene(new SceneFactory().getMainMenuScene(width, height));
        });
        this.getChildren().add(3, this.btn);

        this.btn = new Button("Exit");
        this.btn.setFont(new Font(18));
        this.btn.setPrefWidth(150);
        this.btn.setPrefHeight(15);
        this.btn.setOnAction(event -> {
            System.exit(0);
        });
        VBox.setMargin(this.btn, new Insets(0, 0, 20, 0));
        this.getChildren().add(4, this.btn);
    }

    public void endOfGame() {
        this.getChildren().clear();

        Label lbl = new Label(this.status.getPl1Name() + " player score is: " + this.status.getScore(cell.first_player));
        this.getChildren().add(0, lbl);

        lbl = new Label(this.status.getPl2Name() + " player score is: " + this.status.getScore(cell.second_player));
        this.getChildren().add(1, lbl);

        lbl = new Label(this.status.getWinner());
        lbl.setFont(new Font(18));
        lbl.setPrefWidth(340);
        lbl.setPrefHeight(80);
        this.getChildren().add(2, lbl);

        this.btn = new Button("New Game");
        this.btn.setFont(new Font(18));
        this.btn.setPrefWidth(150);
        this.btn.setPrefHeight(15);

        this.btn.setOnAction(event -> {
            Stage stage = (Stage) this.btn.getScene().getWindow();
            stage.setTitle("Reversi");
            double width = this.btn.getScene().getWidth();
            double height = this.btn.getScene().getHeight();
            stage.setScene(new SceneFactory().getMainMenuScene(width, height));
        });
        this.getChildren().add(3, this.btn);

        this.btn = new Button("Exit");
        this.btn.setFont(new Font(18));
        this.btn.setPrefWidth(150);
        this.btn.setPrefHeight(15);
        this.btn.setOnAction(event -> {
            System.exit(0);
        });
        this.getChildren().add(4, this.btn);
    }

    public void noMove() {
        Label lbl = new Label("No Move. Play passes to other player.\nClick anywhere on the board.");
        lbl.setFont(new Font(12));
        lbl.setTextFill(Color.RED);
        lbl.setPrefHeight(340);
        this.getChildren().add(3, lbl);
    }
}
