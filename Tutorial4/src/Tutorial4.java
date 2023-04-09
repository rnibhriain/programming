import java.util.Scanner;


public class Tutorial4 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("What integer would you like the multiples of?");
		int firstNumber = input.nextInt();
		while (firstNumber <= 0) {
			System.out.println("get fucked try again.");
			firstNumber = input.nextInt();
		}
		System.out.println("What integer would you like the multiples to be supplied up to?");
		int secondNumber = input.nextInt();
		while (secondNumber <= 0) {
			System.out.println("get fucked try again.");
			secondNumber = input.nextInt();
		}
		System.out.print("The multiples of " + firstNumber + " (up to " + secondNumber + ") are ");
		for (int count = 0; count < secondNumber ; count += firstNumber ) {
			System.out.print(count + ", ");
		}
		input.close();
	}

}
