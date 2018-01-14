package GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
            this.hasStage = true;
            this.stage = (Stage) setting_button.getScene().getWindow();
        }
        this.stage.setTitle("Settings Menu");
        double width = this.setting_button.getScene().getWidth();
        double height = this.setting_button.getScene().getHeight();
        this.stage.setScene(new SceneFactory().getSettingsScene(width, height));
    }

    public void startDefaultGame() {
        if (!this.hasStage) {
            this.hasStage = true;
            this.stage = (Stage) start_button.getScene().getWindow();
        }
        this.stage.setTitle("Reversi Game");
        double width = this.start_button.getScene().getWidth();
        double height = this.start_button.getScene().getHeight();
        this.stage.setScene(new SceneFactory().getGameScene(width, height));
    }

    public void exit() {
        System.exit(0);
    }
}
