package edu.cs222.fpteachingcalculator.model.converter;

import org.junit.Test;

import edu.cs222.fpteachingcalculator.model.converter.ValueTranslator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Assert;

public class ValueTranslatorTest {
	private ValueTranslator valueTranslator = new ValueTranslator();

	@Test
	public void testTranslateHexToDec() {
		LinkedList<String> hexList = createLinkedListOfStrings("C 2 A");
		LinkedList<String> correctList = createLinkedListOfStrings("12 2 10");
		LinkedList<String> outputList = valueTranslator.translateHexToDec(hexList);
		Assert.assertEquals(correctList, outputList);
	}

	@Test
	public void testTranslateDecToBin() {
		LinkedList<String> decList = createLinkedListOfStrings("12 2 10");
		LinkedList<String> correctList = createLinkedListOfStrings("1100 0010 1010");
		LinkedList<String> outputList = valueTranslator.translateDecToBin(decList);
		Assert.assertEquals(correctList, outputList);
	}

	private LinkedList<String> createLinkedListOfStrings(String input) {
		LinkedList<String> output = new LinkedList<String>();
		output.addAll(new ArrayList<String>(Arrays.asList(input.split(" "))));
		return output;
	}

	@Test
	public void testGetPositionOfValueSuccess() {
		String[] hexValues = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
		String test = "A";
		int correctOutput = 10;
		int testOutput = valueTranslator.getPostitionOfValue(hexValues, test);
		Assert.assertEquals(correctOutput, testOutput);
	}

	@Test
	public void testGetPositionOfValueFail() {
		String[] hexValues = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
		String test = "H";
		int correctOutput = -1;
		int testOutput = valueTranslator.getPostitionOfValue(hexValues, test);
		Assert.assertEquals(correctOutput, testOutput);
	}
}