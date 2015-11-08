package edu.cs222.fpteachingcalculator.model.converter;

import java.util.LinkedList;

public class HexToBinConverter {
	private LinkedList<String> parsedListOfHexInput = new LinkedList<String>();
	private LinkedList<String> listOfDecimalEquivalents = new LinkedList<String>();
	private LinkedList<String> listOfBinaryEquivalents = new LinkedList<String>();
	private LinkedList<int[]> listOfSeparatedBinaryNibbles = new LinkedList<int[]>();
	private int errorCode = 0;

	private InputSplitter inputParser = new InputSplitter();
	private InputValidator inputValidator = new InputValidator();
	private ValueTranslator valueTranslator = new ValueTranslator();
	private BinSplitter binaryParser = new BinSplitter();	

	public Conversion convertHexToBin(String hexInputValue) {
		parsedListOfHexInput = inputParser.parseHexInput(hexInputValue);
		if (!inputValidator.isHexValueValid(parsedListOfHexInput)) {
			errorCode = inputValidator.getError();
			return new Conversion(errorCode);
		}
		listOfDecimalEquivalents = valueTranslator.translateHexToDec(parsedListOfHexInput);
		listOfBinaryEquivalents = valueTranslator.translateDecToBin(listOfDecimalEquivalents);
		listOfSeparatedBinaryNibbles = binaryParser.separateBinValuesIntoDigits(listOfBinaryEquivalents);
		return new Conversion.ConversionBuilder().originalInput(hexInputValue)
				.parsedListOfHexInput(parsedListOfHexInput)
				.listOfBinEquivalents(listOfBinaryEquivalents)
				.listOfDecEquivalents(listOfDecimalEquivalents)
				.listOfSeparatedBinNibbles(listOfSeparatedBinaryNibbles).build();
	}
}