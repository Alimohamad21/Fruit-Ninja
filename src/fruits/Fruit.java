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
}
