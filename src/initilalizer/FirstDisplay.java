package initilalizer;

import fileHandling.HighScoreFileHandling;

import javax.swing.JFrame;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
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
