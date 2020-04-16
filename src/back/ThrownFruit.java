package back;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class ThrownFruit extends GameObject{
	Random randomNumber=new Random();
	public ThrownFruit(int x, int y) {
		super(x, y);
		velocityX=5;
		velocityY=5;
	}
	public void tick() {
		x+=velocityX;
		if(x<=0 || x>=Game.WIDTH-16) velocityX*=-1;
		y+=velocityY;
		if(y<=Game.HEIGHT/2-32 || y>=Game.HEIGHT-32) velocityY*=-1;
	}
	public void render(Graphics graphics) {
		graphics.setColor(Color.white);
		graphics.fillRect(x,y, 32, 32);
	}
	
}
