
public class PlayingCard {
	
	private int rank;
	private String suit;
	private boolean faceUp;
	private boolean isDealt;
	
	PlayingCard (int rank, String suit) {
		this.rank = rank;
		this.suit = suit;
		this.isDealt = false;
	}
	
	int getRank () {
		return this.rank;
	}
	
	boolean getIsDealt () {
		return isDealt;
	}
	
	void setDealingStatus (boolean status) {
		this.isDealt = status;
	}
	
	String getSuit () {
		return this.suit;
	}
	
	boolean isFaceUp () {
		if (this.faceUp) {
			return true;
		}
		return false;
	}
	
	void flip () {
		if (faceUp) {
			this.faceUp = false;
		}
		else {
			this.faceUp = true;
		}
	}
	
	PlayingCard setFaceDown () {
		if (isFaceUp()) {
			flip();
		}
		return this;
	}

	int compareTo (PlayingCard pC) {
		if (pC.getRank() == this.getRank()) {
			return 0;
		}
		else if (pC.getRank() > this.getRank()) {
			return -1;
		}
		else {
			return 1;
		}
	}
	
}
