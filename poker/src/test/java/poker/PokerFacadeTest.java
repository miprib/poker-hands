package poker;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import poker.Hand.ComboType;

class PokerFacadeTest {

	private static PokerFacade pokerFacade;

	@BeforeAll
	public static void setup() {
		pokerFacade = new PokerFacade();
	}
	
	@Test
	@DisplayName("Given two hands when finding winning hand better hand should win")
	public void testGameVictories() {
		assertAll("Given Project Euler test game", () -> {
			Hand hand1 = new Hand("5H 5C 6S 7S KD");
			Hand hand2 = new Hand("2C 3S 8S 8D TD");
			assertEquals(hand2, pokerFacade.findWinningCombo(hand1, hand2).getInitialHand(),
					hand2 + " should have won");
		}, () -> {
			Hand hand1 = new Hand("5D 8C 9S JS AC");
			Hand hand2 = new Hand("2C 5C 7D 8S QH");
			assertEquals(hand1, pokerFacade.findWinningCombo(hand1, hand2).getInitialHand(),
					hand1 + " should have won");
		}, () -> {
			Hand hand1 = new Hand("2D 9C AS AH AC");
			Hand hand2 = new Hand("3D 6D 7D TD QD");
			assertEquals(hand2, pokerFacade.findWinningCombo(hand1, hand2).getInitialHand(),
					hand2 + " should have won");
		}, () -> {
			Hand hand1 = new Hand("4D 6S 9H QH QC");
			Hand hand2 = new Hand("3D 6D 7H QD QS");
			assertEquals(hand1, pokerFacade.findWinningCombo(hand1, hand2).getInitialHand(),
					hand1 + " should have won");
		}, () -> {
			Hand hand1 = new Hand("2H 2D 4C 4D 4S");
			Hand hand2 = new Hand("3C 3D 3S 9S 9D");
			assertEquals(hand1, pokerFacade.findWinningCombo(hand1, hand2).getInitialHand(),
					hand1 + " should have won");
		}, () -> {
			Hand hand1 = new Hand("2C 3S 8S 8D TD");
			Hand hand2 = new Hand("4C 4H 6S 7S KD");
			assertEquals(hand1, pokerFacade.findWinningCombo(hand1, hand2).getInitialHand(),
					hand1 + " should have won");
		}, () -> {
			Hand hand1 = new Hand("TD JD QD KD AD");
			Hand hand2 = new Hand("4C 4H 6S 7S KD");
			assertEquals(hand1, pokerFacade.findWinningCombo(hand1, hand2).getInitialHand(),
					hand1 + " should have won");
		}, () -> {		
			Hand hand1 = new Hand("2C 2D 3C 4C 5C");
			Hand hand2 = new Hand("2C 2D TC JC QC");
			assertEquals(hand2, pokerFacade.findWinningCombo(hand1, hand2).getInitialHand(),
					hand2 + " should have won");
		});
	}

	@Test
	@DisplayName("Given two hands when finding winning combo better combo/higher cards should win")
	public void testGameCombos() {
		assertAll("Given Project Euler test game", () -> {
			Hand hand1 = new Hand("5H 5C 6S 7S KD");
			Hand hand2 = new Hand("2C 3S 8S 8D TD");
			assertEquals(ComboType.ONE_PAIR, pokerFacade.findWinningCombo(hand1, hand2).getComboType(),
					"ONE_PAIR " + hand2 + " should have won");
		}, () -> {
			Hand hand1 = new Hand("5D 8C 9S JS AC");
			Hand hand2 = new Hand("2C 5C 7D 8S QH");
			assertEquals(ComboType.HIGH_CARD, pokerFacade.findWinningCombo(hand1, hand2).getComboType(),
					"HIGH_CARD " + hand1 + " should have won");
		}, () -> {
			Hand hand1 = new Hand("2D 9C AS AH AC");
			Hand hand2 = new Hand("3D 6D 7D TD QD");
			assertEquals(ComboType.FLUSH, pokerFacade.findWinningCombo(hand1, hand2).getComboType(),
					"FLUSH " + hand2 + " should have won");
		}, () -> {
			Hand hand1 = new Hand("4D 6S 9H QH QC");
			Hand hand2 = new Hand("3D 6D 7H QD QS");
			assertEquals(ComboType.ONE_PAIR, pokerFacade.findWinningCombo(hand1, hand2).getComboType(),
					"ONE_PAIR " + hand1 + " should have won");
		}, () -> {
			Hand hand1 = new Hand("2H 2D 4C 4D 4S");
			Hand hand2 = new Hand("3C 3D 3S 9S 9D");
			assertEquals(ComboType.FULL_HOUSE, pokerFacade.findWinningCombo(hand1, hand2).getComboType(),
					"FULL_HOUSE " + hand1 + " should have won");
		});
	}

}
