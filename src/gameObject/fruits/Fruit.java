package gameObject.fruits;

import gameObject.GameObject;
import initilalizer.NormalDiff;

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

    public Fruit() {
    }

    ;

    public Fruit(int x, int y) {
        super(x, y);
        velocityX = 1;
        velocityY = 4;
    }

    public void tick() {
        xCoordinate += velocityX;
        if (xCoordinate + this.width <= 0 || xCoordinate + this.width>= 600 ) velocityX *= -1;
        yCoordinate += velocityY;
        if (yCoordinate <= NormalDiff.HEIGHT / 3-100 || yCoordinate >= NormalDiff.HEIGHT - 32) velocityY *= -1;
        
        
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.white);
        //graphics.fillRect(xCoordinate, yCoordinate, 32, 32);
        graphics.fillRoundRect(xCoordinate, yCoordinate, 32, 32, 32, 32);
    }

}
