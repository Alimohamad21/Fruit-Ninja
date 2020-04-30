package initilalizer;

import java.io.File;
import java.util.Random;

import factories.BombFactory;
import factories.FruitFactory;
import gameObject.bombs.BombsTypes;
import gameObject.fruits.fruitTypes;
import jaco.mp3.player.MP3Player;

public class ExpDifficulty implements ILevel{

	 private int timeBetweenLoops;
	    private Handler handler;

	    public ExpDifficulty(){
	    	timeBetweenLoops = 70;
	    }

	    /**
	     * Getters And Setters
	     **/

	    public int getTimeBetweenLoops() {
	        return timeBetweenLoops;
	    }

	    public void setTimeBetweenLoops(int timeBetweenLoops) {
	        this.timeBetweenLoops = timeBetweenLoops;
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
	    int random,i,j;
	    int fruitCount = 0;
	    while (true) {
	        random = 2+numberOfFruits.nextInt(2);
	        boolean bombCreated=false;
	        Random bombs=new Random();
	        fruitCount += random;
	        int noOfBombs=bombs.nextInt(3);
	        j=0;
	        for (i = 0; i < random; i++){
	            fruitTypes fruitTypes = gameObject.fruits.fruitTypes.Apple;
	            BombsTypes bombsTypes = gameObject.bombs.BombsTypes.Fatal;
	            handler.addObject(factory.create(fruitTypes.randomFruitTypes()));
	            mp3Player.play();
	            try {
	                while(j<noOfBombs && !bombCreated) {
	                    handler.addObject(factory2.create("fatal"));// randomize el type lamma ne3mel el tanya
	                    bombSound.play();
	                    Thread.sleep(timeBetweenLoops + interval.nextInt(500 - timeBetweenLoops));
	                    j++;
	                }
	                if(j>0) {bombCreated=true;}
	                Thread.sleep(timeBetweenLoops + interval.nextInt(500 - timeBetweenLoops));

	            } catch (InterruptedException e) {
	                // System.out.println("Ali");
	            }
	        }
	        while (!handler.listOfObjects.isEmpty()) handler.removeOutOfBoundObjects();
	    }

	}

}
