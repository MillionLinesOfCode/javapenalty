import java.util.Random;

public class Goalkeeper {
	// Instance Variables
	private String name;
	private String nationality;
	private int goalkeeperScore = 0;

	// Constructors
	public Goalkeeper() {
		setName("D.de Gea");
		setNationality("Spain");
		setGoalkeeperScore(0);
	}

	public Goalkeeper(String name, String nationality) {
		setName(name);
		setNationality(nationality);
		setGoalkeeperScore(0);
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
		if(goalkeeperScore>0){
			this.goalkeeperScore += goalkeeperScore;
		}
	}

	// Methods
	public int randGoalkeeperNum() {
		Random rand = new Random();
		int n = rand.nextInt(6);
		n += 1;
		return n;
	}
}
