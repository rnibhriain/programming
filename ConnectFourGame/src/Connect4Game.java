/* SELF ASSESSMENT

Connect4Game class (35 marks):	35
My class creates references to the Connect 4 Grid and two Connect 4 Players. 
It asks the user whether he/she would like to play/quit inside a loop. 
If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface,
 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. 
 In the game, I ask the user where he/she would like to drop the piece. 
 I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment: Yes it asks the user to play or quit
		 - The connect4Grid2DArray is created which implements the interface
		 - The two players are initialised depending on how many the user wants
		 - The user is asked what column they would like to drop the piece in and the methods are called to 
		 	check if the column is appropriate
		 -  A check is performed after each piece is dropped to see if there was a win

Connect4Grid interface (10 marks):	10
I define all 7 methods within this interface.
Comment: All seven methods are defined within the interface.

Connect4Grid2DArray class (25 marks):	25
My class implements the Connect4Grid interface. 
It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. 
It provides as implementation of the method to check whether the column to drop the piece is full. 
It provides as implementation of the method to drop the piece.  
It provides as implementation of the method to check whether there is a win.
Comment: The class implements the interface
		- It creates a grid using a 2D char array and checks whether the column to drop the piece is valid.
		- It checks whether the column to drop the piece is full.
		- It has a method to 'drop' the piece into the char array
		- It has a method to check if there is a win on the last piece dropped

ConnectPlayer abstract class (10 marks):	10
My class provides at lest one non-abstract method and at least one abstract method. 
Comment: There is one abstract method (setChoice) and several non-abstract methods.

C4HumanPlayer class (10 marks):	10
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
Comment: The class extends the Connect Player class and overrides the abstract method to set a choice.
		- It gives the user the option to choose a column

C4RandomAIPlayer class (10 marks): 10
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 
Comment: The class extends ConnectPlater and overrides the abstract method (setChoice)
		- It gives a random appropriate column as a number

Total Marks out of 100:	100

 */
import java.util.Scanner;

public class Connect4Game {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Connect4Grid2DArray theArray = new Connect4Grid2DArray();
		boolean chosen = false;
		int playerChoice = 0;
		boolean playGame = true;
		while (playGame) {
			System.out.println("Welcome to Connect Four.");
			boolean choiceMade = false;
			while (!choiceMade) {
				System.out.println("Would you like to play or quit?");
				String play = input.next();
				if (play.equalsIgnoreCase("quit")) {
					choiceMade = true;
					playGame = false;
				}
				else if (play.equalsIgnoreCase("play")) {

				}
				else {
					System.out.println("Incorrect Input.");
				}
			}
			if (playGame) {
				while (!chosen) {
					System.out.println("Choose how many players you want (0, 1, 2): ");
					if (!input.hasNextInt()) {
						input.next();
						System.out.println("Incorrect Input.");
					} 
					else {
						playerChoice = input.nextInt();
						if (playerChoice == 0 || playerChoice == 1 || playerChoice ==2) {
							chosen =  true;
						}
						else {
							System.out.println("Incorrect Input.");
						}
					}
				}

				ConnectPlayer playerOne;
				ConnectPlayer playerTwo;

				if (playerChoice == 0) {
					playerOne = new C4RandomAIPlayer('R');
					playerTwo = new C4RandomAIPlayer('Y');
				} 
				else if (playerChoice == 1) {
					chosen = false;
					while (!chosen) {
						System.out.println("Choose what colour you want (R = 1, Y = 2): ");
						if (!input.hasNextInt()) {
							input.next();
							System.out.println("Incorrect Input.");
						} 
						else {
							playerChoice = input.nextInt();
							if (playerChoice == 1 || playerChoice ==2) {
								chosen =  true;
							}
							else {
								System.out.println("Incorrect Input.");
							}
						}
					}
					if (playerChoice == 1) {
						playerOne = new C4HumanPlayer('R');
						playerTwo = new C4RandomAIPlayer('Y');
					}
					else {
						playerOne = new C4HumanPlayer('Y');
						playerTwo = new C4RandomAIPlayer('R');
					}
				}
				else {
					chosen = false;
					while (!chosen) {
						System.out.println("Choose what colour you want (R = 1, Y = 2): ");
						if (!input.hasNextInt()) {
							input.next();
							System.out.println("Incorrect Input.");
						} 
						else {
							playerChoice = input.nextInt();
							if (playerChoice == 1 || playerChoice ==2) {
								chosen =  true;
							}
							else {
								System.out.println("Incorrect Input.");
							}
						}
					}
					if (playerChoice == 1) {
						playerOne = new C4HumanPlayer('R');
						playerTwo = new C4HumanPlayer('Y');
					}
					else {
						playerOne = new C4HumanPlayer('Y');
						playerTwo = new C4HumanPlayer('R');
					}
				}
				boolean finished = false;
				theArray.emptyGrid();
				while (!finished||theArray.isGridFull()) {
					System.out.print(theArray.toString());
					playerOne.setChoice(theArray);
					theArray.dropPiece(playerOne, playerOne.getChoice());
					System.out.println("Player One has chosen column: " + playerOne.getChoice());
					System.out.print(theArray.toString());
					if (theArray.didLastPieceConnect4()) {
						System.out.println("Congratulations Player One. You Win!");
						finished = true;
					}
					playerTwo.setChoice(theArray);
					theArray.dropPiece(playerTwo, playerTwo.getChoice());
					System.out.println("Player Two has chosen column: " + playerTwo.getChoice());
					System.out.print(theArray.toString());
					if (theArray.didLastPieceConnect4()) {
						System.out.println("Congratulations Player Two. You Win!");
						finished = true;
					}





					if (theArray.isGridFull()) {
						finished = true;
						System.out.println("The grid is Full");
					}
				}
				System.out.println("You have finished the game.");
			}

		}

		input.close();
	}

}
