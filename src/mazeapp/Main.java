package mazeapp;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import javax.swing.text.html.StyleSheet;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            HBox root = (HBox)FXMLLoader.load(getClass().getResource("MazeGame.fxml"));
            Scene scene = new Scene(root,1800,500);

            primaryStage.setTitle("Maze game");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
