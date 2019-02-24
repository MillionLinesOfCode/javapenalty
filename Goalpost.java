
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Reeyan.mak
 */
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
