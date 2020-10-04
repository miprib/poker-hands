package poker.combo;

import java.util.List;

import poker.Hand;

public class ComboChecker {

	private List<Combo> combos;

	public ComboChecker(List<Combo> combos) {
		this.combos = combos;
	}

	public ComboResult findCombo(Hand hand) {
		for (Combo combo : combos) {
			ComboResult comboResult = combo.checkHand(hand);
			if (comboResult != null) {
				return comboResult;
			}
		}
		throw new RuntimeException("Couldn't find a combo for " + hand);
	}
}
