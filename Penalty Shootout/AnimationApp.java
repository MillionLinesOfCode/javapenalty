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
	// Variables
	Stage window;
	Scene sceneStartMenue, scenePlayerSelection, sceneGoalkeeperSelection, sceneCheckGameStart, sceneGameStart, sceneAfterShot, sceneFinalScreen;

	private Player player = new Player();
	private Goalkeeper goalkeeper = new Goalkeeper();

	Label lblWelcomePlayer = new Label("");
	TextField tfName;
	Label lblChosenPlayer = new Label("");
	Label lblChosenGoalkeeper = new Label("");
	Label lblShotNum = new Label("Shot Number : " + "1");
	Label lblShotsMade = new Label("Shots Made: " + player.getPlayerScore());
	Label lblShotsMissed = new Label("Shots Missed : " + goalkeeper.getGoalkeeperScore());
	Label lblShotCondition = new Label("");
	Label lblFinalResult = new Label("");

	int shotNumCounter = 1;

	BackgroundImage selectionBG = new BackgroundImage(new Image("selectionBG.jpg",1280,720,false,true),null,null,null,null);
	Image portugalFlag = new Image("portugalFlag.png");
	Image juventusFlag = new Image("JuventusFlag.png");
	Image argentinaFlag = new Image("ArgentinaFlag.png");
	Image barcelonaFlag = new Image("BarcelonaFlag.PNG");
	Image franceFlag = new Image("FranceFlag.jpg");
	Image manchesterFlag = new Image("ManchesterFlag.PNG");
	Image brazilFlag = new Image("BrazilFlag.png");
	Image psgFlag = new Image("PSGFlag.png");
	Image belgiumFlag = new Image("BelgiumFlag.png");
	Image chelseaFlag = new Image("ChelseaFlag.png");
	Image spainFlag = new Image("SpainFlag.jpg");
	Image sloveniaFlag = new Image("SloveniaFlag.png");
	Image atleticoFlag = new Image("AtleticoFlag.jpg");
	Image germanyFlag = new Image("GermanyFlag.png");
	Image realFlag = new Image("RealFlag.png");
	Image bayernFlag = new Image("BayernFlag.jpg");

	// Scenes
	public Scene startMenueScene() {
		// Welcome Screen
		GridPane gridStartMenue = new GridPane();
		gridStartMenue.setAlignment(Pos.CENTER);
		gridStartMenue.setVgap(40);
	 	gridStartMenue.setHgap(10);
		gridStartMenue.setPadding(new Insets(10,10,10,10));

		// Background Image
		BackgroundImage startMenueBG = new BackgroundImage(new Image("startMenueBG.jpg",1280,720,false,true),null,null,null,null);
		gridStartMenue.setBackground(new Background(startMenueBG));

		// Text Background Image
		Image textBG = new Image("textBG.jpeg");
		ImageView textBG1 = new ImageView(textBG);
		textBG1.setFitHeight(40);
		textBG1.setFitWidth(900);
		textBG1.setOpacity(0.5);
		ImageView textBG2 = new ImageView(textBG);
		textBG2.setFitHeight(40);
		textBG2.setFitWidth(900);
		textBG2.setOpacity(0.5);
		ImageView textBG3 = new ImageView(textBG);
		textBG3.setFitHeight(40);
		textBG3.setFitWidth(900);
		textBG3.setOpacity(0.5);

		// Welcome Text
	 	Label lblWelcomeMessage = new Label("Welcome to the Penalty Shootout Game!");
	 	lblWelcomeMessage.setFont(Font.font("Algerian", 30));
	 	GridPane.setHalignment(lblWelcomeMessage, HPos.CENTER);

	 	// Enter Player Name
	 	HBox enterName = new HBox();
	 	Label lblEnterName = new Label("Please enter your name: ");
	 	lblEnterName.setFont(Font.font("Forte", 30));
	 	tfName = new TextField();
	  	tfName.setPrefWidth(150);
	  	tfName.setPrefHeight(30);
	  	enterName.getChildren().add(lblEnterName);
	  	enterName.getChildren().add(tfName);
	  	enterName.setAlignment(Pos.CENTER);

	  	// Button to Enter
	  	Button btnEnterName = new Button("Enter");
	  	btnEnterName.setPrefWidth(150);
	  	btnEnterName.setPrefHeight(30);
	  	btnEnterName.setOnAction(this);
	  	GridPane.setHalignment(btnEnterName, HPos.CENTER);

	  	// Adding to Grid
	  	gridStartMenue.add(textBG1, 1, 0);
	  	gridStartMenue.add(lblWelcomeMessage, 1, 0);
	  	gridStartMenue.add(textBG2, 1, 1);
	  	gridStartMenue.add(enterName, 1, 1);
	  	gridStartMenue.add(textBG3, 1, 2);
	  	gridStartMenue.add(btnEnterName, 1, 2);

	  	// Setting Scene
		sceneStartMenue = new Scene(gridStartMenue, 1280, 720);
		return sceneStartMenue;
	}

	public Scene playerSelectionScene() {
		if (scenePlayerSelection == null) {
		// Player Selection
		Pane gridPlayerSelection = new Pane();
		gridPlayerSelection.setPadding(new Insets(10,10,10,10));

		// Background Image
		gridPlayerSelection.setBackground(new Background(selectionBG));

		// Label for User Name
	  	lblWelcomePlayer.setFont(Font.font("Arial", 30));

	  	// Please Chose Player
	  	Label lblChoosePlayer = new Label("Please choose your player to take the penalties.");
	  	lblChoosePlayer.setFont(Font.font("Arial", 30));


	  	// List of Players
	  	VBox boxPlayerSelection = new VBox();
	  	boxPlayerSelection.setSpacing(20);

	  	// Ronaldo
	  	Button btnRonaldo = new Button("C.Ronaldo");
		ImageView portugal = new ImageView(portugalFlag);
		portugal.setFitHeight(30);
		portugal.setFitWidth(60);
		ImageView juventus = new ImageView(juventusFlag);
		juventus.setFitHeight(30);
		juventus.setFitWidth(60);

		// Messi
	  	Button btnMessi = new Button("L.Messi");  
		ImageView argentina = new ImageView(argentinaFlag);
		argentina.setFitHeight(30);
		argentina.setFitWidth(60);
		ImageView barcelona = new ImageView(barcelonaFlag);
		barcelona.setFitHeight(30);
		barcelona.setFitWidth(60);

		//Pogba
	  	Button btnPogba = new Button("P.Pogba");
		ImageView france = new ImageView(franceFlag);
		france.setFitHeight(30);
		france.setFitWidth(60);
		ImageView manchester = new ImageView(manchesterFlag);
		manchester.setFitHeight(30);
		manchester.setFitWidth(60);

		// Neymar
	  	Button btnNeymar = new Button("Neymar");
		ImageView brazil = new ImageView(brazilFlag);
		brazil.setFitHeight(30);
		brazil.setFitWidth(60);
		ImageView psg = new ImageView(psgFlag);
		psg.setFitHeight(30);
		psg.setFitWidth(60);

		// Hazard
	  	Button btnHazard = new Button("E.Hazard");
		ImageView belgium = new ImageView(belgiumFlag);
		belgium.setFitHeight(30);
		belgium.setFitWidth(60);
		ImageView chelsea = new ImageView(chelseaFlag);
		chelsea.setFitHeight(30);
		chelsea.setFitWidth(60);

		// Setting Action on Buttons
	  	btnRonaldo.setOnAction(this);
	  	btnMessi.setOnAction(this);
	  	btnPogba.setOnAction(this);
	  	btnNeymar.setOnAction(this);
	  	btnHazard.setOnAction(this);
               
		// Setting up player selection Box
		HBox player1 = new HBox();
		HBox player2 = new HBox();
		HBox player3 = new HBox();
		HBox player4 = new HBox();
		HBox player5 = new HBox();
		
		player1.getChildren().addAll(portugal, btnRonaldo, juventus);
		player2.getChildren().addAll(argentina, btnMessi, barcelona);
		player3.getChildren().addAll(france, btnPogba, manchester);
		player4.getChildren().addAll(brazil, btnNeymar, psg);
		player5.getChildren().addAll(belgium, btnHazard, chelsea);

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

	  	// Layout of Player Selection Scene
	  	boxPlayerSelection.setLayoutX(520);
	  	boxPlayerSelection.setLayoutY(300);
	  	
	  	lblChoosePlayer.setLayoutX(320);
	  	lblChoosePlayer.setLayoutY(200);
                
		lblWelcomePlayer.setLayoutX(500);
	  	lblWelcomePlayer.setLayoutY(125);
	  	
	  	// Adding to Grid
	  	gridPlayerSelection.getChildren().add(lblChoosePlayer);
		gridPlayerSelection.getChildren().add(lblWelcomePlayer);
		gridPlayerSelection.getChildren().add(boxPlayerSelection);

		scenePlayerSelection = new Scene(gridPlayerSelection, 1280, 720);
		}
		return scenePlayerSelection;
	}
	
	public Scene goalkeeperSelectionScene() {
		// Goalkeeper Selection
		Pane gridGoalkeeper = new Pane();
		gridGoalkeeper.setPadding(new Insets(10,10,10,10));

		// Background Image
		gridGoalkeeper.setBackground(new Background(selectionBG));

		// Label for choosing players
	  	Label lblChooseGoalkeeper = new Label("Please choose your favourite goalkeeper to save the penalties.");
	  	lblChooseGoalkeeper.setFont(Font.font("Arial", 30));


	  	// List of Players
	  	VBox boxGoalkeeperSelection = new VBox();
	  	boxGoalkeeperSelection.setSpacing(20);
	  	
	  	// DeGea
	  	Button btnGea = new Button("D.de Gea");
		ImageView spain = new ImageView(spainFlag);
		spain.setFitHeight(30);
		spain.setFitWidth(60);		
		ImageView manchester1 = new ImageView(manchesterFlag);
		manchester1.setFitHeight(30);
		manchester1.setFitWidth(60);
		
		// Oblak
		Button btnOblak = new Button("J.Oblak");
		ImageView slovenia = new ImageView(sloveniaFlag);
		slovenia.setFitHeight(30);
		slovenia.setFitWidth(60);
		ImageView atletico = new ImageView(atleticoFlag);
		atletico.setFitHeight(30);
		atletico.setFitWidth(60);
		
		// Stegen
		Button btnStegen = new Button("M.ter Stegen");
		ImageView germany = new ImageView(germanyFlag);
		germany.setFitHeight(30);
		germany.setFitWidth(60);
		ImageView barcelona1 = new ImageView(barcelonaFlag);
		barcelona1.setFitHeight(30);
		barcelona1.setFitWidth(60);
		
		// Courtois		
	  	Button btnCourtois = new Button("T.Courtois");
		ImageView belgium1 = new ImageView(belgiumFlag);
		belgium1.setFitHeight(30);
		belgium1.setFitWidth(60);
		ImageView real = new ImageView(realFlag);
		real.setFitHeight(30);
		real.setFitWidth(60);
		
		// Neuer	  	
	  	Button btnNeuer = new Button("M.Neuer");
		ImageView germany1 = new ImageView(germanyFlag);
		germany1.setFitHeight(30);
		germany1.setFitWidth(60);
		ImageView bayern = new ImageView(bayernFlag);
		bayern.setFitHeight(30);
		bayern.setFitWidth(60);

		// Setting Action
		btnGea.setOnAction(this);
	  	btnOblak.setOnAction(this);
	  	btnStegen.setOnAction(this);
	  	btnCourtois.setOnAction(this);
	  	btnNeuer.setOnAction(this);

		// Adding to Box
		HBox keeper1 = new HBox();
		HBox keeper2 = new HBox();
		HBox keeper3 = new HBox();
		HBox keeper4 = new HBox();
		HBox keeper5 = new HBox();
		
		keeper1.getChildren().addAll(spain, btnGea, manchester1);
		keeper2.getChildren().addAll(slovenia, btnOblak, atletico);
		keeper3.getChildren().addAll(germany, btnStegen, barcelona1);
		keeper4.getChildren().addAll(belgium1, btnCourtois, real);
		keeper5.getChildren().addAll(germany1, btnNeuer, bayern);
	  	
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

	  	// Layout of the Goalkeeper Selection
	  	boxGoalkeeperSelection.setLayoutX(520);
	  	boxGoalkeeperSelection.setLayoutY(300);
	  	
	  	lblChooseGoalkeeper.setLayoutX(250);
	  	lblChooseGoalkeeper.setLayoutY(200);

	  	// Adding to Grid
	  	gridGoalkeeper.getChildren().add(lblChooseGoalkeeper);
		gridGoalkeeper.getChildren().add(boxGoalkeeperSelection);

	  	sceneGoalkeeperSelection = new Scene(gridGoalkeeper, 1280, 720);
	  	return sceneGoalkeeperSelection;
	}

	public Scene checkGameStartScene() {
		// Check Game Start
	  	VBox checkGameStart = new VBox();
	  	checkGameStart.setSpacing(30);

	  	lblChosenPlayer.setFont(Font.font("Arial", 30));
	  	lblChosenGoalkeeper.setFont(Font.font("Arial", 30));

	  	Button btnGameStart = new Button("Start Game");
	  	btnGameStart.setPrefWidth(150);
	  	btnGameStart.setPrefHeight(40);
	  	btnGameStart.setOnAction(this);

	  	// Background Image
	  	BackgroundImage checkGameStartBG = new BackgroundImage(new Image("checkGameStartBG.jpg",1280,720,false,true),null,null,null,null);
		checkGameStart.setBackground(new Background(checkGameStartBG));

	  	checkGameStart.setAlignment(Pos.CENTER);

	  	checkGameStart.getChildren().add(lblChosenPlayer);
	  	checkGameStart.getChildren().add(lblChosenGoalkeeper);
	  	checkGameStart.getChildren().add(btnGameStart);

	  	sceneCheckGameStart = new Scene(checkGameStart, 1280, 720);
	  	return sceneCheckGameStart;
	}

	public Scene gameStartScene() {
		// Game Start
	  	Pane gridGameStart = new Pane();
		gridGameStart.setPadding(new Insets(10,10,10,10));

		// Background Image
		BackgroundImage gameStartBG = new BackgroundImage(new Image("gameStartBG.png",1280,720,false,true),null,null,null,null);
		gridGameStart.setBackground(new Background(gameStartBG));

		// Player
		Image ronaldoIMG = new Image("RonaldoStanding.png");
		ImageView ronaldo = new ImageView(ronaldoIMG);
		ronaldo.setFitHeight(350);
		ronaldo.setFitWidth(200);
		ronaldo.setLayoutX(250);
		ronaldo.setLayoutY(300);

		// Goalkeeper
		Image deGeaIMG = new Image("DeGeaStanding.png");
		ImageView deGea = new ImageView(deGeaIMG);
		deGea.setFitHeight(200);
        deGea.setFitWidth(100);
        deGea.setLayoutX(585);
        deGea.setLayoutY(175);

		// Football		
		Image footballIMG = new Image("Football.png");
		ImageView football = new ImageView(footballIMG);
		football.setFitHeight(50);
		football.setFitWidth(50);
		football.setLayoutX(595);
		football.setLayoutY(437);
		football.setOpacity(0.75);
		
        gridGameStart.getChildren().addAll(deGea, ronaldo, football);

        // Shot number
		VBox boxShotNum = new VBox();
		Label lblInstruction = new Label("Choose where to shoot.");
		lblInstruction.setFont(Font.font("Arial", 30));
		/*
		lblShotNum = new Label("Shot Number : " + shotNumCounter);
		*/
		lblShotNum.setFont(Font.font("Arial", 30));
		Label lblWhiteSpace = new Label("");
		lblWhiteSpace.setFont(Font.font("Arial", 30));
		boxShotNum.getChildren().add(lblInstruction);
		boxShotNum.getChildren().add(lblShotNum);
		boxShotNum.getChildren().add(lblWhiteSpace);
		boxShotNum.setSpacing(20);
		boxShotNum.setAlignment(Pos.TOP_CENTER);

		// Current Standing
		VBox boxScoreCounter = new VBox();
		/*
		lblShotsMade = new Label("Shots Made: " + player.getPlayerScore());
		*/
		lblShotsMade.setFont(Font.font("Arial", 30));
		/*
		lblShotsMissed = new Label("Shots Missed : " + goalkeeper.getGoalkeeperScore());
		*/
		lblShotsMissed.setFont(Font.font("Arial", 30));
		boxScoreCounter.getChildren().add(lblShotsMade);
		boxScoreCounter.getChildren().add(lblShotsMissed);
		boxScoreCounter.getChildren().add(lblWhiteSpace);
		boxScoreCounter.setSpacing(20);
		boxScoreCounter.setAlignment(Pos.TOP_CENTER);

		// Buttons to Shoot
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

	  	sceneGameStart = new Scene(gridGameStart, 1280, 720);
	  	return sceneGameStart;
	}

	public Scene afterShotScene() {
		// AfterShot Screen
	  	VBox boxAfterShot = new VBox();
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
	  	return sceneAfterShot;
	}

	public Scene finalScreenScene() {
		// Final Screen
	  	VBox boxFinalScreen = new VBox();
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
	  	return sceneFinalScreen;
	}


	// Main Method
	public static void main(String[] args) {
		launch(args);
	}

	// Sets the player and goalkeeper name
	public void showPlayerGoalkeeper() {
		lblChosenPlayer.setText("The player you chose is " + player.getName() + ".");
		lblChosenGoalkeeper.setText("The goalkeeper you chose is " + goalkeeper.getName() + ".");
		window.setScene(checkGameStartScene());
	}

	// Decides outcome of the shot
	public void decideOutcome(int playerNum, int goalkeeperNum, int playerStrength) {
		// player = goalkeeper, shot missed
		if ((playerNum == goalkeeperNum) && (playerStrength <= 74 || playerStrength >= 80)) {
     		lblShotCondition.setText("Shot was saved by the goalkeeper. Shot Missed.");
      		goalkeeper.setGoalkeeperScore(1);
       		shotNumCounter ++;
	   		window.setScene(afterShotScene());
	   	// player = goalkeeper, strength 75-79, overpowered goalkeeper, goal
	   	} else if ((playerNum == goalkeeperNum) && (playerStrength >= 75 && playerStrength <= 79)) {
	   		lblShotCondition.setText("Shot overpowered the goalkeeper. Goal!");
	   		player.setPlayerScore(1);
	   		shotNumCounter ++;
	   		window.setScene(afterShotScene());
	   	// player != goalkeeper, strenght 60-79, goal
	  	} else if ((playerNum != goalkeeperNum) && (playerStrength >= 60 && playerStrength <= 79)) {
	  		lblShotCondition.setText("Goal!!");
	   		player.setPlayerScore(1);
	   		shotNumCounter ++;
	  		window.setScene(afterShotScene());
	  	// player != goalkeeper, strength 1-59, two options
	  	} else if ((playerNum != goalkeeperNum) && (playerStrength >= 1 && playerStrength <= 59)) {
	  		Random rand = new Random();
			int n = rand.nextInt(2);
			if (n == 1) {
				// Shot missed
				lblShotCondition.setText("The shot was too weak. Shot Missed.");
				goalkeeper.setGoalkeeperScore(1);
				shotNumCounter ++;
				window.setScene(afterShotScene());
			} else {
				// goal
				lblShotCondition.setText("Goal!!");
				player.setPlayerScore(1);
				shotNumCounter ++;
				window.setScene(afterShotScene());
			}
		// player != goalkeeper, strength 80-89, hit post, shot missed
	    } else if ((playerNum != goalkeeperNum) && (playerStrength >= 80 && playerStrength <= 89)) {
	       	lblShotCondition.setText("The ball hit the post. Shot Missed.");
	       	goalkeeper.setGoalkeeperScore(1);
	       	shotNumCounter ++;
	      	window.setScene(afterShotScene());
	    // player != goalkeeper, strenght 90-100, too strong, shot missed 
	    } else if ((playerNum != goalkeeperNum) && (playerStrength >= 90 && playerStrength <= 100)) {
	       	lblShotCondition.setText("The shot was too strong and went outside the goal. Shot Missed.");
	       	goalkeeper.setGoalkeeperScore(1);
	       	shotNumCounter ++;
	       	window.setScene(afterShotScene());
	    } else {
	       	lblShotCondition.setText("Shot Missed.");
	       	goalkeeper.setGoalkeeperScore(1);
	       	shotNumCounter ++;
	       	window.setScene(afterShotScene());
	    }
	}


	// Handles Button Click
	@Override
	public void handle(ActionEvent event) {
		if (event.getSource() instanceof Button) {
			Button btnClicked = (Button) event.getSource();

			// Opeing Window
			if (btnClicked.getText().equals("Enter")) {
				String enteredPlayerName = tfName.getText();
				lblWelcomePlayer.setText("Welcome " + enteredPlayerName + "!");
				window.setScene(playerSelectionScene());

			// Player Selection
			} else if (btnClicked.getText().equals("C.Ronaldo")) {
				window.setScene(goalkeeperSelectionScene());
			} else if (btnClicked.getText().equals("L.Messi")) {
				player.setName("L.Messi");
        		player.setNationality("Argentina");
				window.setScene(goalkeeperSelectionScene());
			} else if (btnClicked.getText().equals("P.Pogba")) {
				player.setName("P.Pogba");
        		player.setNationality("France");
				window.setScene(goalkeeperSelectionScene());
			} else if (btnClicked.getText().equals("Neymar")) {
				player.setName("Neymar");
        		player.setNationality("Brazil");
				window.setScene(goalkeeperSelectionScene());
			} else if (btnClicked.getText().equals("E.Hazard")) {
				player.setName("E.Hazard");
        		player.setNationality("Belgium");
				window.setScene(goalkeeperSelectionScene());
				
			// Goalkeeper Selection
			} if (btnClicked.getText().equals("D.de Gea")) {
				showPlayerGoalkeeper();
			} else if (btnClicked.getText().equals("J.Oblak")) {
				goalkeeper.setName("J.Oblak");
        		goalkeeper.setNationality("Slovenia");
				showPlayerGoalkeeper();
			} else if (btnClicked.getText().equals("M.ter Stegen")) {
				goalkeeper.setName("M.ter Stegen");
        		goalkeeper.setNationality("Germany");
				showPlayerGoalkeeper();
			} else if (btnClicked.getText().equals("T.Courtois")) {
				goalkeeper.setName("T.Courtois");
        		goalkeeper.setNationality("Belgium");
				showPlayerGoalkeeper();
			} else if (btnClicked.getText().equals("M.Neuer")) {
				goalkeeper.setName("M.Neuer");
        		goalkeeper.setNationality("Germany");
				showPlayerGoalkeeper();

			// Game Start
			} else if (btnClicked.getText().equals("Start Game")) {
				window.setScene(gameStartScene());

			} else if (btnClicked.getText().equals("1")) {
				int goalkeeperNum = goalkeeper.randGoalkeeperNum();
	            int playerStrength = player.randStrength();
	            int playerNum = 1;
	            decideOutcome(playerNum, goalkeeperNum, playerStrength);

			} else if (btnClicked.getText().equals("2")) {
				int goalkeeperNum = goalkeeper.randGoalkeeperNum();
	            int playerStrength = player.randStrength();
	            int playerNum = 2;
	            decideOutcome(playerNum, goalkeeperNum, playerStrength);

			} else if (btnClicked.getText().equals("3")) {
				int goalkeeperNum = goalkeeper.randGoalkeeperNum();
	            int playerStrength = player.randStrength();
	            int playerNum = 3;
	            decideOutcome(playerNum, goalkeeperNum, playerStrength);

			} else if (btnClicked.getText().equals("4")) {
				int goalkeeperNum = goalkeeper.randGoalkeeperNum();
	            int playerStrength = player.randStrength();
	            int playerNum = 4;
	            decideOutcome(playerNum, goalkeeperNum, playerStrength);

			} else if (btnClicked.getText().equals("5")) {
				int goalkeeperNum = goalkeeper.randGoalkeeperNum();
	            int playerStrength = player.randStrength();
	            int playerNum = 5;
	            decideOutcome(playerNum, goalkeeperNum, playerStrength);

			} else if (btnClicked.getText().equals("6")) {
				int goalkeeperNum = goalkeeper.randGoalkeeperNum();
	            int playerStrength = player.randStrength();
	            int playerNum = 6;
	            decideOutcome(playerNum, goalkeeperNum, playerStrength);

			} else if (btnClicked.getText().equals("Back to Game")) {
				lblShotNum.setText("Shot Number : " + shotNumCounter);
				lblShotsMade.setText("Shots Made: " + player.getPlayerScore());
				lblShotsMissed.setText("Shots Missed : " + goalkeeper.getGoalkeeperScore());
				if (shotNumCounter < 6) {
					window.setScene(gameStartScene());
				} else {
					if (player.getPlayerScore() > goalkeeper.getGoalkeeperScore()) {
        				lblFinalResult.setText("Congratulations! You Won!!");
       				} else {
        				lblFinalResult.setText("Sorry. You Lost.");
       				}
					window.setScene(finalScreenScene());
				}
			
			// End Game
			} else if (btnClicked.getText().equals("End Game")) {
				window.close();
			}
	  	}
	}

	// Sets up beggining of the game
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

	  	// Initialize
      	window.setTitle("Penalty Shootout");
      	window.setResizable(false);
   		window.setScene(startMenueScene());
      	window.show();
	}
}
