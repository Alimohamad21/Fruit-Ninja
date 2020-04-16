package back;

import java.awt.Graphics;

public abstract class GameObject {
	protected int x,y;
	protected int velocityX,velocityY;
	
	public GameObject(int x,int y) {
		this.x=x;
		this.y=y;
	}
	public abstract void tick();
	public abstract void render(Graphics graphics);
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getVelocityX() {
		return velocityX;
	}
	public void setVelocityX(int velocityX) {
		this.velocityX = velocityX;
	}
	public int getVelocityY() {
		return velocityY;
	}
	public void setVelocityY(int velocityY) {
		this.velocityY = velocityY;
	}
	
	
}
