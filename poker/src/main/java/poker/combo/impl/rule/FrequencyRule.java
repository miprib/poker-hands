package poker.combo.impl.rule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import poker.Card;
import poker.Card.Face;
import poker.Card.Suit;
import poker.Hand;

public class FrequencyRule {

	public List<Hand> getRepeatingHands(Hand initialHand) {
		List<Hand> hands = new ArrayList<>();
		Map<Face, Long> cardFrequency = findCardFrequency(initialHand);
		for (Entry<Face, Long> entry : cardFrequency.entrySet()) {
			Face face = entry.getKey();
			Long frequency = entry.getValue();
			Card[] cards = createRepeatingCards(face, frequency.intValue());
			Hand hand = new Hand(cards, false);
			hands.add(hand);
		}
		return hands;
	}

	private Card[] createRepeatingCards(Face face, int frequency) {
		Card[] comboCards = new Card[frequency];
		for (int i = 0; i < frequency; i++) {
			comboCards[i] = new Card(face, Suit.UNKNOWN);
		}
		return comboCards;
	}

	private Map<Face, Long> findCardFrequency(Hand hand) {
		return Arrays.stream(hand.getCards())
				.collect(Collectors.groupingBy(
						Card::getFace,
						Collectors.counting()));
	}
}
