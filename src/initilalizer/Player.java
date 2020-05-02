package initilalizer;

import java.util.ArrayList;
import java.util.List;

///Singleton
public class Player {
    private int points = 0;
    private int life;
    private String userName;
    private static Player player;
    List<Observer> observers = new ArrayList<>();

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
        try {
            for (Observer x : observers) {
                x.update(points);
            }
        } catch (Exception e) {
        }
    }

}
