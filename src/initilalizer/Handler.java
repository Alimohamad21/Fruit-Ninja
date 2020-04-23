package initilalizer;

import gameObject.GameObject;
import gameObject.GameObject.ObjectType;
import gameObject.fruits.Fruit;
import gameObject.fruits.fruitTypes;
import main.Player;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static initilalizer.GameLoop.HEIGHT;

public class Handler {
    List<GameObject> listOfObjects;
    private int missedFruits=0;


    public Handler() {
        this.listOfObjects = new ArrayList<>();
    }

    public void tick() {
    	/**m7dsh yghayr el loop dy lel tanya,CM exception**/
        for (int i = 0; i < listOfObjects.size(); i++) {
            GameObject object = listOfObjects.get(i);
            object.tick();
        }
    }

    public void render(Graphics graphics) {
		/**m7dsh yghayr el loop dy lel tanya,CM exception**/
		for (int i = 0; i < listOfObjects.size(); i++) {
            GameObject object = listOfObjects.get(i);
            object.render(graphics);
        }

    }

    public void addObject(GameObject object) {
        this.listOfObjects.add(object);
    }

    public void removeOutOfBoundObjects() {
        Player player = Player.getPlayer();
        for (int i = 0; i < listOfObjects.size(); i++) {
               if (listOfObjects.get(i).getYCoordinate() >= GameLoop.HEIGHT ) {
                   if(listOfObjects.get(i).getObjectType().equals(ObjectType.fruit)){
                   player.setLife(player.getLife()-1);
                   missedFruits++;
                   if(missedFruits==3) {
                       System.out.println("GAME OVER");}
                       System.out.println(listOfObjects.get(i).getObjectType());}
                   listOfObjects.remove(i);
               }

            }

    }
}
