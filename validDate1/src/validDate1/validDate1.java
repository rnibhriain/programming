package validDate1;

import java.util.Scanner;

public class validDate1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		input.useDelimiter(" / ");
		System.out.println("Enter a date in this format: day / month / year");
		int day = input.nextInt();
		int month = input.nextInt();
		int year = input.nextInt();
		

		if (validDate(day, month, year)) {
			System.out.println("The date is valid.");
		}
		else {
			System.out.println("Your date does not exist!");

		}
		input.close();

	}

	public static boolean validDate (int day, int month, int year) {
		if (day <= daysInMonth(month, year)) {
			return true;
		}
		return false;
	}

	public static int daysInMonth (int month, int year) {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		case 2:
			if (isLeapYear(month)) {
				return 29;
			}
			else {
				return 28;
			}
		}
		return -1;
	}

	public static boolean isLeapYear(int year) {
		if (year % 400 == 0) {
			return true;
		}
		else if (year % 100 == 0) {
			return false;
		}
		else if (year % 4 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
