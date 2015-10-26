package edu.cs222.fp_teaching_calculator.model.converter;

import java.util.LinkedList;

public class HexToBinConvertor {
	private LinkedList<String> parsedListOfHexInput = new LinkedList<String>();
	private LinkedList<String> listOfDecimalEquivalents = new LinkedList<String>();
	private LinkedList<String> listOfBinaryEquivalents = new LinkedList<String>();
	private LinkedList<int[]> listOfSeparatedBinaryNibbles = new LinkedList<int[]>();
	private int errorCode = 0;

	private InputParser inputParser = new InputParser();
	private InputValidator inputValidator = new InputValidator();
	private ValueTranslator valueTranslator = new ValueTranslator();
	private BinParser binaryParser = new BinParser();	

	public ConversionContainer convertHexToBin(String hexInputValue) {
		parsedListOfHexInput = inputParser.parseHexInput(hexInputValue);
		if (!inputValidator.isHexValueValid(parsedListOfHexInput)) {
			errorCode = inputValidator.getError();
			return new ConversionContainer(errorCode);
		}
		listOfDecimalEquivalents = valueTranslator.translateHexToDec(parsedListOfHexInput);
		listOfBinaryEquivalents = valueTranslator.translateDecToBin(listOfDecimalEquivalents);
		listOfSeparatedBinaryNibbles = binaryParser.separateBinValuesIntoDigits(listOfBinaryEquivalents);
		return new ConversionContainer.ContainerBuilder().originalInput(hexInputValue)
				.parsedListOfHexInput(parsedListOfHexInput)
				.listOfBinEquivalents(listOfBinaryEquivalents)
				.listOfDecEquivalents(listOfDecimalEquivalents)
				.listOfSeparatedBinNibbles(listOfSeparatedBinaryNibbles).build();
	}
}
