package edu.cs222.fpteachingcalculator.model.converter;

public class DecToBinConverter extends ValueConverter {
	
	public Conversion convertDecToBin(String userInputValue) {
		parsedListOfUserInput = inputSplitter.splitInput(userInputValue);
		listOfDecimalEquivalents = parsedListOfUserInput;
		listOfBinaryEquivalents = valueTranslator
				.translateDecToBin(listOfDecimalEquivalents);
		listOfSeparatedBinaryNibbles = binaryParser
				.separateBinValuesIntoDigits(listOfBinaryEquivalents);
		return new Conversion.ConversionBuilder().originalInput(userInputValue)
				.parsedListOfUserInput(parsedListOfUserInput)
				.listOfBinEquivalents(listOfBinaryEquivalents)
				.listOfDecEquivalents(listOfDecimalEquivalents)
				.listOfSeparatedBinNibbles(listOfSeparatedBinaryNibbles)
				.build();
	}

}
