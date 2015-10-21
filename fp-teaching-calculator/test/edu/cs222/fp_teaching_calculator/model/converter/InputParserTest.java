package edu.cs222.fp_teaching_calculator.model.converter;

import org.junit.Test;

import java.util.LinkedList;

import org.junit.Assert;

public class InputParserTest {

	InputParser inputParser = new InputParser();
	
	@Test
	public void testParseHexidecimalInput(){
		String hexString = "C2A";
		LinkedList<String> correctOutput = new LinkedList<String>();
		correctOutput.add("C");
		correctOutput.add("2");
		correctOutput.add("A");
		LinkedList<String> methodOutput = inputParser.parseHexidecimalInput(hexString);
		Assert.assertEquals(methodOutput, correctOutput);
	}
	
	@Test
	public void testParseDecimalInput(){
		String decString = "3114";
		LinkedList<String> correctOutput = new LinkedList<String>();
		correctOutput = null;
		LinkedList<String> methodOutput = inputParser.parseDecimalInput(decString);
		Assert.assertEquals(methodOutput, correctOutput);
	}
	
	@Test
	public void testParseBinaryInput(){
		String binString = "‭110000101010";
		LinkedList<String> correctOutput = new LinkedList<String>();
		correctOutput = null;
		LinkedList<String> methodOutput = inputParser.parseBinaryInput(binString);
		Assert.assertEquals(methodOutput, correctOutput);
	}
}
