package poker.combo.impl;

import poker.Hand;
import poker.Hand.ComboType;
import poker.combo.Combo;
import poker.combo.ComboResult;
import poker.combo.impl.rule.StraightRule;

/** All cards are consecutive values. */
public class StraightCombo implements Combo {

	private StraightRule straightRule = new StraightRule();

	@Override
	public ComboResult checkHand(Hand hand) {
		if (straightRule.isStraight(hand)) {
			return getResult(hand, hand);
		}
		return null;
	}

	private ComboResult getResult(Hand comboHand, Hand initialHand) {
		return new ComboResult(ComboType.STRAIGHT, comboHand, initialHand);
	}
}
