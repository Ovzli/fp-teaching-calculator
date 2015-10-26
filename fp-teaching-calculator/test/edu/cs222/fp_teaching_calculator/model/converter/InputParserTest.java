package edu.cs222.fp_teaching_calculator.model.converter;

import org.junit.Test;

import java.util.LinkedList;

import org.junit.Assert;

public class InputParserTest {

	private InputParser inputParser = new InputParser();

	@Test
	public void testParseHexidecimalInput() {
		String hexString = "C2A";
		LinkedList<String> correctOutput = new LinkedList<String>();
		correctOutput.add("C");
		correctOutput.add("2");
		correctOutput.add("A");
		LinkedList<String> methodOutput = inputParser.parseHexInput(hexString);
		Assert.assertEquals(methodOutput, correctOutput);
	}
}
