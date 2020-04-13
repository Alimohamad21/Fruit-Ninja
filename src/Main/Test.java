package Main;

import Factories.FruitFactory;
import Fruits.Fruit;
import Player.Player;

public class Test {
    public static void main(String[] args) {
        Player player=Player.getPlayer();
        System.out.println(player);
        Player player1=Player.getPlayer();
        System.out.println(player1);
        System.out.println(player.getLife());
        FruitFactory fruitFactory=new FruitFactory();
        fruitFactory.create("mango");
    }
}
