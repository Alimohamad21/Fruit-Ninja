package initilalizer;

import java.awt.event.*;


public class Slicing extends KeyAdapter {


    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)

            System.out.println("hi");

    }


}
