package com.tmoreno.kata.bowling;

import org.junit.Assert;
import org.junit.Test;

public class LineScoreWithStrikesTest {

	private String line;
	private LineScore lineScore;

	@Test
	public void whenGetAStrikeAddNextTwoRollsKnockedDownPins() {
		line = "X11----------------";

		lineScore = new LineScore(line);

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
