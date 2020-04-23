package gameObject.fruits;

//import initilalizer.Slicing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.MouseInfo;
import java.awt.event.MouseListener;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import initilalizer.Window;

public class Apple extends Fruit {
	private BufferedImage img1 = null;
    public Apple() {
    };
    public Apple(int x, int y) {
        super(x, y);
        objectLife = 1;
        sliced = false;
        this.length = 2; //to be determined//
        this.width = 1; //to be determined//
        points = objectLife * 10;
    }

    public void render(Graphics graphics) {
    	if(!sliced) {
    		try
    		{
    			img1 = ImageIO.read(this.getClass().getResource("apple.png"));
    			setImg(img1);
    		}
    		catch ( IOException exc )
    		{
    		    System.out.println("apple rendering failed");
    		}}else {
    			try
    			{
    				img1 = ImageIO.read(this.getClass().getResource("apple-2.png"));
    				setImg(img1);
    			}
    			catch ( IOException exc )
    			{
    			    System.out.println("Sliced apple rendering failed");
        }}
        	graphics.drawImage(img1, (int)xCoordinate,(int)yCoordinate, null);
    }
    }
