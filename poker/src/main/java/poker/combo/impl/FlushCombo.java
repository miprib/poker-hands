package poker.combo.impl;

import poker.Hand;
import poker.Hand.ComboType;
import poker.combo.Combo;
import poker.combo.ComboResult;
import poker.combo.impl.rule.FlushRule;

/** All cards of the same suit. */
public class FlushCombo implements Combo {

	private FlushRule flushRule = new FlushRule();

	@Override
	public ComboResult checkHand(Hand hand) {
		if (flushRule.isFlush(hand)) {
			return getResult(hand, hand);
		}
		return null;
	}

	private ComboResult getResult(Hand comboHand, Hand initialHand) {
		return new ComboResult(ComboType.FLUSH, comboHand, initialHand);
	}
}
