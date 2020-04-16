package gameObject.fruits;


public class Mango extends Fruit {

    public Mango() {};
    public Mango(int x, int y) {
        super(x, y);
        objectLife = 1;
        sliced = false;
        this.length = 2; //to be determined//
        this.width = 1; //to be determined//
        points = objectLife * 10;
    }

}
