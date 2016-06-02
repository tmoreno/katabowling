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

		Roll roll;
		for (int i = 0; i < lineArray.length; i++) {
			if (isBonus(i, lineArray)) {
				roll = RollFactory.createBonusRoll();
			}
			else {
				switch (lineArray[i]) {
				case MISS_SYMBOL:
					roll = RollFactory.createMissRoll();
					break;

				case SPARE_SYMBOL:
					roll = RollFactory.createSpareRoll(lineArray[i - 1],
							lineArray[i + 1]);
					break;

				case STRIKE_SYMBOL:
					roll = RollFactory.createStrikeRoll(lineArray[i + 1],
							lineArray[i + 2]);
					break;

				default:
					roll = RollFactory.createWithPointsRoll(lineArray[i]);
					break;
				}
			}

			line.add(roll);
		}

		return line;
	}

	private boolean isBonus(int i, String[] line) {
		return (i == line.length - 1 && isSpare(line[i - 1]))
				|| (i == line.length - 1 && isStrike(line[i - 2]))
				|| (i == line.length - 2 && isStrike(line[i - 1]));
	}

	private boolean isSpare(String symbol) {
		return SPARE_SYMBOL.equals(symbol);
	}

	private boolean isStrike(String symbol) {
		return STRIKE_SYMBOL.equals(symbol);
	}
}
