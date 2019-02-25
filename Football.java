
import java.awt.Rectangle;

/**
	This is a class for the football
	It has methods that check the outcome of the shot
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
            return (location == goalpost.getLocation());
        }
	//This method checks if the goal was saved by the goal keeper
        public boolean SavedByGoalkeeper(Goalkeeper goalkeeper){
            return (location == goalkeeper.getLocation());
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
