package fruits;

public abstract class Fruit {
    protected int fruitLife;    ////needed in super fruits
    protected boolean sliced;
    protected float length;
    protected float width;
    protected int points;


    /////Methods
    public abstract void setFruit();
    public String FruitType() {
        return null;
    }

    ///Setters & Getters
    public int getFruitLife() {
        return fruitLife;
    }

    public void setFruitLife(int fruitLife) {
        this.fruitLife = fruitLife;
    }

    public boolean isSliced() {
        return sliced;
    }

    public void setSliced(boolean sliced) {
        this.sliced = sliced;
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

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


}
