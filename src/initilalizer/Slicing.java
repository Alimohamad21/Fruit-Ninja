package initilalizer;

import java.awt.event.*;


public class Slicing implements MouseListener {


    public void mousePressed(MouseEvent e) {
        System.out.println("hii");
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("hii");

    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
        switch (e.getModifiers()) {
            case InputEvent.BUTTON1_MASK: {
                System.out.println("That's the LEFT button");
                break;
            }
            case InputEvent.BUTTON2_MASK: {
                System.out.println("That's the MIDDLE button");
                break;
            }
            case InputEvent.BUTTON3_MASK: {
                System.out.println("That's the RIGHT button");
                break;
            }
        }
    }
}
