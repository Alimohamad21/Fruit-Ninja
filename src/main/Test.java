package main;

import factories.FruitFactory;
import player.Player;

public class Test {
    public static void main(String[] args) {
        Player player=Player.getPlayer();
        System.out.println(player);
        Player player1=Player.getPlayer();
        System.out.println(player1);
        player1.setLife(0);
        System.out.println(player.getLife());
        FruitFactory fruitFactory=new FruitFactory();
        fruitFactory.create("mango");
    }
}
