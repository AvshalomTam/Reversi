package GUI;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
    @FXML
    private Button back_button;


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
        int size = 0;
        String c_first = "";
        String c_second = "";
        String starter = "";

        try {
            FileReader reader = new FileReader("settings.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (line.startsWith("size")) {
                    size = Integer.parseInt(line.split(":")[1]);
                }
                if (line.startsWith("color_pl1")) {
                    c_first = line.split(":")[1];
                }
                if (line.startsWith("color_pl2")) {
                    c_second = line.split(":")[1];
                }
                if (line.startsWith("starting")) {
                    starter = line.split(":")[1];
                }
            }
            bufferedReader.close();
        } catch (Exception error) {
            System.out.println(error.getMessage());
            System.exit(0);
        }
        this.hasStage = false;
        //board size
        board_size.setValue(size + "x" + size);
        board_size.setItems(board_size_list);
        //color first player
        first_color.setValue(c_first);
        first_color.setItems(first_color_list);
        //color second player
        second_color.setValue(c_second);
        second_color.setItems(second_color_list);
        //who starts?
        who_starts.setValue(starter);
        who_starts.setItems(who_starts_list);

    }

    public void startGame() {
        this.saveToFile();

        if (!this.hasStage) {
            this.stage = (Stage) start_button.getScene().getWindow();
            this.hasStage = true;
        }
        this.stage.setTitle("Reversi Game");
        this.stage.setScene(new SceneFactory().getGameScene());
    }

    public void backToMenu() {
        this.saveToFile();

        if (!this.hasStage) {
            this.stage = (Stage) back_button.getScene().getWindow();
            this.hasStage = true;
        }
        this.stage.setTitle("Reversi");
        this.stage.setScene(new SceneFactory().getMainMenuScene());
    }

    public void saveToFile() {
        int size = Integer.parseInt((this.board_size.getValue()).toString().split("x")[0]);
        String color1 = this.first_color.getValue().toString();
        String color2 = this.second_color.getValue().toString();
        String starter = this.who_starts.getValue().toString();

        try {
            FileWriter writer = new FileWriter("settings.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("size:" + size);
            bufferedWriter.newLine();
            bufferedWriter.write("color_pl1:" + color1);
            bufferedWriter.newLine();
            bufferedWriter.write("color_pl2:" + color2);
            bufferedWriter.newLine();
            bufferedWriter.write("starting:" + starter);
            bufferedWriter.close();

        } catch (Exception error) {
            System.out.println(error.getMessage());
            System.exit(0);
        }
    }
}
