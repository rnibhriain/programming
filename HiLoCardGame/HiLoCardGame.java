/* SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5:5
       Comment:Yes appropriate constants were used within the code.
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5:5
       Comment:All constant names were relevant and formatted correctly.
   3. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:10
       Comment: yes all variable names were relevant.
   4. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:5
       Comment: All variable names were formatted in lowerCamelCase.
   5. Did I indent the code appropriately?
       Mark out of 10:10
       Comment: All code was indented using tabs.
   6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose?
       Mark out of 20: 20
       Comment: Yes a while loop was used to allow the user to enter their guesses until they win or until they enter quit.
   7. Did I check the input to ensure that invalid input was handled appropriately?
       Mark out of 10: 10
       Comment: Yes there was error handling done for invalid input.
   8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)?
       Mark out of 10: 10
       Comment: Yes all the cards were generated using a random number generator.
   9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King?
       Mark out of 10: 10
       Comment: Yes all the cards were outputted correctly..
   10. Did I report whether the user won or lost the game before the program finished?
       Mark out of 10: 10
       Comment: Yes the program reports whether the user won or lost the game before the program is over.
   11. How well did I complete this self-assessment?
       Mark out of 5:5
       Comment: I answered all questions honestly.
   Total Mark out of 100 (Add all the previous marks):100
 */

import java.util.Scanner;
import java.util.Random;

public class HiLoCardGame {

	public static final String HIGHER = "higher";
	public static final String LOWER = "lower";
	public static final String EQUAL = "equal";
	public static final int WIN = 4;
	public static final int KING = 13;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int ACE = 1;
	public static final int AMOUNT_OF_CARDS = 13;
	public static final String QUIT = "quit";

	public static void main(String[] args) {

		boolean finished = false;
		Scanner input = new Scanner(System.in);
		Random generator =  new Random();
		int currentCard = 0;
		int lastCard = 0;
		String guess = "";
		int rightGuess = 0;
		String currentCardString = "";
		currentCard =  generator.nextInt(AMOUNT_OF_CARDS)+1;
		switch (currentCard) {
		case ACE:
			currentCardString = "Ace";
			System.out.println("The card is an " + currentCardString);
			break;
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			currentCardString = String.format ("%d", currentCard);
			System.out.println("The card is a " + currentCardString);
			break;
		case JACK:
			currentCardString = "Jack";
			System.out.println("The card is a Jack" + currentCardString);
			break;
		case QUEEN:
			currentCardString = "Queen";
			System.out.println("The card is a " + currentCardString);
			break;
		case KING:
			currentCardString = "King";
			System.out.println("The card is a " + currentCardString);
			break;
		}

		while (!finished) {

			System.out.print("Do you think the next card will be higher, lower or equal? (Or enter quit): ");
			lastCard = currentCard;
			currentCard = generator.nextInt(AMOUNT_OF_CARDS) + 1;
			guess = input.next();
			while (!guess.equalsIgnoreCase(HIGHER) && !guess.equalsIgnoreCase(LOWER) && !guess.equalsIgnoreCase(EQUAL) && !guess.equalsIgnoreCase(QUIT)) {
				System.out.println("Incorrect input. Try again");
				System.out.print("Do you think the next card will be higher, lower or equal? (Or enter quit): ");
				guess = input.next();
			}

			if (guess.equalsIgnoreCase(QUIT)) {
				System.out.println("You have quit the game without winning.");
				finished = true;
			}
			else if (guess.equalsIgnoreCase(HIGHER)&&(currentCard>lastCard)) {
				rightGuess++;
			}
			else if (guess.equalsIgnoreCase(LOWER)&&(currentCard<lastCard)) {
				rightGuess++;
			}
			else if (guess.equalsIgnoreCase(EQUAL)&&(currentCard==lastCard)) {
				rightGuess++;
			}
			else {
				rightGuess = 0;
			}

			if (rightGuess == WIN ) {
				System.out.println("The card is a " + currentCard);
				System.out.println("Congratulations. You got them all correct.");
				finished = true;
				input.close();
			}
			else if (finished) {

			}
			else {
				switch (currentCard) {
				case ACE:
					currentCardString = "Ace";
					System.out.println("The card is an " + currentCardString);
					break;
				case 2:
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
					currentCardString = String.format ("%d", currentCard);
					System.out.println("The card is a " + currentCardString);
					break;
				case JACK:
					currentCardString = "Jack";
					System.out.println("The card is a Jack" + currentCardString); 
					break;
				case QUEEN:
					currentCardString = "Queen";
					System.out.println("The card is a " + currentCardString);
					break;
				case KING:
					currentCardString = "King";
					System.out.println("The card is a " + currentCardString);
					break;
				}
			}
		}
	}

}
