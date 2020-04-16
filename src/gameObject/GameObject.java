package gameObject;

public abstract class GameObject {
    protected int xCoordinate, yCoordinate;
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


    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
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
