package back;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{
	private static final long serialVersionUID = 2916851953456180804L;
	public static final int WIDTH=640,HEIGHT=WIDTH/12*9;
	
	private Thread thread;
	private boolean running=false;
	private Handler handler;
	Random randomNumber=new Random();
	public Game() {
		new Window(WIDTH,HEIGHT,"FRUIT NINJA",this);
		handler=new Handler();
		handler.addObject(new ThrownFruit(WIDTH/2-32,HEIGHT-33));
	}
	public synchronized void start() {
		thread=new Thread(this);
		thread.start();
		running=true;
	}
	public synchronized void stop() {
		try {
			thread.join();
			running=false;
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
        while(running)
        {
                    long now = System.nanoTime();
                    delta += (now - lastTime) / tick_time_in_nanoseconds;
                    lastTime = now;
                    while(delta >=1)
                            {
                                tick();
                                delta--;
                            }
                            if(running)
                                render();
                            frames++;
                            
                            if(System.currentTimeMillis() - timer > 1000)
                            {
                                timer += 1000;
                                //System.out.println("FPS: "+ frames);
                                frames = 0;
                            }
        }
                stop();
	}
	private void tick() {
		handler.tick();
	}
	private void render() {
		BufferStrategy bufferSt=this.getBufferStrategy();
		if(bufferSt==null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics graphics=bufferSt.getDrawGraphics();
		graphics.setColor(Color.GRAY);
		graphics.fillRect(0,0, WIDTH, HEIGHT);
		handler.render(graphics);
		graphics.dispose();
		bufferSt.show();
	}
	public static void main(String[] args) {
		new Game();
	}

}
