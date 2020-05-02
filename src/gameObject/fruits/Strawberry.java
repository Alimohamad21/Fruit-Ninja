package gameObject.fruits;

import gameObject.GameState;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Strawberry extends Fruit {

    public Strawberry() {}

	private BufferedImage img1 = null;
    private BufferedImage img2 = null;
    public Strawberry(int x, int y) {
        super(x, y);
        objectLife = 1;
        sliced = false;

        points = objectLife * 10;
    }
	public Strawberry(double xCoordinate, double yCoordinate, double velocityX, double velocityY, int objectLife, boolean sliced, int points, BufferedImage img) {
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
    				img2 = ImageIO.read(this.getClass().getResource("basaha-1.png"));
    				setImg(img1);
    			}
    			catch ( IOException exc )
    			{
    			    System.out.println("Sliced strawberry rendering failed");
        }}
        	graphics.drawImage(img1, (int)xCoordinate,(int)yCoordinate, null);
        	graphics.drawImage(img2, (int)(xCoordinate-50),(int)yCoordinate, null);
    }
}
