import java.util.Scanner;

public class StandardDeviation {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter three numbers seperated by a space.");
		double number1 = input.nextDouble();
		double number2 = input.nextDouble();
		double number3 = input.nextDouble();
		double average = (number1 + number2 + number3 ) / 3;
		double standardDeviation = Math.sqrt((((number1 - average)*(number1 - average)) +  ((number2 - average)*(number2 - average)) + 
				((number3 - average) *(number3 - average))) / 3);
		System.out.print("Your average is: " + average  + ". Your standard deviation is: " + standardDeviation);
		input.close();
		
	}

}
