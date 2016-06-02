package com.tmoreno.kata.bowling;

import java.util.List;

import com.tmoreno.kata.bowling.roll.Roll;

public class LineScore {

	private List<Roll> line;

	public LineScore(List<Roll> line) {
		this.line = line;
	}

	public int calc() {
		int score = 0;

		for (Roll roll : line) {
			score += roll.getScore();
		}

		return score;
	}

}
