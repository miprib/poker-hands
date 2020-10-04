package poker.combo.impl;

import poker.Hand;
import poker.Hand.ComboType;
import poker.combo.Combo;
import poker.combo.ComboResult;

/** All cards are consecutive values of same suit. */
public class StraightFlushCombo implements Combo {

	private Combo straightCombo;
	private Combo flushCombo;

	public StraightFlushCombo(Combo straightCombo, Combo flushCombo) {
		this.straightCombo = straightCombo;
		this.flushCombo = flushCombo;
	}

	@Override
	public ComboResult checkHand(Hand hand) {
		if (straightCombo.checkHand(hand) != null && flushCombo.checkHand(hand) != null) {
			return getResult(hand, hand);
		}
		return null;
	}

	private ComboResult getResult(Hand comboHand, Hand initialHand) {
		return new ComboResult(ComboType.STRAIGHT_FLUSH, comboHand, initialHand);
	}
}
