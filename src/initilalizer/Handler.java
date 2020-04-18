package initilalizer;

import gameObject.GameObject;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static initilalizer.GameLoop.HEIGHT;

public class Handler {
    //LinkedList<GameObject> listOfObjects=new LinkedList<GameObject>();
    List<GameObject> listOfObjects;
    private int deletedFruits=0;
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
            for (int i = 0; i < listOfObjects.size(); i++) {
               if (listOfObjects.get(i).getYCoordinate() >= GameLoop.HEIGHT ) {
                   listOfObjects.remove(i);
                   System.out.println("deleted:" + (++deletedFruits));
                   missedFruits++;
                   if(missedFruits==3)
                       System.out.println("GAME OVER");
               }

            }

    }
}
