package ReversiApp;

import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ReversiGameController implements Initializable {

    private Stage stage;
    private boolean hasStage;
    private String Curr_player_name;
    private int Black_score;
    private int White_score;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.hasStage = false;
    }
}
