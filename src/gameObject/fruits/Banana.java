package gameObject.fruits;

import gameObject.GameState;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Banana extends Fruit {

    public Banana() {
    }

    private BufferedImage img1 = null;
    private BufferedImage img2 = null;

    public Banana(int x, int y) {
        super(x, y);
        objectLife = 1;
        sliced = false;
        points = objectLife * 10;
    }

    public Banana(double xCoordinate, double yCoordinate, double velocityX, double velocityY, int objectLife, boolean sliced, int points, BufferedImage img) {
        super(xCoordinate, yCoordinate, velocityX, velocityY, objectLife, sliced, points, img);

    }

    @Override
    public void SaveObject(GameState gameState) {
        gameState.gameObjects.add(new Apple(this.getXCoordinate(), this.getYCoordinate(), this.getVelocityX(), this.getVelocityY(), this.getObjectLife(), this.isSliced(), this.getPoints(), this.getImg()));
    }

    public void render(Graphics graphics) {
        if (!sliced) {
            try {
                img1 = ImageIO.read(this.getClass().getResource("banana.png"));
                setImg(img1);
            } catch (IOException exc) {
                System.out.println("Banana rendering failed");
            }
        } else {
            try {
                img1 = ImageIO.read(this.getClass().getResource("banana-2.png"));
                img2 = ImageIO.read(this.getClass().getResource("banana-1.png"));
                setImg(img1);
            } catch (IOException exc) {
                System.out.println("Sliced banana rendering failed");
            }
        }
        graphics.drawImage(img1, (int) xCoordinate, (int) yCoordinate, null);
        graphics.drawImage(img2, (int) (xCoordinate + 30), (int) yCoordinate, null);
    }
}
