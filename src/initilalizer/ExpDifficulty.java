package initilalizer;

import java.io.File;
import java.util.Random;

import factories.BombFactory;
import factories.FruitFactory;
import gameObject.bombs.BombsTypes;
import gameObject.fruits.FruitTypes;
import jaco.mp3.player.MP3Player;

public class ExpDifficulty implements ILevel{

	    private int timeBetweenLoops;
	    BombFactory factory2 = new BombFactory();
	    Random numberOfObjects = new Random();
	    Random interval = new Random();
	    FruitFactory factory = new FruitFactory();
	    Random numberOfFruits = new Random();
	    MP3Player mp3Player = new MP3Player(new File("throw.mp3"));
	    MP3Player bombSound=new MP3Player(new File("Fuse.mp3"));

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
	    int random,i,j;
	    int fruitCount = 0;
	    //while (true) {
	        random = 2+numberOfFruits.nextInt(2);
	        boolean bombCreated=false;
	        Random bombs=new Random();
	        fruitCount += random;
	        int noOfBombs=bombs.nextInt(3);
	        j=0;
	        for (i = 0; i < random; i++){
	            FruitTypes fruitTypes = gameObject.fruits.FruitTypes.Apple;
	            BombsTypes bombsTypes = gameObject.bombs.BombsTypes.Fatal;
	            handler.addObject(factory.create(fruitTypes.randomFruitTypes()));
	            mp3Player.play();
	            try {
	                while(j<noOfBombs && !bombCreated) {
	                    handler.addObject(factory2.create(bombsTypes.randomBombsTypes()));
						if(handler.getType().equals("classic"))
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
	        while (!handler.getListOfObjects().isEmpty()) handler.removeOutOfBoundObjects();
	   // }
	}

}
