package poker;

import java.util.ArrayList;
import java.util.List;

import poker.Hand.ComboType;
import poker.combo.Combo;
import poker.combo.ComboChecker;
import poker.combo.ComboFactory;
import poker.combo.ComboResult;
import poker.utils.ProjectUtils;

public class PokerFacade {
	private ComboFactory comboFactory = new ComboFactory();
	private ComboChecker comboChecker;

	public PokerFacade() {
		initComboChecker();
	}
	
	public void playAllGames(String gameFile) {
		List<String> pokerGames = ProjectUtils.readFile(gameFile);	
		int player1Voctories = 0;
		int player2Voctories = 0;
		for (String pokerGame : pokerGames) {
			//System.out.println(pokerGame);
			Hand hand1 = new Hand(pokerGame.substring(0, 14));
			Hand hand2 = new Hand(pokerGame.substring(15));			
			ComboResult winningCombo = findWinningCombo(hand1, hand2);			
			if (winningCombo.getInitialHand().equals(hand1)) {
				player1Voctories++;
			} else {
				player2Voctories++;
			}
		}	
		System.out.println("Player 1 won " + player1Voctories + " games.");
		System.out.println("Player 2 won " + player2Voctories + " games.");
	}
	
	public void playOneGame(String hand1, String hand2) {
		Hand testHand1 = new Hand(hand1);
		Hand testHand2 = new Hand(hand2);
		ComboResult winningCombo = findWinningCombo(testHand1,
				testHand2);
		String winningPlayer;
		if (winningCombo.getInitialHand().equals(testHand1)) {
			winningPlayer = "Player 1";
		} else {
			winningPlayer = "Player 2";
		}
		System.out.println(winningPlayer + " won: " + winningCombo);
	}

	public ComboResult findWinningCombo(Hand hand1, Hand hand2) {
		ComboResult hand1Combo = comboChecker.findCombo(hand1);
		ComboResult hand2Combo = comboChecker.findCombo(hand2);
		int comboCompare = hand1Combo.getComboType().compareTo(hand2Combo.getComboType());
		if (comboCompare == 0) {
			return resolveComboTie(hand1Combo, hand2Combo);
		} else if (comboCompare > 0) {
			return hand1Combo;
		} else {
			return hand2Combo;
		}
	}

	public ComboResult findCombo(Hand hand) {
		return comboChecker.findCombo(hand);
	}

	private ComboResult resolveComboTie(ComboResult hand1Combo, ComboResult hand2Combo) {
		int compareResult = hand1Combo.getComboHand().compareTo(hand2Combo.getComboHand());
		if (compareResult == 0) {
			return resolveComboHandTie(hand1Combo, hand2Combo);
		} else if (compareResult > 0) {
			return hand1Combo;
		} else {
			return hand2Combo;
		}
	}

	private ComboResult resolveComboHandTie(ComboResult hand1Combo, ComboResult hand2Combo) {
		int compareResult = hand1Combo.getInitialHand().compareTo(hand2Combo.getInitialHand());
		if (compareResult > 0) {
			return hand1Combo;
		} else {
			// Doesn't matter which hand we return if they're equal
			return hand2Combo;
		}
	}

	private void initComboChecker() {
		List<Combo> combos = new ArrayList<>();
		// Order of combinations is very important since we quit at the first combo
		// found. Search is started from the best one (ROYAL_FLUSH) and goes down to the
		// worst (HIGH_CARD).
		combos.add(comboFactory.createCombo(ComboType.ROYAL_FLUSH));
		combos.add(comboFactory.createCombo(ComboType.STRAIGHT_FLUSH));
		combos.add(comboFactory.createCombo(ComboType.FOUR_OF_A_KIND));
		combos.add(comboFactory.createCombo(ComboType.FULL_HOUSE));
		combos.add(comboFactory.createCombo(ComboType.FLUSH));
		combos.add(comboFactory.createCombo(ComboType.STRAIGHT));
		combos.add(comboFactory.createCombo(ComboType.THREE_OF_A_KIND));
		combos.add(comboFactory.createCombo(ComboType.TWO_PAIRS));
		combos.add(comboFactory.createCombo(ComboType.ONE_PAIR));
		combos.add(comboFactory.createCombo(ComboType.HIGH_CARD));
		comboChecker = new ComboChecker(combos);
	}
}
