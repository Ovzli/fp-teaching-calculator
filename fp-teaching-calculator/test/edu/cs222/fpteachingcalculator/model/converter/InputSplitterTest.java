package edu.cs222.fpteachingcalculator.model.converter;

import org.junit.Test;

import edu.cs222.fpteachingcalculator.model.converter.InputSplitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

public class InputSplitterTest {

	private InputSplitter inputSplitter = new InputSplitter();

	@Test
	public void testSplitString() {
		String validInput = "C2A";
		List<String> correctOutput = createListOfStrings("C 2 A");
		List<String> methodOutput = inputSplitter.splitString(validInput);
		Assert.assertEquals(methodOutput, correctOutput);
	}
	
	@Test
	public void testSplitBinInput(){
		String validInput = "110000101010";
		List<String> correctOutput = createListOfStrings("1100 0010 1010");
		List<String> methodOutput = inputSplitter.splitBinString(validInput);
		Assert.assertEquals(correctOutput, methodOutput);	
		String validInput2 = "1110000101010";
		List<String> correctOutput2 = createListOfStrings("0001 1100 0010 1010");
		List<String> methodOutput2 = inputSplitter.splitBinString(validInput2);
		Assert.assertEquals(correctOutput2, methodOutput2);	
	}

	private List<String> createListOfStrings(String input) {
		List<String> output = new LinkedList<>();
		output.addAll(new ArrayList<String>(Arrays.asList(input.split(" "))));
		return output;
	}
}