package edu.cs222.fp_teaching_calculator.model.converter;

import org.junit.Test;

import java.util.LinkedList;

import org.junit.Assert;

public class HexToBinConvertorTest {
	private HexToBinConvertor hexToBinConverter = new HexToBinConvertor();

	@Test
	public void testConvertHexToBinSuccess() {
		String validInput = "C2a";
		ConversionContainer completedConversion = hexToBinConverter.convertHexToBin(validInput);
		LinkedList<String> expectedParsedHex = new LinkedList<String>();
		expectedParsedHex.add("C");
		expectedParsedHex.add("2");
		expectedParsedHex.add("A");
		LinkedList<String> expectedParsedDec = new LinkedList<String>();
		expectedParsedDec.add("12");
		expectedParsedDec.add("2");
		expectedParsedDec.add("10");
		LinkedList<String> expectedBinList = new LinkedList<String>();
		expectedBinList.add("1100");
		expectedBinList.add("0010");
		expectedBinList.add("1010");
		LinkedList<int[]> expectedSeparatedNibbles = new LinkedList<int[]>();
		int[] a = { 1, 1, 0, 0 };
		int[] b = { 0, 0, 1, 0 };
		int[] c = { 1, 0, 1, 0 };
		expectedSeparatedNibbles.add(a);
		expectedSeparatedNibbles.add(b);
		expectedSeparatedNibbles.add(c);
		ConversionContainer expectedResult = new ConversionContainer.ContainerBuilder().originalInput(validInput)
				.parsedListOfHexInput(expectedParsedHex).listOfDecEquivalents(expectedParsedDec)
				.listOfBinEquivalents(expectedBinList).listOfSeparatedBinNibbles(expectedSeparatedNibbles).build();
		Assert.assertEquals(expectedResult.originalInput, completedConversion.originalInput);
		Assert.assertEquals(expectedResult.parsedListOfHexInput, completedConversion.parsedListOfHexInput);
		Assert.assertEquals(expectedResult.listOfDecEquivalents, completedConversion.listOfDecEquivalents);
		Assert.assertEquals(expectedResult.listOfBinEquivalents, completedConversion.listOfBinEquivalents);
		for (int i = 0; i < expectedResult.listOfSeparatedBinNibbles.size(); i++) {
			for (int z = 0; z < 4; z++) {
				Assert.assertEquals(expectedResult.listOfSeparatedBinNibbles.get(i)[z],
						completedConversion.listOfSeparatedBinNibbles.get(i)[z]);
			}
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
