package GUI;

import Game.GameStatus;
import Game.cell;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
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

        this.btn = new Button("Quit Game");
        this.btn.setOnAction(event -> {
            Stage stage = (Stage) this.btn.getScene().getWindow();
            stage.setTitle("Reversi");
            stage.setScene(new SceneFactory().getMainMenuScene());
        });
        this.getChildren().add(3, this.btn);

        this.btn = new Button("Exit");
        this.btn.setOnAction(event -> {
            System.exit(0);
        });
        this.getChildren().add(4, this.btn);
    }
}
