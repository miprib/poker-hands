package poker.combo.impl;

import java.util.List;

import poker.Hand;
import poker.Hand.ComboType;
import poker.combo.Combo;
import poker.combo.ComboResult;
import poker.combo.impl.rule.FrequencyRule;

/** Two cards of the same value. */
public class OnePairCombo implements Combo {
	private FrequencyRule frequencyRule = new FrequencyRule();

	@Override
	public ComboResult checkHand(Hand hand) {
		List<Hand> repeatingHands = frequencyRule.getRepeatingHands(hand);
		for (Hand repeatingHand : repeatingHands) {
			if (repeatingHand.getCards().length == 2) {
				return getResult(repeatingHand, hand);
			}
		}
		return null;
	}

	private ComboResult getResult(Hand comboHand, Hand initialHand) {
		return new ComboResult(ComboType.ONE_PAIR, comboHand, initialHand);
	}
}
