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
	public void testSplitHexInput() {
		String hexString = "C2A";
		List<String> correctOutput = createListOfStrings("C 2 A");
		List<String> methodOutput = inputSplitter.splitInput(hexString);
		Assert.assertEquals(methodOutput, correctOutput);
	}

	private List<String> createListOfStrings(String input) {
		List<String> output = new LinkedList<>();
		output.addAll(new ArrayList<String>(Arrays.asList(input.split(" "))));
		return output;
	}
}