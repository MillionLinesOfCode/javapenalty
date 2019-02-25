
import java.awt.Rectangle;

public class Goalpost {
    //Private instance variables
    private Rectangle location;

    //setter method
    public void setLocation(Rectangle location) {
        this.location = location;
    }
    //Constructor
    public Goalpost(Rectangle location) {
        location = new Rectangle(0, 0, 0, 0);
    }
    //Methods
    //This method returns the location of the goalpost
    public Rectangle getLocation() {
        return location;
    }
}
