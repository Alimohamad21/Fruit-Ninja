package initilalizer;

public class LevelController implements Observer {
    private ILevel difficulty;
    private int points = 0;
    private boolean stCreated = false, expCreated = false;

    public LevelController() {
    }

    @Override
    public void update(int points) {
        this.points = points;
    }

    public void Generate(Thread thread, Handler handler, GameLoop game) {
        while (true) {
            if (points < 30) {
                if (!stCreated) {
                    difficulty = new StarterDifficulty();
                    stCreated = true;
                }
            } else {
                if (!expCreated) {
                    difficulty = new ExpDifficulty();
                    expCreated = true;
                }
            }
            difficulty.initObjects(thread, handler, game);
        }
    }
}
