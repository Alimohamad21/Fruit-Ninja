package initilalizer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu extends JFrame {

    private JPanel contentPane;


    /**
     * Create the frame.
     */
    public MainMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 200, 620, 640 * 9 / 12);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel arcade = new JLabel("New label");
        arcade.setIcon(new ImageIcon(MainMenu.class.getResource("/initilalizer/arcade.png")));
        arcade.setBounds(52, 169, 227, 240);
        contentPane.add(arcade);

        JLabel classic = new JLabel("New label");
        classic.setIcon(new ImageIcon(MainMenu.class.getResource("/initilalizer/classicgame.png")));
        classic.setBounds(311, 173, 230, 233);
        contentPane.add(classic);

        JLabel ninja = new JLabel("New label");
        ninja.setIcon(new ImageIcon(MainMenu.class.getResource("/initilalizer/ninja.png")));
        ninja.setBounds(311, 42, 165, 74);
        contentPane.add(ninja);

        JLabel fruit = new JLabel("New label");
        fruit.setIcon(new ImageIcon(MainMenu.class.getResource("/initilalizer/logo.png")));
        fruit.setBounds(10, -11, 290, 140);
        contentPane.add(fruit);

        JLabel shadow = new JLabel("New label");
        shadow.setIcon(new ImageIcon(MainMenu.class.getResource("/initilalizer/home-mask.png")));
        shadow.setBounds(0, 0, 614, 183);
        contentPane.add(shadow);

        JLabel background = new JLabel("New label");
        background.setIcon(new ImageIcon(MainMenu.class.getResource("/initilalizer/background.jpg")));
        background.setBounds(-16, -38, 640, 640 * 9 / 12);
        contentPane.add(background);
    }
}
