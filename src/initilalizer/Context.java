package initilalizer;

public class Context {
	private IDifficulties difficulties;
	private String difficulty;

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public void starter() {
		if(difficulty.equalsIgnoreCase("Easy")){
			
		}else if(difficulty.equalsIgnoreCase("Normal")){
			difficulties=new NormalDiff();
		}else if(difficulty.equalsIgnoreCase("Hard")){
			
		}else {difficulties=new NormalDiff();}
	}
}
