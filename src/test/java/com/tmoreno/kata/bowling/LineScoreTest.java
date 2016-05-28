package com.tmoreno.kata.bowling;

import org.junit.Assert;
import org.junit.Test;

public class LineScoreTest {

	@Test
	public void allMissGetZero() {
		String line = "--------------------";

		LineScore lineScore = new LineScore(line);

		Assert.assertEquals(0, lineScore.calc());
	}

	@Test
	public void knockDownOnePinFirstTry() {
		String line = "1-------------------";

		LineScore lineScore = new LineScore(line);

		Assert.assertEquals(1, lineScore.calc());
	}

	@Test
	public void knockDownOnePinLastTry() {
		String line = "-------------------1";

		LineScore lineScore = new LineScore(line);

		Assert.assertEquals(1, lineScore.calc());
	}

	@Test
	public void knockDownTwoPinsSameFrame() {
		String line = "11------------------";

		LineScore lineScore = new LineScore(line);

		Assert.assertEquals(2, lineScore.calc());
	}
}
