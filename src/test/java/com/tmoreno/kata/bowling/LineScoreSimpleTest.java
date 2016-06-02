package com.tmoreno.kata.bowling;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LineScoreSimpleTest {

	private String line;
	private List<Roll> line2;
	private LineParser lineParser;
	private LineScore lineScore;

	@Before
	public void setUp() {
		lineParser = new LineParser();
	}

	@Test
	public void allMissGetZero() {
		line2 = lineParser.parse("--------------------");

		lineScore = new LineScore(line2);

		Assert.assertEquals(0, lineScore.calc());
	}

	@Test
	public void knockDownOnePinFirstTry() {
		line2 = lineParser.parse("1-------------------");

		lineScore = new LineScore(line2);

		Assert.assertEquals(1, lineScore.calc());
	}

	@Test
	public void knockDownOnePinLastTry() {
		line2 = lineParser.parse("-------------------1");

		lineScore = new LineScore(line2);

		Assert.assertEquals(1, lineScore.calc());
	}

	@Test
	public void knockDownTwoPinsSameFrame() {
		line2 = lineParser.parse("11------------------");

		lineScore = new LineScore(line2);

		Assert.assertEquals(2, lineScore.calc());
	}

	@Test
	public void knockDownPinsAllFrames() {
		line2 = lineParser.parse("11111111111111111111");

		lineScore = new LineScore(line2);

		Assert.assertEquals(20, lineScore.calc());
	}

	@Test
	public void complexLine() {
		line2 = lineParser.parse("9-9-9-9-9-9-9-9-9-9-");

		lineScore = new LineScore(line2);

		Assert.assertEquals(90, lineScore.calc());
	}
}
