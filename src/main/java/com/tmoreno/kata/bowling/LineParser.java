package com.tmoreno.kata.bowling;

import java.util.ArrayList;
import java.util.List;

import com.tmoreno.kata.bowling.roll.Roll;
import com.tmoreno.kata.bowling.roll.RollFactory;
import com.tmoreno.kata.bowling.roll.RollValues;

public class LineParser {

	private RollValues rollValues;

	public LineParser() {
		rollValues = new RollValues();
	}

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
				case RollValues.MISS_SYMBOL:
					roll = RollFactory.createMissRoll();
					break;

				case RollValues.SPARE_SYMBOL:
					roll = RollFactory.createSpareRoll(
							rollValues.getValue(lineArray[i - 1]),
							rollValues.getValue(lineArray[i + 1]));
					break;

				case RollValues.STRIKE_SYMBOL:
					roll = RollFactory.createStrikeRoll(
							rollValues.getValue(lineArray[i + 1]),
							rollValues.getValue(lineArray[i + 2]));
					break;

				default:
					roll = RollFactory.createWithPointsRoll(rollValues
							.getValue(lineArray[i]));
					break;
				}
			}

			line.add(roll);
		}

		return line;
	}

	private boolean isBonus(int i, String[] line) {
		return (i == line.length - 1 && rollValues.isSpare(line[i - 1]))
				|| (i == line.length - 1 && rollValues.isStrike(line[i - 2]))
				|| (i == line.length - 2 && rollValues.isStrike(line[i - 1]));
	}

}
