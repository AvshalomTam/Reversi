package ReversiApp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {
    @FXML
    private Button start_button;
    private Stage stage;
    private boolean hasStage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.hasStage = false;
    }

    public void startGame() {
        if (!this.hasStage) {
            System.out.print("Starting game...");
            this.stage = (Stage) start_button.getScene().getWindow();
            this.hasStage = true;
        }
    }
}
