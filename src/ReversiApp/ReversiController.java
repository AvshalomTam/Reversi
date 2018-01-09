package ReversiApp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ReversiController implements Initializable {
    @FXML
    private Button setting_button;
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

        try {
            AnchorPane set = (AnchorPane) FXMLLoader.load(getClass().getResource("SettingsMenu.fxml"));
            stage.setScene(new Scene(set,520,400));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exit() {
        System.exit(0);
    }
}
