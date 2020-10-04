package poker.combo;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

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

public class ComboFactory {

	private static final Map<ComboType, Supplier<Combo>> factoryMap = new HashMap<>();
	static {
		factoryMap.put(ComboType.ROYAL_FLUSH, () -> new RoyalFlushCombo(new FlushCombo()));
		factoryMap.put(ComboType.STRAIGHT_FLUSH, () -> new StraightFlushCombo(new StraightCombo(), new FlushCombo()));
		factoryMap.put(ComboType.FOUR_OF_A_KIND, () -> new FourOfAKindCombo());
		factoryMap.put(ComboType.FULL_HOUSE, () -> new FullHouseCombo(new ThreeOfAKindCombo(), new OnePairCombo()));
		factoryMap.put(ComboType.FLUSH, FlushCombo::new);
		factoryMap.put(ComboType.STRAIGHT, StraightCombo::new);
		factoryMap.put(ComboType.THREE_OF_A_KIND, ThreeOfAKindCombo::new);
		factoryMap.put(ComboType.TWO_PAIRS, TwoPairsCombo::new);
		factoryMap.put(ComboType.ONE_PAIR, OnePairCombo::new);
		factoryMap.put(ComboType.HIGH_CARD, HighCardCombo::new);
	}

	public Combo createCombo(ComboType comboType) {
		Supplier<Combo> factory = factoryMap.get(comboType);
		if (factory == null) {
			throw new RuntimeException("No combo found for type: " + comboType);
		}
		return factory.get();
	}
}
