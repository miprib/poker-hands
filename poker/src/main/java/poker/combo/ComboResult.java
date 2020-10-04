package poker.combo;

import poker.Hand;
import poker.Hand.ComboType;

public class ComboResult {

	private ComboType comboType;
	private Hand comboHand;
	private Hand initialHand;

	public ComboResult(ComboType comboType, Hand comboHand, Hand initialHand) {
		this.comboType = comboType;
		this.comboHand = comboHand;
		this.initialHand = initialHand;
	}

	public ComboType getComboType() {
		return comboType;
	}

	public Hand getComboHand() {
		return comboHand;
	}

	public Hand getInitialHand() {
		return initialHand;
	}

	@Override
	public String toString() {
		return "ComboResult [comboType=" + comboType + ", comboHand=" + comboHand + ", initialHand=" + initialHand + "]";
	}
}
