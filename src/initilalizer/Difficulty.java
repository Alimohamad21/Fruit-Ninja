package initilalizer;

public class Difficulty {

    private int fruitSpeed;
    private int fruitNumberPerMoment;
    private int bombSpeed;
    private int bombNumberPerMoment;
    private static Difficulty difficulty = new Difficulty();

    private Difficulty() {
    }

    public static Difficulty getDifficulty() {
        return difficulty;
    }

    public void setNormalDifficulty() {
        fruitSpeed = 5;
        fruitNumberPerMoment = 6;
        bombSpeed = 5;
        bombNumberPerMoment = 3;

    }

    /**
     * Getters And Setters
     **/
    public int getFruitSpeed() {
        return fruitSpeed;
    }

    public void setFruitSpeed(int fruitSpeed) {
        this.fruitSpeed = fruitSpeed;
    }

    public int getFruitNumberPerMoment() {
        return fruitNumberPerMoment;
    }

    public void setFruitNumberPerMoment(int fruitNumberPerMoment) {
        this.fruitNumberPerMoment = fruitNumberPerMoment;
    }

    public int getBombSpeed() {
        return bombSpeed;
    }

    public void setBombSpeed(int bombSpeed) {
        this.bombSpeed = bombSpeed;
    }

    public int getBombNumberPerMoment() {
        return bombNumberPerMoment;
    }

    public void setBombNumberPerMoment(int bombNumberPerMoment) {
        this.bombNumberPerMoment = bombNumberPerMoment;
    }

    public static void setDifficulty(Difficulty difficulty) {
        Difficulty.difficulty = difficulty;
    }
}
