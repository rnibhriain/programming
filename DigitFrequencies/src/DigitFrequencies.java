import java.util.Scanner;

public class DigitFrequencies {

	public static void main(String[] args) {

		int [] frequencies = new int[10];
		Scanner scanner = new Scanner(System.in);
		int number = 0;
		boolean finished = false;
		while (!finished) {
			System.out.println("Enter a number > ");
			while (!scanner.hasNextInt()) {
				System.out.println("Invalid Input");
				System.out.println("Enter a number > ");
				scanner.next();
			}
			number = scanner.nextInt();
			if (number < 0) {
				System.out.println("Invalid Input");
			}
			else {
				countDigitFrequencies(number, frequencies);
				printDigitFrequencies(frequencies);
			}

		}
		scanner.close();
	}

	public static void countDigitFrequencies (int number, int[ ] frequencies) {

		int currentDigit = 0;

		while (number!=0) {
			currentDigit = number % 10;
			number /= 10;
			frequencies [currentDigit]++;
		}

	}

	public static void printDigitFrequencies (int[ ] frequencies) {
		System.out.print("Digit Frequencies: ");
		for (int count = 0; count <frequencies.length; count ++) {
			if (frequencies[count] != 0) {
				System.out.print(count + "(" + frequencies[count] + ") ");
			}
		}
		System.out.println();
	}



}
