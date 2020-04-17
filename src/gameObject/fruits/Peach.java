package gameObject.fruits;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Peach extends Fruit {

    public Peach() {};
    private BufferedImage img = null;
	String filePath = new File("images/fruit/peach.png").getAbsolutePath();
	File file=new File(filePath);

    public Peach(int x, int y) {
        super(x, y);
        objectLife = 1;
        sliced = false;
        this.length = 2; //to be determined//
        this.width = 1; //to be determined//
        points = objectLife * 10;
    }
    public void render(Graphics graphics) {
		try
		{
		    img = ImageIO.read(file);
		}
		catch ( IOException exc )
		{
		    System.out.println("mizak");
		}
		graphics.drawImage(img, xCoordinate,yCoordinate, null);
    }
}
