package gameObject.fruits;

import java.util.Random;

public enum fruitTypes {
    Watermelon,
    Apple,
    Banana,
    Peach,
    Strawberry;
     public fruitTypes fruitTypes;

    public String randomFruitTypes() {
        Random random = new Random();
        return String.valueOf(fruitTypes.values()[random.nextInt(fruitTypes.values().length)]);
    }

}

