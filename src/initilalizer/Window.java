package initilalizer;

import jaco.mp3.player.MP3Player;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Window extends JPanel implements Observer{

	private static final long serialVersionUID = -6374877296636020057L;
	private int points=0;
	JFrame frame;
	JPanel contentPane;
	JLabel melon;
	JLabel newGame;
	JLabel ninja;
	JLabel fruit;
	JLabel shadow;
	private long startTime=0 ;

	public Window(int width, int height, String title, GameLoop game) {
		frame= new JFrame(title);
		frame.setPreferredSize(new Dimension(width,height));
		frame.setMaximumSize(new Dimension(width,height));
		frame.setMinimumSize(new Dimension(width,height));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		//frame.add(game);
		//frame.setVisible(true);
		this.mainMenu(width, height, title, game);
}
	public void mainMenu(int width, int height, String title, GameLoop game) {
		setBounds(550, 200, 620, 640*9/12);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		//frame.getContentPane().add(game);

		melon = new JLabel("New label");

		melon.setIcon(new ImageIcon(Window.class.getResource("/initilalizer/sandia.png")));
		melon.setBounds(246, 249, 106, 85);
		contentPane.add(melon);

		newGame = new JLabel("New label");
		newGame.setIcon(new ImageIcon(Window.class.getResource("/initilalizer/new-game.png")));
		newGame.setBounds(196, 194, 194, 195);
		contentPane.add(newGame);

		ninja = new JLabel("New label");
		ninja.setIcon(new ImageIcon(Window.class.getResource("/initilalizer/ninja.png")));
		ninja.setBounds(311, 42, 165, 74);
		contentPane.add(ninja);

		fruit = new JLabel("New label");
		fruit.setIcon(new ImageIcon(Window.class.getResource("/initilalizer/logo.png")));
		fruit.setBounds(10, -11, 290, 140);
		contentPane.add(fruit);

		shadow = new JLabel("New label");
		shadow.setIcon(new ImageIcon(Window.class.getResource("/initilalizer/home-mask.png")));
		shadow.setBounds(0, 0, 614, 183);
		contentPane.add(shadow);

		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon(Window.class.getResource("/initilalizer/background.jpg")));
		background.setBounds(-16, -38, 640, 640*9/12);
		contentPane.add(background);
		melon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				startTime= System.currentTimeMillis();
				MP3Player slice=new MP3Player(new File("splatter.mp3"));
				slice.play();
				contentPane.removeAll();
				//frame.remove(contentPane);
				contentPane.revalidate();
				contentPane.repaint();
				frame.dispose();
				//frame.setContentPane(contentPane);
				JFrame frame1 = new JFrame(title);
		        frame1.setPreferredSize(new Dimension(width, height));
		        frame1.setMaximumSize(new Dimension(width, height));
		        frame1.setMinimumSize(new Dimension(width, height));
		        frame1.setLocationRelativeTo(null);
		        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame1.setResizable(false);
		        frame1.add(game);
		        frame1.setVisible(true);
		        game.start();

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				melon.setIcon(new ImageIcon(Window.class.getResource("/initilalizer/sandia-1.png")));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				melon.setIcon(new ImageIcon(Window.class.getResource("/initilalizer/sandia.png")));
			}
		});
		//game.start();
		frame.setVisible(true);

	}
	public void drawLabels(Handler handler, Graphics graphics, long currentTime) {

        BufferedImage melonback;
        try {
            melonback = ImageIO.read(this.getClass().getResource("score.png"));
            graphics.drawImage(melonback, 0, 0, null);
        } catch (IOException exc) {
            System.out.println("melon background");
        }
        int runtime = (int) ((currentTime - startTime) / 1000);

        String time = String.format("%02d:%02d", runtime / 60, runtime % 60);
        String highScore = String.format("%d", handler.getGameState().getHighestScore());
		graphics.setColor(Color.YELLOW);
		graphics.setFont(new Font("Bauhaus 93", Font.BOLD, 28));
            graphics.drawString(time, 540, 30);
        graphics.drawString("Score:" + points, 30, 25);
        graphics.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
        graphics.setColor(Color.YELLOW);
        graphics.drawString("Best:" + highScore, 30, 50);
    }



    @Override
    public void update(int points) {
        this.points = points;
    }
}
