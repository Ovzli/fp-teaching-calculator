package edu.cs222.fpteachingcalculator.model.converter;

import java.util.LinkedList;
import java.util.List;

public class HexToBinConverter {
	private List<String> parsedListOfHexInput = new LinkedList<>();
	private List<String> listOfDecimalEquivalents = new LinkedList<>();
	private List<String> listOfBinaryEquivalents = new LinkedList<>();
	private List<int[]> listOfSeparatedBinaryNibbles = new LinkedList<>();

	private final InputSplitter inputSplitter = new InputSplitter();
	private final ValueTranslator valueTranslator = new ValueTranslator();
	private final BinSplitter binaryParser = new BinSplitter();

	public Conversion convertHexToBin(String hexInputValue){
		parsedListOfHexInput = inputSplitter.splitHexInput(hexInputValue);
		listOfDecimalEquivalents = valueTranslator
				.translateHexToDec(parsedListOfHexInput);
		listOfBinaryEquivalents = valueTranslator
				.translateDecToBin(listOfDecimalEquivalents);
		listOfSeparatedBinaryNibbles = binaryParser
				.separateBinValuesIntoDigits(listOfBinaryEquivalents);
		return new Conversion.ConversionBuilder().originalInput(hexInputValue)
				.parsedListOfHexInput(parsedListOfHexInput)
				.listOfBinEquivalents(listOfBinaryEquivalents)
				.listOfDecEquivalents(listOfDecimalEquivalents)
				.listOfSeparatedBinNibbles(listOfSeparatedBinaryNibbles)
				.build();
	}

}