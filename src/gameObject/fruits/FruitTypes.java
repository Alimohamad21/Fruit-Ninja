package gameObject.fruits;

import java.util.Random;

public enum FruitTypes {
    Watermelon,
    Apple,
    Banana,
    Peach,
    Strawberry;
     public FruitTypes fruitTypes;

    public String randomFruitTypes() {
        Random random = new Random();
        return String.valueOf(FruitTypes.values()[random.nextInt(FruitTypes.values().length)]);
    }

}

