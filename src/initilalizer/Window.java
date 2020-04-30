package initilalizer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.*;

public class Window extends JPanel implements Observer{

	private static final long serialVersionUID = -6374877296636020057L;
	private Player player= Player.getPlayer();
	private int points;

	public Window(int width, int height, String title, GameLoop game) {
		JFrame frame= new JFrame(title);
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(game);
		frame.setVisible(true);
		game.start();
}

public void drawLabels(Graphics graphics,long currentTime,long startTime) {
    int runtime=(int)((currentTime-startTime)/1000);
    graphics.setFont(new Font("Tahoma",Font.ITALIC,24));
    graphics.setColor(Color.YELLOW);
    if(runtime<=9) {graphics.drawString("0:0"+String.valueOf(runtime), 550, 30);}
    else {graphics.drawString("0:"+String.valueOf(runtime), 550, 30);}
    graphics.drawString("Points:"+String.valueOf(points),20, 30);
}
	@Override
	public void update() {
		points= player.getPoints();
	}
}
