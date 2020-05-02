package initilalizer;

import main.HighScoreFileHandling;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class FirstDisplay extends JFrame {



    /**
     * Launch the application.
     */
    public static void main(String[] args) throws JAXBException {
        File file = new File("highscore.xml"); //to handle errors if file is empty
        if(file.length()<=30) {  JAXBContext jaxbContext = JAXBContext.newInstance(HighScoreFileHandling.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            HighScoreFileHandling zero=new HighScoreFileHandling();
            zero.setClassicHighScore(0);
            zero.setArcadeHighScore(0);
            marshaller.marshal(zero,file);
        }
        new GameLoop();
    }
    public FirstDisplay() {

    }
}
