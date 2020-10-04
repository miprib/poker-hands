package poker.combo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import poker.Hand.ComboType;
import poker.combo.impl.FlushCombo;
import poker.combo.impl.FourOfAKindCombo;
import poker.combo.impl.FullHouseCombo;
import poker.combo.impl.HighCardCombo;
import poker.combo.impl.OnePairCombo;
import poker.combo.impl.RoyalFlushCombo;
import poker.combo.impl.StraightCombo;
import poker.combo.impl.StraightFlushCombo;
import poker.combo.impl.ThreeOfAKindCombo;
import poker.combo.impl.TwoPairsCombo;

class ComboFactoryTest {

	private static ComboFactory comboFactory;

	@BeforeAll
	public static void setup() {
		comboFactory = new ComboFactory();
	}
	
	@Test
	@DisplayName("Given a ComboType enum the correct combo should be created")
	void test() {
		assertAll("When creating a Combo", () -> {
			Combo combo = comboFactory.createCombo(ComboType.ROYAL_FLUSH);
			assertTrue(combo instanceof RoyalFlushCombo, "RoyalFlushCombo should have been created");
		}, () -> {
			Combo combo = comboFactory.createCombo(ComboType.STRAIGHT_FLUSH);
			assertTrue(combo instanceof StraightFlushCombo, "StraightFlushCombo should have been created");
		}, () -> {
			Combo combo = comboFactory.createCombo(ComboType.FOUR_OF_A_KIND);
			assertTrue(combo instanceof FourOfAKindCombo, "FourOfAKindCombo should have been created");
		}, () -> {
			Combo combo = comboFactory.createCombo(ComboType.FULL_HOUSE);
			assertTrue(combo instanceof FullHouseCombo, "FullHouseCombo should have been created");
		}, () -> {
			Combo combo = comboFactory.createCombo(ComboType.FLUSH);
			assertTrue(combo instanceof FlushCombo, "FlushCombo should have been created");
		}, () -> {
			Combo combo = comboFactory.createCombo(ComboType.STRAIGHT);
			assertTrue(combo instanceof StraightCombo, "StraightCombo should have been created");
		}, () -> {
			Combo combo = comboFactory.createCombo(ComboType.THREE_OF_A_KIND);
			assertTrue(combo instanceof ThreeOfAKindCombo, "ThreeOfAKindCombo should have been created");
		}, () -> {
			Combo combo = comboFactory.createCombo(ComboType.TWO_PAIRS);
			assertTrue(combo instanceof TwoPairsCombo, "TwoPairsCombo should have been created");
		}, () -> {
			Combo combo = comboFactory.createCombo(ComboType.ONE_PAIR);
			assertTrue(combo instanceof OnePairCombo, "OnePairCombo should have been created");
		}, () -> {
			Combo combo = comboFactory.createCombo(ComboType.HIGH_CARD);
			assertTrue(combo instanceof HighCardCombo, "HighCardCombo should have been created");
		});
	}

}
