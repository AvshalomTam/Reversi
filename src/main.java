import GUI.SceneFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Reversi");
        primaryStage.setScene(new SceneFactory().getMainMenuScene(650, 410));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
