package poker.combo.impl.util;

import java.util.ArrayList;
import java.util.List;

import poker.Hand;

public class HandCombo {
	// TODO: generate poker hand combinations to use
	// in tests

	/** Ten, Jack, Queen, King, Ace, in same suit. */
	public static List<Hand> getRoyalFlushHands() {
		List<Hand> hands = new ArrayList<>();
		hands.add(new Hand("TD JD QD KD AD"));
		hands.add(new Hand("TC JC QC KC AC"));
		hands.add(new Hand("TH JH QH KH AH"));
		hands.add(new Hand("TS JS QS KS AS"));
		return hands;
	}

	/** All cards are consecutive values of same suit. */
	public static List<Hand> getStraightFlushHands() {
		List<Hand> hands = new ArrayList<>();
		hands.add(new Hand("9D TD JD QD KD"));
		hands.add(new Hand("8C 9C TC JC QC"));
		hands.add(new Hand("7H 8H 9H TH JH"));
		hands.add(new Hand("6S 7S 8S 9S TS"));
		return hands;
	}

	/** Four cards of the same value. */
	public static List<Hand> getFourOfAKindHands() {
		List<Hand> hands = new ArrayList<>();
		hands.add(new Hand("2D 2C 2H 2S KS"));
		hands.add(new Hand("5D 5C 5H 5S KS"));
		hands.add(new Hand("AD AC AH AS KS"));
		hands.add(new Hand("TD TC TH TS KS"));
		return hands;
	}

	/** Three of a kind and a pair. */
	public static List<Hand> getFullHouseHands() {
		List<Hand> hands = new ArrayList<>();
		hands.add(new Hand("2D 2C 2H KD KC"));
		hands.add(new Hand("5D 5C 5H TD TC"));
		hands.add(new Hand("AD AC AH QD QC"));
		hands.add(new Hand("TD TC TH 2D 2C"));
		return hands;
	}

	/** All cards of the same suit. */
	public static List<Hand> getFlushHands() {
		List<Hand> hands = new ArrayList<>();
		hands.add(new Hand("2D 4D 6D 8D TD"));
		hands.add(new Hand("2C 4C 6C 8C TC"));
		hands.add(new Hand("2H 4H 6H 8H TH"));
		hands.add(new Hand("2S 4S 6S 8S TS"));
		return hands;
	}

	/** All cards are consecutive values. */
	public static List<Hand> getStraightHands() {
		List<Hand> hands = new ArrayList<>();
		hands.add(new Hand("9D TC JH QS KD"));
		hands.add(new Hand("8D 9C TH JS QD"));
		hands.add(new Hand("7D 8C 9H TS JD"));
		hands.add(new Hand("6D 7C 8H 9S TD"));
		return hands;
	}

	/** Three cards of the same value. */
	public static List<Hand> getThreeOfAKindHands() {
		List<Hand> hands = new ArrayList<>();
		hands.add(new Hand("2D 2C 2H QD KC"));
		hands.add(new Hand("5D 5C 5H 9D TC"));
		hands.add(new Hand("AD AC AH JD QC"));
		hands.add(new Hand("TD TC TH 2D 3C"));
		return hands;
	}

	/** Two different pairs. */
	public static List<Hand> getTwoPairsHands() {
		List<Hand> hands = new ArrayList<>();
		hands.add(new Hand("2D 2C 3H 3D KC"));
		hands.add(new Hand("5D 5C 6H 6D TC"));
		hands.add(new Hand("AD AC 2H 2D QC"));
		hands.add(new Hand("TD TC QH QD 3C"));
		return hands;
	}

	/** Two cards of the same value. */
	public static List<Hand> getOnePairHands() {
		List<Hand> hands = new ArrayList<>();
		hands.add(new Hand("2D 2C 3H 4D KC"));
		hands.add(new Hand("5D 5C 6H 8D TC"));
		hands.add(new Hand("AD AC 2H 3D QC"));
		hands.add(new Hand("TD TC QH 5D 3C"));
		return hands;
	}

}
