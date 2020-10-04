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

class StraightRuleTest {

	private static StraightRule straightRule;

	@BeforeAll
	public static void setup() {
		straightRule = new StraightRule();
	}

	@ParameterizedTest(name = "#{index} - Test with Hand : {0}")
    @MethodSource("poker.combo.impl.util.HandCombo#getStraightHands")
	@DisplayName("Given a STRAIGHT hand when asserting a straight all cards should be consecutive values")
	public void testStraight(Hand hand) {
		assertTrue(straightRule.isStraight(hand));
	}
	
	@ParameterizedTest(name = "#{index} - Test with Hand : {0}")
    @MethodSource("poker.combo.impl.util.HandCombo#getStraightFlushHands")
	@DisplayName("Given a STRAIGHT_FLUSH hand when asserting a straight all cards should be consecutive values")
	public void testStraightFlush(Hand hand) {
		assertTrue(straightRule.isStraight(hand));
	}
	
	@Test
	@DisplayName("Given a non straight hand when asserting a straight all cards should not be consecutive values")
	public void testNonStraight() {
		assertAll("", () -> {
			Hand hand = new Hand("2D 2D 3D 5D 6D");
			assertFalse(straightRule.isStraight(hand));
		}, () -> {
			Hand hand = new Hand("2D 2C 3D 5C 6D");
			assertFalse(straightRule.isStraight(hand));
		});
	}
}
