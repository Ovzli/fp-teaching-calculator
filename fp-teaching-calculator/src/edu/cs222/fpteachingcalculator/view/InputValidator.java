package edu.cs222.fpteachingcalculator.view;

import java.util.List;

import edu.cs222.fpteachingcalculator.view.inputexceptions.*;

public class InputValidator {
	private final int maxHexInputLength = 8;
	private final String validHexSymbols = "0123456789ABCDEF";

	public void checkIfInputIsEmpty(String input) throws EmptyInputException {
		if (input.isEmpty()) {
			throw new EmptyInputException();
		}
	}

	public void checkIfHexValueIsValid(List<String> parsedListOfHexInput)
			throws InvalidHexSymbolException, InvalidHexNumberLengthException {
		areHexSymbolsValid(parsedListOfHexInput);
		isHexNumberTooLong(parsedListOfHexInput);
	}

	private void areHexSymbolsValid(List<String> parsedListOfHexInput)
			throws InvalidHexSymbolException {
		for (String hexChar : parsedListOfHexInput) {
			if (!validHexSymbols.contains(hexChar)) {
				throw new InvalidHexSymbolException();
			}
		}
	}

	private void isHexNumberTooLong(List<String> parsedListOfHexInput)
			throws InvalidHexNumberLengthException {
		if (parsedListOfHexInput.size() > maxHexInputLength) {
			throw new InvalidHexNumberLengthException();
		}
	}
}