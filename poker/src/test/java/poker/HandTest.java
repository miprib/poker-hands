package poker;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HandTest {
	
	@Test
	@DisplayName("Given a string of cards when creating a hand it should not be sorted")
	void testCreateHandWithoutSorting() {
		Hand expectedHand = new Hand("2C AS 8S 8D TD", false);
		Hand actualHand = new Hand("2C AS 8S 8D TD", false);
		assertEquals(expectedHand, actualHand);
	}
	
	@Test
	@DisplayName("Given a string of cards when creating a hand it should be sorted")
	void testCreateHandWithSorting() {
		Hand expectedHand = new Hand("2C 8S 8D TD AS", false);
		Hand actualHand = new Hand("2C AS 8S 8D TD");
		assertEquals(expectedHand, actualHand);
	}

	@Test
	@DisplayName("Given two hands when merging the result should not be sorted")
	void testMergeHandsWithoutSorting() {
		Hand hand1 = new Hand("3S 3H 3D");
		Hand hand2 = new Hand("2S 2H");
		Hand mergedHands = Hand.mergeHands(hand1, hand2);
		assertEquals(new Hand("3S 3H 3D 2S 2H", false), mergedHands);
	}
	
	@Test
	@DisplayName("Given two hands when merging the result should be sorted")
	void testMergeHandsWithSorting() {
		Hand hand1 = new Hand("3S 3H 3D");
		Hand hand2 = new Hand("2S 2H");
		Hand mergedHands = Hand.mergeHands(hand1, hand2, true);
		assertEquals(new Hand("2S 2H 3S 3H 3D"), mergedHands);
	}
	
	@Test
	@DisplayName("Given two hands when comparing higher value hand should be better")
	void testHandCompare() {
		assertAll("Given two hands when comparing", () -> {
			Hand hand1 = new Hand("2? 3? 4? 5? 6?");
			Hand hand2 = new Hand("2? 3? 4? A? 6?");
			assertTrue(hand1.compareTo(hand2) < 0, hand2 + " should be better");
		}, () -> {
			Hand hand1 = new Hand("2? A? 4? 5? 6?");
			Hand hand2 = new Hand("2? 3? 4? 5? 6?");
			assertTrue(hand1.compareTo(hand2) > 0, hand1 + " should be better");
		}, () -> {
			Hand hand1 = new Hand("2? A? 4? 5? 6?");
			Hand hand2 = new Hand("2? A? A? 5? 7?");
			assertTrue(hand1.compareTo(hand2) < 0, hand2 + " should be better");
		}, () -> {
			Hand hand1 = new Hand("A? A? K? K? 6?");
			Hand hand2 = new Hand("K? K? K? 5? 7?");
			assertTrue(hand1.compareTo(hand2) > 0, hand1 + " should be better");
		});
	}
	
	@Test
	@DisplayName("Given two hands when checking equality equal hands should have the same face and suit cards")
	void testHandCheckEquality() {
		assertAll("Given two hands when comparing", () -> {
			Hand hand1 = new Hand("2? 3? 4? 5? 6?");
			Hand hand2 = new Hand("2? 3? 4? 5? 6?");
			assertTrue(hand1.equals(hand2), hand1 + "and" + hand2 + " should be equal");
		}, () -> {
			Hand hand1 = new Hand("2? 3? 4? 5? A?");
			Hand hand2 = new Hand("2? 3? 4? 5? 6?");
			assertFalse(hand1.equals(hand2), hand1 + "and" + hand2 + " should not be equal");
		}, () -> {
			Hand hand1 = new Hand("2? 3? 4? 5? 6?");
			Hand hand2 = new Hand("2? 3? 4? 5? A?");
			assertFalse(hand1.equals(hand2), hand1 + "and" + hand2 + " should not be equal");
		}, () -> {
			Hand hand = new Hand("2? 3? 4? 5? 6?");
			assertTrue(hand.equals(hand), hand + "and" + hand + " should be equal");
		}, () -> {
			Hand hand1 = new Hand("2? 3? 4? 5? 6?");
			Hand hand2 = new Hand("2? 3? 4? 5? 6D");
			assertFalse(hand1.equals(hand2), hand1 + "and" + hand2 + " should not be equal");
		});
	}
}
