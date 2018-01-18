package GUI;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class SceneFactory {
    public Scene getMainMenuScene(double width, double height) {
        try {
            AnchorPane set = (AnchorPane) FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            return new Scene(set, width, height);
        } catch (Exception e) {
            System.exit(0);
        }
        return null;
    }

    public Scene getSettingsScene(double width, double height) {
        try {
            AnchorPane set = (AnchorPane) FXMLLoader.load(getClass().getResource("SettingsMenu.fxml"));
            return new Scene(set, width, height);
        } catch (Exception e) {
            System.exit(0);
        }
        return null;
    }

    public Scene getGameScene(double width, double height) {
        try {
            HBox root = (HBox) FXMLLoader.load(getClass().getResource("ReversiGame.fxml"));
            return new Scene(root, width, height);
        } catch (Exception e) {
            System.exit(0);
        }
        return null;
    }
}
