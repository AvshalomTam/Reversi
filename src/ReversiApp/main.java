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
        primaryStage.setTitle("Reversi");
        primaryStage.setScene(new SceneFactory().getMainMenuScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
