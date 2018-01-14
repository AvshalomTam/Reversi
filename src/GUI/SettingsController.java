package GUI;
import Game.GameSettings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {
    private Stage stage;
    @FXML
    private ComboBox board_size;
    @FXML
    private ComboBox first_color;
    @FXML
    private ComboBox second_color;
    @FXML
    private ComboBox who_starts;
    @FXML
    private Button start_button;
    @FXML
    private Button back_button;
    private boolean hasStage;


    ObservableList<String> board_size_list = FXCollections.observableArrayList("4x4","5x5","6x6",
            "7x7","8x8","9x9","10x10","11x11","12x12","13x13","14x14","15x15","16x16","17x17","18x18",
            "19x19","20x20");
    ObservableList<String> first_color_list = FXCollections.observableArrayList("Black","White","Brown",
            "Gray","Yellow","Orange","Red","Pink","Purple","Blue","Green");

    ObservableList<String> second_color_list = FXCollections.observableArrayList("Black","White","Brown",
            "Gray","Yellow","Orange","Red","Pink","Purple","Blue","Green");
    ObservableList<String> who_starts_list = FXCollections.observableArrayList("1st Player","2nd Player");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.hasStage = false;
        GameSettings settings = GameSettings.getInstance();
        //board size
        board_size.setValue(settings.getBoardSize() + "x" + settings.getBoardSize());
        board_size.setItems(board_size_list);
        //color first player
        first_color.setValue(settings.getPl1());
        first_color.setItems(first_color_list);
        //color second player
        second_color.setValue(settings.getPl2());
        second_color.setItems(second_color_list);
        //who starts?
        who_starts.setValue(settings.getStarterName());
        who_starts.setItems(who_starts_list);

    }

    public void startGame() {
        this.saveToFile();

        if (!this.hasStage) {
            this.hasStage = true;
            this.stage = (Stage) start_button.getScene().getWindow();
        }
        this.stage.setTitle("Reversi Game");
        double width = this.start_button.getScene().getWidth();
        double height = this.start_button.getScene().getHeight();
        this.stage.setScene(new SceneFactory().getGameScene(width, height));
    }

    public void backToMenu() {
        this.saveToFile();

        if (!this.hasStage) {
            this.hasStage = true;
            this.stage = (Stage) back_button.getScene().getWindow();
        }
        this.stage.setTitle("Reversi");
        double width = this.back_button.getScene().getWidth();
        double height = this.back_button.getScene().getHeight();
        this.stage.setScene(new SceneFactory().getMainMenuScene(width, height));
    }

    public void saveToFile() {
        int size = Integer.parseInt((this.board_size.getValue()).toString().split("x")[0]);
        String color1 = this.first_color.getValue().toString();
        String color2 = this.second_color.getValue().toString();
        String starter = this.who_starts.getValue().toString();

        GameSettings.getInstance().saveToFile(size, color1, color2, starter);
    }
}