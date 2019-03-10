import java.util.Scanner;
import java.util.Stack;

import javax.swing.GroupLayout.Group;



import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;
import javafx.geometry.VPos;

import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import com.sun.javafx.css.converters.URLConverter;



public class AnimationApp extends Application implements EventHandler<ActionEvent>{
	// Instance Variables
	private Stage window;
	private Scene sceneStartMenue, scenePlayerSelection, sceneGoalkeeperSelection, sceneCheckGameStart, sceneGameStart, sceneAfterShot, sceneFinalScreen;

	private Label lblWelcomePlayer;
	private TextField tfName;
	private Label lblChosenPlayer;
	private Label lblChosenGoalkeeper;
	private Label lblShotNum;
	private Label lblShotsMade;
	private Label lblShotsMissed;
	private Label lblShotCondition;
	private Label lblFinalResult;
	private Player player = new Player();
	private Goalkeeper goalkeeper = new Goalkeeper();

	int shotNumCounter = 1;



	// Main Method
	public static void main(String[] args) {
		launch(args);
	}



	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() instanceof Button) {
			Button btnClicked = (Button) event.getSource();

			// Opeing Window
			if (btnClicked.getText().equals("Enter")) {
				String enteredPlayerName = tfName.getText();
				lblWelcomePlayer.setText("Welcome " + enteredPlayerName + "!");
				window.setScene(scenePlayerSelection);

			// Player Selection
			} else if (btnClicked.getText().equals("C.Ronaldo")) {
				window.setScene(sceneGoalkeeperSelection);
			} else if (btnClicked.getText().equals("L.Messi")) {
				player.setName("L.Messi");
        		player.setNationality("Argentina");
				window.setScene(sceneGoalkeeperSelection);
			} else if (btnClicked.getText().equals("P.Pogba")) {
				player.setName("P.Pogba");
        		player.setNationality("France");
				window.setScene(sceneGoalkeeperSelection);
			} else if (btnClicked.getText().equals("Neymar")) {
				player.setName("Neymar");
        		player.setNationality("Brazil");
				window.setScene(sceneGoalkeeperSelection);
			} else if (btnClicked.getText().equals("E.Hazard")) {
				player.setName("E.Hazard");
        		player.setNationality("Belgium");
				window.setScene(sceneGoalkeeperSelection);
				
			// Goalkeeper Selection
			} if (btnClicked.getText().equals("D.de Gea")) {
				lblChosenPlayer.setText("The player you chose is " + player.getName() + ".");
				lblChosenGoalkeeper.setText("The goalkeeper you chose is " + goalkeeper.getName() + ".");
				window.setScene(sceneCheckGameStart);
			} else if (btnClicked.getText().equals("J.Oblak")) {
				goalkeeper.setName("J.Oblak");
        		goalkeeper.setNationality("Slovenia");
				lblChosenPlayer.setText("The player you chose is " + player.getName() + ".");
				lblChosenGoalkeeper.setText("The goalkeeper you chose is " + goalkeeper.getName() + ".");
				window.setScene(sceneCheckGameStart);
			} else if (btnClicked.getText().equals("M.ter Stegen")) {
				goalkeeper.setName("M.ter Stegen");
        		goalkeeper.setNationality("Germany");
				lblChosenPlayer.setText("The player you chose is " + player.getName() + ".");
				lblChosenGoalkeeper.setText("The goalkeeper you chose is " + goalkeeper.getName() + ".");
				window.setScene(sceneCheckGameStart);
			} else if (btnClicked.getText().equals("T.Courtois")) {
				goalkeeper.setName("T.Courtois");
        		goalkeeper.setNationality("Belgium");
				lblChosenPlayer.setText("The player you chose is " + player.getName() + ".");
				lblChosenGoalkeeper.setText("The goalkeeper you chose is " + goalkeeper.getName() + ".");
				window.setScene(sceneCheckGameStart);
			} else if (btnClicked.getText().equals("M.Neuer")) {
				goalkeeper.setName("M.Neuer");
        		goalkeeper.setNationality("Germany");
				lblChosenPlayer.setText("The player you chose is " + player.getName() + ".");
				lblChosenGoalkeeper.setText("The goalkeeper you chose is " + goalkeeper.getName() + ".");
				window.setScene(sceneCheckGameStart);

			// Game Start
			} else if (btnClicked.getText().equals("Start Game")) {
				window.setScene(sceneGameStart);
			} else if (btnClicked.getText().equals("1")) {
				int goalkeeperNum = goalkeeper.randGoalkeeperNum();
	            int playerStrength = player.randStrength();
	            if (btnClicked.getText().equals(goalkeeperNum + "") && (playerStrength <= 74 || playerStrength >= 80)) {
	           		lblShotCondition.setText("Shot was saved by the goalkeeper. Shot Missed.");
	           		goalkeeper.setGoalkeeperScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") && (playerStrength >= 75 && playerStrength <= 79)) {
	           		lblShotCondition.setText("Shot overpowered the goalkeeper. Goal!");
	           		player.setPlayerScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 60 && playerStrength <= 79)) {
	           		lblShotCondition.setText("Goal!!");
	           		player.setPlayerScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 1 && playerStrength <= 59)) {
	           		Random rand = new Random();
					int n = rand.nextInt(2);
					if (n == 1) {
						lblShotCondition.setText("The shot was too weak. Shot Missed.");
						goalkeeper.setGoalkeeperScore(1);
						shotNumCounter ++;
						window.setScene(sceneAfterShot);
					} else {
						lblShotCondition.setText("Goal!!");
						player.setPlayerScore(1);
						shotNumCounter ++;
						window.setScene(sceneAfterShot);
					}
	            } else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 80 && playerStrength <= 89)) {
	            	lblShotCondition.setText("The ball hit the post. Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            } else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 90 && playerStrength <= 100)) {
	            	lblShotCondition.setText("The shot was too strong and went outside the goal. Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            } else {
	            	lblShotCondition.setText("Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            }
			} else if (btnClicked.getText().equals("2")) {
				int goalkeeperNum = goalkeeper.randGoalkeeperNum();
	            int playerStrength = player.randStrength();
	            if (btnClicked.getText().equals(goalkeeperNum + "") && (playerStrength <= 74 || playerStrength >= 80)) {
	           		lblShotCondition.setText("Shot was saved by the goalkeeper. Shot Missed.");
	           		goalkeeper.setGoalkeeperScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") && (playerStrength >= 75 && playerStrength <= 79)) {
	           		lblShotCondition.setText("Shot overpowered the goalkeeper. Goal!");
	           		player.setPlayerScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 60 && playerStrength <= 79)) {
	           		lblShotCondition.setText("Goal!!");
	           		player.setPlayerScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 1 && playerStrength <= 59)) {
	           		Random rand = new Random();
					int n = rand.nextInt(2);
					if (n == 1) {
						lblShotCondition.setText("The shot was too weak. Shot Missed.");
						goalkeeper.setGoalkeeperScore(1);
						shotNumCounter ++;
						window.setScene(sceneAfterShot);
					} else {
						lblShotCondition.setText("Goal!!");
						player.setPlayerScore(1);
						shotNumCounter ++;
						window.setScene(sceneAfterShot);
					}
	            } else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 80 && playerStrength <= 89)) {
	            	lblShotCondition.setText("The ball hit the post. Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            } else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 90 && playerStrength <= 100)) {
	            	lblShotCondition.setText("The shot was too strong and went outside the goal. Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            } else {
	            	lblShotCondition.setText("Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            }
			} else if (btnClicked.getText().equals("3")) {
				int goalkeeperNum = goalkeeper.randGoalkeeperNum();
	            int playerStrength = player.randStrength();
	            if (btnClicked.getText().equals(goalkeeperNum + "") && (playerStrength <= 74 || playerStrength >= 80)) {
	           		lblShotCondition.setText("Shot was saved by the goalkeeper. Shot Missed.");
	           		goalkeeper.setGoalkeeperScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") && (playerStrength >= 75 && playerStrength <= 79)) {
	           		lblShotCondition.setText("Shot overpowered the goalkeeper. Goal!");
	           		player.setPlayerScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 60 && playerStrength <= 79)) {
	           		lblShotCondition.setText("Goal!!");
	           		player.setPlayerScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 1 && playerStrength <= 59)) {
	           		Random rand = new Random();
					int n = rand.nextInt(2);
					if (n == 1) {
						lblShotCondition.setText("The shot was too weak. Shot Missed.");
						goalkeeper.setGoalkeeperScore(1);
						shotNumCounter ++;
						window.setScene(sceneAfterShot);
					} else {
						lblShotCondition.setText("Goal!!");
						player.setPlayerScore(1);
						shotNumCounter ++;
						window.setScene(sceneAfterShot);
					}
	            } else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 80 && playerStrength <= 89)) {
	            	lblShotCondition.setText("The ball hit the post. Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            } else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 90 && playerStrength <= 100)) {
	            	lblShotCondition.setText("The shot was too strong and went outside the goal. Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            } else {
	            	lblShotCondition.setText("Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            }
			} else if (btnClicked.getText().equals("4")) {
				int goalkeeperNum = goalkeeper.randGoalkeeperNum();
	            int playerStrength = player.randStrength();
	            if (btnClicked.getText().equals(goalkeeperNum + "") && (playerStrength <= 74 || playerStrength >= 80)) {
	           		lblShotCondition.setText("Shot was saved by the goalkeeper. Shot Missed.");
	           		goalkeeper.setGoalkeeperScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") && (playerStrength >= 75 && playerStrength <= 79)) {
	           		lblShotCondition.setText("Shot overpowered the goalkeeper. Goal!");
	           		player.setPlayerScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 60 && playerStrength <= 79)) {
	           		lblShotCondition.setText("Goal!!");
	           		player.setPlayerScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 1 && playerStrength <= 59)) {
	           		Random rand = new Random();
					int n = rand.nextInt(2);
					if (n == 1) {
						lblShotCondition.setText("The shot was too weak. Shot Missed.");
						goalkeeper.setGoalkeeperScore(1);
						shotNumCounter ++;
						window.setScene(sceneAfterShot);
					} else {
						lblShotCondition.setText("Goal!!");
						player.setPlayerScore(1);
						shotNumCounter ++;
						window.setScene(sceneAfterShot);
					}
	            } else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 80 && playerStrength <= 89)) {
	            	lblShotCondition.setText("The ball hit the post. Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            } else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 90 && playerStrength <= 100)) {
	            	lblShotCondition.setText("The shot was too strong and went outside the goal. Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            } else {
	            	lblShotCondition.setText("Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            }
			} else if (btnClicked.getText().equals("5")) {
				int goalkeeperNum = goalkeeper.randGoalkeeperNum();
	            int playerStrength = player.randStrength();
	            if (btnClicked.getText().equals(goalkeeperNum + "") && (playerStrength <= 74 || playerStrength >= 80)) {
	           		lblShotCondition.setText("Shot was saved by the goalkeeper. Shot Missed.");
	           		goalkeeper.setGoalkeeperScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") && (playerStrength >= 75 && playerStrength <= 79)) {
	           		lblShotCondition.setText("Shot overpowered the goalkeeper. Goal!");
	           		player.setPlayerScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 60 && playerStrength <= 79)) {
	           		lblShotCondition.setText("Goal!!");
	           		player.setPlayerScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 1 && playerStrength <= 59)) {
	           		Random rand = new Random();
					int n = rand.nextInt(2);
					if (n == 1) {
						lblShotCondition.setText("The shot was too weak. Shot Missed.");
						goalkeeper.setGoalkeeperScore(1);
						shotNumCounter ++;
						window.setScene(sceneAfterShot);
					} else {
						lblShotCondition.setText("Goal!!");
						player.setPlayerScore(1);
						shotNumCounter ++;
						window.setScene(sceneAfterShot);
					}
	            } else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 80 && playerStrength <= 89)) {
	            	lblShotCondition.setText("The ball hit the post. Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            } else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 90 && playerStrength <= 100)) {
	            	lblShotCondition.setText("The shot was too strong and went outside the goal. Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            } else {
	            	lblShotCondition.setText("Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            }
			} else if (btnClicked.getText().equals("6")) {
				int goalkeeperNum = goalkeeper.randGoalkeeperNum();
	            int playerStrength = player.randStrength();
	            if (btnClicked.getText().equals(goalkeeperNum + "") && (playerStrength <= 74 || playerStrength >= 80)) {
	           		lblShotCondition.setText("Shot was saved by the goalkeeper. Shot Missed.");
	           		goalkeeper.setGoalkeeperScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") && (playerStrength >= 75 && playerStrength <= 79)) {
	           		lblShotCondition.setText("Shot overpowered the goalkeeper. Goal!");
	           		player.setPlayerScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 60 && playerStrength <= 79)) {
	           		lblShotCondition.setText("Goal!!");
	           		player.setPlayerScore(1);
	           		shotNumCounter ++;
	           		window.setScene(sceneAfterShot);
	           	} else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 1 && playerStrength <= 59)) {
	           		Random rand = new Random();
					int n = rand.nextInt(2);
					if (n == 1) {
						lblShotCondition.setText("The shot was too weak. Shot Missed.");
						goalkeeper.setGoalkeeperScore(1);
						shotNumCounter ++;
						window.setScene(sceneAfterShot);
					} else {
						lblShotCondition.setText("Goal!!");
						player.setPlayerScore(1);
						shotNumCounter ++;
						window.setScene(sceneAfterShot);
					}
	            } else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 80 && playerStrength <= 89)) {
	            	lblShotCondition.setText("The ball hit the post. Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            } else if (btnClicked.getText().equals(goalkeeperNum + "") == false && (playerStrength >= 90 && playerStrength <= 100)) {
	            	lblShotCondition.setText("The shot was too strong and went outside the goal. Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            } else {
	            	lblShotCondition.setText("Shot Missed.");
	            	goalkeeper.setGoalkeeperScore(1);
	            	shotNumCounter ++;
	            	window.setScene(sceneAfterShot);
	            }
			} else if (btnClicked.getText().equals("Back to Game")) {
				lblShotNum.setText("Shot Number : " + shotNumCounter);
				lblShotsMade.setText("Shots Made: " + player.getPlayerScore());
				lblShotsMissed.setText("Shots Missed : " + goalkeeper.getGoalkeeperScore());
				if (shotNumCounter < 6) {
					window.setScene(sceneGameStart);
				} else {
					if (player.getPlayerScore() > goalkeeper.getGoalkeeperScore()) {
        				lblFinalResult.setText("Congratulations! You Won!!");
       				} else {
        				lblFinalResult.setText("Sorry. You Lost.");
       				}
					window.setScene(sceneFinalScreen);
				}
			
			// End Game
			} else if (btnClicked.getText().equals("End Game")) {
				window.close();
			}
	  	}
	}



	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

		GridPane gridStartMenue = new GridPane();
		gridStartMenue.setAlignment(Pos.CENTER);
		gridStartMenue.setVgap(40);
	 	gridStartMenue.setHgap(10);
		gridStartMenue.setPadding(new Insets(10,10,10,10));
		BackgroundImage bi = new BackgroundImage(new Image("Background2.jpg",1280,720,false,true),null,null,null,null);
		gridStartMenue.setBackground(new Background(bi));
		Image Textbg = new Image("TextBG.jpeg");
		ImageView TextBG = new ImageView(Textbg);
		TextBG.setFitHeight(40);
		TextBG.setFitWidth(900);
		TextBG.setOpacity(0.5);
		ImageView TextBG1 = new ImageView(Textbg);
		TextBG1.setFitHeight(40);
		TextBG1.setFitWidth(900);
		TextBG1.setOpacity(0.5);
		ImageView TextBG2 = new ImageView(Textbg);
		TextBG2.setFitHeight(40);
		TextBG2.setFitWidth(900);
		TextBG2.setOpacity(0.5);

		// Welcome Screen
	 	Label lblWelcomeMessage = new Label("Welcome to the Penalty Shootout Game!");
	 	lblWelcomeMessage.setFont(Font.font("Algerian", 30));
	 	GridPane.setHalignment(lblWelcomeMessage, HPos.CENTER);

	 	HBox enterName = new HBox();
	 	Label lblEnterName = new Label("Please enter your name: ");
	 	lblEnterName.setFont(Font.font("Forte", 30));
	 	tfName = new TextField();
	  	tfName.setPrefWidth(150);
	  	tfName.setPrefHeight(30);
	  	enterName.getChildren().add(lblEnterName);
	  	enterName.getChildren().add(tfName);
	  	enterName.setAlignment(Pos.CENTER);

	  	Button btnEnterName = new Button("Enter");
	  	btnEnterName.setPrefWidth(150);
	  	btnEnterName.setPrefHeight(30);
	  	btnEnterName.setOnAction(this);
	  	GridPane.setHalignment(btnEnterName, HPos.CENTER);

	  	gridStartMenue.add(TextBG, 1, 0);
	  	gridStartMenue.add(lblWelcomeMessage, 1, 0);
	  	gridStartMenue.add(TextBG1, 1, 1);
	  	gridStartMenue.add(enterName, 1, 1);
	  	gridStartMenue.add(TextBG2, 1, 2);
	  	gridStartMenue.add(btnEnterName, 1, 2);

		sceneStartMenue = new Scene(gridStartMenue, 1280, 720);




		// Player Selection
		Pane gridPlayer = new Pane();
		//gridPlayer.setHalignment(Pos.CENTER);
		//gridPlayer.setVgap(40);
	 	//gridPlayer.setHgap(10);
		gridPlayer.setPadding(new Insets(10,10,10,10));
		BackgroundImage bi1 = new BackgroundImage(new Image("Background3.jpg",1280,720,false,true),null,null,null,null);
		gridPlayer.setBackground(new Background(bi1));
		lblWelcomePlayer = new Label("");
	  	lblWelcomePlayer.setFont(Font.font("Arial", 30));
	  	//GridPane.setHalignment(lblWelcomePlayer, HPos.CENTER);

	  	Label lblChoosePlayer = new Label("Please choose your player to take the penalties.");
	  	lblChoosePlayer.setFont(Font.font("Arial", 30));
                //GridPane.setHalignment(lblWelcomePlayer, HPos.CENTER);

	  	VBox boxPlayerSelection = new VBox();
	  	boxPlayerSelection.setSpacing(20);
                
	  	Button btnRonaldo = new Button("C.Ronaldo");
                Image PortugalFlag = new Image("PortugalFlag.png");
		ImageView Portugal = new ImageView(PortugalFlag);
		Portugal.setFitHeight(30);
		Portugal.setFitWidth(60);
                Image JuventusFlag = new Image("JuventusFlag.png");
		ImageView Juventus = new ImageView(JuventusFlag);
		Juventus.setFitHeight(30);
		Juventus.setFitWidth(60);
                
	  	Button btnMessi = new Button("L.Messi");
                Image ArgentinaFlag = new Image("ArgentinaFlag.png");
		ImageView Argentina = new ImageView(ArgentinaFlag);
		Argentina.setFitHeight(30);
		Argentina.setFitWidth(60);
                Image BarcelonaFlag = new Image("BarcelonaFlag.PNG");
		ImageView Barcelona = new ImageView(BarcelonaFlag);
		Barcelona.setFitHeight(30);
		Barcelona.setFitWidth(60);
                
	  	Button btnPogba = new Button("P.Pogba");
                Image FranceFlag = new Image("FranceFlag.jpg");
		ImageView France = new ImageView(FranceFlag);
		France.setFitHeight(30);
		France.setFitWidth(60);
                Image ManchesterFlag = new Image("ManchesterFlag.PNG");
		ImageView Manchester3 = new ImageView(ManchesterFlag);
		Manchester3.setFitHeight(30);
		Manchester3.setFitWidth(60);
                
	  	Button btnNeymar = new Button("Neymar");
                Image BrazilFlag = new Image("BrazilFlag.png");
		ImageView Brazil = new ImageView(BrazilFlag);
		Brazil.setFitHeight(30);
		Brazil.setFitWidth(60);
                Image PsgFlag = new Image("PSGFlag.png");
		ImageView Psg = new ImageView(PsgFlag);
		Psg.setFitHeight(30);
		Psg.setFitWidth(60);
                
	  	Button btnHazard = new Button("E.Hazard");
                Image BelgiumFlag = new Image("BelgiumFlag.png");
		ImageView Belgium1 = new ImageView(BelgiumFlag);
		Belgium1.setFitHeight(30);
		Belgium1.setFitWidth(60);
		Image ChelseaFlag = new Image("ChelseaFlag.png");
		ImageView Chelsea = new ImageView(ChelseaFlag);
		Chelsea.setFitHeight(30);
		Chelsea.setFitWidth(60);
                
        HBox player1 = new HBox();
		HBox player2 = new HBox();
		HBox player3 = new HBox();
		HBox player4 = new HBox();
		HBox player5 = new HBox();
		
		player1.getChildren().addAll(Portugal, btnRonaldo, Juventus);
		player2.getChildren().addAll(Argentina, btnMessi, Barcelona);
		player3.getChildren().addAll(France, btnPogba, Manchester3);
		player4.getChildren().addAll(Brazil, btnNeymar, Psg);
		player5.getChildren().addAll(Belgium1, btnHazard, Chelsea);
                
	  	btnRonaldo.setOnAction(this);
	  	btnMessi.setOnAction(this);
	  	btnPogba.setOnAction(this);
	  	btnNeymar.setOnAction(this);
	  	btnHazard.setOnAction(this);

	  	boxPlayerSelection.getChildren().add(player1);
	  	btnRonaldo.setPrefWidth(150);
	  	btnRonaldo.setPrefHeight(30);
	  	boxPlayerSelection.getChildren().add(player2);
	  	btnMessi.setPrefWidth(150);
	  	btnMessi.setPrefHeight(30);
	  	boxPlayerSelection.getChildren().add(player3);
	  	btnPogba.setPrefWidth(150);
	  	btnPogba.setPrefHeight(30);
	  	boxPlayerSelection.getChildren().add(player4);
	  	btnNeymar.setPrefWidth(150);
	  	btnNeymar.setPrefHeight(30);
	  	boxPlayerSelection.getChildren().add(player5);
	  	btnHazard.setPrefWidth(150);
	  	btnHazard.setPrefHeight(30);

	  	//boxPlayerSelection.setAlignment(Pos.CENTER);

		//gridPlayer.add(lblWelcomePlayer, 1, 0);
		//gridPlayer.add(lblChoosePlayer, 1, 1);
		//gridPlayer.add(boxPlayerSelection, 1, 2);
		
	  	boxPlayerSelection.setLayoutX(520);
	  	boxPlayerSelection.setLayoutY(300);
	  	
	  	lblChoosePlayer.setLayoutX(320);
	  	lblChoosePlayer.setLayoutY(200);
                
        lblWelcomePlayer.setLayoutX(500);
	  	lblWelcomePlayer.setLayoutY(125);
	  	
	  	ImageView TextBG4 = new ImageView(Textbg);
		TextBG4.setFitHeight(40);
		TextBG4.setFitWidth(1280);
		TextBG4.setOpacity(0.5);
	  	TextBG4.setLayoutX(0);
	  	TextBG4.setLayoutY(125);
	  	
	  	ImageView TextBG5 = new ImageView(Textbg);
		TextBG5.setFitHeight(40);
		TextBG5.setFitWidth(1280);
		TextBG5.setOpacity(0.5);
	  	TextBG5.setLayoutX(0);
	  	TextBG5.setLayoutY(200);
	  	
	  	gridPlayer.getChildren().addAll(TextBG4, TextBG5);
	  	gridPlayer.getChildren().add(lblChoosePlayer);
        gridPlayer.getChildren().add(lblWelcomePlayer);
		gridPlayer.getChildren().add(boxPlayerSelection);

		scenePlayerSelection = new Scene(gridPlayer, 1280, 720);




		// Goalkeeper Selection
		Pane gridGoalkeeper = new Pane();
		//gridGoalkeeper.setAlignment(Pos.CENTER);
		//gridGoalkeeper.setVgap(40);
	 	//gridGoalkeeper.setHgap(10);
		gridGoalkeeper.setPadding(new Insets(10,10,10,10));
		BackgroundImage bi2 = new BackgroundImage(new Image("Background3.jpg",1280,720,false,true),null,null,null,null);
		gridGoalkeeper.setBackground(new Background(bi2));

	  	Label lblChooseGoalkeeper = new Label("Please choose your favourite goalkeeper to save the penalties.");
	  	lblChooseGoalkeeper.setFont(Font.font("Arial", 30));
	  	//GridPane.setHalignment(lblWelcomePlayer, HPos.CENTER);

	  	VBox boxGoalkeeperSelection = new VBox();
	  	boxGoalkeeperSelection.setSpacing(20);
	  	
	  	//DeGea
	  	Button btnGea = new Button("D.de Gea");
	  	Image SpainFlag = new Image("SpainFlag.jpg");
		ImageView Spain = new ImageView(SpainFlag);
		Spain.setFitHeight(30);
		Spain.setFitWidth(60);		
		ImageView Manchester = new ImageView(ManchesterFlag);
		Manchester.setFitHeight(30);
		Manchester.setFitWidth(60);
		
		//Jan Oblak
		Button btnOblak = new Button("J.Oblak");
		Image SloveniaFlag = new Image("SloveniaFlag.png");
		ImageView Slovenia = new ImageView(SloveniaFlag);
		Slovenia.setFitHeight(30);
		Slovenia.setFitWidth(60);
		Image AtleticoFlag = new Image("AtleticoFlag.jpg");
		ImageView Atletico = new ImageView(AtleticoFlag);
		Atletico.setFitHeight(30);
		Atletico.setFitWidth(60);
		
		//M.ter Stegen
		Button btnStegen = new Button("M.ter Stegen");
		Image GermanyFlag = new Image("GermanyFlag.png");
		ImageView Germany = new ImageView(GermanyFlag);
		Germany.setFitHeight(30);
		Germany.setFitWidth(60);
		ImageView Barcelona1 = new ImageView(BarcelonaFlag);
		Barcelona1.setFitHeight(30);
		Barcelona1.setFitWidth(60);
		
		//T.Courtois		
	  	Button btnCourtois = new Button("T.Courtois");
		ImageView Belgium = new ImageView(BelgiumFlag);
		Belgium.setFitHeight(30);
		Belgium.setFitWidth(60);
		Image real = new Image("RealFlag.png");
		ImageView Real = new ImageView(real);
		Real.setFitHeight(30);
		Real.setFitWidth(60);
		
		//M.Neuer	  	
	  	Button btnNeuer = new Button("M.Neuer");
	  	Image GermanyFlag1 = new Image("GermanyFlag.png");
		ImageView Germany1 = new ImageView(GermanyFlag1);
		Germany1.setFitHeight(30);
		Germany1.setFitWidth(60);
		Image bayern = new Image("BayernFlag.jpg");
		ImageView Bayern = new ImageView(bayern);
		Bayern.setFitHeight(30);
		Bayern.setFitWidth(60);

		HBox keeper1 = new HBox();
		HBox keeper2 = new HBox();
		HBox keeper3 = new HBox();
		HBox keeper4 = new HBox();
		HBox keeper5 = new HBox();
		
		keeper1.getChildren().addAll(Spain, btnGea, Manchester);
		keeper2.getChildren().addAll(Slovenia, btnOblak, Atletico);
		keeper3.getChildren().addAll(Germany, btnStegen, Barcelona1);
		keeper4.getChildren().addAll(Belgium, btnCourtois, Real);
		keeper5.getChildren().addAll(Germany1, btnNeuer, Bayern);
		
		
	  	btnGea.setOnAction(this);
	  	btnOblak.setOnAction(this);
	  	btnStegen.setOnAction(this);
	  	btnCourtois.setOnAction(this);
	  	btnNeuer.setOnAction(this);
	  	
	  	
	  	boxGoalkeeperSelection.getChildren().add(keeper1);
	  	btnGea.setPrefWidth(150);
	  	btnGea.setPrefHeight(30);
	  	boxGoalkeeperSelection.getChildren().add(keeper2);
	  	btnOblak.setPrefWidth(150);
	  	btnOblak.setPrefHeight(30);
	  	boxGoalkeeperSelection.getChildren().add(keeper3);
	  	btnStegen.setPrefWidth(150);
	  	btnStegen.setPrefHeight(30);
	  	boxGoalkeeperSelection.getChildren().add(keeper4);
	  	btnCourtois.setPrefWidth(150);
	  	btnCourtois.setPrefHeight(30);
	  	boxGoalkeeperSelection.getChildren().add(keeper5);
	  	btnNeuer.setPrefWidth(150);
	  	btnNeuer.setPrefHeight(30);

	  	boxGoalkeeperSelection.setLayoutX(520);
	  	boxGoalkeeperSelection.setLayoutY(300);
	  	
	  	lblChooseGoalkeeper.setLayoutX(250);
	  	lblChooseGoalkeeper.setLayoutY(200);
	  	
	  	ImageView TextBG6 = new ImageView(Textbg);
		TextBG6.setFitHeight(40);
		TextBG6.setFitWidth(1280);
		TextBG6.setOpacity(0.5);
	  	TextBG6.setLayoutX(0);
	  	TextBG6.setLayoutY(200);

	  	gridGoalkeeper.getChildren().add(TextBG6);
	  	gridGoalkeeper.getChildren().add(lblChooseGoalkeeper);
		gridGoalkeeper.getChildren().add(boxGoalkeeperSelection);

	  	sceneGoalkeeperSelection = new Scene(gridGoalkeeper, 1280, 720);




	  	// Check Game Start
	  	Pane checkGameStart = new Pane();
	  	//checkGameStart.setSpacing(30);

	  	lblChosenPlayer = new Label("");
	  	lblChosenPlayer.setFont(Font.font("Arial", 30));
	  	lblChosenPlayer.setLayoutX((1280/4)+75);
	  	lblChosenPlayer.setLayoutY(275);

	  	lblChosenGoalkeeper = new Label("");
	  	lblChosenGoalkeeper.setFont(Font.font("Arial", 30));
	  	lblChosenGoalkeeper.setLayoutX((1280/4)+75);
	  	lblChosenGoalkeeper.setLayoutY(345);

	  	Button btnGameStart = new Button("Start Game");
	  	btnGameStart.setPrefWidth(150);
	  	btnGameStart.setPrefHeight(40);
	  	btnGameStart.setOnAction(this);
	  	btnGameStart.setLayoutX(600);
	  	btnGameStart.setLayoutY(390);
	  	
	  	BackgroundImage bi3 = new BackgroundImage(new Image("Background1.jpg",1280,720,false,true),null,null,null,null);
		checkGameStart.setBackground(new Background(bi3));

	  	//checkGameStart.setAlignment(Pos.CENTER);

	  	ImageView TextBG7 = new ImageView(Textbg);
		TextBG7.setFitHeight(40);
		TextBG7.setFitWidth(1280);
		TextBG7.setOpacity(0.5);
	  	TextBG7.setLayoutX(0);
	  	TextBG7.setLayoutY(275);
	  	
	  	ImageView TextBG8 = new ImageView(Textbg);
		TextBG8.setFitHeight(40);
		TextBG8.setFitWidth(1280);
		TextBG8.setOpacity(0.5);
	  	TextBG8.setLayoutX(0);
	  	TextBG8.setLayoutY(345);
	  	
	  	checkGameStart.getChildren().addAll(TextBG7,TextBG8);
	  	checkGameStart.getChildren().add(lblChosenPlayer);
	  	checkGameStart.getChildren().add(lblChosenGoalkeeper);
	  	checkGameStart.getChildren().add(btnGameStart);

	  	sceneCheckGameStart = new Scene(checkGameStart, 1280, 720);



	  	// Game Start
	  	Pane gridGameStart = new Pane();
	  	//gridGameStart.setAlignment(Pos.CENTER);
		//gridGameStart.setVgap(10);
	 	//gridGameStart.setHgap(10);
		gridGameStart.setPadding(new Insets(10,10,10,10));
		BackgroundImage MainBG = new BackgroundImage(new Image("MainBG.png",1280,720,false,true),null,null,null,null);
		gridGameStart.setBackground(new Background(MainBG));
		Image deGea = new Image("DeGeaStanding.png");
		ImageView deGea_1 = new ImageView(deGea);
		deGea_1.setFitHeight(200);
                deGea_1.setFitWidth(100);
                deGea_1.setLayoutX(585);
                deGea_1.setLayoutY(175);
        
        Image Ronaldo = new Image("RonaldoStanding.png");
		ImageView Ronaldo_1 = new ImageView(Ronaldo);
		Ronaldo_1.setFitHeight(350);
		Ronaldo_1.setFitWidth(200);
		Ronaldo_1.setLayoutX(250);
		Ronaldo_1.setLayoutY(300);
		
		Image football = new Image("Football.png");
		ImageView Football = new ImageView(football);
		Football.setFitHeight(50);
		Football.setFitWidth(50);
		Football.setLayoutX(595);
		Football.setLayoutY(437);
		Football.setOpacity(0.75);
		
        gridGameStart.getChildren().addAll(deGea_1,Ronaldo_1,Football);

		VBox boxShotNum = new VBox();
		Label lblInstruction = new Label("Choose where to shoot.");
		lblInstruction.setFont(Font.font("Arial", 30));
		lblShotNum = new Label("Shot Number : " + shotNumCounter);
		lblShotNum.setFont(Font.font("Arial", 30));
		Label lblWhiteSpace = new Label("");
		lblWhiteSpace.setFont(Font.font("Arial", 30));
		boxShotNum.getChildren().add(lblInstruction);
		boxShotNum.getChildren().add(lblShotNum);
		boxShotNum.getChildren().add(lblWhiteSpace);
		boxShotNum.setSpacing(20);
		boxShotNum.setAlignment(Pos.TOP_CENTER);

		VBox boxScoreCounter = new VBox();
		lblShotsMade = new Label("Shots Made: " + player.getPlayerScore());
		lblShotsMade.setFont(Font.font("Arial", 30));
		lblShotsMissed = new Label("Shots Missed : " + goalkeeper.getGoalkeeperScore());
		lblShotsMissed.setFont(Font.font("Arial", 30));
		boxScoreCounter.getChildren().add(lblShotsMade);
		boxScoreCounter.getChildren().add(lblShotsMissed);
		boxScoreCounter.getChildren().add(lblWhiteSpace);
		boxScoreCounter.setSpacing(20);
		boxScoreCounter.setAlignment(Pos.TOP_CENTER);

		//StackPane xyz = new StackPane();
		//Color transparent = new Color(1f,1f,1f,.5f);
		Button one = new Button("1");
		one.setOpacity(0.2);
		one.setPrefWidth(200);
	  	one.setPrefHeight(130);
	  	one.setLayoutX(325);
	    one.setLayoutY(125);
	  	Button two = new Button("2");
	  	two.setOpacity(0.2);
	  	two.setPrefWidth(225);
	  	two.setPrefHeight(130);
	  	two.setLayoutX(525);
	    two.setLayoutY(125);
	  	Button three = new Button("3");
	  	three.setOpacity(0.2);
	  	three.setPrefWidth(200);
	  	three.setPrefHeight(130);
	  	three.setLayoutX(750);
	    three.setLayoutY(125);
	  	Button four = new Button("4");
	  	four.setOpacity(0.2);
	  	four.setPrefWidth(200);
	  	four.setPrefHeight(130);
	  	four.setLayoutX(325);
	    four.setLayoutY(250);
	  	Button five = new Button("5");
	  	five.setOpacity(0.2);
	  	five.setPrefWidth(225);
	  	five.setPrefHeight(130);
	  	five.setLayoutX(525);
	    five.setLayoutY(250);
	  	Button six = new Button("6");
	  	six.setOpacity(0.2);
	  	six.setPrefWidth(200);
	  	six.setPrefHeight(130);
	  	six.setLayoutX(750);
	    six.setLayoutY(250);

	  	one.setOnAction(this);
	  	two.setOnAction(this);
	  	three.setOnAction(this);
	  	four.setOnAction(this);
	  	five.setOnAction(this);
	  	six.setOnAction(this);
	  	
	  	gridGameStart.getChildren().addAll(one,two,three,four,five,six);

	  	/*gridGameStart.add(boxShotNum, 0, 0);
	  	gridGameStart.add(boxScoreCounter, 2, 0);
	  	gridGameStart.add(one, 0, 1);
	  	gridGameStart.add(two, 1, 1);
	  	gridGameStart.add(three, 2, 1);
	  	gridGameStart.add(four, 0, 2);
	  	gridGameStart.add(five, 1, 2);
	  	gridGameStart.add(six, 2, 2);
	  	*/

	  	sceneGameStart = new Scene(gridGameStart, 1280, 720);	
		
	  	// AfterShot Screen
	  	VBox boxAfterShot = new VBox();
	  	lblShotCondition = new Label("");
	  	lblShotCondition.setFont(Font.font("Arial", 30));
	  	Button btnBackToGame = new Button("Back to Game");
	  	btnBackToGame.setOnAction(this);
	  	btnBackToGame.setPrefWidth(150);
	  	btnBackToGame.setPrefHeight(30);
	  	boxAfterShot.getChildren().add(lblShotCondition);
	  	boxAfterShot.getChildren().add(btnBackToGame);
	  	boxAfterShot.setAlignment(Pos.CENTER);
	  	boxAfterShot.setSpacing(20);

	  	sceneAfterShot = new Scene(boxAfterShot, 1280, 720);

	  	// Final Screen
	  	VBox boxFinalScreen = new VBox();
	  	lblFinalResult = new Label("");
	  	lblFinalResult.setFont(Font.font("Arial", 30));
	  	Button btnEndGame = new Button("End Game");
	  	btnEndGame.setOnAction(this);
	  	btnEndGame.setPrefWidth(150);
	  	btnEndGame.setPrefHeight(30);
	  	boxFinalScreen.getChildren().add(lblFinalResult);
	  	boxFinalScreen.getChildren().add(btnEndGame);
	  	boxFinalScreen.setAlignment(Pos.CENTER);
	  	boxFinalScreen.setSpacing(20);

	  	sceneFinalScreen = new Scene(boxFinalScreen, 1280, 720);

	  	// Initialize
      	window.setTitle("Penalty Shootout");
      	window.setResizable(false);
   		window.setScene(sceneStartMenue);
      	window.show();
	}
}
