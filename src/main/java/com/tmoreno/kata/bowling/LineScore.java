package com.tmoreno.kata.bowling;

public class LineScore {

	private static final String MISS_SYMBOL = "-";
	private static final String SPARE_SYMBOL = "/";
	private static final String STRIKE_SYMBOL = "X";

	private String[] line;

	public LineScore(String line) {
		this.line = line.split("");
	}

	public int calc() {
		int score = 0;

		for (int i = 0; i < line.length; i++) {
			if (SPARE_SYMBOL.equals(line[i])) {
				score += spareScore(i);
			}
			else if (STRIKE_SYMBOL.equals(line[i])) {
				score += strikeScore(i);
			}
			else if (!MISS_SYMBOL.equals(line[i]) && !isBonus(i)) {
				score += normalScore(i);
			}
		}

		return score;
	}

	private boolean isBonus(int i) {
		return i >= 20 || (i == 19 && STRIKE_SYMBOL.equals(line[i - 1]));
	}

	private int normalScore(int i) {
		return Integer.parseInt(line[i]);
	}

	private int spareScore(int i) {
		return 10 + Integer.parseInt(line[i + 1])
				- Integer.parseInt(line[i - 1]);
	}

	private int strikeScore(int i) {
		return 10 + Integer.parseInt(line[i + 1])
				+ Integer.parseInt(line[i + 2]);
	}
}
