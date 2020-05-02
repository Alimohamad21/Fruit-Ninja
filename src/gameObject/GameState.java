package gameObject;

import initilalizer.Player;
import fileHandling.HighScoreFileHandling;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class GameState {
    List<GameState> checkPoint = new ArrayList<>();
    public List<GameObject> gameObjects;
    private int missedFruits = 0;
    private int highestScore = 0;
    private int playerPoints;
    private int playerLife;

    public GameState() {
        gameObjects = new ArrayList<>();

    }


    public void Save() {
        System.out.println(gameObjects.size());
        GameState newGameState = new GameState();
        for (int i = 0; i < this.gameObjects.size(); ++i) {
            this.gameObjects.get(i).SaveObject(newGameState);
        }
        newGameState.playerLife = Player.getPlayer().getLife();
        newGameState.playerPoints = Player.getPlayer().getPoints();
        newGameState.missedFruits = this.missedFruits;
        newGameState.highestScore = this.highestScore;
        checkPoint.add(newGameState);

    }

    public void load(GameState gameState) {
      //  checkPoint.get(checkPoint.size() - 1);
        Player.getPlayer().setLife( checkPoint.get(checkPoint.size() - 1).playerLife);
        Player.getPlayer().setPoints( checkPoint.get(checkPoint.size() - 1).playerPoints);
    }


    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public void setGameObjects(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    public int getMissedFruits() {
        return missedFruits;
    }

    public void setMissedFruits(int missedFruits) {
        this.missedFruits = missedFruits;
    }

    public int getHighestScore() {
        return highestScore;
    }

    public void setHighestScore(int highestScore) {
        this.highestScore = highestScore;
    }

    public void saveArcadeHighScore(Player player) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(HighScoreFileHandling.class);
        File file = new File("highscore.xml");
        Marshaller marshaller = jaxbContext.createMarshaller();
        HighScoreFileHandling save = new HighScoreFileHandling();
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        HighScoreFileHandling load = (HighScoreFileHandling) unmarshaller.unmarshal(file);
        if (player.getPoints() > load.getArcadeHighScore()) {
            save.setArcadeHighScore(player.getPoints());
            save.setClassicHighScore(load.getClassicHighScore());
            marshaller.marshal(save, file);
        }
    }

    public void saveClassHighScore(Player player) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(HighScoreFileHandling.class);
        File file = new File("highscore.xml");
        Marshaller marshaller = jaxbContext.createMarshaller();
        HighScoreFileHandling save = new HighScoreFileHandling();
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        HighScoreFileHandling load = (HighScoreFileHandling) unmarshaller.unmarshal(file);
        if (player.getPoints() > load.getClassicHighScore()) {
            save.setClassicHighScore(player.getPoints());
            save.setArcadeHighScore(load.getArcadeHighScore());
            marshaller.marshal(save, file);
        }
    }
}
