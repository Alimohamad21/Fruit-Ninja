package gameObject.fruits;

import gameObject.GameObject;
import initilalizer.GameLoop;
import initilalizer.Mouse;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import com.sun.glass.events.MouseEvent;

public abstract class Fruit extends GameObject {

    protected ObjectType objectType = ObjectType.fruit;
    private boolean flag = false;
    private BufferedImage img = null;

    @Override
    public ObjectType getObjectType() {
        return objectType;
    }

    public Fruit() {
    }

   /* @Override
    public void SaveObject(GameState gameState) {

    }*/

    public Fruit(int x, int y) {
        super(x, y);
        Random randomDirection = new Random();
        if (xCoordinate < 200)
            velocityX = 1.5;
        else if (xCoordinate > 300)
            velocityX = -1.5;
        else {
            velocityX = -2 + randomDirection.nextInt(5);
        }
        velocityY = 8;
    }

    public Fruit(double xCoordinate, double yCoordinate, double velocityX, double velocityY, int objectLife, boolean sliced, int points, BufferedImage img) {
        super(xCoordinate, yCoordinate, velocityX, velocityY, objectLife, sliced, points, img);

    }

    public void tick() {
        xCoordinate += velocityX;
        yCoordinate -= velocityY;
        Random maxHeight = new Random();
        if (flag && yCoordinate == GameLoop.HEIGHT - 32) yCoordinate = GameLoop.HEIGHT;
        if (yCoordinate <= maxHeight.nextInt(300) || (yCoordinate >= GameLoop.HEIGHT - 32 && !flag)) {
            velocityY -= 0.35;
            flag = true;
        }
    }

    abstract public void render(Graphics graphics);

}
