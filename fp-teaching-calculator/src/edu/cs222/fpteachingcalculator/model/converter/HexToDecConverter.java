package edu.cs222.fpteachingcalculator.model.converter;

public class HexToDecConverter extends ValueConverter {

	public Conversion convertHexToDec(String userInputValue) {
		parsedListOfUserInput = inputSplitter.splitInput(userInputValue);
		listOfHexadecimalEquivalents = parsedListOfUserInput;
		listOfDecimalEquivalents = valueTranslator
				.translateHexToDec(parsedListOfUserInput);
		return new Conversion.ConversionBuilder().originalInput(userInputValue)
				.parsedListOfUserInput(parsedListOfUserInput)
				.listOfHexEquivalents(listOfHexadecimalEquivalents)
				.listOfDecEquivalents(listOfDecimalEquivalents)
				.build();
	}

}
