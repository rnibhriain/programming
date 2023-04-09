import java.util.Scanner;

public class C4HumanPlayer extends ConnectPlayer {
	
	C4HumanPlayer (char theColour) {
		super (theColour);
	}
	
	public void setChoice (Connect4Grid2DArray theArray) {
		int theChoice = 0;
		boolean choiceMade = false;
		Scanner input = new Scanner(System.in);
		while (!choiceMade) {
			System.out.println("What is your choice of column?");
			if (input.hasNextInt()) {
				theChoice = input.nextInt();
				if (theArray.isValidColumn(theChoice)) {
					choiceMade = true;
				}
				else {
					System.out.println("This is not a valid column.");
				}
			}
			else {
				input.next();
				System.out.println("Incorrect Input.");
			}
		}
		super.columnChoice = theChoice;
	}
	
	public char getColour () {
		return super.getColour();
	}
	
	public int getChoice () {
		return super.columnChoice;
	}

}
