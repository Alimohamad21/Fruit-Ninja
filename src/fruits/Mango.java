package fruits;

public class Mango extends Fruit {

    public Mango() {
        fruitLife = 1;
        sliced = false;
        this.length = 50; //to be determined//
        this.width = 50; //to be determined//
        points = fruitLife * 10;
    }

    public void setFruit() {
        fruitLife = 1;
        sliced = false;
        this.length = 50; //to be determined//
        this.width = 50; //to be determined//
        points = fruitLife * 10;

    }

    @Override
    public String FruitType() {
        return "Mango";
    }
}
