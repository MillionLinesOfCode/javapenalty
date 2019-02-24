
import java.awt.Rectangle;

/**
	This is a class for the ball
	It has methods that check the outcome of the shoot
*/

public class Football {
	// Instance Variables
	private Rectangle location;
        private int speed;
        private int direction;
	// Constructors
	public Football(Rectangle location){
		location = new Rectangle(0, 0, 0, 0);
	}

	// Methods
	// This method checks if the ball hit the goalpost or not
	public boolean hitsGoalpost(Goalpost goalpost){
            if (location == goalpost.getLocation()) {
		return true;
            }    
            else if (location != goalpost.getLocation());
                return false;
	}
	//This method checks if the goal was saved by the goal keeper
	public boolean SavedByGoalkeeper(Goalkeeper goalkeeper){
            if (location == goalkeeper.getLocation()) {
		return true;
            }    
            else if (location != goalkeeper.getLocation());
                return false;
	}
        // This method checks if the shot was on target
	public boolean onTarget(Goal goal) {
            return (location == goal.getLocation()); 
	}
        // This method checks if the shot was off target
	public boolean offTarget(Goal goal) {
            return (location != goal.getLocation());
	}
        // This method will return the location of the football
        public Rectangle getLocation() {
            return location;
	}

}
