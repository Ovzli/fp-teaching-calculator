package edu.cs222.fpteachingcalculator.model.converter;

import org.junit.Test;

import edu.cs222.fpteachingcalculator.model.converter.InputSplitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Assert;

public class InputSplitterTest {

	private InputSplitter inputParser = new InputSplitter();

	@Test
	public void testParseHexidecimalInput() {
		String hexString = "C2A";
		LinkedList<String> correctOutput = createLinkedListOfStrings("C 2 A");
		LinkedList<String> methodOutput = inputParser.parseHexInput(hexString);
		Assert.assertEquals(methodOutput, correctOutput);
	}
	
	private LinkedList<String> createLinkedListOfStrings(String input){
		LinkedList<String> output = new LinkedList<String>();
		output.addAll(new ArrayList<String>(Arrays.asList(input.split(" "))));
		return output;
	}
}