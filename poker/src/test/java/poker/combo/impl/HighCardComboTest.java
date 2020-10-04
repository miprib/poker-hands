package poker.combo.impl;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import poker.Hand;
import poker.Hand.ComboType;
import poker.PokerFacade;

class HighCardComboTest {

	private static PokerFacade pokerFacade;

	@BeforeAll
	public static void setup() {
		pokerFacade = new PokerFacade();
	}
	
	@ParameterizedTest(name = "#{index} - Test with Hand : {0}")
    @MethodSource("poker.combo.impl.util.HandCombo#getRoyalFlushHands")
	@DisplayName("Given a ROYAL_FLUSH hand the combo should not be a HIGH_CARD")
	public void testRoyalFlush(Hand hand) {
		assertNotEquals(ComboType.HIGH_CARD, pokerFacade.findCombo(hand).getComboType());
	}
	
	@ParameterizedTest(name = "#{index} - Test with Hand : {0}")
    @MethodSource("poker.combo.impl.util.HandCombo#getStraightFlushHands")
	@DisplayName("Given a STRAIGHT_FLUSH hand the combo should not be a HIGH_CARD")
	public void testStraightFlush(Hand hand) {
		assertNotEquals(ComboType.HIGH_CARD, pokerFacade.findCombo(hand).getComboType());
	}
	
	@ParameterizedTest(name = "#{index} - Test with Hand : {0}")
    @MethodSource("poker.combo.impl.util.HandCombo#getFourOfAKindHands")
	@DisplayName("Given a FOUR_OF_A_KIND hand the combo should not be a HIGH_CARD")
	public void testFourOfAKind(Hand hand) {
		assertNotEquals(ComboType.HIGH_CARD, pokerFacade.findCombo(hand).getComboType());
	}
	
	@ParameterizedTest(name = "#{index} - Test with Hand : {0}")
    @MethodSource("poker.combo.impl.util.HandCombo#getFullHouseHands")
	@DisplayName("Given a FULL_HOUSE hand the combo should not be a HIGH_CARD")
	public void testFullHouse(Hand hand) {
		assertNotEquals(ComboType.HIGH_CARD, pokerFacade.findCombo(hand).getComboType());
	}
	
	@ParameterizedTest(name = "#{index} - Test with Hand : {0}")
    @MethodSource("poker.combo.impl.util.HandCombo#getFlushHands")
	@DisplayName("Given a FLUSH hand the combo should be a HIGH_CARD")
	public void testFlush(Hand hand) {
		assertNotEquals(ComboType.HIGH_CARD, pokerFacade.findCombo(hand).getComboType());
	}
	
	@ParameterizedTest(name = "#{index} - Test with Hand : {0}")
    @MethodSource("poker.combo.impl.util.HandCombo#getStraightHands")
	@DisplayName("Given a STRAIGHT hand the combo should not be a HIGH_CARD")
	public void testStraight(Hand hand) {
		assertNotEquals(ComboType.HIGH_CARD, pokerFacade.findCombo(hand).getComboType());
	}
	
	@ParameterizedTest(name = "#{index} - Test with Hand : {0}")
    @MethodSource("poker.combo.impl.util.HandCombo#getThreeOfAKindHands")
	@DisplayName("Given a THREE_OF_A_KIND hand the combo should not be a HIGH_CARD")
	public void testThreeOfAKind(Hand hand) {
		assertNotEquals(ComboType.HIGH_CARD, pokerFacade.findCombo(hand).getComboType());
	}
	
	@ParameterizedTest(name = "#{index} - Test with Hand : {0}")
    @MethodSource("poker.combo.impl.util.HandCombo#getTwoPairsHands")
	@DisplayName("Given a TWO_PAIRS hand the combo should not be a HIGH_CARD")
	public void testTwoPairs(Hand hand) {
		assertNotEquals(ComboType.HIGH_CARD, pokerFacade.findCombo(hand).getComboType());
	}
	
	@ParameterizedTest(name = "#{index} - Test with Hand : {0}")
    @MethodSource("poker.combo.impl.util.HandCombo#getOnePairHands")
	@DisplayName("Given a ONE_PAIR hand the combo should not be a HIGH_CARD")
	public void testOnePair(Hand hand) {
		assertNotEquals(ComboType.HIGH_CARD, pokerFacade.findCombo(hand).getComboType());
	}
}
