package fileHandling;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
public class HighScoreFileHandling {
    @XmlElement(name = "arcade_high_score")
    private int arcadeHighScore;

    public int getArcadeHighScore() {
        return arcadeHighScore;
    }

    public void setArcadeHighScore(int arcadeHighScore) {
        this.arcadeHighScore = arcadeHighScore;
    }

    @XmlElement(name = "classic_high_score")
    private int classicHighScore;

    public int getClassicHighScore() {
        return classicHighScore;
    }

    public void setClassicHighScore(int highScore) {
        this.classicHighScore = highScore;
    }
}


