package edu.cs222.fp_teaching_calculator.model.converter;

import org.junit.Test;

import java.util.LinkedList;

import org.junit.Assert;

public class InputParserTest {

	private InputParser inputParser = new InputParser();

	@Test
	public void testParseHexidecimalInput() {
		String hexString = "C2A";
		LinkedList<String> correctOutput = createLinkedListOfStrings("C", "2", "A");
		LinkedList<String> methodOutput = inputParser.parseHexInput(hexString);
		Assert.assertEquals(methodOutput, correctOutput);
	}
	
	private LinkedList<String> createLinkedListOfStrings(String string1, String string2, String string3) {
		LinkedList<String> output = new LinkedList<String>();
		output.add(string1);
		output.add(string2);
		output.add(string3);
		return output;
	}
}
