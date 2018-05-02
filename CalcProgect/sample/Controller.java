package sample;

import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.Random;

public class Controller {
    public AnchorPane panel;
    private Random rnd = new Random();
    public Button butt;

    public void move(MouseEvent mouseEvent) {
    //    final double oldX = butt.getLayoutX();
    //    final double oldY = butt.getScaleY();
        Bounds buttBounds = butt.getLayoutBounds();
        final int x = rnd.nextInt((int) panel.getLayoutBounds().getWidth()-(int) buttBounds.getWidth());
        final int y = rnd.nextInt((int) panel.getLayoutBounds().getHeight()-(int) buttBounds.getHeight());
        butt.setLayoutX(x);
        butt.setLayoutY(y);
    }
}
