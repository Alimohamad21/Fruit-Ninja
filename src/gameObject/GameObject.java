package gameObject;

import java.awt.Graphics;

public abstract class GameObject {
    protected int xCoordinate, yCoordinate;
    protected int velocityX, velocityY;
    protected int objectLife;
    protected float length;
    protected float width;
    protected int ascendingVelocity;
    protected boolean sliced;
    protected int points;

    protected enum ObjectType {
        fruit,
        bomb;
    }

    protected ObjectType objectType;

    public GameObject(){};
    public GameObject(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);

    /**
     * Getters & Setters
     **/

    public int getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public int getObjectLife() {
        return objectLife;
    }

    public void setObjectLife(int objectLife) {
        this.objectLife = objectLife;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public int getAscendingVelocity() {
        return ascendingVelocity;
    }

    public void setAscendingVelocity(int ascendingVelocity) {
        this.ascendingVelocity = ascendingVelocity;
    }

    public boolean isSliced() {
        return sliced;
    }

    public void setSliced(boolean sliced) {
        this.sliced = sliced;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public ObjectType getObjectType() {
        return objectType;
    }

    public void setObjectType(ObjectType objectType) {
        this.objectType = objectType;
    }
}
