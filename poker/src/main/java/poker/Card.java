package poker;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.ArrayUtils;

public class Card implements Comparable<Card> {

	public enum Face {
		TWO(2, '2'),
		THREE(3, '3'),
		FOUR(4, '4'),
		FIVE(5, '5'),
		SIX(6, '6'),
		SEVEN(7, '7'),
		EIGHT(8, '8'),
		NINE(9, '9'),
		TEN(10, 'T'),
		JACK(11, 'J'),
		QUEEN(12, 'Q'),
		KING(13, 'K'),
		ACE(14, 'A');

		private int value;
		private char name;

		private Face(int value, char name) {
			this.value = value;
			this.name = name;
		}

		public int getValue() {
			return value;
		}

		public char getName() {
			return name;
		}

		private static final Map<Character, Face> map;
		static {
			map = new HashMap<Character, Face>();
			for (Face s : Face.values()) {
				map.put(s.name, s);
			}
		}

		public static Face findByName(Character name) {
			return map.get(name);
		}
	}

	public enum Suit {
		CLUBS('C'),
		DIAMONDS('D'),
		HEARTS('H'),
		SPADES('S'),
		UNKNOWN('?'); // Used when suit doesn't matter/can't be determined

		private char name;

		private Suit(char name) {
			this.name = name;
		}

		public char getName() {
			return name;
		}

		private static final Map<Character, Suit> map;
		static {
			map = new HashMap<Character, Suit>();
			for (Suit s : Suit.values()) {
				map.put(s.name, s);
			}
		}

		public static Suit findByName(Character name) {
			return map.get(name);
		}
	}

	private Face face;
	private Suit suit;

	public Card(String card) {
		this.face = Face.findByName(card.charAt(0));
		this.suit = Suit.findByName(card.charAt(1));
	}

	public Card(Face face, Suit suit) {
		this.face = face;
		this.suit = suit;
	}

	public Face getFace() {
		return face;
	}

	public Suit getSuit() {
		return suit;
	}
	
	public static Card[] mergeCards(Card[] cards1, Card[] cards2) {
		return ArrayUtils.addAll(cards1, cards2);
	}

	@Override
	public int compareTo(Card card) {
		// return Integer.compare(face.getValue(), card.getFace().getValue());
		return face.getValue() - card.getFace().getValue();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((face == null) ? 0 : face.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
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
		Card other = (Card) obj;
		if (face != other.face)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.valueOf(face.getName()) + suit.getName();
	}
}
