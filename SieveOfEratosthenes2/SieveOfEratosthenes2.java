/* SELF ASSESSMENT 
   1.  createSequence:
Did I use the correct method definition?
Mark out of 5:5
Comment: Yes there was a reference to the sieveArray as a parameter.
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5:5
Comment:An array was made as an object and was passed as a parameter.
Did I return the correct item?
Mark out of 5:5
Comment:It was necessary to return anything so the method is void.
   2.  crossOutMultiples
Did I use the correct method definition?
Mark out of 5:5
Comment:Yes the method used a number n and the sieveArray reference as parameters.
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2:2
Comment:Yes the number is checked to insure it is greater than zero.
Did I loop through the array using the correct multiple?
Mark out of 5:5
Comment:Yes there was a for loop used with a count and the correct multiples were crossed out.
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3:3
Comment:Yes all non prime numbers were crossed out.
   3.  sieve   
Did I have the correct function definition?
Mark out of 5:5
Comment:Yes there are references to both arrays as parameters and the return type is void.
Did I make calls to other methods?
Mark out of 5:5
Comment:There was a call made to the nonCrossedOutSubseqToString function.
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2:2
Comment:There is no need to return anything so the return type is void.
   4.  sequenceTostring  
Did I have the correct function definition?
Mark out of 5:5
Comment:Yes there is return type of string and both array references are passed as parameters.
Did I ensure the parameter to be used is not null?
Mark out of 3:3
Comment: Yes both arrays have references which are passed as parameters.
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10:10
Comment:    Yes i looped through the sieveArray and added brackets when the number was crossed out.
   5.  nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5:5
Comment:Yes there is an array reference as a parameter and the return type is String. 
Did I ensure the parameter to be used is not null?  
Mark out of 3:3
Comment:Yes there is a reference to the sieveOfEratosthenes array as a parameter.
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5:5
Comment:Yes every time the number is crossed out there is nothing added to the string variable.
   6.  main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5:5
Comments:Yes the input was checked to insure it was appropriate.
Did I make calls to other methods (at least one)?
Mark out of 5:5
Comment:  Yes there were calls to other methods within the main.
Did I print the output as shown in the question?  
Mark out of 5:5
Comment:  Yes the output was printed as shown in the question.
   7.  Overall
Is my code indented correctly?
Mark out of 4:4
Comments:All code was indented using tabs.
Do my variable names make sense?
Mark out of 4:4
Comments:All variable names are relevant.
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4:4
Comments:All variable names, method names and class names follow the coding standard.
      Total Mark out of 100 (Add all the previous marks):100
 */

import java.util.Scanner;

public class SieveOfEratosthenes2 {

	private static int [] sieveArray;
	private static int [] sieveOfEratosthenes;
	public static final String QUESTION = "Enter an integer greater than or equal to two: " ;
	public static final String WRONG_INPUT = "You have entered incorrect input.";

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println(QUESTION);
		int number = 0;
		boolean correctInput = false;
		while (!correctInput) {
			if (input.hasNextInt()) {
				number = input.nextInt();
				if (number > 0 ) {
					correctInput = true;
				}
				else {
					System.out.println(WRONG_INPUT);
					System.out.println(QUESTION);	
				}
			}
			else {
				input.next();
				System.out.println(WRONG_INPUT);
				System.out.println(QUESTION);
			}
		}
		sieveArray  = new int[number-1];
		sieveOfEratosthenes = new int [number-1];
		createSequence(sieveArray);
		sieve(sieveArray, sieveOfEratosthenes);
		String lastSequence = "";
		for (int count = 2; count < number; count++) {
			crossOutHigherMultiples(count, sieveArray);
			if (sieveArray[count-2] == 1) {
				if (lastSequence.equals(sequenceToString(sieveArray, sieveOfEratosthenes))) {
					count = number;
				}
				else {
					System.out.println(sequenceToString(sieveArray, sieveOfEratosthenes));
					lastSequence = sequenceToString(sieveArray, sieveOfEratosthenes);
				}
			}
		}
		sieve(sieveArray, sieveOfEratosthenes);
		input.close();
	}

	public static void createSequence (int sieveArray []) {
		for (int count = 0; count < sieveArray.length ; count++) {
			sieveArray [count] = 1;
		}
	}

	public static void crossOutHigherMultiples (int number, int sieveArray[]) {
		for (int count = number-2+number; count < sieveArray.length; count+=number) {
			sieveArray [count] = 0;
		}
	}

	public static void sieve (int sieveArray[], int sieveOfEratosthenes []) {
		for (int count = 0; count < sieveArray.length; count++) {
			if(sieveArray[count] == 0) {
				sieveOfEratosthenes [count] =0;
			}
			else {
				sieveOfEratosthenes [count] = count+2;
			}
		}
		System.out.println(nonCrossedOutSubseqToString(sieveOfEratosthenes));
	}

	public static String sequenceToString (int sieveArray [], int sieveOfEratosthenes []) {
		String sequence = "";
		for (int count = 0; count < sieveArray.length; count++) {
			if (sieveArray[count] == 0) {
				sequence += "[" + (count+2) +"], ";
			}
			else {
				sequence += sieveOfEratosthenes[count] + ", ";
			}
		}
		return sequence;
	}

	public static String nonCrossedOutSubseqToString (int sieveOfEratosthenes []) {
		String sequence = "";
		for (int count = 0; count < sieveOfEratosthenes.length; count++) {
			if (sieveOfEratosthenes[count] != 0) {
				if (count == 0) {
					sequence += sieveOfEratosthenes[count];
				}
				else {
					sequence += ", " + sieveOfEratosthenes[count];	
				}
			}
		}
		return sequence;
	}

}
