package initilalizer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import factories.FruitFactory;
import gameObject.fruits.Apple;

public class NormalDiff extends Canvas implements Runnable, IDifficulties{
    private static final long serialVersionUID = 2916851953456180804L;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    private Thread thread;
    private boolean running = false;
    private Handler handler;
    FruitFactory factory=new FruitFactory();
    Random randomNumber = new Random();
    private BufferedImage img1 = null;
	/*String filePath = new File("/project3/background.jpg").getAbsolutePath();
	File file=new File(filePath);*/
	//Image img1= new ImageIcon(this.getClass().getResource("background.jpg")).getImage();
    //BufferedImage img1 = ImageIO.read(this.getClass().getResource("background.jpg"));
    //ImageIcon icon = new ImageIcon(image);
        public NormalDiff() {
        new Window(WIDTH, HEIGHT, "FRUIT NINJA", this);
        handler = new Handler();
        int noofobjects;
        Random r = new Random();
        noofobjects = r.nextInt(4) + 1;
        for(int i=0;i<noofobjects;i++) {
        int option=randomNumber.nextInt(5);
        switch (option) {
        case 0:
        handler.addObject(factory.create("Watermelon"));
        break;
        case 1:
       	handler.addObject(factory.create("Apple"));
       	break;
        case 2:
        handler.addObject(factory.create("Banana"));
        break;
        case 3:
        handler.addObject(factory.create("Peach"));
        break;
        case 4:
        handler.addObject(factory.create("Strawberry"));
        break;
        }
        try {
			thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("thread stuck generating fruits");
		}
        }
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
        try
		{
        	img1 = ImageIO.read(this.getClass().getResource("background.jpg"));
		}
		catch ( IOException exc )
		{
		    System.out.println("mizak");
		}
		graphics.drawImage(img1,0,0, null);
        
        //graphics.setColor(Color.GRAY);
        //graphics.fillRect(0, 0, WIDTH, HEIGHT);
        handler.render(graphics);
        graphics.dispose();
        bufferSt.show();
    }

   /* public static void main(String[] args) {
        new Game();
    }
*/
}
