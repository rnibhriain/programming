/* SELF ASSESSMENT
   1. Did I use easy-to-understand meaningful variable and CONSTANT names? 
       Mark out of 10:10
       Comment:Yes all variable and constant names were relevant.
   2. Did I format the variable and CONSTANT names properly (in lowerCamelCase and UPPERCASE_WITH_UNDERSCORES)?
       Mark out of 10:10
       Comment:Yes all the variable and constant names were formatted correctly.
   3. Did I indent the code appropriately?
       Mark out of 10:10
       Comment:All the code was indented correctly.
   4. Did I read the input correctly from the user using appropriate questions?
       Mark out of 15:15
       Comment:Yes the input was taken from the user in the console using appropriate questions.
   5. Did I computer the disposable income and disposable income percentage correctly, and output it in the correct format?
       Mark out of 15:15
       Comment:Yes the disposable income and disposable income percentage was calculated and outputted correctly.
  6. Did I use an appropriate series of if statements to generate the income analysis to the user?
       Mark out of 25:25
       Comment:Yes i used nested if statements to analyse the income.
   7. Did I provide the correct output for each possibility in an easy to read format?
       Mark out of 10:10
       Comment:Yes all output was accurate and easy to read.
   8. How well did I complete this self-assessment?
       Mark out of 5:5
       Comment:I answered all questions honestly.
   Total Mark out of 100 (Add all the previous marks):
*/

import java.util.Scanner;

public class AnalysingDisposableIncome {

	public static final double TAX = 0.65;
	public static final int PERCENTAGE = 100;
	public static final String FIRST_QUESTION = "How much are you paid a month before tax?";
	public static final String SECOND_QUESTION = "How much do you pay in rent/mortgage a month?";
	public static final String THIRD_QUESTION = "How much does your commute cost a month?";
	public static final String FOURTH_QUESTION = "How much do you spend on food per month?";
	public static final int AVERAGE_DISPOSABLE_INCOME = 500;
	public static final double FIFTY_PERCENT_LOWER = 0.5;
	public static final double FIFTY_PERCENT_HIGHER = 1.5;
	

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println(FIRST_QUESTION);
		double income = input.nextDouble();
		System.out.println(SECOND_QUESTION);
		double rent = input.nextDouble();
		System.out.println(THIRD_QUESTION);
		double commute = input.nextDouble();
		System.out.println(FOURTH_QUESTION);
		double food = input.nextDouble();
		double disposableIncome = ((income * TAX) - rent - commute - food);
		System.out.println("Your monthly disposable income is €" + 
				String.format( "%.2f" ,disposableIncome) + " which is " + 
				String.format( "%.2f" ,((disposableIncome/income)*PERCENTAGE)) 
				+ "% of your salary." );
		if (disposableIncome == AVERAGE_DISPOSABLE_INCOME) {
			System.out.println("You have exactly the average disposable per month.");
		}
		else if (disposableIncome < AVERAGE_DISPOSABLE_INCOME) {
			if (disposableIncome <= (AVERAGE_DISPOSABLE_INCOME *FIFTY_PERCENT_LOWER)) {
				System.out.println("You have much less than the average disposable per month.");
			}
			else if (disposableIncome == 0) {
				System.out.println("You have no disposable per month.");
			}
			else {
				System.out.println("You have less than the average disposable per month.");
			}
		}
		else if (disposableIncome > AVERAGE_DISPOSABLE_INCOME) {
			if (disposableIncome >= (AVERAGE_DISPOSABLE_INCOME *FIFTY_PERCENT_HIGHER)) {
				System.out.println("You have much more than the average disposable per month.");
			}
			else {
				System.out.println("You have more than the average disposable per month.");
			}
		}
		input.close();

	}

}
