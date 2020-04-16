package main;

import gameObject.fruits.Mango;

public class Test {
    public static void main(String[] args) {
        Mango fruit = new Mango();
        System.out.println(fruit.getObjectType());
        System.out.println(fruit.getObjectLife());
        System.out.println(fruit.getLength());
        System.out.println(fruit.isSliced());

    }
}
