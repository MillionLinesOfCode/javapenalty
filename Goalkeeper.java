import java.awt.Rectangle;
import java.util.Random;
        
public class Goalkeeper{
    // These are the private instance variables:
    private String name; // The name of the goalkeeper which will be picked by the player from a limited
                         // number of choices
    private String nationality; // Of the goalkeeper, again chosen by the player
    private Rectangle location; // Of the goalkeeper, which should be in the goalpost!
    /**
     * @return the nationality
     */
    //Getter and setter methods
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality the nationality to set
     */
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    //Methods
    //This method generates a random number for the keeper to dive in a random direction
    public int processGoalkeeperSave() {
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