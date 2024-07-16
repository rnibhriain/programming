import java.util.Scanner;

public class NumbersFactorian {

	public static final String INVALID_INPUT = "You did not enter valid input.";
	public static final String QUIT = "quit";
	public static final String QUESTION_ONE = "Enter a number.(or enter quit)";

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean finished = false;
		int number = 0;

		while (!finished) {
			System.out.println(QUESTION_ONE);
			while ((!input.hasNextInt() && !finished)) {
				String inputString = input.next();
				if (QUIT.equalsIgnoreCase(inputString)) {
					finished = true;
				} else {
					System.out.println(INVALID_INPUT);
					System.out.println(QUESTION_ONE);
				}
			}
			number = input.nextInt();
			if (isFactorian(number)) {
				System.out.println(number + " is a Factorian.");
			}
			else {
				System.out.println(number + " is not a Factorian.");
			}
		}
		input.close();
	}

	public static int computeFactorial (int number) {
		int answer = number;
		if (number == 1) {
			answer = 1;
		}
		else {
			answer =  answer * computeFactorial(number-1);
		}
		return answer;
	}

	public static boolean isFactorian (int number) {
		int check = 0;
		int answer = 0;
		int numberCopy = number;
		while (numberCopy !=0) {
			check = numberCopy % 10;
			numberCopy = numberCopy / 10;
			answer += computeFactorial(check);
		}
		if (answer == number) {
			return true;
		}
		return false;
	}
}
