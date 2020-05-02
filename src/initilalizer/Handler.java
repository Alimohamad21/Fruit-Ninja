package initilalizer;

import gameObject.GameObject;
import gameObject.GameObject.ObjectType;
import gameObject.GameState;

import java.awt.Graphics;
import java.util.List;

import static initilalizer.GameLoop.HEIGHT;

public class Handler {
    private GameState gameState;
    private Mouse mouse;
    private String type;


    public Handler(String type) {
    	this.type=type;
        gameState = new GameState();
        mouse = new Mouse();
    }

    public void tick() {
        /**m7dsh yghayr el loop dy lel tanya,CM exception**/
        for (int i = 0; i < gameState.getGameObjects().size(); i++) {
            GameObject object = gameState.getGameObjects().get(i);
            object.tick();
        }
    }

    public void render(Graphics graphics) {
        /**m7dsh yghayr el loop dy lel tanya,CM exception**/
        for (int i = 0; i < gameState.getGameObjects().size(); i++) {
            GameObject object = gameState.getGameObjects().get(i);
            mouse.render(graphics);
            if(type=="arcade" && String.valueOf(object.getObjectType()) == "bomb") { continue;}
            object.render(graphics);
        }

    }

    public void addObject(GameObject object) {
        this.gameState.getGameObjects().add(object);
    }

    public void removeOutOfBoundObjects() {
        Player player = Player.getPlayer();
        for (int i = 0; i < gameState.getGameObjects().size(); i++) {
            if (gameState.getGameObjects().get(i).getYCoordinate() >= HEIGHT) {
                if (gameState.getGameObjects().get(i).getObjectType().equals(ObjectType.fruit)) {
                    if (!gameState.getGameObjects().get(i).isSliced()) {
                        if (player.getLife() > 0 && type=="classic") {
                            player.setLife(player.getLife() - 1);
                        gameState.setMissedFruits(getMissedFruits() + 1);
                        }
                        }
                }
                if (gameState.getMissedFruits() == 3)
                    System.out.println("GAME OVER");
                gameState.getGameObjects().remove(i);
            }

        }

    }

    public void removeAllObjects() {
        for (int i = 0; i < gameState.getGameObjects().size(); i++) {
            if (gameState.getGameObjects().get(i).getYCoordinate() >= GameLoop.HEIGHT) {
                gameState.getGameObjects().remove(i);
            }

        }

    }

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
    public List<GameObject> getListOfObjects() {
        return gameState.getGameObjects();
    }

    public void setListOfObjects(List<GameObject> listOfObjects) {
        gameState.setGameObjects(listOfObjects);
    }

    public int getMissedFruits() {
        return gameState.getMissedFruits();
    }

    public void setMissedFruits(int missedFruits) {
        gameState.setMissedFruits(missedFruits);
    }

    public Mouse getMouse() {
        return mouse;
    }

    public void setMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

}
