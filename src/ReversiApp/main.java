package ReversiApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class main extends Application {
    @Override
    public void start(Stage primaryStage) {

        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            Scene scene = new Scene(root,520,400);

            primaryStage.setTitle("Reversi");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
