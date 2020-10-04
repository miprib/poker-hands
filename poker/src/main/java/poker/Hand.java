package poker;

import java.util.Arrays;

public class Hand implements Comparable<Hand> {

	public enum ComboType {
		HIGH_CARD,
		ONE_PAIR,
		TWO_PAIRS,
		THREE_OF_A_KIND,
		STRAIGHT,
		FLUSH,
		FULL_HOUSE,
		FOUR_OF_A_KIND,
		STRAIGHT_FLUSH,
		ROYAL_FLUSH
	}

	private Card[] cards;

	public Hand(String hand, boolean needsSorting) {
		String[] cards = hand.split(" ");
		this.cards = new Card[cards.length];
		for (int i = 0; i < cards.length; i++) {
			this.cards[i] = new Card(cards[i]);
		}
		if(needsSorting) {
			Arrays.sort(this.cards);
		}
	}
	
	public Hand(String hand) {
		this(hand, true);
	}

	public Hand(Card[] cards, boolean needsSorting) {
		this.cards = cards;
		if (needsSorting) {
			Arrays.sort(this.cards);
		}
	}

	public Hand(Card[] cards) {
		this(cards, true);
	}

	public Card[] getCards() {
		return cards;
	}
	
	public static Hand mergeHands(Hand hand1, Hand hand2, boolean needsSorting) {
		Card[] mergedCards = Card.mergeCards(hand1.getCards(), hand2.getCards());
		return new Hand(mergedCards, needsSorting);
	}
	
	/** Merges the cards without sorting */
	public static Hand mergeHands(Hand hand1, Hand hand2) {
		return mergeHands(hand1, hand2, false);
	}

	@Override
	public int compareTo(Hand hand) {
		if (equals(hand)) {
			return 0;
		}
		return compareHighestCards(this, hand);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(cards);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hand other = (Hand) obj;
		if (!Arrays.equals(cards, other.cards))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return Arrays.toString(cards);
	}

	private int compareHighestCards(Hand hand1, Hand hand2) {
		Card[] cards1 = hand1.getCards();
		Card[] cards2 = hand2.getCards();
		int compareResult;
		for (int i = cards.length - 1; i >= 0; i--) {
			compareResult = cards1[i].compareTo(cards2[i]);
			if (compareResult != 0) {
				return compareResult;
			}
		}
		throw new RuntimeException("Couldn't find a winning hand");
	}
}
