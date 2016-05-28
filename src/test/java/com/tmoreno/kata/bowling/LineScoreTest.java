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
}
