import GUI.SceneFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Reversi");
        primaryStage.setScene(new SceneFactory().getMainMenuScene(800, 550));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
