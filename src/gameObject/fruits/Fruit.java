package gameObject.fruits;

import back.Game;
import gameObject.GameObject;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public abstract class Fruit extends GameObject {

    protected ObjectType objectType = ObjectType.fruit;
    @Override
    public ObjectType getObjectType() {
        return objectType;
    }


    Random randomNumber = new Random();
    public Fruit(){};
    public Fruit(int x, int y) {
        super(x, y);
        velocityX = 5;
        velocityY = 5;
    }

    public void tick() {
        xCoordinate += velocityX;
        if (xCoordinate <= 0 || xCoordinate >= Game.WIDTH - 16) velocityX *= -1;
        yCoordinate += velocityY;
        if (yCoordinate <= Game.HEIGHT / 2 - 32 || yCoordinate >= Game.HEIGHT - 32) velocityY *= -1;
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect(xCoordinate, yCoordinate, 32, 32);
    }

}
