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
	private BufferedImage img2 = null;
    public Apple() {
    };
    public Apple(int x, int y) {
        super(x, y);
        objectLife = 1;
        sliced = false;
        points = objectLife * 10;
    }
	public Apple(double xCoordinate, double yCoordinate, double velocityX, double velocityY, int objectLife, boolean sliced, int points, BufferedImage img) {
		super(xCoordinate, yCoordinate, velocityX, velocityY, objectLife, sliced, points, img);

	}
	@Override
	public void SaveObject(GameState gameState) {
    	gameState.gameObjects.add(new Apple(this.getXCoordinate(), this.getYCoordinate(), this.getVelocityX(), this.getVelocityY(), this.getObjectLife(), this.isSliced(), this.getPoints(), this.getImg()));
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
    				img2 = ImageIO.read(this.getClass().getResource("apple-1.png"));
    				setImg(img1);
    			}
    			catch ( IOException exc )
    			{
    			    System.out.println("Sliced apple rendering failed");
        }}
        	graphics.drawImage(img1, (int)xCoordinate,(int)yCoordinate, null);
        	graphics.drawImage(img2, (int)(xCoordinate-50),(int)yCoordinate, null);
    }
    }
