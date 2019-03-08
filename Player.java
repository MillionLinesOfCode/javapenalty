import java.util.Random;

public class Player {
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getPlayerScore() {
		return playerScore;
	}
	public void setPlayerScore(int playerScore) {
		this.playerScore += playerScore;
	}

	// Methods
	public int randStrength() { //Generates a random number between 1 and 100(to be changed later) 
		Random rand = new Random();
		int n = rand.nextInt(100);
		n += 1;
		return n;
	}
}
