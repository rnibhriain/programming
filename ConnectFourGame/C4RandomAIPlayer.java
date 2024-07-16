import java.util.Random;

public class C4RandomAIPlayer extends ConnectPlayer  {
	
	C4RandomAIPlayer (char theColour) {
		super(theColour);
	}
	
	public void setChoice (Connect4Grid2DArray theArray) {
		Random randomGenerator = new Random();
		int randomNumber = randomGenerator.nextInt(theArray.theGrid.length);
		while (!theArray.isValidColumn(randomNumber)) {
			randomNumber = randomGenerator.nextInt();
		}
		super.columnChoice = randomNumber;
	}

	public char getColour () {
		return super.getColour();
	}
	
	public int getChoice () {
		return super.columnChoice;
	}
	
}