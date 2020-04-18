package initilalizer;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import factories.FruitFactory;
import gameObject.fruits.fruitTypes;
import jaco.mp3.player.MP3Player;

public class GameLoop extends Canvas implements Runnable, IMainGameActions {
    private static final long serialVersionUID = 2916851953456180804L;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;


    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private BufferedImage img1;


    public GameLoop() {
        new Window(WIDTH, HEIGHT, "FRUIT NINJA", this);
        handler = new Handler();
        MP3Player mp3Player=new MP3Player(new File("throw.mp3"));
        MP3Player mp3Player1=new MP3Player(new File("menu.mp3"));
        mp3Player1.setRepeat(true);
        mp3Player.setRepeat(true);
        mp3Player1.play();
        /**lazem tt7at f 7eta tanya class init or sth**/
        FruitFactory factory = new FruitFactory();
        Difficulty difficulty = initilalizer.Difficulty.getDifficulty();
        while(true){
        for (int i = 0; i < difficulty.getFruitNumberPerMoment(); i++) {
            fruitTypes fruitTypes = gameObject.fruits.fruitTypes.Apple;
            handler.addObject(factory.create(fruitTypes.randomFruitTypes()));
            mp3Player.play();


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("thread stuck generating fruits");
            }
        }
        }

    }
    public void initObjects(){

    }

    public synchronized void start() {
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
            delta += (now - lastTime) / tick_time_in_nanoseconds;
            lastTime = now;
            while (delta >= 1) {
                tick();

                delta--;
            }
            if (running)
                render();
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
        BufferStrategy bufferSt = this.getBufferStrategy();
        if (bufferSt == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics graphics = bufferSt.getDrawGraphics();
        try {
            img1 = ImageIO.read(this.getClass().getResource("background.jpg"));
        } catch (IOException exc) {
            System.out.println("Background ");
        }
        graphics.drawImage(img1, 0, 0, null);

        handler.render(graphics);
        graphics.dispose();
        bufferSt.show();
    }


}
