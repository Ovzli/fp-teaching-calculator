package edu.cs222.fpteachingcalculator.model.converter;

import org.junit.Test;
import edu.cs222.fpteachingcalculator.model.converter.Conversion;
import edu.cs222.fpteachingcalculator.model.converter.ValueConverter;
import edu.cs222.fpteachingcalculator.view.inputexceptions.EmptyInputException;
import edu.cs222.fpteachingcalculator.view.inputexceptions.InvalidNumberLengthException;
import edu.cs222.fpteachingcalculator.view.inputexceptions.InvalidSymbolException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

public class ValueConverterTest {
	private BinSplitter binSplitter = new BinSplitter();

	@Test
	public void testConvertHexSuccess()
			throws InvalidSymbolException, InvalidNumberLengthException, EmptyInputException {
		String validInput = "C2a";
		ValueConverter converter = new ValueConverter(validInput);
		Conversion completedConversion = converter.convert("HEX");
		String expectedDecValue = "3114";
		List<String> expectedSplitHex = createListOfStrings("C 2 A");
		List<String> expectedSplitdDec = createListOfStrings("12 2 10");
		List<String> expectedBinList = createListOfStrings("1100 0010 1010");
		List<List<Integer>> expectedSeparatedNibbles = createListOfExpectedSeparatedNibbles();
		List<String> expectedUserCharList = expectedSplitHex;
		List<String> expectedSeparatedBinList = createListOfStrings("1 1 0 0 0 0 1 0 1 0 1 0");
		Conversion expectedResult = new Conversion.ConversionBuilder().originalInput(validInput)
				.decValue(expectedDecValue).listOfRepresentativeHexChars(expectedSplitHex)
				.listOfRepresentativeDecChars(expectedSplitdDec).listOfRepresentationBinChars(expectedBinList)
				.listOfSeparatedBinNibbles(expectedSeparatedNibbles).listOfUserInputChars(expectedUserCharList)
				.listOfIndividualBinChars(expectedSeparatedBinList).build();
		assertConversionsAreEqual(completedConversion, expectedResult);
	}

	@Test
	public void testConvertDecSuccess() {
		String validInput = "3114";
		ValueConverter converter = new ValueConverter(validInput);
		Conversion completedConversion = converter.convert("DEC");
		List<String> expectedHexList = createListOfStrings("C 2 A");
		List<String> expectedBinList = createListOfStrings("1100 0010 1010");
		List<List<Integer>> expectedSeparatedNibbles = binSplitter.separateBinValuesIntoDigits(expectedBinList);
		List<String> expectedDecList = createListOfStrings("12 2 10");
		List<String> expectedUserCharList = createListOfStrings("3 1 1 4");
		List<String> expectedSeparatedBinList = createListOfStrings("1 1 0 0 0 0 1 0 1 0 1 0");
		String expectedDecValue = validInput;
		Conversion expectedResult = new Conversion.ConversionBuilder().originalInput(validInput)
				.listOfRepresentationBinChars(expectedBinList).listOfRepresentativeHexChars(expectedHexList)
				.listOfSeparatedBinNibbles(expectedSeparatedNibbles).listOfRepresentativeDecChars(expectedDecList)
				.listOfIndividualBinChars(expectedSeparatedBinList).listOfUserInputChars(expectedUserCharList)
				.decValue(expectedDecValue).build();
		assertConversionsAreEqual(completedConversion, expectedResult);
	}

	@Test
	public void testConvertBinSuccess()
			throws InvalidSymbolException, InvalidNumberLengthException, EmptyInputException {
		String validInput = "110000101010";
		ValueConverter converter = new ValueConverter(validInput);
		Conversion completedConversion = converter.convert("BIN");
		String expectedDecValue = "3114";
		List<String> expectedParsedHex = createListOfStrings("C 2 A");
		List<String> expectedParsedDec = createListOfStrings("12 2 10");
		List<String> expectedBinList = createListOfStrings("1100 0010 1010");
		List<String> expectedUserInputList = createListOfStrings("1 1 0 0 0 0 1 0 1 0 1 0");
		List<String> expectedSeparatedBinList = expectedUserInputList;
		List<List<Integer>> expectedSeparatedNibbles = createListOfExpectedSeparatedNibbles();
		Conversion expectedResult = new Conversion.ConversionBuilder().originalInput(validInput)
				.decValue(expectedDecValue).listOfRepresentativeHexChars(expectedParsedHex)
				.listOfRepresentativeDecChars(expectedParsedDec).listOfRepresentationBinChars(expectedBinList)
				.listOfSeparatedBinNibbles(expectedSeparatedNibbles).listOfUserInputChars(expectedUserInputList)
				.listOfIndividualBinChars(expectedSeparatedBinList).build();
		assertConversionsAreEqual(completedConversion, expectedResult);
	}

	private List<String> createListOfStrings(String input) {
		List<String> output = new LinkedList<>();
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
		b.add(0);
		b.add(0);
		b.add(1);
		b.add(0);
		List<Integer> c = new ArrayList<>();
		c.add(1);
		c.add(0);
		c.add(1);
		c.add(0);
		expectedSeparatedNibbles.add(a);
		expectedSeparatedNibbles.add(b);
		expectedSeparatedNibbles.add(c);
		return expectedSeparatedNibbles;
	}

	private void assertArraysAreEqual(List<Integer> list, List<Integer> list2) {
		for (int c = 0; c < 4; c++) {
			Assert.assertEquals(list.get(c), list2.get(c));
		}
	}

	private void assertConversionsAreEqual(Conversion completedConversion, Conversion expectedResult) {
		Assert.assertEquals(expectedResult.getOriginalInput(), completedConversion.getOriginalInput());
		Assert.assertEquals(expectedResult.getListOfRepresentationBinChars(),
				completedConversion.getListOfRepresentationBinChars());
		for (int i = 0; i < expectedResult.getListOfSeparatedBinNibbles().size(); i++) {
			assertArraysAreEqual(expectedResult.getListOfSeparatedBinNibbles().get(i),
					completedConversion.getListOfSeparatedBinNibbles().get(i));
		}
		Assert.assertEquals(expectedResult.getListOfRepresentativeDecChars(),
				completedConversion.getListOfRepresentativeDecChars());
		Assert.assertEquals(expectedResult.getListOfRepresentativeHexChars(),
				completedConversion.getListOfRepresentativeHexChars());
		Assert.assertEquals(expectedResult.getDecValue(), completedConversion.getDecValue());
		Assert.assertEquals(expectedResult.getListOfUserInputChars(), completedConversion.getListOfUserInputChars());
		Assert.assertEquals(expectedResult.getListOfIndividualBinChars(),
				completedConversion.getListOfIndividualBinChars());
	}
}