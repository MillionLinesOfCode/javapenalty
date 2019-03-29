import java.util.Scanner;
import java.util.Random;

public class AnimationApp {
	// Main Method
	public static void main(String[] args) {
		System.out.println("Welcome to the Penalty Shootout Game!");

		Scanner keyboard = new Scanner(System.in); //Takes input from the user, specifically his/her name.
		System.out.print("Please enter your name: ");
		String playerName = keyboard.nextLine(); //Reads what the user types in field.
		System.out.println("");
		System.out.println("Welcome " + playerName + "!");
		System.out.println("");
		
		// Player Selection
		System.out.println("Please Choose your player to take the penalties.");
		System.out.println("1- C.Ronaldo\n" +"2- L.Messi\n"+"3- P.Pogba\n"+"4- Neymar\n"+"5- E.Hazard\n");
		System.out.print("Please enter a number between 1 and 5: ");//To choose the player with whom you will (try) to score
        
        Player player = new Player();
        boolean playerIntCheck = false;
        while(playerIntCheck == false){
        	String playerOption = keyboard.nextLine();
		//Case should be a better option
        	if (playerOption.equals("1")) {
        		System.out.println("");
        		System.out.println("Great! You chose " + player.getName() + ".");
        		break;
        	} else if (playerOption.equals("2")) {
        		System.out.println("");
        		player.setName("L.Messi");
        		player.setNationality("Argentina");
				System.out.println("Great! You chose " + player.getName() + ".");
        		break;
        	} else if (playerOption.equals("3")) {
        		System.out.println("");
        		player.setName("P.Pogba");
        		player.setNationality("France");
		    	System.out.println("Great! You chose " + player.getName() + ".");
        		break;
        	} else if (playerOption.equals("4")) {
        		System.out.println("");
        		player.setName("Neymar");
        		player.setNationality("Brazil");
		    	System.out.println("Great! You chose " + player.getName() + ".");
        		break;
        	} else if (playerOption.equals("5")) {
        		System.out.println("");
        		player.setName("E.Hazard");
        		player.setNationality("Belgium");
		    	System.out.println("Great! You chose " + player.getName() + ".");
        		break;
        	} else {
        		System.out.print("Error! Please enter a valid number: ");
        	}
        }
		
	// Goalkeeper Selection
        System.out.println("");
        System.out.println("Choose your favorite goalkeeper to save the penalties.");
        System.out.println("1- D.de Gea\n"+"2- J.Oblak\n"+"3- M.ter Stegen\n" +"4- T.Courtois\n"+"5- M.Neuer\n");
        System.out.print("Please enter a number between 1 and 5: "); //To choose the goalkeeper you want to face off against

        Goalkeeper goalkeeper = new Goalkeeper();
        while(playerIntCheck == false){
        	String playerOption = keyboard.nextLine();
        	if (playerOption.equals("1")) {
        		System.out.println("");
                System.out.println("Cool! You chose " + goalkeeper.getName() + ".");
        		break;
        	} else if (playerOption.equals("2")) {
        		System.out.println("");
        		goalkeeper.setName("J.Oblak");
        		goalkeeper.setNationality("Slovenia");
                System.out.println("Cool! You chose " + goalkeeper.getName() + ".");
        		break;
        	} else if (playerOption.equals("3")) {
        		System.out.println("");
        		goalkeeper.setName("M.ter Stegen");
        		goalkeeper.setNationality("Germany");
                System.out.println("Cool! You chose " + goalkeeper.getName() + ".");
        		break;
        	} else if (playerOption.equals("4")) {
        		System.out.println("");
        		goalkeeper.setName("T.Courtois");
        		goalkeeper.setNationality("Belgium");
                System.out.println("Cool! You chose " + goalkeeper.getName() + ".");
        		break;
        	} else if (playerOption.equals("5")) {
        		System.out.println("");
        		goalkeeper.setName("M.Neuer");
        		goalkeeper.setNationality("Germany");
                System.out.println("Cool! You chose " + goalkeeper.getName() + ".");
        		break;
        	} else {
        		System.out.print("Error! Please enter a valid number: ");
        	}
        }
        
        System.out.println("");
        System.out.println("");
        System.out.println("Game Start!"); //Self explanatory
        System.out.println("");

   		// Shooting
        System.out.println(    " ____________________________  \n" +
                               "|         |        |         | \n" +
                               "|    1    |   2    |    3    | \n" +
                               "|_________|________|_________| \n" +
                               "|         |        |         | \n" +
                               "|    4    |   5    |    6    | \n" +
                               "|_________|________|_________| \n");

        System.out.println(""); //Its a text based version, had to make do with what was available!

        for (int i = 0; i < 5; i++) {
        	System.out.print("Choose a number to take a shot #" + (i + 1) + ": ");//each number corresponds to a section in the goal.
            String shotInput = keyboard.nextLine();

            if (shotInput.equals("1") || shotInput.equals("2") || shotInput.equals("3") || shotInput.equals("4") || shotInput.equals("5") || shotInput.equals("6")) {
            	int goalkeeperNum = goalkeeper.randGoalkeeperNum();
            	int playerStrength = player.randStrength();
            	System.out.println("");

            	if (shotInput.equals(goalkeeperNum + "") && (playerStrength <= 74 || playerStrength >= 80)) {
            		System.out.println("Shot was saved by the goalkeeper. Shot Missed.");
            		goalkeeper.setGoalkeeperScore(1);
            	} else if (shotInput.equals(goalkeeperNum + "") && (playerStrength >= 75 && playerStrength <= 79)) {
            		System.out.println("Shot overpowered the goalkeeper. Goal!");
            		player.setPlayerScore(1);
            	} else if (shotInput.equals(goalkeeperNum + "") == false && (playerStrength >= 60 && playerStrength <= 79)) {
            		System.out.println("Goal!!");
            		player.setPlayerScore(1);
            	} else if (shotInput.equals(goalkeeperNum + "") == false && (playerStrength >= 1 && playerStrength <= 59)) {
            		Random rand = new Random();
					int n = rand.nextInt(2);
					if (n == 1) {
						System.out.println("The shot was too weak. Shot Missed.");
						goalkeeper.setGoalkeeperScore(1);
					} else {
						System.out.println("Goal!!");
						player.setPlayerScore(1);
					}
            	} else if (shotInput.equals(goalkeeperNum + "") == false && (playerStrength >= 80 && playerStrength <= 89)) {
            		System.out.println("The ball hit the post. Shot Missed.");
            		goalkeeper.setGoalkeeperScore(1);
            	} else if (shotInput.equals(goalkeeperNum + "") == false && (playerStrength >= 90 && playerStrength <= 100)) {
            		System.out.println("The shot was too strong and went outside the goal. Shot Missed.");
            		goalkeeper.setGoalkeeperScore(1);
            	} else {
            		System.out.println("Shot Missed.");
            		goalkeeper.setGoalkeeperScore(1);
            	}
            	System.out.println("");
            } else {
            	while(playerIntCheck == false) {
                	System.out.print("Error! Please enter a valid number: ");
                	shotInput = keyboard.nextLine();

                	if (shotInput.equals("1") || shotInput.equals("2") || shotInput.equals("3") || shotInput.equals("4") || shotInput.equals("5") || shotInput.equals("6")) {
		            	int goalkeeperNum = goalkeeper.randGoalkeeperNum();
		            	int playerStrength = player.randStrength();
		            	System.out.println("");

		            	if (shotInput.equals(goalkeeperNum + "") && (playerStrength <= 74 || playerStrength >= 80)) {
		            		System.out.println("Shot was saved by the goalkeeper. Shot Missed.");
		            		goalkeeper.setGoalkeeperScore(1);
		            	} else if (shotInput.equals(goalkeeperNum + "") && (playerStrength >= 75 && playerStrength <= 79)) {
		            		System.out.println("Shot overpowered the goalkeeper. Goal!");
		            		player.setPlayerScore(1);
		            	} else if (shotInput.equals(goalkeeperNum + "") == false && (playerStrength >= 60 && playerStrength <= 79)) {
		            		System.out.println("Goal!!");
		            		player.setPlayerScore(1);
		            	} else if (shotInput.equals(goalkeeperNum + "") == false && (playerStrength >= 1 && playerStrength <= 59)) {
		            		Random rand = new Random();
							int n = rand.nextInt(2);
							if (n == 1) {
								System.out.println("The shot was too weak. Shot Missed.");
								goalkeeper.setGoalkeeperScore(1);
							} else {
								System.out.println("Goal!!");
								player.setPlayerScore(1);
							}
		            	} else if (shotInput.equals(goalkeeperNum + "") == false && (playerStrength >= 80 && playerStrength <= 89)) {
		            		System.out.println("The ball hit the post. Shot Missed.");
		            		goalkeeper.setGoalkeeperScore(1);
		            	} else if (shotInput.equals(goalkeeperNum + "") == false && (playerStrength >= 90 && playerStrength <= 100)) {
		            		System.out.println("The shot was too strong and went outside the goal. Shot Missed.");
		            		goalkeeper.setGoalkeeperScore(1);
		            	} else {
		            		System.out.println("Shot Missed.");
		            		goalkeeper.setGoalkeeperScore(1);
		            	}
		            	System.out.println("");
                		break;
                	}
            	}
            }
        }

        System.out.println("");
        if (player.getPlayerScore() > goalkeeper.getGoalkeeperScore()) {
		//Self explanatory stuff
        	System.out.println("Congratulations! You Won!!");
        } else {
        	System.out.println("Sorry. You Lost.");
        }
        System.out.println("");

	}
}
