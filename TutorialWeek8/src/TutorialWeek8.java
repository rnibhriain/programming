import java.util.Scanner;


public class TutorialWeek8 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number.");
		int numberEntered = input.nextInt();
		
		String output = "Prizes should be given to the competitors who come: 1st, 2nd, 3rd, ";
		
		for (int count =0; count < numberEntered; count++ ) {
			
			for (int divisor = 2; divisor <23; divisor++ ) {
				
				output += "hi"  ;
				
			}
			
			
		}
		
		switch (numberEntered) {
		case 1:
			
			break;
		}
		
		input.close();
	}

}
