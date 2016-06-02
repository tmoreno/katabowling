package com.tmoreno.kata.bowling.roll;

public class StrikeRoll implements Roll {

	private int nextRollValue;
	private int followingNextRollValue;

	public StrikeRoll(int nextRollValue, int followingNextRollValue) {
		this.nextRollValue = nextRollValue;
		this.followingNextRollValue = followingNextRollValue;
	}

	@Override
	public int getScore() {
		return 10 + nextRollValue + followingNextRollValue;
	}

}
