package initilalizer;

import java.io.File;
import java.util.Random;

import factories.BombFactory;
import factories.FruitFactory;
import gameObject.bombs.BombsTypes;
import gameObject.fruits.FruitTypes;
import jaco.mp3.player.MP3Player;

public class StarterDifficulty implements ILevel {

    private int timeBetweenLoops;
    private boolean entered = false;
    MP3Player mp3Player = new MP3Player(new File("throw.mp3"));
    MP3Player bombSound = new MP3Player(new File("Fuse.mp3"));
    BombFactory factory2 = new BombFactory();
    Random numberOfObjects = new Random();
    Random interval = new Random();
    FruitFactory factory = new FruitFactory();
    Random numberOfFruits = new Random();

    public StarterDifficulty() {
        timeBetweenLoops = 100;
    }

    @Override
    public void initObjects(Thread thread, Handler handler, GameLoop game) {
        int random, i;
        //   int waitingTime = timeBetweenLoops + interval.nextInt(500 - timeBetweenLoops);
        int fruitCount = 0;
        FruitTypes fruitTypes = gameObject.fruits.FruitTypes.Apple;
        BombsTypes bombsTypes = gameObject.bombs.BombsTypes.Fatal;
        if (!entered) {
            try {
                handler.addObject(factory.create(fruitTypes.randomFruitTypes(), game));
                mp3Player.play();
                Thread.sleep(timeBetweenLoops + interval.nextInt(500 - timeBetweenLoops));
            } catch (InterruptedException e) {
            }
            while (!handler.getListOfObjects().isEmpty()) handler.removeOutOfBoundObjects();
            for (i = 0; i < 2; i++) {
                try {
                    handler.addObject(factory.create(fruitTypes.randomFruitTypes(), game));
                    mp3Player.play();
                    Thread.sleep(timeBetweenLoops + interval.nextInt(500 - timeBetweenLoops));
                } catch (InterruptedException e) {
                }
            }
            while (!handler.getListOfObjects().isEmpty()) handler.removeOutOfBoundObjects();
        }
        entered = true;
        random = 2 + numberOfFruits.nextInt(4);
        boolean bombCreated = false;
        Random bombs = new Random();
        fruitCount += random;
        if (game.isFrenzyMode())
            random = 10;
        int noOfBombs = bombs.nextInt(2);
        for (i = 0; i < random; i++) {
            handler.addObject(factory.create(fruitTypes.randomFruitTypes(), game));
            mp3Player.play();
            try {
                if (!game.isFrenzyMode()) {
                    if (noOfBombs == 1 && !bombCreated) {
                        handler.addObject(factory2.create(bombsTypes.randomBombsTypes()));
                        if (handler.getType().equals("classic"))
                            bombSound.play();
                        bombCreated = true;
                    }
                }
                Thread.sleep(timeBetweenLoops + interval.nextInt(500 - timeBetweenLoops));

            } catch (InterruptedException e) {

            }
        }

        while (!handler.getListOfObjects().isEmpty()) handler.removeOutOfBoundObjects();
    }
}
