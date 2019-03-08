import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import static javafx.application.Platform.exit;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.text.Font;

/*
This is the AnimationApp class, which controls the entire application. 
1. Interact with the human player to ask it for a move.
2. Move the avatar as specified
3. Check if any obstacles are hit.  If so react appropriately.
4. Check if any collectibles have been reached.  If so, react appropriately.
5. Move any collectibles that are movable.

*/
public class AnimationApp extends Application{
	// These are the private instance variables:
	private Avatar avatar = new Avatar();
	private Goalkeeper goalkeeper = new Goalkeeper();
	private ArrayList<Football> football = new ArrayList<Football>();
	private ArrayList<Goal> goal = new ArrayList<Goal>();
	private ArrayList<Goalpost> goalpost = new ArrayList<Goalpost>();
        
	// Methods
	public void displayAvatarShot() {
		//GUI
	// It asks the human for input and then shows the animation as per input
	}
	
	public void displayGoalkeeperSave() {
		//GUI
	// Based on the Goalkeeper's random decision to dive, it will dive at one side regardless of the player shooting the ball.
	// If the keeper dives at the same side as the ball was kicked, it won't let the ball get inside the post.
	}
	
	public int printCurrentScore() {
	// From the arraylist maintained for score it will take the number of goals and print the result .
		return goal.size();
	}
	public static void processGoalkeeperSave(int shotInput, Goalkeeper goalkeeper) {
            
            if (shotInput == goalkeeper.randomGoalkeeperGuess() && shotInput < 7 && shotInput > 0) {
                System.out.println("Hard luck! Your shot was saved by the keeper");
            }
            else { 
                System.out.println("Amazing! You scored a goal!");
            }
        }
        public static boolean processHitThePost(int shotPower) {
            switch (shotPower) {
                case 9:
                    {
                        Random rand = new Random();
                        int randomPost9 = rand.nextInt(3);
                        randomPost9 += 1;
                        if (randomPost9 == 1) {
                            System.out.println("You hit the post! Hard Luck!");
                            return true;
                        }       break;
                    }
                case 8:
                    {
                        Random rand = new Random();
                        int randomPost8 = rand.nextInt(6);
                        randomPost8 += 1;
                        if (randomPost8 == 1) {
                            System.out.println("You hit the post! Hard Luck!");
                            return true;
                        }       break;
                    }
                case 7:
                    {
                        Random rand = new Random();
                        int randomPost7 = rand.nextInt(12);
                        randomPost7 += 1;
                        if (randomPost7 == 1) {
                            System.out.println("You hit the post! Hard Luck!");
                            return true;
                        }       break;
                    }
                case 6:
                    {
                        Random rand = new Random();
                        int randomPost6 = rand.nextInt(20);
                        randomPost6 += 1;
                        if (randomPost6 == 1) {
                            System.out.println("You hit the post! Hard Luck!");
                            return true;
                        }       break;
                    }
                case 5:
                    {
                        Random rand = new Random();
                        int randomPost5 = rand.nextInt(15);
                        randomPost5 += 1;
                        if (randomPost5 == 1) {
                            System.out.println("You hit the post! Hard Luck!");
                            return true;
                        }       break;
                    }
                case 4:
                    {
                        Random rand = new Random();
                        int randomPost4 = rand.nextInt(10);
                        randomPost4 += 1;
                        if (randomPost4 == 1) {
                            System.out.println("You hit the post! Hard Luck!");
                            return true;
                        }       break;
                    }
                case 3:
                    {
                        Random rand = new Random();
                        int randomPost3 = rand.nextInt(6);
                        randomPost3 += 1;
                        if (randomPost3 == 1) {
                            System.out.println("You hit the post! Hard Luck!");
                            return true;
                        }       break;
                    }
                case 2:
                    {
                        Random rand = new Random();
                        int randomPost2 = rand.nextInt(6);
                        randomPost2 += 1;
                        if (randomPost2 == 1) {
                            System.out.println("You hit the post! Hard Luck!");
                            return true;
                        }       break;
                    }
                case 1:
                    {
                        Random rand = new Random();
                        int randomPost1 = rand.nextInt(2);
                        randomPost1 += 1;
                        if (randomPost1 == 1) {
                            System.out.println("You hit the post! Hard Luck!");
                            return true;
                        }       break;
                    }
                default:
                    return false;       
            }
            if (shotPower < 0 || shotPower > 9);
                    return false;   
        }
            
	public void drawCurrentScore() {
		//GUI
	// Draws the score on the screen, from the above function "printCurrentScore()"
	}
	
	public void performAvatarCelebration() {
		//GUI
	// Depending on the output of the situation, avatar will accordingly perform a celebration.
	}
	
	public void performGoalkeeperCelebration() {
		//GUI
	// Depending on the output of the situation, Goalkeeper will accordingly perform a celebration.
	}

        public static void main(String[] args) {
               {
      launch(args);
   }
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
                    Avatar ronaldo = new Avatar("C.Ronaldo", "Portugal");
                    System.out.println("Great! You chose " + ronaldo.getName());
                    break;
                case 2:
		    Avatar messi = new Avatar("L.Messi", "Argentina");
                    System.out.println("Great! You chose " + messi.getName());
                    break;
                case 3:
		    Avatar pogba = new Avatar("P.Pogba", "France");
		    System.out.println("Great! You chose " + pogba.getName());
                    break;
                case 4:
		    Avatar neymar = new Avatar("Neymar", "Brazil");
		    System.out.println("Great! You chose " + neymar.getName());
                    break;
                case 5:
		    Avatar hazard = new Avatar("E.Hazard", "Belgium");
		    System.out.println("Great! You chose " + hazard.getName());
                    break;
                default:
		    Avatar defaultPlayer = new Avatar("C.Ronaldo", "Portugal");
		    System.out.println("Your default player is " + defaultPlayer.getName());
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
		    Goalkeeper gea = new Goalkeeper("D.de Gea", "Spain");
                    System.out.println("Cool! You chose " + gea.getName());
                    break;
                case 2:
		    Goalkeeper oblak = new Goalkeeper("J.Oblak", "Slovenia");
                    System.out.println("Cool! You chose " + oblak.getName());
                    break;
                case 3:
		    Goalkeeper stegen = new Goalkeeper("M.ter Stegen", "Germany");
                    System.out.println("Cool! You chose " + stegen.getName());
                    break;
                case 4:
		    Goalkeeper courtois = new Goalkeeper("T.Courtois", "Belgium");
                    System.out.println("Cool! You chose " + courtois.getName());
                    break;
                case 5:
		    Goalkeeper neuer = new Goalkeeper("M.Neuer", "Germany");
                    System.out.println("Cool! You chose " + neuer.getName());
                    break;
                default:
		    Goalkeeper defaultKeeper = new Goalkeeper("D.de Gea", "Spain");
                    System.out.println("Your default keeper is " + defaultKeeper.getName());
                    break;
            }
            //Ask the user for input in order to take the shot
            System.out.println("Choose a number to take a shot \n" +
                               " ____________________________  \n" +
                               "|         |        |         | \n" +
                               "|    1    |   2    |    3    | \n" +
                               "|_________|________|_________| \n" +
                               "|         |        |         | \n" +
                               "|    4    |   5    |    6    | \n" +
                               "|_________|________|_________| \n");
            
            for (int i = 0; i < 5; i++) {
                System.out.println("Please enter a number to choose the direction to shoot the ball");
                int shotInput = sc.nextInt();

                while (shotInput < 1 || shotInput > 6){
                    System.out.println("Error! Please enter a valid number");
                    shotInput = sc.nextInt();
                }
                System.out.println("Please enter your a value for your shot power between 1-9,"
                    + " 9 is the highest");
                int shotPower = sc.nextInt();
                while (shotPower < 1 || shotPower > 9) {
                    System.out.println("Error! Please enter a valid number");
                    shotPower = sc.nextInt();
                }
                Goalkeeper goalkeeper = new Goalkeeper("D.de Gea", "Spain");
                if (processHitThePost(shotPower) == false) {
                    processGoalkeeperSave(shotInput, goalkeeper);
                }    
            }
            System.out.println("Game over!");
        }

	//public static void main(String[] args)

	@Override
	public void start(Stage primaryStage) throws Exception {
                
		Image bgImg = new Image("file:Background.jpg");
		ImageView mv = new ImageView(bgImg);
		mv.setFitWidth(700);
		mv.setFitHeight(500);
		Group bg = new Group();
		bg.getChildren().addAll(mv);
		BorderPane root = new BorderPane();
		HBox topLabel = new HBox();
		HBox centreLabel = new HBox();
		Label label1 = new Label("Welcome to the Penalty Shooutout Game!");
		Label label2 = new Label("Enter your Name: ");
		label1.setFont(Font.font("Times New Roman", 24));
		label1.setStyle("-fx-font-weight: bold");
		//label1.setFill(Color.WHITE);
		label2.setFont(Font.font("Castellar", 24));
		label2.setStyle("-fx-font-weight: bold");
		TextField name = new TextField("name");
		topLabel.getChildren().add(label1);
		centreLabel.getChildren().add(label2);
		centreLabel.getChildren().add(name);
		Button doneButton = new Button("Done");
		centreLabel.getChildren().add(doneButton);
                
                Canvas canvas = new Canvas( 512, 512 );
                root.getChildren().add( canvas );
		GraphicsContext gc = canvas.getGraphicsContext2D();
                
		topLabel.setAlignment(Pos.CENTER);
		centreLabel.setAlignment(Pos.CENTER);
		root.getChildren().add(bg);
		
		root.setTop(topLabel);
		root.setCenter(centreLabel);

		Scene scene = new Scene(root, 700, 500);
		primaryStage.setTitle("Penalty Shootout Game");
		primaryStage.setScene(scene);
		primaryStage.show();
                
                /*
                 {
        primaryStage.setTitle( "AnimationTimer Example" );

        Group root = new Group();
        Scene theScene = new Scene( root );
        primaryStage.setScene( theScene );

        Canvas canvas = new Canvas( 1000, 1000 );
        root.getChildren().add( canvas );

        GraphicsContext gc = canvas.getGraphicsContext2D();

        Image space = new Image( "DeGeaSave1.png" );
        Image heya = new Image( "DeGeaSave1.png" );
        Image beya = new Image( "DeGeaSave1.png" );
        
        final long startNanoTime = System.nanoTime();

        new AnimationTimer()
        {
            public void handle(long currentNanoTime)
            {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0; 

                double x = 232 + 128 * Math.cos(t);
                double y = 232 + 128 * Math.sin(t);

                // Clear the canvas
                gc.clearRect(0, 0, 512,512);

                // background image clears canvas
                gc.drawImage( space, 0, 0 );
                gc.drawImage( heya, x, y );
                gc.drawImage( beya, 196, 196 );
            }
        }.start();

        primaryStage.show();
        */
    }
}
		

