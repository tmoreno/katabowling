package com.tmoreno.kata.bowling;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tmoreno.kata.bowling.roll.Roll;

public class LineScoreSimpleTest {

	private List<Roll> line;
	private LineParser lineParser;
	private LineScore lineScore;

	@Before
	public void setUp() {
		lineParser = new LineParser();
	}

	@Test
	public void allMissGetZero() {
		line = lineParser.parse("--------------------");

		lineScore = new LineScore(line);

		Assert.assertEquals(0, lineScore.calc());
	}

	@Test
	public void knockDownOnePinFirstTry() {
		line = lineParser.parse("1-------------------");

		lineScore = new LineScore(line);

		Assert.assertEquals(1, lineScore.calc());
	}

	@Test
	public void knockDownOnePinLastTry() {
		line = lineParser.parse("-------------------1");

		lineScore = new LineScore(line);

		Assert.assertEquals(1, lineScore.calc());
	}

	@Test
	public void knockDownTwoPinsSameFrame() {
		line = lineParser.parse("11------------------");

		lineScore = new LineScore(line);

		Assert.assertEquals(2, lineScore.calc());
	}

	@Test
	public void knockDownPinsAllFrames() {
		line = lineParser.parse("11111111111111111111");

		lineScore = new LineScore(line);

		Assert.assertEquals(20, lineScore.calc());
	}

	@Test
	public void complexLine() {
		line = lineParser.parse("9-9-9-9-9-9-9-9-9-9-");

		lineScore = new LineScore(line);

		Assert.assertEquals(90, lineScore.calc());
	}
}
