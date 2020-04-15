package test;

import com.jfoenix.controls.JFXButton;
import fruits.Fruit;
import fruits.Mango;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.*;
import javafx.util.Duration;
import player.Player;
import sun.plugin.dom.css.Counter;

import java.net.URL;
import java.util.ResourceBundle;

public class GamePlay implements Initializable {

    @FXML
    public AnchorPane pane;

    public void setButton(JFXButton jfxButton, Fruit fruit) {
        jfxButton.setPrefSize(fruit.getWidth(), fruit.getLength());
        jfxButton.setStyle("-fx-background-color: RED");
        jfxButton.setShape(new Circle(5));
        pane.getChildren().add(jfxButton);
        jfxButton.setLayoutX(setXPosition());
        jfxButton.setLayoutY(500);
    }

    public int setXPosition() {
        int max = 500;
        int min = 10;
        int range = max - min + 1;
        int rand = (int) (Math.random() * range) + min;
        // System.out.println(rand);
        return rand;
    }


    public void setPath(JFXButton jfxButton) {

        Path path = new Path();
        path.getElements().add(new MoveTo());
        path.getElements().add(new LineTo(0, -450));
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(5000));
        pathTransition.setPath(path);
        pathTransition.setNode(jfxButton);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
        pathTransition.play();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Player player = Player.getPlayer();
        JFXButton fruitButton = new JFXButton();
        Fruit fruit = new Mango();
        setButton(fruitButton, fruit);
        setPath(fruitButton);
    }


}
