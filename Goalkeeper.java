import java.awt.Rectangle;
import java.util.Random;
        
public class Goalkeeper{
    // These are the private instance variables:
    private String name; // The name of the goalkeeper which will be picked by the player
    private String nationality; // of the goalkeeper, again chosen by the player
    private Rectangle location; // of the goalkeeper, which should be in the goalpost!
    
    //Constructors
    public Goalkeeper(String name, String nationality){
        this.name = name;
        this.nationality = nationality;
    }
    public Goalkeeper(){
        name = "D.de Gea";
        nationality = "Spain";
        location = new Rectangle(0, 0, 0, 0);
    }
    //Getter and setter methods
    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    //Methods
    //This method generates a random number for the keeper to dive in a random direction
    public int randomGoalkeeperGuess() {
        Random rand = new Random();
        int randomSave = rand.nextInt(6);
        randomSave += 1;
        return randomSave;
    }
    //This method returns true if the goalkeeper saves a shot
    public Boolean saveShot() {
        return true;
    }
    //This method returns true if the goalkeeper conceded a goal
    public Boolean concedesGoal() {
        return true;
    }
    //This method returns the location of the goalkeeper
    public Rectangle getLocation(){
        return location;
    }
}
