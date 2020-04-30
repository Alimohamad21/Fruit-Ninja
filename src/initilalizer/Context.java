package initilalizer;

public class Context {
    private IMainGameActions difficulties;
    private String difficulty;

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void starter() {
        if (difficulty.equalsIgnoreCase("Easy")) {
            difficulties=(IMainGameActions) new GameLoop();
        } else if (difficulty.equalsIgnoreCase("Normal")) {
            difficulties = (IMainGameActions) new GameLoop();
        } else if (difficulty.equalsIgnoreCase("Hard")) {

        } else {
            difficulties = (IMainGameActions) new GameLoop();
        }
    }
}
