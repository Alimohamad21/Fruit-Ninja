package initilalizer;

import java.util.ArrayList;

///Singleton
public class Player{
  private int points;
  private ArrayList <Observer> observers = new ArrayList<Observer>();
  private int life;
  private String userName;
  private static Player player;
  private Player() {
  }

  public static Player getPlayer() {
      if (player == null) {
          player = new Player();
          player.setPoints(0);
          player.setLife(3);
      }
      return player;
  }


  ////Getters,Setters

  public int getPoints() {
      return points;
  }

  public void setPoints(int points) {
      this.points = points;
      notifyAllObservers();
  }

  public int getLife() {
      return life;
  }

  public void setLife(int life) {
      this.life = life;
  }

  public String getUserName() {
      return userName;
  }

  public void setUserName(String userName) {
      this.userName = userName;
  }

public void register(Observer o) {
	observers.add(o);
}

public void unregister(Observer o) {
	observers.remove(o);
}

public void notifyAllObservers() {
	int i;
	for(i=0;i<observers.size();i++) {
	observers.get(i).update();}
	}
}
