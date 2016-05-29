package com.tmoreno.kata.bowling;

import org.junit.Assert;
import org.junit.Test;

public class LineScoreSimpleTest {

	private String line;
	private LineScore lineScore;

	@Test
	public void allMissGetZero() {
		line = "--------------------";

		lineScore = new LineScore(line);

		Assert.assertEquals(0, lineScore.calc());
	}

	@Test
	public void knockDownOnePinFirstTry() {
		line = "1-------------------";

		lineScore = new LineScore(line);

		Assert.assertEquals(1, lineScore.calc());
	}

	@Test
	public void knockDownOnePinLastTry() {
		line = "-------------------1";

		lineScore = new LineScore(line);

		Assert.assertEquals(1, lineScore.calc());
	}

	@Test
	public void knockDownTwoPinsSameFrame() {
		line = "11------------------";

		lineScore = new LineScore(line);

		Assert.assertEquals(2, lineScore.calc());
	}

	@Test
	public void knockDownPinsAllFrames() {
		line = "11111111111111111111";

		lineScore = new LineScore(line);

		Assert.assertEquals(20, lineScore.calc());
	}

	@Test
	public void complexLine() {
		line = "9-9-9-9-9-9-9-9-9-9-";

		lineScore = new LineScore(line);

		Assert.assertEquals(90, lineScore.calc());
	}
}
