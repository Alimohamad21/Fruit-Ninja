package gameObject.bombs;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Fatal extends Bombs{
	 public Fatal() {};
	    private BufferedImage img1 = null;
	    public Fatal(int x, int y) {
	        super(x, y);
	        objectLife = 1;
	        sliced = false;
	        this.length = 2; //to be determined//
	        this.width = 1; //to be determined//
	    }
	    public void render(Graphics graphics) {
			try
			{
				img1 = ImageIO.read(this.getClass().getResource("boom.png"));
			}
			catch ( IOException exc )
			{
			    System.out.println("Fatal rendering failed");
			}
			graphics.drawImage(img1, (int)xCoordinate,(int)yCoordinate, null);
	    }
}
