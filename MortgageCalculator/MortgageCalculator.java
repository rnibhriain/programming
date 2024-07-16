/* 1. Did I use easy-to-understand meaningful properly formatted, variable names and CONSTANTS?
        Mark out of 10: 10
        Comment:   Yes all variable and constant names were relevant and formatted correctly.
 2. Did I indent the code appropriately?
        Mark out of 5: 5
        Comment:   All code was indented using tabs.
 3. Did I implement the main-line correctly with a loop which continues using the user says "no" ?
       Mark out of 10: 10
        Comment:  The while loop finished when the user enters "no".
 4. Did I obtain the relevant inputs from the user and produce the relevant outputs using the specified prompts & formats ?
       Mark out of 10: 10
        Comment: Yes the input was obtained using the readDoubleFromUser function and a Scanner.
 5. Did I implement the readDoubleFromUser function correctly and in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment:  The readDoubleFromUser uses a recursive function to get the correct input from the user.
 6. Did I implement the calculateMonthlyRepayment function correctly in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment:  The calculateMonthlyRepayment returns the monthly re-payment back assuming the mortgage is for 20 years.
 7. Did I implement the calculateMonthsToRepayMortgage function correctly in a manner that can be easily understood (4 marks for function definition, 4 marks for function call and 12 marks for function implementation)?
       Mark out of 20: 20
        Comment:  The calculate months to repay returns the amount of months it will take to reoay the mortgage assuming a fixed amount is paid each month.
 8. How well did I complete this self-assessment?
        Mark out of 5: 5
        Comment:	I answered all questions honestly.
 Total Mark out of 100 (Add all the previous marks): 100
 */ 

import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class MortgageCalculator {

	public static final String QUESTION_ONE = "Please enter the mortgage amount: ";
	public static final String QUESTION_TWO = "Please enter the annual interest rate (APR): ";
	public static final String QUESTION_THREE = "How much can you afford to pay per month? ";
	public static final String QUESTION_FOUR = "Would you like to use the mortgage calculator again (yes/no)? ";
	private static DecimalFormat df = new DecimalFormat("0.00");

	public static void main(String[] args) {

		double mortgageAmount = 0;
		double interestRate = 0;
		double amountPossibleToPayPerMonth = 0;
		String reply = "";
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to the mortgage calculator.");

		boolean finished = false; 

		while (!finished) {

			mortgageAmount = readDoubleFromUser(QUESTION_ONE);
			interestRate = readDoubleFromUser(QUESTION_TWO);
			System.out.println("Assuming a 20 year term, the monthly repayments would be " + df.format(calculateMonthlyRepayment(mortgageAmount, interestRate)));
			amountPossibleToPayPerMonth = readDoubleFromUser(QUESTION_THREE);
			System.out.println("If you pay " + amountPossibleToPayPerMonth + " per month your mortgage would be paid off in " + 
					(calculateMonthsToRepayMortage(mortgageAmount, interestRate, amountPossibleToPayPerMonth)- (calculateMonthsToRepayMortage(mortgageAmount, interestRate, amountPossibleToPayPerMonth)%12))/12 + " years and " + 
					calculateMonthsToRepayMortage(mortgageAmount, interestRate, amountPossibleToPayPerMonth)%12 + " months.");
			System.out.println(QUESTION_FOUR);
			reply = input.next();
			while (!reply.equalsIgnoreCase("yes") || !reply.equalsIgnoreCase("no")) {
				System.out.println("Invalid Input");
				System.out.println(QUESTION_FOUR);
				reply = input.next();
			}
			if (reply.equalsIgnoreCase("no")) {
				finished = true;
			}
		}
		input.close();
	}

	public static double readDoubleFromUser (String question) {
		Scanner input = new Scanner(System.in);
		double numberInputted = 0;
		System.out.println(question);
		if (!input.hasNextDouble()) {
			System.out.println("Invalid Input");
			return readDoubleFromUser(question);
		}
		else {
			numberInputted = input.nextDouble();
			if (numberInputted < 0) {
				System.out.println("Invalid Input");
				return readDoubleFromUser(question);
			}
			return numberInputted;
		}
	}

	public static double calculateMonthlyRepayment (double mortgageAmount, double interestRate) {
		return mortgageAmount * (interestRate/12/100) / (1 - Math.pow(1 + interestRate/12/100, -20*12));
	}

	public static double calculateMonthsToRepayMortage (double mortgageAmount, double interestRate, double repayments) {
		int count = 0;
		while (mortgageAmount > 0) {
			mortgageAmount = (mortgageAmount - repayments) * (1 + (interestRate/12/100)); 
			count++;
		}
		return count;
	}

}
