import java.util.Random;

public class Goalkeeper extends Avatar {
	//Instance Variables that represent the characteristics of the goalkeeper that is played by the user's system and is not playable by user.
	private String name;
	private String nationality;
	private int goalkeeperScore = 0; //Default value

	// Constructors
	public Goalkeeper() {
		//Default values
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

	public int getGoalkeeperScore() {
		return goalkeeperScore;
	}
	public void setGoalkeeperScore(int goalkeeperScore) {
		if (goalkeeperScore > 0) {
                    this.goalkeeperScore += goalkeeperScore;
		}
	}
	// Other Method(s)
	public int randGoalkeeperNum() {
		/*
		Generates a random number between 1 and 6,
		which the goalkeeper 'A.I.' uses to guess the direction in which the player shoots
		*/
		Random rand = new Random();
		int n = rand.nextInt(6);
		n += 1;
		return n;
	}
}