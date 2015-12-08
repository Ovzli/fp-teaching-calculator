package edu.cs222.fpteachingcalculator.model.converter;

public class BinToHexConverter extends ValueConverter {

	public Conversion convertBinToHex(String userInputValue) {
		parsedListOfUserInput = inputSplitter.splitInput(userInputValue);
		listOfBinaryEquivalents = parsedListOfUserInput;
		listOfSeparatedBinaryNibbles = binaryParser
				.separateBinValuesIntoDigits(listOfBinaryEquivalents);
		listOfDecimalEquivalents = valueTranslator
				.translateBinToDec(listOfBinaryEquivalents);
		listOfHexadecimalEquivalents = valueTranslator
				.translateDecToHex(listOfDecimalEquivalents);
		return new Conversion.ConversionBuilder().originalInput(userInputValue)
				.listOfSeparatedBinNibbles(listOfSeparatedBinaryNibbles)
				.listOfBinEquivalents(listOfBinaryEquivalents)
				.parsedListOfUserInput(parsedListOfUserInput)
				.listOfDecEquivalents(listOfDecimalEquivalents)
				.listOfHexEquivalents(listOfHexadecimalEquivalents)
				.build();
	}

}
