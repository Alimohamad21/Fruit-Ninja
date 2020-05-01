package gameObject.fruits;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class SuperFrenzyFruit  extends SuperFruit {
    private BufferedImage img1 = null;
    private BufferedImage img2 = null;

    public SuperFrenzyFruit(int x, int y) {
        super(x, y);
    }

    public void render(Graphics graphics) {
        if (!sliced) {
            try {
                img1 = ImageIO.read(this.getClass().getResource("Frenzy_Banana.png"));
                setImg(img1);
            } catch (IOException exc) {
                System.out.println("apple rendering failed");
            }
        } else {
            try {
                img1 = ImageIO.read(this.getClass().getResource("Frenzy_BananaSliced.png"));
                setImg(img1);
            } catch (IOException exc) {
                System.out.println("Sliced apple rendering failed");
            }
        }
        graphics.drawImage(img1, (int) xCoordinate, (int) yCoordinate, null);
    }

}

