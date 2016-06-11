package com.tmoreno.kata.bowling.roll;

public class RollFactory {

	public static BonusRoll createBonusRoll() {
		return new BonusRoll();
	}

	public static MissRoll createMissRoll() {
		return new MissRoll();
	}

	public static Roll createWithPointsRoll(int points) {
		return new WithPointsRoll(points);
	}

	public static SpareRoll createSpareRoll(int previousRollValue,
			int nextRollValue) {
		return new SpareRoll(previousRollValue, nextRollValue);
	}

	public static StrikeRoll createStrikeRoll(int nextRollValue,
			int followingNextRollValue) {
		return new StrikeRoll(nextRollValue, followingNextRollValue);
	}
}
