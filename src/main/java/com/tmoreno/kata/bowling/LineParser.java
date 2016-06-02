package com.tmoreno.kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class LineParser {

	private static final String MISS_SYMBOL = "-";
	private static final String SPARE_SYMBOL = "/";
	private static final String STRIKE_SYMBOL = "X";

	public List<Roll> parse(String lineString) {
		String[] lineArray = lineString.split("");

		List<Roll> line = new ArrayList<Roll>();

		String roll;
		for (int i = 0; i < lineArray.length; i++) {
			if (i == 20) {
				line.add(new BonusRoll());
			}
			else {
				roll = lineArray[i];

				switch (roll) {
				case MISS_SYMBOL:
					line.add(new MissRoll());
					break;

				case SPARE_SYMBOL:
					line.add(new SpareRoll(getValue(lineArray[i - 1]),
							getValue(lineArray[i + 1])));
					break;

				case STRIKE_SYMBOL:
					line.add(new StrikeRoll(getValue(lineArray[i + 1]),
							getValue(lineArray[i + 2])));
					break;

				default:
					line.add(new WithPointsRoll(getValue(roll)));
					break;
				}
			}
		}

		return line;
	}

	private int getValue(String roll) {
		if (MISS_SYMBOL.equals(roll)) {
			return 0;
		}
		else {
			return Integer.parseInt(roll);
		}
	}

}
