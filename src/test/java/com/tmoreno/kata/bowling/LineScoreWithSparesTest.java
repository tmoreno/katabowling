package com.tmoreno.kata.bowling;

import org.junit.Assert;
import org.junit.Test;

public class LineScoreWithSparesTest {

	private String line;
	private LineScore lineScore;

	@Test
	public void whenGetASpareAddNextThrowKnockedDownPins() {
		line = "1/1-----------------";

		lineScore = new LineScore(line);

		Assert.assertEquals(12, lineScore.calc());
	}

	@Test
	public void whenGetASpareAtTheEndGetOneExtraThrow() {
		line = "------------------1/1";

		lineScore = new LineScore(line);

		Assert.assertEquals(11, lineScore.calc());
	}

	@Test
	public void complexLine() {
		line = "5/5/5/5/5/5/5/5/5/5/5";

		lineScore = new LineScore(line);

		Assert.assertEquals(150, lineScore.calc());
	}
}
