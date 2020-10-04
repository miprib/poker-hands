package poker.combo.impl.rule;

import poker.Card;
import poker.Hand;

public class StraightRule {

	public boolean isStraight(Hand hand) {
		Card[] cards = hand.getCards();
		Card previousCard = null;
		for (Card card : cards) {
			if (!isCardValid(card, previousCard)) {
				return false;
			}
			previousCard = card;
		}
		return true;
	}

	private boolean isCardValid(Card currentCard, Card previousCard) {
		if (previousCard != null) {
			if (currentCard.compareTo(previousCard) != 1) {
				return false;
			}
		}
		return true;
	}
}
