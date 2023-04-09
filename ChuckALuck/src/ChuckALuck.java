/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7].
Comment:It has a void return type which takes the bet type string and the wallet object.
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
Comment:resolveBet prints the amount of cash in the wallet and then asks the user how much they want to bet.
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment:Yes it will ask the user to enter an amount again if the bet amount is greater than the cash in the wallet.
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 15]..
Comment:Yes three Dice are created and rolled and a variable with the total is created.
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 20].
Comment:The bet types are checked and then the conditions for the bet are checked and if they are met the user wins.
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: ].
Comment:Yes the wallet amount is added to or taken away from depending on whether the user wins or not.

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15]
Comment:Yes the user is asked how much cash they have and this cash is put in the created wallet object.
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5]
Comment:Yes the program loops until the user enters quit or they have no money left.
I ask the user to enter any of the four bet types or quit [Mark out of 5: 5].
Comment:The user is asked to enter their bet choice or quit.
My program calls resolveBet for each bet type entered [Mark out of 5: 5].
Comment:The resolveBet function is called every time a bet is entered.
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5]
Comment:I created a function to output the final results.

 Total Mark out of 100 (Add all the previous marks):100
 */


import java.util.Scanner;

public class ChuckALuck {

	public static final String QUESTION = "Enter the amount of cash you have: " ;
	public static final String WRONG_INPUT = "You have entered incorrect input.";
	public static final String QUESTION1 = "Enter your bet type (or enter quit): " ;
	public static final String QUESTION2 = "Enter the amount you would like to bet: " ;
	public static final String BET1 = "triple" ;
	public static final String BET2 = "field" ;
	public static final String BET3 = "high" ;
	public static final String BET4 = "low" ;
	public static final String QUIT	= "quit";
	public static final String FINISH_GAME = "You have quit the game.";

	public static void main(String[] args) {

		Wallet wallet = new Wallet();
		Scanner input = new Scanner(System.in);
		explainGame();
		wallet.put(checkValidNumber(input, QUESTION));
		double originalAmount = wallet.check();
		boolean finished = false;
		String currentBet = "";
		while (!finished) {
			if (wallet.check() != 0) {
				currentBet = checkValidBet(input);
				if (currentBet.equalsIgnoreCase(QUIT)) {
					finished = true;
					System.out.println(FINISH_GAME);
				}
				else {
					resolveBet(wallet, currentBet);
				}
			}
			else {
				finished = true;
				System.out.println(FINISH_GAME);
			}
		}
		outputResults(wallet, originalAmount);
		input.close();
	}

	public static void explainGame () {
		System.out.println("Welcome to the Chuck a Luck Dice Game!");
		System.out.println();
		System.out.println("You have four options to bet on: ");
		System.out.println();
		System.out.println("Option One: Triple");
		System.out.println("This gives 30:1 odds that the three dice will be the same number as long as that number is not 1 or 6.");
		System.out.println();
		System.out.println("Option Two: Field");
		System.out.println("This gives 1:1 odds the three dice added together will be less than 8 or greater than 12.");
		System.out.println();
		System.out.println("Option Three: High");
		System.out.println("This gives 1:1 odds that the three dice will be higher than 10 but not a high triple.");
		System.out.println();
		System.out.println("Option Four: Low");
		System.out.println("This gives 1:1 odds that the three dice will be less than 11 but not a low triple.");
		System.out.println();
		System.out.println("Good luck playing!");
		System.out.println();
	}

	public static void resolveBet (Wallet wallet, String betType) {
		Scanner input = new Scanner(System.in);
		System.out.println("You currently have € " + wallet.check());
		boolean correctInput = false;
		double amountToBet = 0;
		while (!correctInput) {
			amountToBet = checkValidNumber(input, QUESTION2);
			if (amountToBet <= wallet.check()) {
				correctInput = true;
			}
			else {
				System.out.println("You don't have enough money to bet that much.");
				System.out.println("You currently have € " + wallet.check());
			}
		}
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		Dice dice3 = new Dice();
		int firstNumber  =  dice1.roll();
		int secondNumber  =  dice2.roll();
		int thirdNumber  =  dice3.roll();
		int totalNumber = firstNumber + secondNumber + thirdNumber;
		if (betType.equalsIgnoreCase(BET1)) {
			if (firstNumber == secondNumber && secondNumber == thirdNumber && (firstNumber !=1 ||firstNumber!=6)) {
				wallet.put(amountToBet*30);
				System.out.println("Nice one! What a win!");
			}
			else {
				wallet.get(amountToBet);
				System.out.println("Maybe next time ay");
			}
		}
		else if (betType.equalsIgnoreCase(BET2)) {
			if (totalNumber > 12 ||totalNumber < 8  ) {
				wallet.put(amountToBet);
				System.out.println("Aw yes! You win this one!");
			}
			else {
				wallet.get(amountToBet);
				System.out.println("Not this time unfortunately");
			}
		}
		else if (betType.equalsIgnoreCase(BET3)) {
			if (totalNumber > 10) {
				if (!(firstNumber == 4 && secondNumber == 4 && thirdNumber == 4) && !(firstNumber == 5 && secondNumber == 5 && thirdNumber== 5) &!(firstNumber == 6 && secondNumber == 6 && thirdNumber== 6)) {
					wallet.put(amountToBet);
					System.out.println("Congrats! It's a win!");
				}
				else {
					wallet.get(amountToBet);
					System.out.println("House wins this time");
				}
			}
			else {
				wallet.get(amountToBet);
				System.out.println("House wins this time");
			}
		}
		else if (betType.equalsIgnoreCase(BET4)) {
			if (totalNumber < 10) {
				if (!(firstNumber == 1 && secondNumber == 1 && thirdNumber == 1) && !(firstNumber == 2 && secondNumber == 2 && thirdNumber== 2) &!(firstNumber == 3 && secondNumber == 3 && thirdNumber== 3)) {
					wallet.put(amountToBet);
					System.out.println("Yay you got it !");
				}
				else {
					wallet.get(amountToBet);
					System.out.println("Nope sorry");
				}
			}
			else {
				wallet.get(amountToBet);
				System.out.println("Nope sorry");
			}
		}
	}

	public static void outputResults (Wallet wallet, double originalAmount) {
		System.out.println();
		System.out.println("You are left with: €" + wallet.check());
		if (wallet.check() > originalAmount) {
			System.out.println();
			System.out.println("You seem to have a knack for this game.");
			System.out.println("You have €" + (wallet.check() - originalAmount) + " more than you started with.");
		}
		else if (wallet.check() == originalAmount) {
			System.out.println();
			System.out.println("You're alright at this game I guess.");
			System.out.println("You end up with the same money you started with.");
			System.out.println("So that's good.");
		}	
		else {
			System.out.println();
			System.out.println("This game is not for you, maybe find a new hobby.");
			System.out.println("You lost €" + ( originalAmount -wallet.check()) + " this time");
			System.out.println("Yikes");
		}
	}

	public static String checkValidBet (Scanner input) {
		String bet = "";
		boolean correctInput = false;
		System.out.println(QUESTION1);
		while (!correctInput) {
			bet = input.next();
			if (bet.equalsIgnoreCase(BET1)||bet.equalsIgnoreCase(BET2)||bet.equalsIgnoreCase(BET3)||bet.equalsIgnoreCase(BET4)||bet.equalsIgnoreCase(QUIT)) {
				correctInput = true;
			}
			else {
				System.out.println(WRONG_INPUT);
				System.out.println(QUESTION1);	
			}
		}
		return bet;
	}

	public static double checkValidNumber (Scanner input, String currentQuestion) {
		boolean correctInput = false;
		double cash = 0;
		System.out.println(currentQuestion);
		while (!correctInput) {
			if (input.hasNextDouble()) {
				cash = input.nextInt();
				if (cash > 0 ) {
					correctInput = true;
				}
				else {
					System.out.println(WRONG_INPUT);
					System.out.println(currentQuestion);	
				}
			}
			else {
				input.next();
				System.out.println(WRONG_INPUT);
				System.out.println(currentQuestion);
			}
		}
		return cash;
	}
}