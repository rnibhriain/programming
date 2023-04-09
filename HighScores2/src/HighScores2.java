/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5:  5
        Yes all variable names were relevant and formatted correctly.

 2. Did I indent the code appropriately?

        Mark out of 5: 5
        Yes the code was indented using tabs.

 3. Did I write the initialiseHighScores function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 15:  15
       Yes the intialiseHighScores took the array as a parameter and used a for loop to set all values equal to 0. The return type was void.

 4. Did I write the printHighScores function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 15:  15
         Yes the printHighScores took the array as a parameter and used a for loop to print all values other than 0. The return type was void.

 5. Did I write the higherThan function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 15:  15
       yes the return type was boolean and it took the newScore and the array and used a for loop to check if the newScore was higher than any of the values.

 6. Did I write the insertScore function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  20
       Yes there return type was void and the parameters were the newScore and the array. The scores are inserted correctly.

 7. Did I write the main function body correctly (first asking for the number of scores to be maintained and then repeatedly asking for scores)?

       Mark out of 20:  20
       Yes first the number is asked for how many scores and then repeatedly for the new scores.

 8. How well did I complete this self-assessment?

        Mark out of 5:	5
        I answered all questions honestly.

 Total Mark out of 100 (Add all the previous marks):	100

 */ 

import java.util.Scanner;

public class HighScores2 {

	public static final String INVALID_INPUT = "You did not enter valid input.";
	public static final String QUESTION_ONE = "How many scores would you like to maintain?";
	public static final String QUESTION_TWO = "Enter a new score: ";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numberOfScores = 0;
		while (numberOfScores <= 0) {
			System.out.println(QUESTION_ONE);
			while (!scanner.hasNextInt()) {
				System.out.println(INVALID_INPUT);
				System.out.println(QUESTION_ONE);
				scanner.next();
			}
			numberOfScores = scanner.nextInt();
			if (numberOfScores <= 0) {
				System.out.println(INVALID_INPUT);
			}
		}
		int highScores [] = new int[numberOfScores];
		initialiseHighScores(highScores);
		boolean finished = false;
		int newScore = 0;
		while (!finished) {
			while (newScore <= 0) {
				System.out.println(QUESTION_TWO);
				if (!scanner.hasNextInt()) {
					System.out.println(INVALID_INPUT);
					scanner.next();
				}
				else {
					newScore = scanner.nextInt();
					if (newScore <= 0) {
						System.out.println(INVALID_INPUT);
					}
				}		
			}
			insertScore(newScore, highScores);
			printHighScores(highScores);
			newScore = 0;
		}
		scanner.close();
	}

	public static void initialiseHighScores (int [] highScores) {

		for (int count = 0; count < highScores.length; count++) {
			highScores [count] = 0;
		}

	}

	public static void printHighScores (int [] highScores) {
		System.out.print("The high scores are ");
		for (int count = 0; count < highScores.length && highScores [count] != 0; count++) {
			System.out.print(highScores[count] + ", ");
		}
		System.out.println();
	}

	public static boolean higherThan (int newScore, int [] highScores) {
		for (int count = 0; count < highScores.length; count++) {
			if (newScore > highScores[count]) {
				return true;
			}
		}
		return false;
	}

	public static void insertScore (int newScore, int [] highScores) {
		if (higherThan(newScore, highScores)) {
			for (int count = 0; count < highScores.length && newScore >0; count++) {
				if (highScores [count] == 0) {
					highScores [count] = newScore;
					newScore = -1;
				}
				else if (newScore > highScores [count]) {
					for (int newCount = highScores.length-1; newCount > count; newCount--) {
						highScores[newCount] = highScores[newCount-1];
					}
					highScores [count] = newScore;
					newScore = -1;
				}
			}
		}
	}
}