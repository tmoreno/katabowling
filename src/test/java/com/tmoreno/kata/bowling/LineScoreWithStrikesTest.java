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
}
