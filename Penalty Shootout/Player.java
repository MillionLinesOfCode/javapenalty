import java.util.*;

public class Player {
	// Instance Variables that represent the characteristics of the player that the user controls
	private String name; 
	private String nationality;
	private int playerScore = 0; //Default score that a player starts with

	// Constructors
	public Player() {
		setName("C.Ronaldo"); 
		setNationality("Portugal");
		setPlayerScore(0);
	}
	public Player(String name, String nationality) {
		setName(name);
		setNationality(nationality);
		setPlayerScore(0);
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
		if(playerScore>0){ //To make sure the players score is valid since the score cannot decrease 
			this.playerScore += playerScore;
		}
	}
}
