package Factories;

import Fruits.Apple;
import Fruits.Fruit;
import Fruits.Mango;
import Fruits.Orange;

public class FruitFactory {

    public Fruit create(String fruitType) throws NullPointerException {
        Fruit fruit = null;
        if (fruitType.equalsIgnoreCase("Mango"))
            fruit = new Mango();
        if (fruitType.equalsIgnoreCase("Orange"))
            fruit = new Orange();
        if (fruitType.equalsIgnoreCase("Apple"))
            fruit = new Apple();
        fruit.setFruit();
        return fruit;
    }
}
