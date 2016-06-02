package com.tmoreno.kata.bowling;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LineParserTest {

	private List<Roll> line;
	private LineParser lineParser;

	@Before
	public void setUp() {
		lineParser = new LineParser();
	}

	@Test
	public void parseAllMissLine() {
		line = lineParser.parse("--------------------");

		for (Roll roll : line) {
			Assert.assertTrue(roll instanceof MissRoll);
		}
	}

	@Test
	public void parseOnePinKnocked() {
		line = lineParser.parse("1-------------------");

		Assert.assertTrue(line.get(0) instanceof WithPointsRoll);
	}

	@Test
	public void parseOneSpare() {
		line = lineParser.parse("1/------------------");

		Assert.assertTrue(line.get(1) instanceof SpareRoll);
	}

	@Test
	public void parseSpareWithBonus() {
		line = lineParser.parse("-------------------/-");

		Assert.assertTrue(line.get(20) instanceof BonusRoll);
	}

	@Test
	public void parseOneStrike() {
		line = lineParser.parse("X11----------------");

		Assert.assertTrue(line.get(0) instanceof StrikeRoll);
	}
}
