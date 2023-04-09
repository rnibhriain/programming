public class PlayingCard {
	
	public int value;
	public String suit;
	
	PlayingCard () {
		value = 0;
		suit = "";
	}
	
	PlayingCard (int currentValue, String currentSuit) {
		this.value = currentValue;
		this.suit = currentSuit;
	}
	
	boolean isSuitEqual (PlayingCard otherCard) {
		if (this.suit.equals(otherCard.suit)) {
			return true;
		}
		return false;
	}
	
	int compareRank (PlayingCard otherCard) {
		if(this.value == otherCard.value) {
			return 0;
		}
		else if (this.value > otherCard.value) {
			return 1;
		}
		else {
			return -1;
		}
	}

}
