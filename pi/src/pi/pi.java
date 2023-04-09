package pi;

import java.util.Scanner;

public class pi {

	public static void main(String[] args) {
		
		System.out.println("Enter a number!");
		Scanner input = new Scanner(System.in);
		int numberEntered = input.nextInt();
		System.out.print("PI = ");
		int count = 0;
		double number = 2;
		double pi = 3;
		
		while (count < numberEntered) {
			if (count%2==0) {
				pi = pi + (4/((number)*(number+1)*(number+2)));
			}
			else {
				pi = pi - (4/((number)*(number+1)*(number+2)));
			}
			count++;
			number += 2;
		}
		System.out.print(pi);
		input.close();

	}

}
