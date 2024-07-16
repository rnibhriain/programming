
public class Poem {

	private String [][] thePoem;
	private String[] theLines;

	Poem (String thePoem) {
		theLines = thePoem.split("\n");
		this.thePoem = new String[theLines.length][];
		for (int count = 0; count < this.thePoem.length; count++) {
			this.thePoem [count] = theLines[count].split(" ");
		}
	}

	public boolean isSquareMatrix () {
		for (int count = 0; count < thePoem.length; count++) {
			if (thePoem.length != thePoem[count].length) {
				return false;
			}
		}
		return true;
	}



	public String removePunctuation (String theWord) {
		char [] theCharacters = theWord.toCharArray();
		theWord = "";
		for (int count = 0; count < theCharacters.length; count++) {
			if (((int)theCharacters[count] == 39)||
					((int) theCharacters[count] >= 65 && 
					(int) theCharacters[count] <=90)||
					((int) theCharacters[count] >= 97 && 
					(int) theCharacters[count] <=122)) {
				theWord += theCharacters[count];
			}
		}
		return theWord;
	}

	public boolean isSquarePoem  () {
		if (isSquareMatrix()) {
			for (int count = 0; count < this.thePoem.length; count++) {
				for (int index = 0; index < this.thePoem[count].length; index++) {
					thePoem [count][index] = removePunctuation(thePoem [count][index]);
				}
			}
			for (int row1 = 0, column1 = 0; row1 < this.thePoem.length; row1++, column1++ ) {
				for (int row2 = 0, column2 = 0; row2 < this.thePoem.length; row2++, column2++ ) {
					if (!(this.thePoem[row1][column2].equalsIgnoreCase(this.thePoem[row2][column1]))) {
						return false;
					}
				}
			}
			return true;
		}
		else {
			return false;
		}
		
	}

	public static void main(String[] args) {
		String aPoem = "I often wondered when I cursed,\nOften feared where I would be-\nWondered where she'd yield her love,\nWhen I yield, so will she.\nI would her will be pitied!\nCursed be love! She pitied me...";
		Poem poem = new Poem (aPoem);
		if (poem.isSquarePoem()) {
			System.out.println("YEs");
		}
		else {
			System.out.println("Narp");
		}


	}

}
