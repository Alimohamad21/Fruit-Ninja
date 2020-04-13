package Fruits;

public class FruitFactory {


    public Fruit create(String fruitType) throws NullPointerException {
        Fruit fruit = null;
        if (fruitType.equalsIgnoreCase("Mango"))
            fruit = new Mango();
        if (fruitType.equalsIgnoreCase("Orange"))
            fruit = new Orange();
        if (fruitType.equalsIgnoreCase("Apple"))
            fruit = new Apple();
        return fruit;
    }
}
