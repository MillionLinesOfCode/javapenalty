import java.util.ArrayList;
import java.util.Scanner;

/*
This is the AnimationApp class, where it  controls the entire application. 
1. Interact with the human player to ask it for a move.
2. Move the avatar as specified
3. Check if any obstacles are hit.  If so react appropriately.
4. Check if any collectibles have been reached.  If so, react appropriately.
5. Move any collectibles that are movable.

*/
public class AnimationApp{
	// These are the private instance variables:
	private Avatar avatar = new Avatar();
	private Goalkeeper goalkeeper = new Goalkeeper();
	private ArrayList<Football> football = new ArrayList<Football>();
	private ArrayList<Goal> goal = new ArrayList<Goal>();
	private ArrayList<Goalpost> goalpost = new ArrayList<Goalpost>();
        
	// Methods
	public void displayAvatarShot() {
	// It asks the human for input and then shows the animation as per input
	}
	
	public void displayGoalkeeperSave() {
	// Based on the Goalkeeper's random decision to dive, it will dive at one side regardless of the player shooting the ball.
	// If the keeper dives at the same side as the ball was kicked, it won't let the ball get inside the post.
	}
	
	public int printCurrentScore() {
	// From the arraylist maintained for score it will take the number of goals and print.
		return goal.size();
	}
	
	public void drawCurrentScore() {
	// Draws the score on the screen, from the above function "printCurrentScore()"
	}
	
	public void performAvatarCelebration() {
	// Depending on the output of the situation, avatar will accordingly perform a celebration.
	}
	
	public void performGoalkeeperCelebration() {
	// Depending on the output of the situation, Goalkeeper will accordingly perform a celebration.
	}
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome to the Penalty Shooutout Game!");
            System.out.println("Enter your name: ");
            String userInput = sc.nextLine();
            System.out.println("Hello" + ", " + userInput + "!");
            System.out.println("Choose your favorite player to take the penalties");
            System.out.println("1- C.Ronaldo");
            System.out.println("2- L.Messi");
            System.out.println("3- P.Pogba");
            System.out.println("4- Neymar");
            System.out.println("5- E.Hazard");
            int playerOption = sc.nextInt();
            switch (playerOption) {
                case 1:
                    Avatar avatar = new Avatar("C.Ronaldo", "Portugal");
                    System.out.println("Great! You chose " + avatar.getName());
                    break;
                case 2:
		    Avatar avatar = new Avatar("L.Messi", "Argentina");
                    System.out.println("Great! You chose " + avatar.getName());
                    break;
                case 3:
		    Avatar avatar = new Avatar("P.Pogba", "France");
		    System.out.println("Great! You chose " + avatar.getName());
                    break;
                case 4:
		    Avatar avatar = new Avatar("Neymar", "Brazil");
		    System.out.println("Great! You chose " + avatar.getName());
                    break;
                case 5:
		    Avatar avatar = new Avatar("E.Hazard", "Belgium");
		    System.out.println("Great! You chose " + avatar.getName());
                    break;
                default:
		    Avatar avatar = new Avatar("C.Ronaldo", "Portugal");
		    System.out.println("Great! You chose " + avatar.getName());
                    break;
            }
            System.out.println("Choose your favorite goalkeeper to save the penalties");
            System.out.println("1- D.de Gea");
            System.out.println("2- J.Oblak");
            System.out.println("3- M.ter Stegen");
            System.out.println("4- T.Courtois");
            System.out.println("5- M.Neuer");
            int goalkeeperOption = sc.nextInt();
            switch (goalkeeperOption) {
                case 1:
		    Goalkeeper goalkeeper = new Goalkeeper("D.de Gea", "Spain");
                    System.out.println("Cool! You chose " + goalkeeper.getName());
                    break;
                case 2:
		    Goalkeeper goalkeeper = new Goalkeeper("J.Oblak", "Slovenia");
                    System.out.println("Cool! You chose " + goalkeeper.getName());
                    break;
                case 3:
		    Goalkeeper goalkeeper = new Goalkeeper("M.ter Stegen", "Germany");
                    System.out.println("Cool! You chose " + goalkeeper.getName());
                    break;
                case 4:
		    Goalkeeper goalkeeper = new Goalkeeper("T.Courtois", "Belgium");
                    System.out.println("Cool! You chose " + goalkeeper.getName());
                    break;
                case 5:
		    Goalkeeper goalkeeper = new Goalkeeper("M.Neuer", "Germany");
                    System.out.println("Cool! You chose " + goalkeeper.getName());
                    break;
                default:
		    Goalkeeper goalkeeper = new Goalkeeper("D.de Gea", "Spain");
                    System.out.println("Cool! You chose " + goalkeeper.getName());
                    break;
            }
            //Ask the user for input in order to take the shot
            System.out.println("Choose a number to take a shot");
            System.out.println(" ____________________________");
            System.out.println("|         |        |         |");
            System.out.println("|    1    |   2    |    3    |");
            System.out.println("|_________|________|_________|");
            System.out.println("|         |        |         |");
            System.out.println("|    4    |   5    |    6    |");
            System.out.println("|_________|________|_________|");
        }
}
