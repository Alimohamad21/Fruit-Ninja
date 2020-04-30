package initilalizer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Window extends JPanel implements Observer{

	private static final long serialVersionUID = -6374877296636020057L;
	private int points=0;;

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
	BufferedImage melonback;
	try {
	    melonback = ImageIO.read(this.getClass().getResource("score.png"));
	    graphics.drawImage(melonback, 0, 0, null);
	  } catch (IOException exc) {
	    System.out.println("melon background");
	  }
    int runtime=(int)((currentTime-startTime)/1000);
    String time = String.format("%02d:%02d", runtime / 60, runtime % 60);
    graphics.setFont(new Font("Tahoma",Font.ITALIC,24));
    graphics.setColor(Color.YELLOW);
    if(runtime<=9) {graphics.drawString("0:0"+String.valueOf(runtime), 550, 30);}
    else {graphics.drawString(time, 550, 30);}
    graphics.drawString("Score:"+String.valueOf(points),30, 25);
}
  

	@Override
	public void update(int points) {
		this.points= points;
	}
}
