package initilalizer;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.xml.bind.JAXBException;

import gameObject.GameObject;
import gameObject.fruits.GameState;
import jaco.mp3.player.MP3Player;
import main.HighScoreFileHandling;

public class GameLoop extends Canvas implements Runnable {
    private static final long serialVersionUID = 2916851953456180804L;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;


    private Thread thread;
    private boolean running = false;
    protected Handler handler;
    protected BufferedImage img1;
    protected Player player;
    protected Window window;
    private LevelController control;
    private boolean gameOver = false;
    private boolean frenzyMode = false;
    private boolean x2Mode = false;

    BufferedImage death1 = null;
    BufferedImage death2 = null;
    BufferedImage death3 = null;
    BufferedImage gameover = null;
    MP3Player music = new MP3Player(new File("menu.mp3"));

    public void setMode(String mode) {
        this.mode = mode;
    }

    private String mode;
    private GameState gameState;
    long currentTime;


    public GameLoop() throws JAXBException {
        gameState = new GameState();
        handler = new Handler("classic");
        player = Player.getPlayer();
        control = new LevelController();
        player.register(control);
        window = new Window(WIDTH, HEIGHT, "FRUIT NINJA", this);
        player.register(window);
        control.Generate(thread, handler, this);
    }

    public void start() {
        try {
            img1 = ImageIO.read(this.getClass().getResource("background.jpg"));
        } catch (IOException exc) {
            System.out.println("Background");
        }
        MP3Player start = new MP3Player(new File("start.mp3"));
        start.play();
        music.setRepeat(true);
        music.play();
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
                try {
                    tick();
                } catch (JAXBException e) {
                    e.printStackTrace();
                }
                delta--;
            }
            if (running) {
                try {
                    render();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: "+ frames);
                frames = 0;
            }
            try {

                gameover = ImageIO.read(this.getClass().getResource("game-over.png"));
            } catch (IOException exc) {
                System.out.println("Game over rendering failed");
            }
            if (player.getLife() <= 0) {
                getGraphics().drawImage(gameover, 50, 200, null);
                getGraphics().drawImage(death1, WIDTH - 215, 5, null);
                getGraphics().drawImage(death2, WIDTH - 190, 5, null);
                getGraphics().drawImage(death3, WIDTH - 160, 5, null);
                gameOver = true;
            }
        }
        stop();
    }

    public void tick() throws JAXBException {
        MP3Player gameOverSound = new MP3Player(new File("over.mp3"));
        if (gameOver) {
            GameState save = new GameState();
            if (mode.equals("arcade")) save.saveArcadeHighScore(player);
            else if (mode.equals("classic")) save.saveClassHighScore(player);
            music.stop();
            gameOverSound.play();
            getGraphics().drawImage(gameover, 50, 200, null);
            //window.gameOver();
            gameState.Save();
            stop();
        }
        handler.tick();
    }

    public void render() throws InterruptedException {
        int factor = 1;
        try {
            if ((System.nanoTime() - currentTime) / 1000000000 <= 7) {
                if (isFrenzyMode()) {
                    factor = 2;
                    /**New frenzy Label*/
                }
                if (isX2Mode()) {
                    factor = 2;
                    /**New x2label Label*/
                }

                /**Insert Music*/

            } else {
                frenzyMode = false;
                x2Mode = false;
            }
            Mouse mouse = new Mouse();
            addMouseMotionListener(mouse);
            MP3Player splash = new MP3Player(new File("splatter.mp3"));
            int i;
            for (i = 0; i < handler.getListOfObjects().size(); i++) {
                GameObject object = handler.getListOfObjects().get(i);
                if (Mouse.x >= object.getXCoordinate() && Mouse.x <= object.getXCoordinate() + object.getImg().getWidth()) {
                    if (Mouse.y >= object.getYCoordinate() && Mouse.y <= object.getYCoordinate() + object.getImg().getHeight()) {
                        if (!object.isSliced()) {
                            if (String.valueOf(object.getObjectType()).equals("fruit")) {
                                player.setPoints(player.getPoints() + factor);
                                object.setSliced(true);
                                splash.play();
                            } else if (String.valueOf(object.getObjectType()).equals("superFruit")) {
                                if (object.getObjectLife() == 50) {
                                    currentTime = System.nanoTime();
                                    player.setPoints(player.getPoints() + 5);
                                    x2Mode = true;
                                } else if (object.getObjectLife() == 75) {
                                    frenzyMode = true;
                                    currentTime = System.nanoTime();
                                }

                                object.setSliced(true);
                                splash.play();
                            } else {
                                MP3Player bombSound = new MP3Player(new File("boom.mp3"));
                                bombSound.play();
                                if (object.getObjectLife() == 100) player.setLife(0);
                                if (player.getLife() > 0) {
                                    player.setLife(player.getLife() - 1);
                                }
                                object.setSliced(true);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
        }
        BufferStrategy bufferSt = this.getBufferStrategy();
        if (bufferSt == null) {
            this.createBufferStrategy(3);
            return;
        }
        BufferedImage life1 = null;
        BufferedImage life2 = null;
        BufferedImage life3 = null;

        try {

            life1 = ImageIO.read(this.getClass().getResource("x.png"));
            life2 = ImageIO.read(this.getClass().getResource("xx.png"));
            life3 = ImageIO.read(this.getClass().getResource("xxx.png"));
            death1 = ImageIO.read(this.getClass().getResource("xf.png"));
            death2 = ImageIO.read(this.getClass().getResource("xxf.png"));
            death3 = ImageIO.read(this.getClass().getResource("xxxf.png"));
        } catch (IOException exc) {
            System.out.println("Game over rendering failed");
        }

        Graphics graphics = bufferSt.getDrawGraphics();
        long currentTime = System.currentTimeMillis();
        graphics.drawImage(img1, 0, 0, null);
        window.drawLabels(handler, graphics, currentTime);
        if (handler.getType() == "classic") {
            graphics.drawImage(life1, WIDTH - 215, 5, null);
            graphics.drawImage(life2, WIDTH - 190, 5, null);
            graphics.drawImage(life3, WIDTH - 160, 5, null);
            if (player.getLife() == 2)
                graphics.drawImage(death1, WIDTH - 215, 5, null);
            if (player.getLife() == 1) {
                graphics.drawImage(death1, WIDTH - 215, 5, null);
                graphics.drawImage(death2, WIDTH - 190, 5, null);
            }
        }

        handler.render(graphics);
        graphics.dispose();
        bufferSt.show();
    }

    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isFrenzyMode() {
        return frenzyMode;
    }

    public void setFrenzyMode(boolean frenzyMode) {
        this.frenzyMode = frenzyMode;
    }

    public boolean isX2Mode() {
        return x2Mode;
    }

    public void setX2Mode(boolean x2Mode) {
        this.x2Mode = x2Mode;
    }
}
