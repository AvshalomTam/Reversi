package GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NoMoveController implements Initializable {
    @FXML
    private Button closeButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

    public void continueGame() {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
