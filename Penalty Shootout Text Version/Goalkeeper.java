import java.util.Random;

public class Goalkeeper {
	// Instance Variables
	private String name;
	private String nationality;
	private int goalkeeperScore = 0;

	// Constructors
	public Goalkeeper() {
		this.name = "D.de Gea";
		this.nationality = "Spain";
		this.goalkeeperScore = 0;
	}

	public Goalkeeper(String name, String nationality) {
		this.name = name;
		this.nationality = nationality;
		this.goalkeeperScore = 0;
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

	public int getGoalkeeperScore() {
		return goalkeeperScore;
	}
	public void setGoalkeeperScore(int goalkeeperScore) {
		this.goalkeeperScore += goalkeeperScore;
	}

	// Methods
	public int randGoalkeeperNum() {
		Random rand = new Random();
		int n = rand.nextInt(6);
		n += 1;
		return n;
	}
}