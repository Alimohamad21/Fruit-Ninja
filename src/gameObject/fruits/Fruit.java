package gameObject.fruits;

import gameObject.GameObject;
import initilalizer.GameLoop;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Fruit extends GameObject {

    protected ObjectType objectType = ObjectType.fruit;
    private boolean flag = false;

    @Override
    public ObjectType getObjectType() {
        return objectType;
    }


    public Fruit() {
    }

    ;

    public Fruit(int x, int y) {
        super(x, y);
        velocityX = 0;
        velocityY = 6;
    }

    public void tick() {
        yCoordinate += velocityY;
        if (flag == true && yCoordinate == GameLoop.HEIGHT - 32) yCoordinate = GameLoop.HEIGHT;
        if (yCoordinate <= GameLoop.HEIGHT / 3 - 100 || (yCoordinate >= GameLoop.HEIGHT - 32 && !flag)) {
            velocityY *= -1;
            flag = true;
        }
    }

    public void render(Graphics graphics) {
        //graphics.setColor(Color.white);
        //graphics.fillRect(xCoordinate, yCoordinate, 32, 32);
        //graphics.fillRoundRect(xCoordinate, yCoordinate, 32, 32, 32, 32);
    }

}
