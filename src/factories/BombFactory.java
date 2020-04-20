package factories;

import static initilalizer.GameLoop.HEIGHT;
import static initilalizer.GameLoop.WIDTH;

import java.util.Random;

import gameObject.bombs.*;

public class BombFactory {
	public Bombs create(String bombsTypes) throws NullPointerException {
        Random r = new Random();
        int x_axis = r.nextInt(WIDTH-100);
        Bombs bomb = null;
        if (bombsTypes.equalsIgnoreCase("Fatal"))
            bomb = new Fatal(x_axis, HEIGHT - 33);
        if (bombsTypes.equalsIgnoreCase("Dangerous"))
            bomb = new Dangerous(x_axis, HEIGHT - 33);
        return bomb;
}
}
