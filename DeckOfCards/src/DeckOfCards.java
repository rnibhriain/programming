import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {

	ArrayList <PlayingCard> deck = new ArrayList<PlayingCard>();

	DeckOfCards () {
		PlayingCard currentCard;
		for (int suit = 0; suit < 4; suit++) {
			for (int rank = 2; rank < 14; rank++) {
				if (suit == 0) {
					currentCard = new PlayingCard (rank, "heart");
					deck.add(currentCard);
				}
				else if (suit == 1) {
					currentCard = new PlayingCard (rank, "diamond");
					deck.add(currentCard);
				}
				else if (suit == 2){
					currentCard = new PlayingCard (rank, "spade");
					deck.add(currentCard);
				}
				else {
					currentCard = new PlayingCard (rank, "club");
					deck.add(currentCard);
				}
			}
		}
	}

	boolean isEmpty () {
		for (int count = 0; count < deck.size(); count++) {
			if (!deck.get(count).getIsDealt()) {
				return false;
			}
		}
		return true;
	}

	PlayingCard setFaceDown (PlayingCard pC) {
		pC.setFaceDown();
		return pC;
	}

	void setFaceDown () {
		for (int count = 0; count < deck.size(); count++) {
			if (!deck.get(count).getIsDealt()) {
				deck.set(count, setFaceDown(deck.get(count)));
			}
		}
	}

	void shuffle () {
		Random generator = new Random();
		boolean swapped = false;
		for (int count = 0; count < deck.size(); count++) {
			swapped = false;
			if (!deck.get(count).getIsDealt()) {
				PlayingCard pc = deck.get(count);
				while (!swapped) {
					int random =  generator.nextInt(deck.size());
					if (!deck.get(random).getIsDealt()) {
						PlayingCard randomCard = deck.get(random);
						deck.set(random, pc);
						deck.set(count, randomCard);
						swapped = true;
					}
				}
			}
		}	
	}
	
	PlayingCard deal () {
		
		if (isEmpty()) {
			setFaceDown();
			for (int count = 0; count < deck.size(); count++) {
				deck.get(count).setDealingStatus(false);
			}
			shuffle();
		}
		PlayingCard currentCard = deck.get(0);
		currentCard.setDealingStatus(true);
		deck.remove(0);
		deck.add(currentCard);
		
		
		
		return deck.get(deck.size()-1);
	}

}
