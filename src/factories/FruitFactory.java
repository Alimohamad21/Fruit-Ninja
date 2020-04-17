package factories;

import static back.Game.HEIGHT;
import static back.Game.WIDTH;

import gameObject.fruits.Apple;
import gameObject.fruits.Banana;
import gameObject.fruits.Fruit;
import gameObject.fruits.Peach;
import gameObject.fruits.Strawberry;
import gameObject.fruits.Watermelon;

public class FruitFactory {

    public Fruit create(String fruitType) throws NullPointerException {
        Fruit fruit = null;
        if (fruitType.equalsIgnoreCase("Strawberry")) ;
        fruit = new Strawberry(WIDTH / 2 - 32, HEIGHT - 33);
        if (fruitType.equalsIgnoreCase("Watermelon")) ;
        fruit = new Watermelon(WIDTH / 2 - 32, HEIGHT - 33);
        if (fruitType.equalsIgnoreCase("Apple"))
            fruit = new Apple(WIDTH / 2 - 32, HEIGHT - 33);
        if (fruitType.equalsIgnoreCase("Peach"))
            fruit = new Peach(WIDTH / 2 - 32, HEIGHT - 33);
        if (fruitType.equalsIgnoreCase("Banana"))
            fruit = new Banana(WIDTH / 2 - 32, HEIGHT - 33);
        return fruit;
    }
}
