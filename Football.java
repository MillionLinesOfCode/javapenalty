import java.awt.Rectangle;
import java.util.*;
/**
	This is the class for the football
	It has methods that check the outcome of the shot and respond appropriately
*/
public class Football {
	// Instance Variables for the football(factors that affect the outcome)
	private Rectangle location;
    private int speed;
    private int direction;
	// Constructors
	public Football(Rectangle location, int speed, int direction){
        location = new Rectangle(0, 0, 0, 0);
        this.speed= speed;
        this.direction =direction;
    }
    public Football(){
        location = new Rectangle(0, 0, 0, 0);
        speed=0;
        direction=0;
    }
    // This method will return the location of the football
    public Rectangle getLocation() {
        return location;
	}		
	// Other methods
	// This method checks if the ball hit the goalpost or not
	public boolean hitsGoalpost(Goalpost goalpost){
            return (location == goalpost.getLocation());
        }
	//This method checks if the goal was saved by the goalkeeper
	public boolean SavedByGoalkeeper(Goalkeeper goalkeeper){
            return (location == goalkeeper.getLocation());
    }
    
    // This method checks if the shot was on target(Any shot attempt that would or does enter the goal if left unblocked)
	public boolean onTarget(Goal goal) {
            return (location == goal.getLocation()); 
	}
    // This method checks if the shot was off target, this means that the shot was never going inside the goal
	public boolean offTarget(Goal goal) {
            return (location != goal.getLocation());
	}
}
