package com.tmoreno.kata.bowling;

public class LineScore {

	private static final String MISS_SYMBOL = "-";
	private static final String SPARE_SYMBOL = "/";

	private String[] line;

	public LineScore(String line) {
		this.line = line.split("");
	}

	public int calc() {
		int score = 0;

		for (int i = 0; i < line.length; i++) {
			if (SPARE_SYMBOL.equals(line[i])) {
				score += 10 + Integer.parseInt(line[i + 1])
						- Integer.parseInt(line[i - 1]);
			}
			else if (!MISS_SYMBOL.equals(line[i])) {
				score += Integer.parseInt(line[i]);
			}
		}

		return score;
	}

}
