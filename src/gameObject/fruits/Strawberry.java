package gameObject.fruits;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Strawberry extends Fruit {

    public Strawberry() {};
    private BufferedImage img1 = null;
    public Strawberry(int x, int y) {
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
    			img1 = ImageIO.read(this.getClass().getResource("basaha.png"));
    			setImg(img1);
    		}
    		catch ( IOException exc )
    		{
    		    System.out.println("Strawberry rendering failed");
    		}}else {
    			try
    			{
    				img1 = ImageIO.read(this.getClass().getResource("basaha-2.png"));
    				setImg(img1);
    			}
    			catch ( IOException exc )
    			{
    			    System.out.println("Sliced strawberry rendering failed");
        }}
        	graphics.drawImage(img1, (int)xCoordinate,(int)yCoordinate, null);
    }
}
