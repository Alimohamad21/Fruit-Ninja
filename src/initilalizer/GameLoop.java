package initilalizer;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

import factories.BombFactory;
import factories.FruitFactory;
import gameObject.GameObject;
import gameObject.bombs.BombsTypes;
import gameObject.fruits.fruitTypes;
import jaco.mp3.player.MP3Player;
import main.Player;

public class GameLoop extends Canvas implements Runnable, IMainGameActions {
    private static final long serialVersionUID = 2916851953456180804L;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;


    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private BufferedImage img1;
    Window window;

    public GameLoop() {
        handler = new Handler();
        window = new Window(WIDTH, HEIGHT, "FRUIT NINJA", this);

    }

    public void initObjects() {

        int count = 0;
        MP3Player mp3Player = new MP3Player(new File("throw.mp3"));
        MP3Player mp3Player1 = new MP3Player(new File("menu.mp3"));
        MP3Player bombSound=new MP3Player(new File("Fuse.mp3"));
        mp3Player1.setRepeat(true);
        mp3Player1.play();
        FruitFactory factory1 = new FruitFactory();
        BombFactory factory2 = new BombFactory();
        Difficulty difficulty = initilalizer.Difficulty.getDifficulty();
        Player player = Player.getPlayer();
        Random numberOfObjects = new Random();
        Random interval = new Random();
        FruitFactory factory = new FruitFactory();
        Random numberOfFruits = new Random();
        int random ;
        int fruitCount = 0;
        while (true) {
            random = 2+numberOfFruits.nextInt(4);
            boolean bombCreated=false;
            Random bombs=new Random();
            fruitCount += random;
            int noOfBombs=bombs.nextInt(3);
            for (int i = 0; i < random; i++) {
                fruitTypes fruitTypes = gameObject.fruits.fruitTypes.Apple;
                BombsTypes bombsTypes = gameObject.bombs.BombsTypes.Fatal;
                handler.addObject(factory.create(fruitTypes.randomFruitTypes()));
                mp3Player.play();
                try {

                    if(noOfBombs==1 && !bombCreated) {
                        handler.addObject(factory2.create("fatal"));// randomize el type lamma ne3mel el tanya
                        bombSound.play();
                        bombCreated=true;
                    }
                    Thread.sleep(difficulty.getTimeBetweenLoops() + interval.nextInt(500 - difficulty.getTimeBetweenLoops()));

                } catch (InterruptedException e) {
                    // System.out.println("Ali");
                }
            }
            while (!handler.listOfObjects.isEmpty()) handler.removeOutOfBoundObjects();
        }

    }

    public synchronized void start() {

        try {
            img1 = ImageIO.read(this.getClass().getResource("background.jpg"));
        } catch (IOException exc) {
            System.out.println("Background");
        }
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double tick_time_in_nanoseconds = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            // System.out.println(now);
            delta += (now - lastTime) / tick_time_in_nanoseconds;
            lastTime = now;
            while (delta >= 1) {
                tick();

                delta--;
            }
            if (running) {
                render();
               // this.addMouseListener(new Slicing());
              //  window.addMouseListener(new Slicing());
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: "+ frames);
                frames = 0;
            }
        }
        stop();
    }

    public void tick() {
        handler.tick();
    }

    public void render() {
       try {
           Mouse mouse = new Mouse();
           addMouseMotionListener(mouse);
           MP3Player splash=new MP3Player(new File("splatter.mp3"));
           int i;
           for (i = 0; i < handler.listOfObjects.size(); i++) {
               GameObject object = handler.listOfObjects.get(i);
              /* System.out.println("object{" + i + "}:" + object.getYCoordinate() + "," + object.getYCoordinate());
               System.out.println("mouse:" + mouse.x + "," + mouse.y);*/
               if (mouse.x >= object.getXCoordinate() && mouse.x <= object.getXCoordinate() + object.getImg().getWidth()) {
                   if (mouse.y >= object.getYCoordinate() && mouse.y <= object.getYCoordinate() + object.getImg().getHeight()) {
                       if (!object.isSliced()) {
                           object.setSliced(true);
                           System.out.println("SLICED");
                           splash.play();
                       }
                   }
               }
           }
       }catch (Exception e){

       }
        BufferStrategy bufferSt = this.getBufferStrategy();
        if (bufferSt == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics graphics = bufferSt.getDrawGraphics();
        graphics.drawImage(img1, 0, 0, null);
        handler.render(graphics);
        graphics.dispose();
        bufferSt.show();
    }
}
