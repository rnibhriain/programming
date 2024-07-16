/* 1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5: 4
       Comment:
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5: 3
       Comment:
   3. Did I use easy-to-understand meaningful variable names?
       Mark out of 10: 4
       Comment:
   4. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5: 4
       Comment:
   5. Did I indent the code appropriately?
       Mark out of 10: 5
       Comment:
   6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose?
       Mark out of 20: 12
       Comment:
   7. Did I check the input to ensure that invalid input was handled appropriately?
       Mark out of 10: 4
       Comment:
   8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)?
       Mark out of 10: 6
       Comment:
   9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King?
       Mark out of 10: 2
       Comment:
   10. Did I report whether the user won or lost the game before the program finished?
       Mark out of 10: 2
       Comment:
   11. How well did I complete this self-assessment?
       Mark out of 5: 3
       Comment:  
   Total Mark out of 100 (Add all the previous marks): 49
 */

import java.util.Scanner;
import java.util.Random;


public class HiLowGame {
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	public static final int ACE = 14;
	public static final int MAXIMUM_CARD = 14;
	public static final int UNAVAILABLE = 1;
	public static final int LIMIT = 4;

	public static void main(String[] args) {

		Random  cardGenerator = new Random();
		int userScore = 0;
		int card;
		int numberGuessed = UNAVAILABLE;
		boolean quit=false;
		do
		{
			int computerNumber = cardGenerator.nextInt(MAXIMUM_CARD+1);
			int choice = input.nextInt(14);

			while (computerNumber != numberGuessed);
			{
				Scanner input = new Scanner( System.in );
				System.out.println("The card is " + computerNumber + "Do you think the next card will be higher, lower or equal?");


				if (card > numberGuessed) && (numberGuessed != card);
				System.out.println("Invalid input.  Try again.");

				if (card > numberGuessed) && (numberGuessed = card);
				System.out.println("Your score is " + userScore);
				userScore++;
				{


					if (input.hasNext("LIMIT"))
						quit = true;





				}while (!quit);



			}

		}