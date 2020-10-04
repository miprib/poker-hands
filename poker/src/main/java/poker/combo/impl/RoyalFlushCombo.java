package poker.combo.impl;

import poker.Card;
import poker.Card.Face;
import poker.Hand;
import poker.Hand.ComboType;
import poker.combo.Combo;
import poker.combo.ComboResult;

/** Ten, Jack, Queen, King, Ace, in same suit. */
public class RoyalFlushCombo implements Combo {

	private Face[] royalFlushFaces = { Face.TEN, Face.JACK, Face.QUEEN, Face.KING, Face.ACE };
	private Combo flushCombo;

	public RoyalFlushCombo(Combo flushCombo) {
		this.flushCombo = flushCombo;
	}

	@Override
	public ComboResult checkHand(Hand hand) {
		Card[] cards = hand.getCards();
		if (areFacesRoyal(cards) && flushCombo.checkHand(hand) != null) {
			return getResult(hand);
		}
		return null;
	}

	private boolean areFacesRoyal(Card[] cards) {
		for (int i = 0; i < cards.length; i++) {
			if (cards[i].getFace() != royalFlushFaces[i]) {
				return false;
			}
		}
		return true;
	}

	private ComboResult getResult(Hand hand) {
		return new ComboResult(ComboType.ROYAL_FLUSH, hand, hand);
	}
}
