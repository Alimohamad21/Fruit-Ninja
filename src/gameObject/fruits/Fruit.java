package gameObject.fruits;

import gameObject.GameObject;
import initilalizer.GameLoop;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Fruit extends GameObject {

    protected ObjectType objectType = ObjectType.fruit;

    @Override
    public ObjectType getObjectType() {
        return objectType;
    }



    public Fruit() {};

    public Fruit(int x, int y) {
        super(x, y);
        velocityX = 0;
        velocityY = 4;
    }

    public void tick() {
        yCoordinate += velocityY;
        if (yCoordinate <= GameLoop.HEIGHT / 3-100 || yCoordinate >= GameLoop.HEIGHT - 32) velocityY *= -1;
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.white);
        //graphics.fillRect(xCoordinate, yCoordinate, 32, 32);
        graphics.fillRoundRect(xCoordinate, yCoordinate, 32, 32, 32, 32);
    }

}
