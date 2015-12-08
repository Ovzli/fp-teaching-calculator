package edu.cs222.fpteachingcalculator.model.converter;

public class HexToBinConverter extends ValueConverter {

	public Conversion convertHexToBin(String userInputValue){
		parsedListOfUserInput = inputSplitter.splitInput(userInputValue);
		listOfHexadecimalEquivalents = parsedListOfUserInput;
		listOfDecimalEquivalents = valueTranslator
				.translateHexToDec(parsedListOfUserInput);
		listOfBinaryEquivalents = valueTranslator
				.translateDecToBin(listOfDecimalEquivalents);
		listOfSeparatedBinaryNibbles = binaryParser
				.separateBinValuesIntoDigits(listOfBinaryEquivalents);
		return new Conversion.ConversionBuilder().originalInput(userInputValue)
				.parsedListOfUserInput(parsedListOfUserInput)
				.listOfHexEquivalents(listOfHexadecimalEquivalents)
				.listOfBinEquivalents(listOfBinaryEquivalents)
				.listOfDecEquivalents(listOfDecimalEquivalents)
				.listOfSeparatedBinNibbles(listOfSeparatedBinaryNibbles)
				.build();
	}

}