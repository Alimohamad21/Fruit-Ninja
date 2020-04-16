package gameObject.fruits;

import gameObject.GameObject;

public abstract class Fruit extends GameObject {
     ObjectType objectType=ObjectType.fruit;

    @Override
    public ObjectType getObjectType() {
        return objectType;
    }

    @Override
    public void setObjectType(ObjectType objectType) {
        this.objectType = ObjectType.fruit;
    }
}
