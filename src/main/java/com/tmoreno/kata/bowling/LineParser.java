package com.tmoreno.kata.bowling;

import java.util.ArrayList;
import java.util.List;

import com.tmoreno.kata.bowling.roll.Roll;
import com.tmoreno.kata.bowling.roll.RollFactory;

public class LineParser {

	private static final String MISS_SYMBOL = "-";
	private static final String SPARE_SYMBOL = "/";
	private static final String STRIKE_SYMBOL = "X";

	public List<Roll> parse(String lineString) {
		String[] lineArray = lineString.split("");

		List<Roll> line = new ArrayList<Roll>();

		String roll;
		for (int i = 0; i < lineArray.length; i++) {
			if (isBonus(i, lineArray)) {
				line.add(RollFactory.createBonusRoll());
			}
			else {
				roll = lineArray[i];

				switch (roll) {
				case MISS_SYMBOL:
					line.add(RollFactory.createMissRoll());
					break;

				case SPARE_SYMBOL:
					line.add(RollFactory.createSpareRoll(lineArray[i - 1],
							lineArray[i + 1]));
					break;

				case STRIKE_SYMBOL:
					line.add(RollFactory.createStrikeRoll(lineArray[i + 1],
							lineArray[i + 2]));
					break;

				default:
					line.add(RollFactory.createWithPointsRoll(roll));
					break;
				}
			}
		}

		return line;
	}

	private boolean isSpare(int i, String[] line) {
		return SPARE_SYMBOL.equals(line[i]);
	}

	private boolean isStrike(int i, String[] line) {
		return STRIKE_SYMBOL.equals(line[i]);
	}

	private boolean isBonus(int i, String[] line) {
		return (i == line.length - 1 && isSpare(i - 1, line))
				|| (i == line.length - 1 && isStrike(i - 2, line))
				|| (i == line.length - 2 && isStrike(i - 1, line));
	}

}
