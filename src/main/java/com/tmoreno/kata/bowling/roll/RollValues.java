package com.tmoreno.kata.bowling.roll;

import java.util.HashMap;
import java.util.Map;

public class RollValues {

	public static final String MISS_SYMBOL = "-";
	public static final String SPARE_SYMBOL = "/";
	public static final String STRIKE_SYMBOL = "X";

	private final Map<String, Integer> values;

	public RollValues() {
		values = new HashMap<String, Integer>();
		values.put("-", 0);
		values.put("/", 10);
		values.put("X", 10);
		values.put("1", 1);
		values.put("2", 2);
		values.put("3", 3);
		values.put("4", 4);
		values.put("5", 5);
		values.put("6", 6);
		values.put("7", 7);
		values.put("8", 8);
		values.put("9", 9);
	}

	public int getValue(String symbol) {
		return values.get(symbol);
	}

	public boolean isSpare(String symbol) {
		return SPARE_SYMBOL.equals(symbol);
	}

	public boolean isStrike(String symbol) {
		return STRIKE_SYMBOL.equals(symbol);
	}
}
