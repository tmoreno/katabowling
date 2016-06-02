package com.tmoreno.kata.bowling.roll;

public class WithPointsRoll implements Roll {

	private int points;

	public WithPointsRoll(int points) {
		this.points = points;
	}

	@Override
	public int getScore() {
		return points;
	}

}
