
public class PokerHand {


	PlayingCard [] cards;

	PokerHand () {
		cards = new PlayingCard[5];
		for (int count = 0; count < cards.length; count ++) {
			cards[count] = new PlayingCard();
		}
	}


	void addPlayingCard (PlayingCard pCard) {
		for (int count = 0; count < cards.length; count++) {
			if (cards[count].value == 0) {
				cards[count] = pCard;
			}
		}
	}

	boolean isFlush () {
		int clubs = 0;
		int hearts = 0;
		int diamonds = 0;
		int spades = 0;
		for (int count = 0; count < cards.length; count++) {
			if (cards[count].suit.equals("spade")) {
				spades++;
			} else if (cards[count].suit.equals("club")) {
				clubs++;
			} else if (cards[count].suit.equals("heart")) {
				hearts++;
			}
			else if (cards[count].suit.equals("diamond")) {
				diamonds++;
			}
		}
		if (clubs == 4 || hearts == 4|| diamonds == 4|| spades == 4 ) {
			return true;
		}
		return false;
	}

	PlayingCard [] sortCards (PlayingCard [] cards) {
		boolean notSorted = true;
		boolean swapped = false;
		PlayingCard temp;
		while (notSorted) {
			do {
				swapped = false;
				for (int count = 1; count-1 < cards.length; count++) {
					if (cards[count-1].value > cards[count].value) {
						temp = cards[count-1];
						cards[count-1] = cards[count];
						cards[count] = temp;
						swapped = true;
					}
				}
			} while (swapped);
			notSorted = true;
			for (int count =1; count-1 < cards.length && !notSorted; count++) {
				if (cards[count-1].value > cards[count].value) {
					notSorted = true;
				}
			}
		}
		return cards;
	}

	boolean isStraight () {
		for (int count = 1; count -1 < cards.length; count++) {
			if (cards[count].value != cards[count-1].value+1) {
				return false;
			}
		}
		return true;
	}

	boolean isStraightFlush () {
		if (isFlush() && isStraight()) {
			return true;
		}
		return false;
	}

	boolean isFourOFaKind () {
		if (cards[0] == cards[3] || cards[1] == cards [4]) {
			return true;
		}
		return false;
	}

}
