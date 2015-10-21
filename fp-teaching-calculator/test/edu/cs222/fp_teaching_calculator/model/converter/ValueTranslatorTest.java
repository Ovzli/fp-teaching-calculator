package edu.cs222.fp_teaching_calculator.model.converter;

import org.junit.Test;

import java.util.LinkedList;

import org.junit.Assert;

public class ValueTranslatorTest {
	private ValueTranslator valueTranslator = new ValueTranslator();

	@Test
	public void testTranslateHexadecimalToDecimal() {
		LinkedList<String> hexList = new LinkedList<String>();
		hexList.add("C");
		hexList.add("2");
		hexList.add("A");
		LinkedList<String> correctList = new LinkedList<String>();
		correctList.add("12");
		correctList.add("2");
		correctList.add("10");
		LinkedList<String> outputList = valueTranslator.translateHexadecimalToDecimal(hexList);
		Assert.assertEquals(correctList, outputList);
	}

	@Test
	public void testTranslateDecimalToBinary() {
		LinkedList<String> decList = new LinkedList<String>();
		decList.add("12");
		decList.add("2");
		decList.add("10");
		LinkedList<String> correctList = new LinkedList<String>();
		correctList.add("1100");
		correctList.add("0010");
		correctList.add("1010");
		LinkedList<String> outputList = valueTranslator.translateDecimalToBinary(decList);
		System.out.println(outputList);
		Assert.assertEquals(correctList, outputList);
	}

	@Test
	public void testGetPositionOfValueSuccess() {
		String[] hexadecimalValues = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
		String test = "A";
		int correctOutput = 10;
		int testOutput = valueTranslator.getPostitionOfValue(hexadecimalValues, test);
		Assert.assertEquals(correctOutput, testOutput);
	}

	@Test
	public void testGetPositonOfValueFail() {
		String[] hexadecimalValues = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
		String test = "H";
		int correctOutput = 0;
		int testOutput = valueTranslator.getPostitionOfValue(hexadecimalValues, test);
		Assert.assertEquals(correctOutput, testOutput);
	}
}