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
            difficulties=new GameLoop();
        } else if (difficulty.equalsIgnoreCase("Normal")) {
            difficulties = new GameLoop();
        } else if (difficulty.equalsIgnoreCase("Hard")) {

        } else {
            difficulties = new GameLoop();
        }
    }
}
