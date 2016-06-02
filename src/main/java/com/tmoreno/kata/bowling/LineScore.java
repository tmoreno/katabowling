package com.tmoreno.kata.bowling;

import java.util.List;

public class LineScore {

	private static final String MISS_SYMBOL = "-";
	private static final String SPARE_SYMBOL = "/";
	private static final String STRIKE_SYMBOL = "X";

	private String[] line;
	private List<Roll> line2;

	public LineScore(String line) {
		this.line = line.split("");
	}

	public LineScore(List<Roll> line2) {
		this.line2 = line2;
	}

	public int calc() {
		int score = 0;

		if (line != null) {
			for (int i = 0; i < line.length; i++) {
				if (isSpare(i)) {
					score += spareScore(i);
				}
				else if (isStrike(i) && !isBonus(i)) {
					score += strikeScore(i);
				}
				else if (!isMiss(i) && !isBonus(i)) {
					score += normalScore(i);
				}
			}
		}
		else {
			for (Roll roll : line2) {
				score += roll.getScore();
			}
		}

		return score;
	}

	private boolean isSpare(int i) {
		return SPARE_SYMBOL.equals(line[i]);
	}

	private boolean isStrike(int i) {
		return STRIKE_SYMBOL.equals(line[i]);
	}

	private boolean isMiss(int i) {
		return MISS_SYMBOL.equals(line[i]);
	}

	private boolean isBonus(int i) {
		return (i == line.length - 1 && isSpare(i - 1))
				|| (i == line.length - 1 && isStrike(i - 2))
				|| (i == line.length - 2 && isStrike(i - 1));
	}

	private int normalScore(int i) {
		return getValue(i);
	}

	private int spareScore(int i) {
		return 10 + getValue(i + 1) - getValue(i - 1);
	}

	private int strikeScore(int i) {
		return 10 + getValue(i + 1) + getValue(i + 2);
	}

	private int getValue(int i) {
		if (isStrike(i)) {
			return 10;
		}
		else if (isMiss(i)) {
			return 0;
		}
		else {
			return Integer.parseInt(line[i]);
		}
	}
}
