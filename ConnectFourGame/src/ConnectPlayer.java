
public abstract class ConnectPlayer {
	
	private char colour;
	public int columnChoice;
	
	ConnectPlayer (char colour) {
		this.colour = colour;
	}
	
	public char getColour () {
		return this.colour;
	}
	
	public abstract void setChoice (Connect4Grid2DArray theArray);
	
	public int getChoice () {
		return this.columnChoice;
	}
	
}
