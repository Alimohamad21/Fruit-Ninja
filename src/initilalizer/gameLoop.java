package initilalizer;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import factories.FruitFactory;
import gameObject.fruits.fruitTypes;

public class gameLoop extends Canvas implements Runnable, IMainGameActions {
    private static final long serialVersionUID = 2916851953456180804L;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private BufferedImage img1;


    public gameLoop() {
        new Window(WIDTH, HEIGHT, "FRUIT NINJA", this);
        handler = new Handler();

        /**lazem tt7at f 7eta tanya class init or sth**/
        FruitFactory factory = new FruitFactory();
        difficulty Difficulty = difficulty.getDifficulty();
        for (int i = 0; i < Difficulty.getFruitNumberPerMoment(); i++) {
            fruitTypes fruitTypes = gameObject.fruits.fruitTypes.Apple;
            handler.addObject(factory.create(fruitTypes.randomFruitTypes()));


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("thread stuck generating fruits");
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
