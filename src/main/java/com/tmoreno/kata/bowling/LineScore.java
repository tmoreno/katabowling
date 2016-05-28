package com.tmoreno.kata.bowling;

public class LineScore {

	private String[] line;

	public LineScore(String line) {
		this.line = line.split("");
	}

	public int calc() {
		int score = 0;

		for (int i = 0; i < line.length; i++) {
			if (!"-".equals(line[i])) {
				score += Integer.parseInt(line[i]);
			}
		}

		return score;
	}

}
