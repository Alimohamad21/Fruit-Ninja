package initilalizer;

import jaco.mp3.player.MP3Player;
import fileHandling.HighScoreFileHandling;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Window extends JPanel implements Observer {

    private static final long serialVersionUID = -6374877296636020057L;
    private int points = 0;
    private JFrame frame;
    private JPanel contentPane;
    private JLabel melon;
    private JLabel newGame;
    private JLabel ninja;
    private JLabel fruit;
    private JLabel shadow;
    private GameLoop game;
    private long startTime = 0;
    JAXBContext jaxbContext = JAXBContext.newInstance(HighScoreFileHandling.class);
    File file = new File("highscore.xml");
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    HighScoreFileHandling load = (HighScoreFileHandling) unmarshaller.unmarshal(file);

    public Window(int width, int height, String title, GameLoop game) throws JAXBException {
        frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        //frame.add(game);
        //frame.setVisible(true);
        this.game = game;
        this.mainMenu(width, height, title, game);
    }

    public void mainMenu(int width, int height, String title, GameLoop game) {
        setBounds(550, 200, 620, 640 * 9 / 12);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);

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

        JLabel arcade = new JLabel("New label");
        arcade.setIcon(new ImageIcon(Window.class.getResource("/initilalizer/arcade.png")));
        arcade.setBounds(52, 169, 227, 240);
        contentPane.add(arcade);

        JLabel classic = new JLabel("New label");
        classic.setIcon(new ImageIcon(Window.class.getResource("/initilalizer/classicgame.png")));
        classic.setBounds(311, 173, 230, 233);
        contentPane.add(classic);

        JLabel background = new JLabel("New label");
        background.setIcon(new ImageIcon(Window.class.getResource("/initilalizer/background.jpg")));
        background.setBounds(-16, -38, 640, 640 * 9 / 12);
        contentPane.add(background);
        classic.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                startTime = System.currentTimeMillis();
                MP3Player slice = new MP3Player(new File("splatter.mp3"));
                slice.play();
                contentPane.removeAll();
                //frame.remove(contentPane);
                contentPane.revalidate();
                contentPane.repaint();
                frame.dispose();
                JFrame frame1 = new JFrame(title);
                frame1.setPreferredSize(new Dimension(width, height));
                frame1.setMaximumSize(new Dimension(width, height));
                frame1.setMinimumSize(new Dimension(width, height));
                frame1.setLocationRelativeTo(null);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setResizable(false);
                frame1.add(game);
                frame1.setVisible(true);
                game.setMode("classic");
                game.start();

            }
        });
        arcade.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                startTime = System.currentTimeMillis();
                MP3Player slice = new MP3Player(new File("splatter.mp3"));
                slice.play();
                contentPane.removeAll();
                //frame.remove(contentPane);
                contentPane.revalidate();
                contentPane.repaint();
                frame.dispose();
                game.handler.setType("arcade");
                JFrame frame1 = new JFrame(title);
                frame1.setPreferredSize(new Dimension(width, height));
                frame1.setMaximumSize(new Dimension(width, height));
                frame1.setMinimumSize(new Dimension(width, height));
                frame1.setLocationRelativeTo(null);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setResizable(false);
                frame1.add(game);
                frame1.setVisible(true);
                game.setMode("arcade");
                game.start();

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
        if (runtime >= 58 && game.handler.getType().equals("arcade")) {
            time = "00:00";
        }
        if (runtime > 1 && (runtime % 60) == 0 && game.handler.getType().equals("arcade")) {
            game.setGameOver(true);

        }
        String highScore;
        if (game.handler.getType() == "arcade") {
            time = String.format("%02d:%02d", runtime / 60, 60 - (runtime % 60));
            highScore = String.format("%d", load.getArcadeHighScore());
        } else highScore = String.format("%d", load.getClassicHighScore());

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
