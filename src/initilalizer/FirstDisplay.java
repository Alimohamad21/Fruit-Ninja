package initilalizer;

import java.awt.BorderLayout;
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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FirstDisplay extends JFrame {

	private JPanel frame;
	private JTextField textField;
	Context co=new Context();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstDisplay frame = new FirstDisplay();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FirstDisplay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(550, 200, 700, 400);
		frame = new JPanel();
		frame.setBackground(Color.WHITE);
		frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(frame);
		frame.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(229, 204, 202, 42);
		frame.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(74, 211, 128, 35);
		frame.add(lblNewLabel);
		
		/*JButton btnNewButton_1 = new JButton("Normal");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				co.setDifficulty("Normal");
			}
		});
		btnNewButton_1.setBounds(40, 277, 119, 51);
		frame.add(btnNewButton_1);*/
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				co.setDifficulty("Normal");
			}
		});
		lblNewLabel_4.setBounds(267, 25, 120, 119);
		Image img4= new ImageIcon(this.getClass().getResource("medium.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img4));
		frame.add(lblNewLabel_4);
		
		JButton btnNewButton_3 = new JButton("Proceed");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				co.starter();
			}
		});
		btnNewButton_3.setBounds(500, 276, 144, 51);
		frame.add(btnNewButton_3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img1= new ImageIcon(this.getClass().getResource("easy.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img1));
		lblNewLabel_2.setBounds(64, 47, 120, 119);
		frame.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		Image img= new ImageIcon(this.getClass().getResource("hard.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img));
		lblNewLabel_3.setBounds(484, 47, 120, 120);
		frame.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("");
		Image img2= new ImageIcon(this.getClass().getResource("firstBackground2.jpg")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img2));
		lblNewLabel_1.setBounds(0, 0, 682, 353);
		frame.add(lblNewLabel_1);
		
	}
}
