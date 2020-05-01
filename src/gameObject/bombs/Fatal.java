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
	        objectLife = 100;
	        sliced = false;

	    }
	    public void render(Graphics graphics) {
			try
			{
				img1 = ImageIO.read(this.getClass().getResource("dangerousbomb.png"));
				setImg(img1);
			}
			catch ( IOException exc )
			{
			    System.out.println("Fatal rendering failed");
			}
			graphics.drawImage(img1, (int)xCoordinate,(int)yCoordinate, null);
	    }
}
