package edu.cs222.fpteachingcalculator.model.converter;

public class BinToDecConverter extends ValueConverter {

	public Conversion convertBinToDec(String userInputValue) {
		parsedListOfUserInput = inputSplitter.splitInput(userInputValue);
		listOfBinaryEquivalents = parsedListOfUserInput;
		listOfSeparatedBinaryNibbles = binaryParser
				.separateBinValuesIntoDigits(listOfBinaryEquivalents);
		listOfDecimalEquivalents = valueTranslator
				.translateBinToDec(listOfBinaryEquivalents);
		return new Conversion.ConversionBuilder().originalInput(userInputValue)
				.listOfSeparatedBinNibbles(listOfSeparatedBinaryNibbles)
				.listOfBinEquivalents(listOfBinaryEquivalents)
				.parsedListOfUserInput(parsedListOfUserInput)
				.listOfDecEquivalents(listOfDecimalEquivalents)
				.build();
	}

}
