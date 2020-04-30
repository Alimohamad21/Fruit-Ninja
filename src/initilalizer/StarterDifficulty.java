package initilalizer;

import java.io.File;
import java.util.Random;

import factories.BombFactory;
import factories.FruitFactory;
import gameObject.bombs.BombsTypes;
import gameObject.fruits.fruitTypes;
import jaco.mp3.player.MP3Player;

public class StarterDifficulty implements ILevel,Observer{

    private int timeBetweenLoops;
    private Handler handler;
    private int points=0;
    private Player player= Player.getPlayer();
    LevelController control;
    private boolean stop=false;

    public StarterDifficulty(){
    	timeBetweenLoops = 100;
    }
    
    @Override
    public void initObjects(Thread thread,Handler handler) {
    MP3Player mp3Player = new MP3Player(new File("throw.mp3"));
    MP3Player mp3Player1 = new MP3Player(new File("menu.mp3"));
    MP3Player bombSound=new MP3Player(new File("Fuse.mp3"));
    mp3Player1.setRepeat(true);
    mp3Player1.play();
    FruitFactory factory1 = new FruitFactory();
    BombFactory factory2 = new BombFactory();
    Random numberOfObjects = new Random();
    Random interval = new Random();
    FruitFactory factory = new FruitFactory();
    Random numberOfFruits = new Random();
    int random,i;
    int fruitCount = 0;
    fruitTypes fruitTypes = gameObject.fruits.fruitTypes.Apple;
    BombsTypes bombsTypes = gameObject.bombs.BombsTypes.Fatal;
    try {handler.addObject(factory.create(fruitTypes.randomFruitTypes()));
        mp3Player.play();
        Thread.sleep(timeBetweenLoops + interval.nextInt(500 - timeBetweenLoops));
    }catch (InterruptedException e) {}
    while(!handler.listOfObjects.isEmpty()) handler.removeOutOfBoundObjects();
    for(i=0;i<2;i++) {
    	try{handler.addObject(factory.create(fruitTypes.randomFruitTypes()));
        mp3Player.play();
        Thread.sleep(timeBetweenLoops + interval.nextInt(500 - timeBetweenLoops));
    }catch (InterruptedException e) {}
    }while(!handler.listOfObjects.isEmpty()) handler.removeOutOfBoundObjects();
    while (!stop) {
        random = 2+numberOfFruits.nextInt(2);
        boolean bombCreated=false;
        Random bombs=new Random();
        fruitCount += random;
        int noOfBombs=bombs.nextInt(2);
        for (i = 0; i < random; i++){
            handler.addObject(factory.create(fruitTypes.randomFruitTypes()));
            mp3Player.play();
            try {
                if(noOfBombs==1 && !bombCreated) {
                    handler.addObject(factory2.create("fatal"));
                    bombSound.play();
                    bombCreated=true;
                }
                Thread.sleep(timeBetweenLoops + interval.nextInt(500 - timeBetweenLoops));

            } catch (InterruptedException e) {
            	
            }
        }
        while (!handler.listOfObjects.isEmpty()) handler.removeOutOfBoundObjects();
        if(points>50) {stop=true;}
    }
   control.Generate(thread, handler);
}

	@Override
	public void update() {
		this.points= player.getPoints();
	}

}
