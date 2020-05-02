package gameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class GameObject {
    protected double xCoordinate, yCoordinate;
    protected double velocityX, velocityY;
    protected int objectLife;

    protected boolean sliced;
    protected int points;
    private BufferedImage img;

    public enum ObjectType {
        fruit,
        bomb,
        superFruit
    }

    public ObjectType objectType;

    public GameObject() {
    }

    public void SaveObject(GameState gameState) {

    }

    public GameObject(double xCoordinate, double yCoordinate, double velocityX, double velocityY, int objectLife, boolean sliced, int points, BufferedImage img) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.objectLife = objectLife;
        this.sliced = sliced;
        this.points = points;
        this.img = img;
        // this.objectType = objectType;
    }

    public GameObject(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public abstract void tick();

    public abstract void render(Graphics graphics);

    /**
     * Getters & Setters
     **/

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public void setXCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public void setYCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public double getVelocityY() {
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
