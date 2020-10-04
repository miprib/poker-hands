package poker.combo.impl;

import java.util.List;
import java.util.stream.Collectors;

import poker.Hand;
import poker.Hand.ComboType;
import poker.combo.Combo;
import poker.combo.ComboResult;
import poker.combo.impl.rule.FrequencyRule;

/** Two different pairs. */
public class TwoPairsCombo implements Combo {

	private FrequencyRule frequencyRule = new FrequencyRule();

	@Override
	public ComboResult checkHand(Hand hand) {
		Hand comboHand = getComboHand(hand);
		if (comboHand != null) {
			return getResult(comboHand, hand);
		}
		return null;
	}

	private Hand getComboHand(Hand hand) {
		List<Hand> repeatingHands = frequencyRule.getRepeatingHands(hand);
		List<Hand> pairHands = repeatingHands.stream()
				.filter(h -> h.getCards().length == 2)
				.collect(Collectors.toList());
		if (pairHands.size() == 2) {
			return Hand.mergeHands(pairHands.get(0), pairHands.get(1));
		}
		return null;
	}

	private ComboResult getResult(Hand comboHand, Hand initialHand) {
		return new ComboResult(ComboType.TWO_PAIRS, comboHand, initialHand);
	}

}
