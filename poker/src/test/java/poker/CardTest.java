package poker;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import poker.Card.Face;
import poker.Card.Suit;

class CardTest {
	
    @ParameterizedTest(name = "#{index} - Is Face {0}?")
    @EnumSource(value = Face.class)
    @DisplayName("Given a Face enum when creating a new Card(Face, Suit) it should match new Card(String)")
    public void testCardFaceEnum(Face face) {
        Card actualCard = new Card(face, Suit.UNKNOWN);
        Card expectedCard = new Card(String.valueOf(face.getName()) + Suit.UNKNOWN.getName());
        assertEquals(expectedCard.getFace(), actualCard.getFace());
    }
    
    @ParameterizedTest(name = "#{index} - Is Face {0}?")
    @ValueSource(strings = {"2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A"})
    @DisplayName("Given a face string when creating a new new Card(String) it should match new Card(Face, Suit)")
    public void testCardFaceString(String face) {
        Card actualCard = new Card(face + Suit.UNKNOWN.getName());
        Face faceEnum = Face.findByName(face.charAt(0));
        Card expectedCard = new Card(faceEnum, Suit.UNKNOWN);
        assertEquals(expectedCard.getFace(), actualCard.getFace());
    }
    
    @ParameterizedTest(name = "#{index} - Is Suit {0}?")
    @EnumSource(value = Suit.class)
    @DisplayName("Given a Suit enum when creating a new Card(Face, Suit) it should match new Card(String)")
    public void testCardSuiteEnum(Suit suit) {
        Card actualCard = new Card(Face.ACE, suit);
        Card expectedCard = new Card(String.valueOf(Face.ACE.getName()) + suit.getName());
        assertEquals(expectedCard.getSuit(), actualCard.getSuit());
    }
    
    @ParameterizedTest(name = "#{index} - Is Suit {0}?")
    @ValueSource(strings = {"C", "F", "H", "S", "?"})
    @DisplayName("Given a suit string when creating a new new Card(String) it should match new Card(Face, Suit)")
    public void testCardSuitString(String suit) {
        Card actualCard = new Card(Face.ACE.getName() + suit);
        Suit suitEnum = Suit.findByName(suit.charAt(0));
        Card expectedCard = new Card(Face.ACE, suitEnum);
        assertEquals(expectedCard.getSuit(), actualCard.getSuit());
    }
    
	@Test
	@DisplayName("Given two cards when comparing equal cards should return 0")
	public void testCardCompareEqualValue() {
		assertAll("Given two cards when comparing ", () -> {
			Card card1 = new Card(Face.ACE, Suit.DIAMONDS);
			Card card2 = new Card(Face.ACE, Suit.DIAMONDS);
			assertTrue(card1.compareTo(card2) == 0, card1 + " and " + card2 + " should return 0");
		}, () -> {
			Card card1 = new Card(Face.ACE, Suit.DIAMONDS);
			Card card2 = new Card(Face.ACE, Suit.HEARTS);
			assertTrue(card1.compareTo(card2) == 0, card1 + " and " + card2 + " should return 0");
		});
	}
    
    @Test
    @DisplayName("Given two cards when comparing lesser card should return negative value")
    public void testCardCompareMore() {
		assertAll("Given two cards when comparing ", () -> {
			Card card1 = new Card(Face.TWO, Suit.DIAMONDS);
			Card card2 = new Card(Face.ACE, Suit.DIAMONDS);
			assertTrue(card1.compareTo(card2) == -12, card1 + " and " + card2 + " should return -12");
		}, () -> {
			Card card1 = new Card(Face.TWO, Suit.DIAMONDS);
			Card card2 = new Card(Face.ACE, Suit.HEARTS);
			assertTrue(card1.compareTo(card2) == -12, card1 + " and " + card2 + " should return -12");
		});
    }
    
    @Test
    @DisplayName("Given two cards when comparing higher card should return positive value")
    public void testCardCompareLess() {
		assertAll("Given two cards when comparing", () -> {
			Card card1 = new Card(Face.ACE, Suit.DIAMONDS);
			Card card2 = new Card(Face.TWO, Suit.DIAMONDS);
			assertTrue(card1.compareTo(card2) == 12, card1 + " and " + card2 + " should return 12");
		}, () -> {
			Card card1 = new Card(Face.ACE, Suit.DIAMONDS);
			Card card2 = new Card(Face.TWO, Suit.HEARTS);
			assertTrue(card1.compareTo(card2) == 12, card1 + " and " + card2 + " should return 12");
		});
    }
    
    @Test
    @DisplayName("Given two cards when checking equality same face and suit cards should be equal")
	public void testCardCheckEquality() {
		assertAll("Given two cards when checking equality", () -> {
			Card card1 = new Card(Face.ACE, Suit.DIAMONDS);
			Card card2 = new Card(Face.ACE, Suit.DIAMONDS);
			assertTrue(card1.equals(card2), card1 + " and " + card2 + " should be equal");
		}, () -> {
			Card card1 = new Card(Face.ACE, Suit.DIAMONDS);
			Card card2 = new Card(Face.ACE, Suit.HEARTS);
			assertFalse(card1.equals(card2), card1 + " and " + card2 + " should not be equal");
		}, () -> {
			Card card1 = new Card(Face.ACE, Suit.DIAMONDS);
			Card card2 = new Card(Face.TWO, Suit.HEARTS);
			assertFalse(card1.equals(card2), card1 + " and " + card2 + " should not be equal");
		}, () -> {
			Card card1 = new Card(Face.ACE, Suit.DIAMONDS);
			Card card2 = new Card(Face.ACE, Suit.HEARTS);
			assertFalse(card1.equals(card2), card1 + " and " + card2 + " should not be equal");
		});
    }
}
