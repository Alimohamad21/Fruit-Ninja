package factories;

import static initilalizer.GameLoop.HEIGHT;
import static initilalizer.GameLoop.WIDTH;

import java.util.Random;

import gameObject.fruits.Apple;
import gameObject.fruits.Banana;
import gameObject.fruits.Fruit;
import gameObject.fruits.Peach;
import gameObject.fruits.Strawberry;
import gameObject.fruits.Watermelon;

public class FruitFactory {

    public Fruit create(String fruitType) throws NullPointerException {
        Random r = new Random();
        int x_axis = r.nextInt(WIDTH-150);
        Fruit fruit = null;
        if (fruitType.equalsIgnoreCase("Strawberry"))
            fruit = new Strawberry(x_axis, HEIGHT - 33);
        if (fruitType.equalsIgnoreCase("Watermelon"))
            fruit = new Watermelon(x_axis, HEIGHT - 33);
        if (fruitType.equalsIgnoreCase("Apple"))
            fruit = new Apple(x_axis, HEIGHT - 33);
        if (fruitType.equalsIgnoreCase("Peach"))
            fruit = new Peach(x_axis, HEIGHT - 33);
        if (fruitType.equalsIgnoreCase("Banana"))
            fruit = new Banana(x_axis, HEIGHT - 33);
        return fruit;
    }
}
