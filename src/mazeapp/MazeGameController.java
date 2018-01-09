package mazeapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class MazeGameController implements Initializable {
    @FXML
    private HBox root;
    private int[][] maze = {
            {0,1,0,1,0,0,0,1,0,0,0},
            {0,1,0,1,1,1,0,1,0,1,0}};

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MazeBoard mazeBoard = new MazeBoard(maze);
        mazeBoard.setPrefWidth(400);
        mazeBoard.setPrefHeight(400);
        root.getChildren().add(0, mazeBoard);
        mazeBoard.draw();
    }
}
