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
//import org.eclipse.swt.widgets.Display;

import initilalizer.Slicing;
import initilalizer.Window;

public class Apple extends Fruit {
	//Window window;
    public Apple() {
    };
    public Apple(int x, int y) {
        super(x, y);
        objectLife = 1;
        sliced = false;
        this.length = 2; //to be determined//
        this.width = 1; //to be determined//
        points = objectLife * 10;
    }

    public void render(Graphics graphics) {
    	//window.addMouseListener(new Slicing());
    	double xloc,yloc;
        BufferedImage img1 = null;
        try {
            img1 = ImageIO.read(this.getClass().getResource("apple.png"));
        } catch (IOException exc) {
            System.out.println("Apple rendering failed");
        }
        graphics.drawImage(img1, (int) xCoordinate, (int) yCoordinate, null);
       // xloc=getCursorLocation();
        xloc=MouseInfo.getPointerInfo().getLocation().x;
        yloc= MouseInfo.getPointerInfo().getLocation().y;
        if((xloc>xCoordinate-1 && xloc<xCoordinate+1)&&(yloc>yCoordinate-2 && yloc<yCoordinate+2)) {
        	System.out.println("mizogedan");
        }

    }


}
