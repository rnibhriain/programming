/* SELF ASSESSMENT
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:10
       Comment:Yes all variable names are relevant. 
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:5
       Comment:yes all variable names were formatted correctly.
   3. Did I indent the code appropriately?
       Mark out of 10:10
       Comment:Yes the code is indented appropriately.
   4. Did I input the numbers one at a time from the command line?
       Mark out of 10: 10
       Comment:Yes all numbers were inputted one at a time from the command line.
   5. Did I check the input to ensure that invalid input was handled appropriately?
       Mark out of 10: 10
       Comment:Yes there was error checking.
   6. Did I use an appropriate while or do-while loop to allow the user to enter numbers until they entered exit/quit?
       Mark out of 20: 20
       Comment:Yes a while loop was used to allow the user to enter numbers.
   7. Did I implement the loop body correctly so that the average and variance were updated and output appropriately?
       Mark out of 30: 30
       Comment:Yes the average and variance were updated and output correctly.
   8. How well did I complete this self-assessment?
       Mark out of 5:5
       Comment:I answered all questions honestly.
   Total Mark out of 100 (Add all the previous marks):100
 */

import java.util.Scanner;

public class AverageAndVariance {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		boolean finished = false;
		double average = 0;
		double lastAverage = 0;
		double lastVariance = 0;
		double variance = 0;
		double count = 0;
		double numberEntered = 0;

		while (!finished) {

			System.out.print("Enter a number (or type 'exit'): ");
			if (input.hasNextDouble()) {
				numberEntered = input.nextDouble();
				count++;
				average = lastAverage + (numberEntered - (lastAverage)) / count;
				variance = (((lastVariance) * (count-1)) + (numberEntered - (lastAverage)) * (numberEntered - average))
						/ count;
				System.out.println("So far the average is " + average + " and the variance is " + variance);
				lastAverage = average;
				lastVariance = variance;
			}
			else if (input.next().equalsIgnoreCase("exit")) {
				finished = true;
			}
			else {
				System.out.println("Error. Enter something else.");
			}

		}
		System.out.print("Goodbye.");
		input.close();
	}

} 