import java.util.Scanner;

public class AnotherTutorial {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		input.useDelimiter(", ");
		System.out.println("Enter numbers seperated by a comma!");
		double minimum = 0;
		double maximum = 0;
		double numberEntered = input.nextDouble();
		boolean finished =  false;

		while (!finished) {
			numberEntered = input.nextDouble();
			if (numberEntered > maximum) {
				maximum = numberEntered;
			}
			else if (numberEntered < minimum) {
				minimum = numberEntered;
			}
			if (!input.hasNext()) {
				finished = true;
			}
		}
		System.out.println("The max is: " + maximum);
		System.out.println("The min is: " + minimum);
		input.close();
	}

}