import java.awt.Rectangle;

public class Goal{
    // Private instance variable:
    private Rectangle location; //Self documenting B-)
    /*
     *  The net of the goalpost.
     *  This method essentially compares the location of the ball which is shot by the player to the location of the net.
    */
    //Methods
    //This method returns true if the player scores a goal i.e. if the location of the goal and the ball is same.
    public Boolean hasTheBall(Football football){
        return (football.getLocation() == location);
    }
    //This method returns the location of the goal
    public Rectangle getLocation(){
        return location;
    }
}
