package initilalizer;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Window extends Canvas {

	private static final long serialVersionUID = -6374877296636020057L;

	public Window(int width, int height, String title, GameLoop game) {
		JFrame frame= new JFrame(title);
		frame.addMouseListener(new Slicing());
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		frame.setLocationRelativeTo(null);
		//frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setResizable(false);
		/*addKeyListener( new KeyAdapter(){
			public void keyPressed(KeyEvent ke) {
				if(ke.getKeyCode()==KeyEvent.VK_ESCAPE) {
					System.out.println("escaped?");
					System.exit(0);
				}
			}
			});*/
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}

}
