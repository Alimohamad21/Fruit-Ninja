package gameObject.bombs;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Dangerous extends Bombs {
    public Dangerous() {
    }

    private BufferedImage img1 = null;

    public Dangerous(int x, int y) {
        super(x, y);
        objectLife = 1;
        sliced = false;
    }

    public void render(Graphics graphics) {
        if (!sliced) {
            try {
                img1 = ImageIO.read(this.getClass().getResource("boom.png"));
                setImg(img1);
            } catch (IOException exc) {
                System.out.println("Dangerous rendering failed");
            }
            graphics.drawImage(img1, (int) xCoordinate, (int) yCoordinate, null);
        }
    }
}
