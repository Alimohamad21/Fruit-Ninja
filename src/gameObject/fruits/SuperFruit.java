package gameObject.fruits;

public abstract class SuperFruit extends Fruit {

    protected ObjectType objectType = ObjectType.superFruit;

    @Override
    public ObjectType getObjectType() {
        return objectType;
    }

    public SuperFruit(int x, int y) {
        super(x, y);
    }
}
