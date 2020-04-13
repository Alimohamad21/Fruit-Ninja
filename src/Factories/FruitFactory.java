package Factories;

import Fruits.Apple;
import Fruits.Fruit;
import Fruits.Mango;
import Fruits.Orange;

///Singleton
public class FruitFactory {
    private static FruitFactory fruitFactory = new FruitFactory();
    private FruitFactory() {
    }
    public static FruitFactory getFruitFactory() {
        return fruitFactory;
    }

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
