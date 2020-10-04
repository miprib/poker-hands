package poker.combo.impl.rule;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import poker.Hand;

class FlushRuleTest {

	private static FlushRule flushRule;

	@BeforeAll
	public static void setup() {
		flushRule = new FlushRule();
	}

	@ParameterizedTest(name = "#{index} - Test with Hand : {0}")
	@MethodSource("poker.combo.impl.util.HandCombo#getFlushHands")
	@DisplayName("Given a FLUSH hand when asserting a flush all cards should be in the same suit")
	public void testFlush(Hand hand) {
		assertTrue(flushRule.isFlush(hand));
	}

	@ParameterizedTest(name = "#{index} - Test with Hand : {0}")
	@MethodSource("poker.combo.impl.util.HandCombo#getRoyalFlushHands")
	@DisplayName("Given a ROYAL_FLUSH hand when asserting a flush all cards should be in the same suit")
	public void testRoyalFlush(Hand hand) {
		assertTrue(flushRule.isFlush(hand));
	}

	@ParameterizedTest(name = "#{index} - Test with Hand : {0}")
	@MethodSource("poker.combo.impl.util.HandCombo#getStraightFlushHands")
	@DisplayName("Given a STRAIGHT_FLUSH hand when asserting a flush all cards should be in the same suit")
	public void testStraightFlush(Hand hand) {
		assertTrue(flushRule.isFlush(hand));
	}

	@Test
	@DisplayName("Given a non flush hand when asserting a flush all cards should be in the same suit")
	public void testNotFlush() {
		assertAll(() -> {
			Hand hand = new Hand("2D 2D 2D 2D 3C");
			assertFalse(flushRule.isFlush(hand));
		}, () -> {
			Hand hand = new Hand("2D 3D 2D 2C 3D");
			assertFalse(flushRule.isFlush(hand));
		}, () -> {
			Hand hand = new Hand("2C 2D 2C 2D 3D");
			assertFalse(flushRule.isFlush(hand));
		});
	}
}
