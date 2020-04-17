package initilalizer;

import gameObject.GameObject;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList<GameObject> listOfObjects=new LinkedList<GameObject>();
	public void tick() {
		for(GameObject gameObject:listOfObjects) {
			GameObject object=gameObject;
			object.tick();
		}
	}
	public void render(Graphics graphics) {
		for(GameObject gameObject:listOfObjects) {
			GameObject object=gameObject;
			object.render(graphics);
		}
	}
	public void addObject(GameObject object) {
		this.listOfObjects.add(object);
	}
	public void removeObject(GameObject object) {
		this.listOfObjects.remove(object);
	}
}
