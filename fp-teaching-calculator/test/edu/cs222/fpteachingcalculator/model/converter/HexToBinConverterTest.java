package edu.cs222.fpteachingcalculator.model.converter;

import org.junit.Test;

import edu.cs222.fpteachingcalculator.model.converter.Conversion;
import edu.cs222.fpteachingcalculator.model.converter.HexToBinConverter;
import edu.cs222.fpteachingcalculator.view.inputexceptions.EmptyInputException;
import edu.cs222.fpteachingcalculator.view.inputexceptions.InvalidHexNumberLengthException;
import edu.cs222.fpteachingcalculator.view.inputexceptions.InvalidHexSymbolException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
		List<List<Integer>> expectedSeparatedNibbles = createListOfExpectedSeparatedNibbles();
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

	private List<List<Integer>> createListOfExpectedSeparatedNibbles() {
		List<List<Integer>> expectedSeparatedNibbles = new LinkedList<>();
		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(1);
		a.add(0);
		a.add(0);
		List<Integer> b = new ArrayList<>();
		a.add(0);
		a.add(0);
		a.add(1);
		a.add(0);
		List<Integer> c = new ArrayList<>();
		a.add(1);
		a.add(0);
		a.add(1);
		a.add(0);
		expectedSeparatedNibbles.add(a);
		expectedSeparatedNibbles.add(b);
		expectedSeparatedNibbles.add(c);
		return expectedSeparatedNibbles;
	}

	private void AssertArraysAreEqual(List<Integer> list, List<Integer> list2) {
		for (int c = 0; c < 4; c++) {
			Assert.assertEquals(list.get(c), list2.get(c));
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