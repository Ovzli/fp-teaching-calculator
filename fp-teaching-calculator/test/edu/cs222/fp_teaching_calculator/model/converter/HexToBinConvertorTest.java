package edu.cs222.fp_teaching_calculator.model.converter;

import org.junit.Test;

import java.util.LinkedList;

import org.junit.Assert;

public class HexToBinConvertorTest {
	private HexToBinConvertor hexToBinConverter = new HexToBinConvertor();
	@Test
	public void testConvertHexToBinSuccess(){
		String validInput =  "C2a";
		ConversionContainer completedConversion = hexToBinConverter.convertHexToBin(validInput);
		LinkedList<String> expectedParsedHex = new LinkedList<String>();
		expectedParsedHex.add("C");
		expectedParsedHex.add("2");
		expectedParsedHex.add("A");
		LinkedList<String> expectedParsedDecimal = new LinkedList<String>();
		expectedParsedDecimal.add("12");
		expectedParsedDecimal.add("2");
		expectedParsedDecimal.add("10");
		LinkedList<String> expectedBinaryList = new LinkedList<String>();
		expectedBinaryList.add("1100");
		expectedBinaryList.add("0010");
		expectedBinaryList.add("1010");
		LinkedList<int[]> expectedSeparatedNibbles = new LinkedList<int[]>();
		int[] a = {1,1,0,0};
		int[] b = {0,0,1,0};
		int[] c = {1,0,1,0};
		expectedSeparatedNibbles.add(a);
		expectedSeparatedNibbles.add(b);
		expectedSeparatedNibbles.add(c);
		ConversionContainer expectedResult = new ConversionContainer.ContainerBuilder().originalInput(validInput).
					parsedListOfHexInput(expectedParsedHex).
					listOfDecimalEquivalents(expectedParsedDecimal).
					listOfBinaryEquivalents(expectedBinaryList).
					listOfSeparatedBinaryNibbles(expectedSeparatedNibbles).
					build();
		Assert.assertEquals(expectedResult.originalInput,completedConversion.originalInput);
		Assert.assertEquals(expectedResult.parsedListOfHexInput,completedConversion.parsedListOfHexInput);
		Assert.assertEquals(expectedResult.listOfDecimalEquivalents,completedConversion.listOfDecimalEquivalents);
		Assert.assertEquals(expectedResult.listOfBinaryEquivalents,completedConversion.listOfBinaryEquivalents);
		for(int i = 0; i < expectedResult.listOfSeparatedBinaryNibbles.size(); i++){
			for(int z = 0; z < 4; z++){
			Assert.assertEquals(expectedResult.listOfSeparatedBinaryNibbles.get(i)[z],completedConversion.listOfSeparatedBinaryNibbles.get(i)[z]);
			}
		}
	}
	
	@Test
	public void testConvertHexToBinFail(){
		String invalidInput =  "C2aq";
		ConversionContainer completedConversion = hexToBinConverter.convertHexToBin(invalidInput);
		ConversionContainer expectedResult = new ConversionContainer(1);
		Assert.assertEquals(expectedResult.errorCode,completedConversion.errorCode);
	}
}
