package com.tmoreno.kata.bowling;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LineScoreWithSparesTest {

	private String line;
	private List<Roll> line2;
	private LineParser lineParser;
	private LineScore lineScore;

	@Before
	public void setUp() {
		lineParser = new LineParser();
	}

	@Test
	public void whenGetASpareAddNextThrowKnockedDownPins() {
		line2 = lineParser.parse("1/1-----------------");

		lineScore = new LineScore(line2);

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
