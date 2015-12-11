package edu.cs222.fpteachingcalculator.model.converter;

import org.junit.Test;

import edu.cs222.fpteachingcalculator.model.converter.ValueTranslator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

public class ValueTranslatorTest {
	private ValueTranslator valueTranslator = new ValueTranslator();

	@Test
	public void testTranslateHexToDec() {
		List<String> hexList = createListOfStrings("C 2 A");
		List<String> correctList = createListOfStrings("12 2 10");
		List<String> outputList = valueTranslator.translateHexListToDecList(hexList);
		Assert.assertEquals(correctList, outputList);
	}

	@Test
	public void testTranslateDecListToDecValue() {
		List<String> decList = createListOfStrings("12 2 10");
		String correctValue = "3114";
		String outputValue = valueTranslator.translateDecListToDecValue(decList);
		Assert.assertEquals(correctValue, outputValue);
	}

	@Test
	public void testTranslateBinListToDecList() {
		List<List<Integer>> validInput = createValidInput();
		List<String> correctList = createListOfStrings("12 2 10");
		List<String> outputList = valueTranslator.translateBinListToDecList(validInput);
		Assert.assertEquals(correctList, outputList);
	}

	@Test
	public void testTranslateDecValueToHexValue() {
		String decValue = "3114";
		String correctValue = "C2A";
		String outputValue = valueTranslator.translateDecValueToHexValue(decValue);
		Assert.assertEquals(correctValue, outputValue);
	}

	@Test
	public void testTranslateDecValueToBinValue() {
		String decValue = "3114";
		String correctValue = "110000101010";
		String outputValue = valueTranslator.translateDecValueToBinValue(decValue);
		Assert.assertEquals(correctValue, outputValue);
	}

	@Test
	public void testTranslateDecToBin() {
		List<String> decList = createListOfStrings("12 2 10");
		List<String> correctList = createListOfStrings("1100 0010 1010");
		List<String> outputList = valueTranslator.translateDecListToBinList(decList);
		Assert.assertEquals(correctList, outputList);
	}

	private LinkedList<String> createListOfStrings(String input) {
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

	private List<List<Integer>> createValidInput() {
		List<List<Integer>> correctOutput = new LinkedList<>();
		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(1);
		a.add(0);
		a.add(0);
		List<Integer> b = new ArrayList<>();
		b.add(0);
		b.add(0);
		b.add(1);
		b.add(0);
		List<Integer> c = new ArrayList<>();
		c.add(1);
		c.add(0);
		c.add(1);
		c.add(0);
		correctOutput.add(a);
		correctOutput.add(b);
		correctOutput.add(c);
		return correctOutput;
	}
}