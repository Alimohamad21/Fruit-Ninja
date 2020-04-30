package initilalizer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import factories.BombFactory;
import factories.FruitFactory;
import gameObject.GameObject;
import gameObject.bombs.BombsTypes;
import gameObject.fruits.fruitTypes;
import jaco.mp3.player.MP3Player;

public class GameLoop extends Canvas implements Runnable{
    private static final long serialVersionUID = 2916851953456180804L;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;


    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private BufferedImage img1;
    private Player player;
    Window window;
    LevelController control;
    private final long startTime=System.currentTimeMillis();

    public GameLoop() {
        handler = new Handler();
        player= Player.getPlayer();
        control = new LevelController();
        player.register(control);
        window = new Window(WIDTH, HEIGHT, "FRUIT NINJA", this);
        player.register(window);
        control.Generate(thread,handler);
}
        
     public void start() {
        try {
            img1 = ImageIO.read(this.getClass().getResource("background.jpg"));
        } catch (IOException exc) {
            System.out.println("Background");
        }
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public void stop() {
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
               if (mouse.x>= object.getXCoordinate() && mouse.x <= object.getXCoordinate() + object.getImg().getWidth()) {
                   if (mouse.y>= object.getYCoordinate() && mouse.y<= object.getYCoordinate() + object.getImg().getHeight()) {
                       if (!object.isSliced()) {
                    	   if(String.valueOf(object.getObjectType())=="fruit"){
                    	   player.setPoints(player.getPoints()+1);
                           object.setSliced(true);
                           splash.play();
                    	   }
                    	   else {                    		   
                    		   player.setLife(player.getLife()-1);
                    		   object.setSliced(true);
                    		   }
                       }
                   }
               }
           }
       }catch (Exception e){}
        BufferStrategy bufferSt = this.getBufferStrategy();
        if (bufferSt == null) {
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics graphics = bufferSt.getDrawGraphics();
        long currentTime=System.currentTimeMillis();
        graphics.drawImage(img1, 0, 0, null);
        window.drawLabels(graphics,currentTime,startTime);
        handler.render(graphics);
        graphics.dispose();
        bufferSt.show(); 
    }
}
