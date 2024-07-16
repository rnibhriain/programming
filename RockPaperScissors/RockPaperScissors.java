/* SELF ASSESSMENT
   1. Did I use appropriate easy-to-understand, meaningful variables and CONSTANTS within the code? 
       Mark out of 10:10
       Comment:Yes all variables were easy to understand.
   2. Did I format the variable and CONSTANT names appropriate (in lowerCamelCase and UPPERCASE)?
       Mark out of 5:5
       Comment:All variable and constant names were relevant and formatted correctly.
   3. Did I generate the computer's choice in each game correctly using a Random number generator?
       Mark out of 10:10
       Comment:The computer's choice was chosen using a Random number generator.
   4. Did I input the user's choice in each game correctly?
       Mark out of 10:10
       Comment:Yes the user's choice was inputted correctly in each game.
   5. Did I correctly compare the choices and update the score appropriately?
       Mark out of 20:20
       Comment:All choices were compared correctly and the score updated.
   6. Did I inform the user of who won each game (and why) correctly?
       Mark out of 10:10 
       Comment:Yes the user is told who won each game and why
   7. Did I use an appropriate for loop to allow the player to play 5 games?  There should be only one loop.
       Mark out of 20: 20
       Comment:There was only one for loop used to allow the game to be played 5 times.
   8. Did I output the final scores correctly after the 5 games were played. 
       Mark out of 10: 10
       Comment:Yes the final score were outputted correctly after the 5 games were finished.
   9. How well did I complete this self-assessment?
       Mark out of 5:5
       Comment:I answered all questions honestly. 
   Total Mark out of 100 (Add all the previous marks):100
 */
import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

	public static final String FIRST_QUESTION = "Enter 1 (for Rock) or 2 (for Paper) or 3 (for Scissors): ";
	public static final String DRAW_OUTPUT = "This round was a draw as I chose ";
	public static final String WIN_OUTPUT = "You won this round as I chose ";
	public static final String LOSE_OUTPUT = "You lost this round as I chose ";
	public static final String SCORE_OUTPUT = "The final score was Computer: ";
	public static final int ROCK = 0;
	public static final int SCISSORS = 2;
	public static final int CHOICES = 3;

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		Random generator = new Random();
		int computerScore = 0;
		int userScore = 0;
		int userChoice = 0;
		int computerChoice = 0;
		String computerOption = "";

		for (int count = 0; count < 5; count++) {

			System.out.print(FIRST_QUESTION);
			userChoice = input.nextInt()-1;
			computerChoice = generator.nextInt(CHOICES);

			if (computerChoice == 0) {
				computerOption = "Rock";
			}
			else if (computerChoice == 1) {
				computerOption = "Paper";
			}
			else {
				computerOption = "Scissors";
			}

			if (userChoice == computerChoice) {
				System.out.println(DRAW_OUTPUT + computerOption + " too");
			}
			else if (userChoice > computerChoice || (userChoice == 
					SCISSORS  && computerChoice == ROCK)) {
				System.out.println(WIN_OUTPUT + computerOption);
				userScore++;
			}
			else {
				System.out.println(LOSE_OUTPUT + computerOption);
				computerScore++;

			}	
		}

		System.out.println(SCORE_OUTPUT + computerScore + " User: " + userScore);
		input.close();
	}
}
