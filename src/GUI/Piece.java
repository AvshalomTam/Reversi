package GUI;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Piece extends Group {
    private Ellipse main;
    private Ellipse shaddow;

    public Piece(double radius, Color up, Color side, Color stroke) {
        this.main = new Ellipse(0, 0, radius, 0.45 * radius);
        this.main.setFill(up);
        this.main.setStroke(stroke);
        this.main.setStrokeWidth(2);
        this.shaddow = new Ellipse(0, radius * 0.15, radius, 0.45 * radius);
        this.shaddow.setFill(side);
        this.shaddow.setStroke(stroke);
        this.shaddow.setStrokeWidth(2);

        getChildren().addAll(this.shaddow, this.main);
    }
}
