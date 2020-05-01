package gameObject.fruits;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SuperFreezeFruit extends SuperFruit {
    private BufferedImage img1 = null;
    private BufferedImage img2 = null;

    public SuperFreezeFruit(int x, int y) {
        super(x, y);
    }

    public void render(Graphics graphics) {
        if (!sliced) {
            try {
                img1 = ImageIO.read(this.getClass().getResource("apple-1.png"));
                setImg(img1);
            } catch (IOException exc) {
                System.out.println("apple rendering failed");
            }
        } else {
            try {
                img1 = ImageIO.read(this.getClass().getResource("apple-2.png"));
                img2 = ImageIO.read(this.getClass().getResource("apple-1.png"));
                setImg(img1);
            } catch (IOException exc) {
                System.out.println("Sliced apple rendering failed");
            }
        }
        graphics.drawImage(img1, (int) xCoordinate, (int) yCoordinate, null);
        graphics.drawImage(img2, (int) (xCoordinate - 50), (int) yCoordinate, null);
    }

}
