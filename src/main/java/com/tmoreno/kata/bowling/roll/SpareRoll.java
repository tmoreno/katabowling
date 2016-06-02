package com.tmoreno.kata.bowling.roll;

public class SpareRoll implements Roll {

	private int previousRollValue;
	private int nextRollValue;

	public SpareRoll(int previousRollValue, int nextRollValue) {
		this.previousRollValue = previousRollValue;
		this.nextRollValue = nextRollValue;
	}

	@Override
	public int getScore() {
		return 10 - previousRollValue + nextRollValue;
	}

}
