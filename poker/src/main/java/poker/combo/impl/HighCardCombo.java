package poker.combo.impl;

import poker.Hand;
import poker.Hand.ComboType;
import poker.combo.Combo;
import poker.combo.ComboResult;

/** Highest value card. */
public class HighCardCombo implements Combo {

	@Override
	public ComboResult checkHand(Hand hand) {
		// Every hand has a high card
		return getResult(hand);
	}

	private ComboResult getResult(Hand hand) {
		return new ComboResult(ComboType.HIGH_CARD, hand, hand);
	}
}
