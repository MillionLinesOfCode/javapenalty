import java.awt.Rectangle;
import java.util.*;
/**
 *
 * <b>@author Reeyan.mak</b>
 */
/*
*This is the file for the player that the user controls
*The user can choose the players name 
*/
public class Avatar{
    // These are the private instance variables
    private String name;
    private String nationality;
    private Rectangle location;
    private int goalsScored;
    private int goalsMissed;
    //Constructor
    public Avatar(String name, String nationality, Rectangle location, int goalsScored, int goalsMissed){
        this.name = name;
        this.nationality = nationality;
        location = new Rectangle(0, 0, 0, 0);
        goalsScored= 0;
        goalsMissed = 0;
    }
    //Default Constructor
    public Avatar(){
        name = "C.Ronaldo"; //It had to be him 
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
    //getter method for the players name
    public String getName() {
        return name;
    }
    //Other methods
    //This method returns true if the avatar takes a shot(first step!)
    public boolean kickFootball(Football football){
        return true;
    }
    //GUI
    public int processAvatarShot() {
        return 0;
    }    
    //This method updates the number of goals scored by the player each time he takes a shot
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
