package gameObject.fruits;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Superx2Fruit extends SuperFruit {
    private BufferedImage img1 = null;
    private BufferedImage img2 = null;

    public Superx2Fruit(int x, int y) {
        super(x, y);
        objectLife=50;
    }

    public void render(Graphics graphics) {
        if (!sliced) {
            try {
                img1 = ImageIO.read(this.getClass().getResource("Score_2x_Banana.png"));
                setImg(img1);
            } catch (IOException exc) {
                System.out.println("Score_2x rendering failed");
            }
        } else {
            try {
                img1 = ImageIO.read(this.getClass().getResource("Score_2x_BananaSliced.png"));
                setImg(img1);
            } catch (IOException exc) {
                System.out.println("Sliced apple rendering failed");
            }
        }
        graphics.drawImage(img1, (int) xCoordinate, (int) yCoordinate, null);
    }

}
