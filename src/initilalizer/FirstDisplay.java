package initilalizer;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FirstDisplay extends JFrame {

    private JPanel frame;
    private JTextField textField;
    private JLabel nameLabel;
    private JButton proceed;
    private JLabel easy;
    private JLabel hard;
    private JLabel medium;
    private JLabel background;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
       /*EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FirstDisplay frame = new FirstDisplay();
                    frame.setVisible(true);
                    frame.initFirstDisplay();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });*/
       GameLoop gameActions = new GameLoop();
    }

    /**
     * Create the frame.
     */
    public FirstDisplay() {
        frame = new JPanel();
        textField = new JTextField();
        nameLabel = new JLabel("Enter Name:");
        proceed = new JButton("Proceed");
        easy = new JLabel();
        medium = new JLabel();
        hard = new JLabel();
        background = new JLabel();


    }

    public void initFirstDisplay() {
        Mouse m = new Mouse();
        addMouseMotionListener(m);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(550, 200, 700, 400);
        frame.setBackground(Color.WHITE);
        frame.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(frame);
        frame.setLayout(null);
        textField.setBounds(229, 204, 202, 42);
        frame.add(textField);
        textField.setColumns(10);

        nameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
        nameLabel.setBackground(Color.WHITE);
        nameLabel.setBounds(74, 211, 128, 35);
        frame.add(nameLabel);


        proceed.addActionListener(e -> {
            dispose();
            GameLoop gameActions = new GameLoop();
        });
        proceed.setBounds(500, 276, 144, 51);
        frame.add(proceed);

       Image img1 = new ImageIcon(this.getClass().getResource("easy.png")).getImage();
        easy.setIcon(new ImageIcon(img1));
        easy.setBounds(64, 47, 120, 119);
        frame.add(easy);

        medium.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        medium.setBounds(267, 25, 120, 119);
        Image img4 = new ImageIcon(this.getClass().getResource("medium.png")).getImage();
        medium.setIcon(new ImageIcon(img4));
        frame.add(medium);

        Image img = new ImageIcon(this.getClass().getResource("hard.png")).getImage();
        hard.setIcon(new ImageIcon(img));
        hard.setBounds(484, 47, 120, 120);
        frame.add(hard);

        Image img2 = new ImageIcon(this.getClass().getResource("firstBackground2.jpg")).getImage();
        background.setIcon(new ImageIcon(img2));
        background.setBounds(0, 0, 682, 353);
        frame.add(background);


    }
}
