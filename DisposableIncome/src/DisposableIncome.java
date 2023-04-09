/*  SELF ASSESSMENT
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 10:   10
       Comment: Yes i used constants in place of direct values.
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5: 5 
       Comment: yes all constant names were relevant.
    3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5:  5
       Comment: All constants were formatted in uppercase.
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:  10
       Comment: All variable names were relevant.
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 10:  10
       Comment: All variable names were formatted in lowerCamelCase
   6. Did I indent the code appropriately?
       Mark out of 10:  10
       Comment: All code was indented properly.
   7. Did I read the input correctly from the user using appropriate question(s)?
       Mark out of 10:  10
       Comment: Yes the input was read using appropriate questions.
   8. Did I compute the disposable income correctly?
       Mark out of 10:  10
       Comment: Yes the disposable income was computed correctly.
   9. Did I compute the disposable income percentage correctly?
       Mark out of 10:  10
       Comment: Yes the disposable income percentage was computed correctly.
   10. Did I output the correct answer in the correct format (as shown in the examples)?
       Mark out of 10:  10
       Comment: Yes the format of the output was as shown.
   11. How well did I complete this self-assessment?
       Mark out of 10:  10
       Comment: I answered all questions honestly.
   Total Mark out of 100 (Add all the previous marks):  100
*/

import java.util.Scanner;

public class DisposableIncome {

	public static final double TAX = 0.65;
	public static final int PERCENTAGE = 100;
	public static final String FIRST_QUESTION = "How much are you paid a month before tax?";
	public static final String SECOND_QUESTION = "How much do you pay in rent/mortgage a month?";
	public static final String THIRD_QUESTION = "How much does your commute cost a month?";
	public static final String FOURTH_QUESTION = "How much do you spend on food per month?";

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
		System.out.println("Your monthly disposable income is €" + 
				String.format( "%.2f" ,((income * TAX) - rent - commute - food)) + " which is " + 
				String.format( "%.2f" ,((((income * TAX) - rent - commute - food)/income)*PERCENTAGE)) 
				+ "% of your salary." );
		input.close();

	}

}
