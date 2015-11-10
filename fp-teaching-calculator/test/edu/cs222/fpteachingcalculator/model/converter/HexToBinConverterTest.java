package edu.cs222.fpteachingcalculator.model.converter;

import org.junit.Test;

import edu.cs222.fpteachingcalculator.model.converter.Conversion;
import edu.cs222.fpteachingcalculator.model.converter.HexToBinConverter;
import edu.cs222.fpteachingcalculator.model.converter.inputexceptions.EmptyInputException;
import edu.cs222.fpteachingcalculator.model.converter.inputexceptions.InvalidHexNumberLengthException;
import edu.cs222.fpteachingcalculator.model.converter.inputexceptions.InvalidHexSymbolException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Assert;

public class HexToBinConverterTest {
	private HexToBinConverter hexToBinConverter = new HexToBinConverter();

	@Test
	public void testConvertHexToBinSuccess() throws InvalidHexSymbolException, InvalidHexNumberLengthException, EmptyInputException {
		String validInput = "C2a";
		Conversion completedConversion = null;
		completedConversion = hexToBinConverter.convertHexToBin(validInput);
		LinkedList<String> expectedParsedHex = createLinkedListOfStrings("C 2 A");
		LinkedList<String> expectedParsedDec = createLinkedListOfStrings("12 2 10");
		LinkedList<String> expectedBinList = createLinkedListOfStrings("1100 0010 1010");
		LinkedList<int[]> expectedSeparatedNibbles = createListOfExpectedSeparatedNibbles();
		Conversion expectedResult = new Conversion.ConversionBuilder().originalInput(validInput)
				.parsedListOfHexInput(expectedParsedHex).listOfDecEquivalents(expectedParsedDec)
				.listOfBinEquivalents(expectedBinList).listOfSeparatedBinNibbles(expectedSeparatedNibbles).build();
		AssertConversionContainersAreEqual(completedConversion, expectedResult);
	}

	private LinkedList<String> createLinkedListOfStrings(String input){
		LinkedList<String> output = new LinkedList<String>();
		output.addAll(new ArrayList<String>(Arrays.asList(input.split(" "))));
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

	private void AssertConversionContainersAreEqual(Conversion completedConversion,
			Conversion expectedResult) {
		Assert.assertEquals(expectedResult.getOriginalInput(), completedConversion.getOriginalInput());
		Assert.assertEquals(expectedResult.getParsedListOfHexInput(), completedConversion.getParsedListOfHexInput());
		Assert.assertEquals(expectedResult.getListOfDecEquivalents(), completedConversion.getListOfDecEquivalents());
		Assert.assertEquals(expectedResult.getListOfBinEquivalents(), completedConversion.getListOfBinEquivalents());
		for (int i = 0; i < expectedResult.getListOfSeparatedBinNibbles().size(); i++) {
			AssertArraysAreEqual(expectedResult.getListOfSeparatedBinNibbles().get(i),
					completedConversion.getListOfSeparatedBinNibbles().get(i));
		}
	}
}
