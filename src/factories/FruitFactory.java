package factories;

import static initilalizer.GameLoop.HEIGHT;
import static initilalizer.GameLoop.WIDTH;

import java.util.Random;

import gameObject.fruits.*;

public class FruitFactory {

    public Fruit create(String fruitType) throws NullPointerException {
        Random r = new Random();
        Random superFruit = new Random();
        int noOfSuperFruits = superFruit.nextInt(30);
        int x_axis = r.nextInt(WIDTH - 100);
        Fruit fruit = null;
        if (fruitType.equalsIgnoreCase("Strawberry"))
            fruit = new Strawberry(x_axis, HEIGHT - 33);
        if (fruitType.equalsIgnoreCase("Watermelon"))
            fruit = new Watermelon(x_axis, HEIGHT - 33);
        if (fruitType.equalsIgnoreCase("Apple"))
            fruit = new Apple(x_axis, HEIGHT - 33);
        if (fruitType.equalsIgnoreCase("Peach"))
            fruit = new Peach(x_axis, HEIGHT - 33);
        if (fruitType.equalsIgnoreCase("Banana")) {
           /* if (noOfSuperFruits - 6 == 0)
                fruit = new SuperFreezeFruit(x_axis, HEIGHT - 33);
            else
                fruit = new Banana(x_axis, HEIGHT - 33);*/
            fruit = new SuperFreezeFruit(x_axis, HEIGHT - 33);

        }
        return fruit;
    }
}
