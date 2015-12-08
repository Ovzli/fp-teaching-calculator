package edu.cs222.fpteachingcalculator.model.converter;

public class DecToHexConverter extends ValueConverter {

	public Conversion convertDecToHex(String userInputValue) {
		parsedListOfUserInput = inputSplitter.splitInput(userInputValue);
		listOfDecimalEquivalents = parsedListOfUserInput;
		listOfHexadecimalEquivalents = valueTranslator
				.translateDecToHex(listOfDecimalEquivalents);
		return new Conversion.ConversionBuilder().originalInput(userInputValue)
				.parsedListOfUserInput(parsedListOfUserInput)
				.listOfHexEquivalents(listOfHexadecimalEquivalents)
				.listOfBinEquivalents(listOfBinaryEquivalents)
				.listOfDecEquivalents(listOfDecimalEquivalents)
				.build();
	}

}
