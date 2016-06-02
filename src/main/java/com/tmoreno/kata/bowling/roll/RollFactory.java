package com.tmoreno.kata.bowling.roll;

public class RollFactory {

	private static final String MISS_SYMBOL = "-";
	private static final String STRIKE_SYMBOL = "X";

	public static BonusRoll createBonusRoll() {
		return new BonusRoll();
	}

	public static MissRoll createMissRoll() {
		return new MissRoll();
	}

	public static Roll createWithPointsRoll(String roll) {
		return new WithPointsRoll(getValue(roll));
	}

	public static SpareRoll createSpareRoll(String previousRoll, String nextRoll) {
		return new SpareRoll(getValue(previousRoll), getValue(nextRoll));
	}

	public static StrikeRoll createStrikeRoll(String nextRoll,
			String followingNextRoll) {
		return new StrikeRoll(getValue(nextRoll), getValue(followingNextRoll));
	}

	private static int getValue(String roll) {
		if (STRIKE_SYMBOL.equals(roll)) {
			return 10;
		}
		else if (MISS_SYMBOL.equals(roll)) {
			return 0;
		}
		else {
			return Integer.parseInt(roll);
		}
	}
}
