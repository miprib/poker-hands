package poker.combo.impl.rule;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import poker.Hand;

class FrequencyRuleTest {
	
	private static FrequencyRule frequencyRule;

	@BeforeAll
	public static void setup() {
		frequencyRule = new FrequencyRule();
	}

	@Test
	@DisplayName("Given a hand when looking for card repetition all distinct value cards should be in separate hands")
	void testRepetition() {
		assertAll("Given a hand when looking for card repetition", () -> {
			Hand hand = new Hand("2D 2C 2H 2S 3D");
			List<Hand> actualRepetition = frequencyRule.getRepeatingHands(hand);
			List<Hand> expectedRepetition = new ArrayList<>();
			expectedRepetition.add(new Hand("3?"));
			expectedRepetition.add(new Hand("2? 2? 2? 2?"));
			assertTrue(actualRepetition.containsAll(expectedRepetition), hand + " should be " + expectedRepetition);
		}, () -> {
			Hand hand = new Hand("2D 2C 2H 3S 3D");
			List<Hand> actualRepetition = frequencyRule.getRepeatingHands(hand);
			List<Hand> expectedRepetition = new ArrayList<>();
			expectedRepetition.add(new Hand("3? 3?"));
			expectedRepetition.add(new Hand("2? 2? 2?"));
			assertTrue(actualRepetition.containsAll(expectedRepetition), hand + " should be " + expectedRepetition);
		}, () -> {
			Hand hand = new Hand("2D 3D 4D 5D 6D");
			List<Hand> actualRepetition = frequencyRule.getRepeatingHands(hand);
			List<Hand> expectedRepetition = new ArrayList<>();
			expectedRepetition.add(new Hand("2?"));
			expectedRepetition.add(new Hand("3?"));
			expectedRepetition.add(new Hand("4?"));
			expectedRepetition.add(new Hand("5?"));
			expectedRepetition.add(new Hand("6?"));
			assertTrue(actualRepetition.containsAll(expectedRepetition), hand + " should be " + expectedRepetition);
		}, () -> {
			Hand hand = new Hand("2D 3D 4D 5D 6D");
			List<Hand> actualRepetition = frequencyRule.getRepeatingHands(hand);
			List<Hand> falseRepetition = new ArrayList<>();
			falseRepetition.add(new Hand("3? 3?"));
			falseRepetition.add(new Hand("2? 2? 2?"));
			assertFalse(actualRepetition.containsAll(falseRepetition), hand + " should not be " + falseRepetition);
		});
	}

}
