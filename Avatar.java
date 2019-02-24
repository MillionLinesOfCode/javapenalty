
import java.awt.Rectangle;

/**
 *
 * @author Reeyan.mak
 */
public class Avatar{
    // These are the private instance variables:
    private String name;
    private String nationality;
    private Rectangle location;
    private int goalsScored;
    private int goalsMissed;
    //Constructor
    public Avatar(String name, String nationality, Rectangle location, int goalsScored, int goalsMissed){
        name = "C.Ronaldo";
        nationality = "Portugal";
        location = new Rectangle(0, 0, 0, 0);
        goalsScored= 0;
        goalsMissed = 0;
    }
    //Constructor
    public Avatar(){
        name = "C.Ronaldo";
        nationality = "Portugal";
        location = new Rectangle(0, 0, 0, 0);
        goalsScored= 0;
        goalsMissed = 0;
    }
    public Avatar(String name, String nationality){
        this.name = name;
        this.nationality = nationality;
        location = new Rectangle(0, 0, 0, 0);
        goalsScored= 0;
        goalsMissed = 0;
    }
    //getter
    public String getName() {
        return name;
    }
    //Methods
    //This methods returns true if the avatar takes a shot
    public boolean kickFootball(Football football){
        return true;
    }
    public int processAvatarShot() {
        return 0;
    }    
    //This method updates the number of goals scored by the player
    public int updateGoalsScored(int change){
        return 0;
    }
    //This method updates the number of goals missed by the player
    public int updateGoalsMissed(int change){
        return 0;
    }
    //This method returns the location of the Avatar
    public Rectangle getLocation() {
        return location;
    }
    
}
