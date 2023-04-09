public class Connect4Grid2DArray implements Connect4Grid {
	
	public char [] [] theGrid;
	private int lastRow, lastColumn;
	
	Connect4Grid2DArray () {
		this.theGrid = new char [7][7];
	}
	
	public void emptyGrid () {
		for (int row = 0; row < theGrid.length; row++) {
			for (int column = 0; column < theGrid[row].length; column++) {
				theGrid [row] [column] = '0';
			}
		}
	}
	
	public String toString  () {
		String theString = "  1 2 3 4 5 6 7\n";
		for (int row = 0; row < theGrid.length; row++) {
			theString += (row+1);
			for (int column = 0; column < theGrid[row].length; column++) {
				theString += " " + theGrid[row][column];
			}
			theString += "\n";
		}
		return theString;
	}
	
	public boolean isValidColumn(int column) {
		if (column-1 >= theGrid[0].length) {
			return false;
		}
		if (isColumnFull(column)) {
			return false;
		}
		if (isGridFull()) {
			return false;
		}
		return true;
	}
	
	public boolean isColumnFull (int column) {
		if (theGrid[0][column-1] == '0') {
			return false;
		}
		return true;
	}
	
	public void dropPiece(ConnectPlayer player, int column) {
		int rowToChange = 0;
		for (int row = 1; row < theGrid.length && rowToChange == 0; row++) {
			if (theGrid[row][column-1] != '0' ) {
				rowToChange = row-1;
			}
			if (theGrid[theGrid.length-1][column-1] == '0') {
				rowToChange = theGrid.length-1;
			}
		}
		theGrid [rowToChange][column-1] = player.getColour();
		lastRow = rowToChange;
		lastColumn = column-1;
	}
	
	public boolean didLastPieceConnect4() {
		int numberInARow = 1;
		// check straight column
		if (lastRow<=2) {
			for (int count = lastRow+1; (count -lastRow+1) < 4; count++) {
				if (theGrid[lastRow][lastColumn] == theGrid[count][lastColumn]) {
					numberInARow++;
				}
				if (numberInARow == 4) {
					return true;
				}
			}
			
		}
		// check horizontal
		numberInARow = 1;
		for (int count = lastColumn+1; count < theGrid[lastRow].length; count++) {
			if (theGrid[lastRow][lastColumn] == theGrid[lastRow][count]) {
				numberInARow++;
			}
			else {
				count = theGrid[lastRow].length;
			}
			if (numberInARow == 4) {
				return true;
			}
		}
		for (int count = lastColumn-1; count >= 0; count--) {
			if (theGrid[lastRow][lastColumn] == theGrid[lastRow][count]) {
				numberInARow++;
			}
			else {
				count = -1;
			}
			if (numberInARow == 4) {
				return true;
			}
		}
		// check diagonals: direction1
		numberInARow = 1;
		for (int row = lastRow+1, column = lastColumn+1; row < theGrid.length && column < theGrid[row].length; row++, column++) {
			if (theGrid[lastRow][lastColumn] == theGrid[row][column]) {
				numberInARow++;
			}
			else {
				row = theGrid.length;
			}
			if (numberInARow == 4) {
				return true;
			}
		}
		for (int row = lastRow-1, column = lastColumn-1; row >= 0 && column >= 0; row--, column--) {
			if (theGrid[lastRow][lastColumn] == theGrid[row][column]) {
				numberInARow++;
			}
			else {
				row = theGrid.length;
			}
			if (numberInARow == 4) {
				return true;
			}
		}
		// check diagonals: direction2
		numberInARow = 1;
		for (int row = lastRow+1, column = lastColumn-1; row < theGrid.length && column >= 0; row++, column--) {
			if (theGrid[lastRow][lastColumn] == theGrid[row][column]) {
				numberInARow++;
			}
			else {
				row = theGrid.length;
			}
			if (numberInARow == 4) {
				return true;
			}
		}
		for (int row = lastRow-1, column = lastColumn+1; row >= 0 && column < theGrid[row].length; row--, column++) {
			if (theGrid[lastRow][lastColumn] == theGrid[row][column]) {
				numberInARow++;
			}
			else {
				row = theGrid.length;
			}
			if (numberInARow == 4) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean isGridFull () {
		for (int row = 0; row < theGrid.length; row++) {
			for (int column = 0; column < theGrid[row].length; column++) {
				if (theGrid[row][column] == '0' ) {
					return false;
				}
			}
		}
		return true;
	}

}
