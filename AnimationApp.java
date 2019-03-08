import java.util.Scanner;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
			} else if (btnClicked.getText().equals("D.de Gea")) {
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

		// Welcome Screen
	 	Label lblWelcomeMessage = new Label("Welcome to the Penalty Shootout Game!");
	 	lblWelcomeMessage.setFont(Font.font("Arial", 30));
	 	GridPane.setHalignment(lblWelcomeMessage, HPos.CENTER);

	 	HBox enterName = new HBox();
	 	Label lblEnterName = new Label("Please enter your name: ");
	 	lblEnterName.setFont(Font.font("Arial", 30));
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

	  	gridStartMenue.add(lblWelcomeMessage, 1, 0);
	  	gridStartMenue.add(enterName, 1, 1);
	  	gridStartMenue.add(btnEnterName, 1, 2);

		sceneStartMenue = new Scene(gridStartMenue, 1280, 720);




		// Player Selection
		GridPane gridPlayer = new GridPane();
		gridPlayer.setAlignment(Pos.CENTER);
		gridPlayer.setVgap(40);
	 	gridPlayer.setHgap(10);
		gridPlayer.setPadding(new Insets(10,10,10,10));

		lblWelcomePlayer = new Label("");
	  	lblWelcomePlayer.setFont(Font.font("Arial", 30));
	  	GridPane.setHalignment(lblWelcomePlayer, HPos.CENTER);

	  	Label lblChoosePlayer = new Label("Please choose your player to take the penalties.");
	  	lblChoosePlayer.setFont(Font.font("Arial", 30));
	  	GridPane.setHalignment(lblWelcomePlayer, HPos.CENTER);

	  	VBox boxPlayerSelection = new VBox();
	  	boxPlayerSelection.setSpacing(20);
	  	Button btnRonaldo = new Button("C.Ronaldo");
	  	Button btnMessi = new Button("L.Messi");
	  	Button btnPogba = new Button("P.Pogba");
	  	Button btnNeymar = new Button("Neymar");
	  	Button btnHazard = new Button("E.Hazard");

	  	btnRonaldo.setOnAction(this);
	  	btnMessi.setOnAction(this);
	  	btnPogba.setOnAction(this);
	  	btnNeymar.setOnAction(this);
	  	btnHazard.setOnAction(this);

	  	boxPlayerSelection.getChildren().add(btnRonaldo);
	  	btnRonaldo.setPrefWidth(150);
	  	btnRonaldo.setPrefHeight(30);
	  	boxPlayerSelection.getChildren().add(btnMessi);
	  	btnMessi.setPrefWidth(150);
	  	btnMessi.setPrefHeight(30);
	  	boxPlayerSelection.getChildren().add(btnPogba);
	  	btnPogba.setPrefWidth(150);
	  	btnPogba.setPrefHeight(30);
	  	boxPlayerSelection.getChildren().add(btnNeymar);
	  	btnNeymar.setPrefWidth(150);
	  	btnNeymar.setPrefHeight(30);
	  	boxPlayerSelection.getChildren().add(btnHazard);
	  	btnHazard.setPrefWidth(150);
	  	btnHazard.setPrefHeight(30);

	  	boxPlayerSelection.setAlignment(Pos.CENTER);

		gridPlayer.add(lblWelcomePlayer, 1, 0);
		gridPlayer.add(lblChoosePlayer, 1, 1);
		gridPlayer.add(boxPlayerSelection, 1, 2);

		scenePlayerSelection = new Scene(gridPlayer, 1280, 720);




		// Goalkeeper Selection
		GridPane gridGoalkeeper = new GridPane();
		gridGoalkeeper.setAlignment(Pos.CENTER);
		gridGoalkeeper.setVgap(40);
	 	gridGoalkeeper.setHgap(10);
		gridGoalkeeper.setPadding(new Insets(10,10,10,10));

	  	Label lblChooseGoalkeeper = new Label("Please choose your favourite goalkeeper to save the penalties.");
	  	lblChooseGoalkeeper.setFont(Font.font("Arial", 30));
	  	GridPane.setHalignment(lblWelcomePlayer, HPos.CENTER);

	  	VBox boxGoalkeeperSelection = new VBox();
	  	boxGoalkeeperSelection.setSpacing(20);
	  	Button btnGea = new Button("D.de Gea");
	  	Button btnOblak = new Button("J.Oblak");
	  	Button btnStegen = new Button("M.ter Stegen");
	  	Button btnCourtois = new Button("T.Courtois");
	  	Button btnNeuer = new Button("M.Neuer");

	  	btnGea.setOnAction(this);
	  	btnOblak.setOnAction(this);
	  	btnStegen.setOnAction(this);
	  	btnCourtois.setOnAction(this);
	  	btnNeuer.setOnAction(this);

	  	boxGoalkeeperSelection.getChildren().add(btnGea);
	  	btnGea.setPrefWidth(150);
	  	btnGea.setPrefHeight(30);
	  	boxGoalkeeperSelection.getChildren().add(btnOblak);
	  	btnOblak.setPrefWidth(150);
	  	btnOblak.setPrefHeight(30);
	  	boxGoalkeeperSelection.getChildren().add(btnStegen);
	  	btnStegen.setPrefWidth(150);
	  	btnStegen.setPrefHeight(30);
	  	boxGoalkeeperSelection.getChildren().add(btnCourtois);
	  	btnCourtois.setPrefWidth(150);
	  	btnCourtois.setPrefHeight(30);
	  	boxGoalkeeperSelection.getChildren().add(btnNeuer);
	  	btnNeuer.setPrefWidth(150);
	  	btnNeuer.setPrefHeight(30);

	  	boxGoalkeeperSelection.setAlignment(Pos.CENTER);

	  	gridGoalkeeper.add(lblChooseGoalkeeper, 1, 0);
		gridGoalkeeper.add(boxGoalkeeperSelection, 1, 1);

	  	sceneGoalkeeperSelection = new Scene(gridGoalkeeper, 1280, 720);




	  	// Check Game Start
	  	VBox checkGameStart = new VBox();
	  	checkGameStart.setSpacing(30);

	  	lblChosenPlayer = new Label("");
	  	lblChosenPlayer.setFont(Font.font("Arial", 30));

	  	lblChosenGoalkeeper = new Label("");
	  	lblChosenGoalkeeper.setFont(Font.font("Arial", 30));

	  	Button btnGameStart = new Button("Start Game");
	  	btnGameStart.setPrefWidth(150);
	  	btnGameStart.setPrefHeight(40);
	  	btnGameStart.setOnAction(this);

	  	checkGameStart.setAlignment(Pos.CENTER);

	  	checkGameStart.getChildren().add(lblChosenPlayer);
	  	checkGameStart.getChildren().add(lblChosenGoalkeeper);
	  	checkGameStart.getChildren().add(btnGameStart);

	  	sceneCheckGameStart = new Scene(checkGameStart, 1280, 720);



	  	// Game Start
	  	GridPane gridGameStart = new GridPane();
	  	gridGameStart.setAlignment(Pos.CENTER);
		gridGameStart.setVgap(10);
	 	gridGameStart.setHgap(10);
		gridGameStart.setPadding(new Insets(10,10,10,10));

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

		Button one = new Button("1");
		one.setPrefWidth(410);
	  	one.setPrefHeight(200);
	  	Button two = new Button("2");
	  	two.setPrefWidth(410);
	  	two.setPrefHeight(200);
	  	Button three = new Button("3");
	  	three.setPrefWidth(410);
	  	three.setPrefHeight(200);
	  	Button four = new Button("4");
	  	four.setPrefWidth(410);
	  	four.setPrefHeight(200);
	  	Button five = new Button("5");
	  	five.setPrefWidth(410);
	  	five.setPrefHeight(200);
	  	Button six = new Button("6");
	  	six.setPrefWidth(410);
	  	six.setPrefHeight(200);

	  	one.setOnAction(this);
	  	two.setOnAction(this);
	  	three.setOnAction(this);
	  	four.setOnAction(this);
	  	five.setOnAction(this);
	  	six.setOnAction(this);

	  	gridGameStart.add(boxShotNum, 0, 0);
	  	gridGameStart.add(boxScoreCounter, 2, 0);
	  	gridGameStart.add(one, 0, 1);
	  	gridGameStart.add(two, 1, 1);
	  	gridGameStart.add(three, 2, 1);
	  	gridGameStart.add(four, 0, 2);
	  	gridGameStart.add(five, 1, 2);
	  	gridGameStart.add(six, 2, 2);

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