import java.util.Random;

public class BingoCard {
	
	private int theCard [][];
	
	BingoCard () {
		Random generator = new Random();
		theCard = new int[5][5];
		
		for (int row = 0; row < theCard.length; row++) {
			for (int column = 0; column < theCard[row].length; column++) {
				switch (column) {
					case 0:
						theCard [row][column] = generator.nextInt(15)+1;
						break;
					case 1:
						theCard [row][column] = generator.nextInt(15)+16;
						break;
					case 2:
						theCard [row][column] = generator.nextInt(15)+31;
						break;
					case 3:
						theCard [row][column] = generator.nextInt(15)+46;
						break;
					case 4:
						theCard [row][column] = generator.nextInt(15)+61;
						break;
				}
				if (row==2&&column==2) {
					theCard [row] [column] = 0;
				}
				
			}
		}
		
		
	}
	
	public void makeOccupied(int number) {
		for (int row = 0; row < theCard.length; row++) {
			for (int column = 0; column < theCard[row].length; column++) {
				if (theCard[row][column] == number) {
					theCard [row][column] = 0;
				}
			}
		}
	}
	
	public int numberOccupiedInRow (int rowIndex) {
		int numberOccupied = 0;
		if (rowIndex < theCard.length&&rowIndex>=0) {
			for (int column = 0; column < theCard[rowIndex].length; column++) {
				if (theCard[rowIndex][column]==0) {
					numberOccupied++;
				}
			}
			return numberOccupied;
		}
		System.out.println("Row index is not valid.");
		return -1;
	}
	
	public int numberOccupiedInColumn (int columnIndex) {
		int numberOccupied = 0;
		if (columnIndex < theCard[0].length&&columnIndex>=0) {
			for (int row = 0; row < theCard.length; row++) {
				if (theCard[row][columnIndex]==0) {
					numberOccupied++;
				}
			}
			return numberOccupied;
		}
		System.out.println("Row index is not valid.");
		return -1;
	}
	
	public int numberOccupiedInDiagonal (int leftOrRight) {
		int numberOccupied = 0;
		if (leftOrRight==1) {
			for (int row = 0, column = 0; row < theCard.length && column < theCard[row].length; row++, column++) {
				if (theCard[row][column]==0) {
					numberOccupied++;
				}
			}
			return numberOccupied;
		}
		else if (leftOrRight==-1) {
			for (int row = theCard.length-1, column = 0; row > 0 && column < theCard[row].length; row--, column++) {
				if (theCard[row][column]==0) {
					numberOccupied++;
				}
			}
			return numberOccupied;
		}
		return -1;
	}
	
	public boolean isBingo () {
		for (int row = 0; row < theCard.length; row++) {
			if (numberOccupiedInRow(row) == 5) {
				return true;
			}
		}
		for (int column = 0; column < theCard.length; column++) {
			if (numberOccupiedInColumn(column) == 5) {
				return true;
			}
		}
		if (numberOccupiedInDiagonal(1) == 5|| numberOccupiedInDiagonal(-1) == 5) {
			return true;
		}
		return false;
	}

}
