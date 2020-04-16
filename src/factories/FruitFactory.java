package factories;

import gameObject.fruits.Apple;
import gameObject.fruits.Fruit;
import gameObject.fruits.Mango;
import gameObject.fruits.Orange;

import static back.Game.HEIGHT;
import static back.Game.WIDTH;

public class FruitFactory {

    public Fruit create(String fruitType) throws NullPointerException {
        Fruit fruit = null;
        if (fruitType.equalsIgnoreCase("Mango")) ;
        fruit = new Mango(WIDTH / 2 - 32, HEIGHT - 33);
        if (fruitType.equalsIgnoreCase("Orange")) ;
        fruit = new Orange(WIDTH / 2 - 32, HEIGHT - 33);
        if (fruitType.equalsIgnoreCase("Apple"))
            fruit = new Apple(WIDTH / 2 - 32, HEIGHT - 33);
        //   fruit.setFruit();
        return fruit;
    }
}
