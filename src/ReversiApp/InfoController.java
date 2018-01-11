package ReversiApp;

import Game.BasicRules;
import Game.GameLogic;
import Game.cell;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class InfoController extends VBox {
    private FXMLLoader loader;
    public GameStatus status;

    public InfoController() {
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
    }

    public void setGameStatus(GameStatus status) {
        this.status = status;
    }
}
