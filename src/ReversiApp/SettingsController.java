package ReversiApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class SettingsController implements Initializable {
    private Stage stage;
    private boolean hasStage;
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


    ObservableList<String> board_size_list = FXCollections.observableArrayList("4X4","5X5","6X6",
            "7X7","8X8","9X9","10X10","11X11","12X12","13X13","14X14","15X15","16X16","17X17","18X18",
            "19X19","20X20");
    ObservableList<String> first_color_list = FXCollections.observableArrayList("Black","White","Brown",
            "Gray","Yellow","Orange","Red","Pink","Purple","Blue","Green");

    ObservableList<String> second_color_list = FXCollections.observableArrayList("Black","White","Brown",
            "Gray","Yellow","Orange","Red","Pink","Purple","Blue","Green");
    ObservableList<String> who_starts_list = FXCollections.observableArrayList("1st Player","2nd Player");
    //ObservableList<String> who_starts_list = new ObservableListBase<String>() {};

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        this.hasStage = false;
        //board size
        board_size.setValue("4X4");
        board_size.setItems(board_size_list);
        //color first player
        first_color.setValue("Black");
        first_color.setItems(first_color_list);
        //color second player
        second_color.setValue("White");
        second_color.setItems(second_color_list);
        //who starts?
        who_starts.setValue("1st Player");
        who_starts.setItems(who_starts_list);

    }
    public void startGame() {
        System.out.println("heyyyy!!");
        if (!this.hasStage) {
            System.out.println("heyyyy2!!");
            this.stage = (Stage) start_button.getScene().getWindow();
            this.hasStage = true;
        }
        try {
            System.out.println("heyyyy3!!");
            AnchorPane set = (AnchorPane) FXMLLoader.load(getClass().getResource("ReversiGame.fxml"));
            this.stage.setTitle("Reversi Game");
            this.stage.setScene(new Scene(set,800,500));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
