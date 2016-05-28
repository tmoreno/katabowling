package com.tmoreno.kata.bowling;

public class LineScore {

	private String line;

	public LineScore(String line) {
		this.line = line;
	}

	public int calc() {
		int score = 0;

		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) != '-') {
				score += Character.getNumericValue(line.charAt(i));
			}
		}

		return score;
	}

}
