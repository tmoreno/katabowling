package com.tmoreno.kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class LineParser {

	private static final String MISS_SYMBOL = "-";

	public List<Roll> parse(String lineString) {
		String[] lineArray = lineString.split("");

		List<Roll> line = new ArrayList<Roll>();

		for (String roll : lineArray) {
			switch (roll) {
			case MISS_SYMBOL:
				line.add(new MissRoll());
				break;

			default:
				line.add(new WithPointsRoll(Integer.parseInt(roll)));
				break;
			}
		}

		return line;
	}

}
