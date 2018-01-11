package ReversiApp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {
    @FXML
    private Button setting_button;
    @FXML
    private Button start_button;
    private Stage stage;
    private boolean hasStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.hasStage = false;
    }

    public void settings() {
        if (!this.hasStage) {
            this.stage = (Stage) setting_button.getScene().getWindow();
            this.hasStage = true;
        }

        this.stage.setTitle("Settings Menu");
        this.stage.setScene(new SceneFactory().getSettingsScene());
    }

    public void startDefaultGame() {
        if (!this.hasStage) {
            this.stage = (Stage) start_button.getScene().getWindow();
            this.hasStage = true;
        }

        this.stage.setTitle("Reversi Game");
        this.stage.setScene(new SceneFactory().getGameScene());
    }

    public void exit() {
        System.exit(0);
    }
}
