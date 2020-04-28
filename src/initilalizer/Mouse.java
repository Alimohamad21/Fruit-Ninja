package initilalizer;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.IOException;
import java.util.List;

import gameObject.GameObject;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Mouse implements MouseMotionListener {


	List<GameObject> listOfObjects;
	Canvas window;
	static int x, y;
	private static boolean mouseDragged = false;
	private BufferedImage img1 = null;

	public Mouse() {
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		mouseDragged = true;
		int i;
		//System.out.println("mouse dragging");
		x = e.getX();
		y = e.getY();
		/*try
		{
			blade = ImageIO.read(this.getClass().getResource("flash.png"));
			setImg(blade);
		}

		catch ( IOException exc )
		{
			System.out.println("Flash rendering failed");
		}*/
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
		x = y = 0;
		mouseDragged=false;
	}
	public void setImg(BufferedImage img) {
		this.img1 = img;
	}

	public void render(Graphics graphics) {
		if (mouseDragged) {
			try {
				img1 = ImageIO.read(this.getClass().getResource("blade.png"));
				setImg(img1);
			} catch (IOException exc) {
				System.out.println("blade rendering failed");
			}
			graphics.drawImage(img1, x-60, y, null);
		}
	}

}
