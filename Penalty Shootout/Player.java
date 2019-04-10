
public class Player extends Avatar {
	// Instance Variables that represent the characteristics of the player that the user controls
	private String name; 
	private String nationality;
	private int playerScore = 0;

	// Constructors
	public Player() {
		this.name = "C.Ronaldo"; 
		this.nationality = "Portugal";
		this.playerScore = 0;
	}
	public Player(String name, String nationality) {
		this.name = name;
		this.nationality = nationality;
		this.playerScore = 0;
	}
	// Getters and Setters
        @Override
	public String getName() {
		return name;
	}
        @Override
	public void setName(String name) {
		this.name = name;
	}

        @Override
	public String getNationality() {
		return nationality;
	}
        @Override
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public int getPlayerScore() {
		return playerScore;
	}
	public void setPlayerScore(int playerScore) {
		if(playerScore>0){
		this.playerScore += playerScore;
		}
	}
}
