package edu.cs222.fp_teaching_calculator.model.converter;

import org.junit.Test;

import java.util.LinkedList;

import org.junit.Assert;

public class HexToBinConverterTest {
	private HexToBinConverter hexToBinConverter = new HexToBinConverter();

	@Test
	public void testConvertHexToBinSuccess() {
		String validInput = "C2a";
		ConversionContainer completedConversion = hexToBinConverter.convertHexToBin(validInput);
		LinkedList<String> expectedParsedHex = createLinkedListOfStrings("C", "2", "A");
		LinkedList<String> expectedParsedDec = createLinkedListOfStrings("12", "2", "10");
		LinkedList<String> expectedBinList = createLinkedListOfStrings("1100", "0010", "1010");
		LinkedList<int[]> expectedSeparatedNibbles = createListOfExpectedSeparatedNibbles();
		ConversionContainer expectedResult = new ConversionContainer.ContainerBuilder().originalInput(validInput)
				.parsedListOfHexInput(expectedParsedHex).listOfDecEquivalents(expectedParsedDec)
				.listOfBinEquivalents(expectedBinList).listOfSeparatedBinNibbles(expectedSeparatedNibbles).build();
		AssertConversionContainersAreEqual(completedConversion, expectedResult);
	}

	private LinkedList<String> createLinkedListOfStrings(String string1, String string2, String string3) {
		LinkedList<String> output = new LinkedList<String>();
		output.add(string1);
		output.add(string2);
		output.add(string3);
		return output;
	}

	private LinkedList<int[]> createListOfExpectedSeparatedNibbles() {
		LinkedList<int[]> expectedSeparatedNibbles = new LinkedList<int[]>();
		int[] a = { 1, 1, 0, 0 };
		int[] b = { 0, 0, 1, 0 };
		int[] c = { 1, 0, 1, 0 };
		expectedSeparatedNibbles.add(a);
		expectedSeparatedNibbles.add(b);
		expectedSeparatedNibbles.add(c);
		return expectedSeparatedNibbles;
	}

	private void AssertArraysAreEqual(int[] correctOutput, int[] testOutput) {
		for (int c = 0; c < 4; c++) {
			Assert.assertEquals(correctOutput[c], testOutput[c]);
		}
	}

	private void AssertConversionContainersAreEqual(ConversionContainer completedConversion,
			ConversionContainer expectedResult) {
		Assert.assertEquals(expectedResult.originalInput, completedConversion.originalInput);
		Assert.assertEquals(expectedResult.parsedListOfHexInput, completedConversion.parsedListOfHexInput);
		Assert.assertEquals(expectedResult.listOfDecEquivalents, completedConversion.listOfDecEquivalents);
		Assert.assertEquals(expectedResult.listOfBinEquivalents, completedConversion.listOfBinEquivalents);
		for (int i = 0; i < expectedResult.listOfSeparatedBinNibbles.size(); i++) {
			AssertArraysAreEqual(expectedResult.listOfSeparatedBinNibbles.get(i),
					completedConversion.listOfSeparatedBinNibbles.get(i));
		}
	}

	@Test
	public void testConvertHexToBinFail() {
		String invalidInput = "C2aq";
		ConversionContainer completedConversion = hexToBinConverter.convertHexToBin(invalidInput);
		ConversionContainer expectedResult = new ConversionContainer(1);
		Assert.assertEquals(expectedResult.errorCode, completedConversion.errorCode);
	}
}
