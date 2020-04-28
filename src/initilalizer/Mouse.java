package initilalizer;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import gameObject.GameObject;

import javax.swing.*;


public class Mouse implements MouseMotionListener {

 
	List<GameObject> listOfObjects;
	Canvas window;
	static int x,y;
	public Mouse() {
       // this.window = w;
    }

	
	@Override
	public void mouseDragged(MouseEvent e) {

		int i;
		//System.out.println("mouse dragging");
		x=e.getX();
		y=e.getY();
		/*for(i=0;i<listOfObjects.size();i++) {
			GameObject object = listOfObjects.get(i);
			if(x>=object.getXCoordinate() && x<=object.getXCoordinate() + object.getImg().getWidth()) {
				System.out.println("mizo3");
				if(y>=object.getYCoordinate() && y<=object.getYCoordinate() + object.getImg().getHeight()) {
					System.out.println("mizo2");
					if(!object.isSliced()) {
					   object.setSliced(true);
					}
				}
			}
		}*/
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//System.out.println("mouse is released");
		x=y=0;
	}   
}
