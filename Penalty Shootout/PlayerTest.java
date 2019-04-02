import static org.junit.Assert.*;
import org.junit.Test;

/*
  This file is used to test the Player.java file and check if
  it runs as intended(using JUnit).
  Test names indicate nature of test.
  */

public class PlayerTest{
    @Test
    public void test_creation_defaultConstructor(){
        Player s = new Player();
        assertEquals("Expected initial player score to be 0", 0, s.getPlayerScore());
    }
    @Test
    public void test_getter(){
        Player p = new Player("Jack Daniels","Murica");
        assertEquals("Expected player name to be Jack Daniels.", "Jack Daniels", p.getName());
        assertEquals("Expected player nationality to be Murica", "Murica", p.getNationality());
    }
    @Test
    public void test_setter(){
        Player s = new Player();
        s.setName("Snoop");
        s.setNationality("Weednation");
        assertEquals("Expected player name to be Snoop.", "Snoop", s.getName());
        assertEquals("Expected player score to be Weednation", "Weednation", s.getNationality());
    }
    @Test
    public void test_invalidPlayerScore(){
        Player p = new Player("Fisher","Canada"); //Coincidence.....
        p.setPlayerScore(-9); //Cant do that now, can we?
        assertEquals("Expected initial player score to be 0", 0, p.getPlayerScore());
    }
    @Test
    public void test_setPlayerScore_valid(){
        Player p = new Player();
        p.setPlayerScore(69);
        int result = p.getPlayerScore();
        assertEquals("Set playerScore to 69.", 69, result);
    }
    @Test
    public void test_getter_and_setter_and_invalidPScore(){
        Player p = new Player("You","Earth");
        p.setPlayerScore(-1);
        assertEquals("Expected player name to be You", "You", p.getName());
        assertEquals("Expected player nationality to be Earth", "Earth", p.getNationality());
        assertEquals("Set playerScore to -1(invalid).Should be set to default value of 0.",0,p.getPlayerScore());
    }
}
