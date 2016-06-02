package com.tmoreno.kata.bowling;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LineScoreWithStrikesTest {

	private String line;
	private List<Roll> line2;
	private LineParser lineParser;
	private LineScore lineScore;

	@Before
	public void setUp() {
		lineParser = new LineParser();
	}

	@Test
	public void whenGetAStrikeAddNextTwoRollsKnockedDownPins() {
		line2 = lineParser.parse("X11----------------");

		lineScore = new LineScore(line2);

		Assert.assertEquals(14, lineScore.calc());
	}

	@Test
	public void whenGetAStrikeAtTheEndGetTwoExtraThrow() {
		line = "------------------X11";

		lineScore = new LineScore(line);

		Assert.assertEquals(12, lineScore.calc());
	}

	@Test
	public void twoStrikes() {
		line = "XX------------------";

		lineScore = new LineScore(line);

		Assert.assertEquals(30, lineScore.calc());
	}

	@Test
	public void complex() {
		line = "XXXXXXXXXXXX";

		lineScore = new LineScore(line);

		Assert.assertEquals(300, lineScore.calc());
	}
}
