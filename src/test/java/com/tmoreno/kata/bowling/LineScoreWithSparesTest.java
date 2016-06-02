package com.tmoreno.kata.bowling;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tmoreno.kata.bowling.roll.Roll;

public class LineScoreWithSparesTest {

	private List<Roll> line;
	private LineParser lineParser;
	private LineScore lineScore;

	@Before
	public void setUp() {
		lineParser = new LineParser();
	}

	@Test
	public void whenGetASpareAddNextThrowKnockedDownPins() {
		line = lineParser.parse("1/1-----------------");

		lineScore = new LineScore(line);

		Assert.assertEquals(12, lineScore.calc());
	}

	@Test
	public void whenGetASpareAtTheEndGetOneExtraThrow() {
		line = lineParser.parse("------------------1/1");

		lineScore = new LineScore(line);

		Assert.assertEquals(11, lineScore.calc());
	}

	@Test
	public void complexLine() {
		line = lineParser.parse("5/5/5/5/5/5/5/5/5/5/5");

		lineScore = new LineScore(line);

		Assert.assertEquals(150, lineScore.calc());
	}
}
