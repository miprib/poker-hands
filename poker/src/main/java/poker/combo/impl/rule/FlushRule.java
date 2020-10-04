package poker.combo.impl.rule;

import poker.Card;
import poker.Card.Suit;
import poker.Hand;

public class FlushRule {

	public boolean isFlush(Hand hand) {
		Card[] cards = hand.getCards();
		Suit suit = cards[0].getSuit();
		for (Card card : cards) {
			if (card.getSuit() != suit) {
				return false;
			}
		}
		return true;
	}
}
