/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package penaltyshootoutgame;

import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author Reeyan.mak
 */
public class Avatar{
    private String name;
    private String nationality;
    private Rectangle location;
    private int goalsScored;
    private int goalsMissed;
    
    public Avatar(String name, String nationality, Rectangle location, int goalsScored, int goalsMissed){
        name = "C.Ronaldo";
        nationality = "Portugal";
        location = new Rectangle(0, 0, 0, 0);
        goalsScored= 0;
        goalsMissed = 0;
    }
    public boolean kicksTheFootball(Football football){
        return true;
    }
    public int updateGoalsScored(int change){
        return 0;
    }
    public int updateGoalsMissed(int change){
        return 0;
    }
    public Rectangle getLocation() {
        return location;
    }
    
}
