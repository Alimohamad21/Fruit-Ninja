package gameObject.fruits;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Peach extends Fruit {

    public Peach() {};
    private BufferedImage img1 = null;
    private BufferedImage img2 = null;
    public Peach(int x, int y) {
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
    			img1 = ImageIO.read(this.getClass().getResource("peach.png"));
    			setImg(img1);
    		}
    		catch ( IOException exc )
    		{
    		    System.out.println("Peach rendering failed");
    		}}else {
    			try
    			{
    				img1 = ImageIO.read(this.getClass().getResource("peach-2.png"));
    				img2 = ImageIO.read(this.getClass().getResource("peach-1.png"));
    				setImg(img1);
    			}
    			catch ( IOException exc )
    			{
    			    System.out.println("Sliced peach rendering failed");
        }}
        	graphics.drawImage(img1, (int)xCoordinate,(int)yCoordinate, null);
        	graphics.drawImage(img2, (int)(xCoordinate-50),(int)yCoordinate, null);
    }
}
