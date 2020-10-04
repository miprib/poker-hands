package poker.combo.impl;

import poker.Hand;
import poker.Hand.ComboType;
import poker.combo.Combo;
import poker.combo.ComboResult;

/** Three of a kind and a pair. */
public class FullHouseCombo implements Combo {
	private Combo threeOfAKindCombo;
	private Combo onePairCombo;

	public FullHouseCombo(Combo threeOfAKindCombo, Combo onePairCombo) {
		this.threeOfAKindCombo = threeOfAKindCombo;
		this.onePairCombo = onePairCombo;
	}

	@Override
	public ComboResult checkHand(Hand hand) {
		Hand comboHand = getComboHand(hand);
		if (comboHand != null) {
			return getResult(comboHand, hand);
		}
		return null;
	}
	
	private Hand getComboHand(Hand hand) {
		ComboResult threeOfAKindResult = threeOfAKindCombo.checkHand(hand);
		ComboResult onePairResult = onePairCombo.checkHand(hand);
		if(threeOfAKindResult != null && onePairResult != null) {
			return Hand.mergeHands(onePairResult.getComboHand(), threeOfAKindResult.getComboHand());
		}
		return null;
	}

	private ComboResult getResult(Hand comboHand, Hand initialHand) {
		return new ComboResult(ComboType.FULL_HOUSE, comboHand, initialHand);
	}
}
