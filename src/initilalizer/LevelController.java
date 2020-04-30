package initilalizer;

public class LevelController implements Observer{
    private ILevel difficulty;
    private int points=0;
    private Player player= Player.getPlayer();

   public LevelController(){   
   }
    
    public void Generate(Thread thread,Handler handler) {
        if(points<50){
        	difficulty= new StarterDifficulty();
        	player.register((StarterDifficulty) difficulty);
        	difficulty.initObjects(thread,handler);
        }else{
        	difficulty= new ExpDifficulty();
        	difficulty.initObjects(thread,handler);
        }
    }

	@Override
	public void update() {
		this.points= player.getPoints();
	}
}
