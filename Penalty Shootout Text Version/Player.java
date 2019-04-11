import java.util.Random;

public class Player {
	// Instance Variables
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
	// Other Method(s)
	public int randStrength() {
		Random rand = new Random();
		int n = rand.nextInt(100);
		n += 1;
		return n;
	}
}
