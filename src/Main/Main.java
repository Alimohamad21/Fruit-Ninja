package Main;

import Factories.FruitFactory;

public class Main {


    public static void main(String[] args) {
        //  launch(args);
        FruitFactory fruitFactory = FruitFactory.getFruitFactory();
        fruitFactory.create("mango");
    }
}
