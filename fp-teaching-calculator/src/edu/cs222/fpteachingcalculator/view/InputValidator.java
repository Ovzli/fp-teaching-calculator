package edu.cs222.fpteachingcalculator.view;

import java.util.List;

import edu.cs222.fpteachingcalculator.view.inputexceptions.*;

public class InputValidator {
	private final int maxHexInputLength = 8;
	private final int maxDecInputLength = 6;
	private final int maxBinInputLength = 24;
	private final String validHexSymbols = "0123456789ABCDEF";
	private final String validDecSymbols = "0123456789";
	private final String validBinSymbols = "01";

	public void checkIfInputIsEmpty(String input) throws EmptyInputException {
		if (input.isEmpty()) {
			throw new EmptyInputException();
		}
	}

	public void checkIfValueIsValid(List<String> parsedListOfUserInput, String inputMode)
			throws InvalidSymbolException, InvalidNumberLengthException {
		if (inputMode.equals("HEX")) {
			areHexSymbolsValid(parsedListOfUserInput);
			isHexNumberTooLong(parsedListOfUserInput);
		} else if (inputMode.equals("DEC")) {
			areDecSymbolsValid(parsedListOfUserInput);
			isDecNumberTooLong(parsedListOfUserInput);
		} else if (inputMode.equals("BIN")) {
			areBinSymbolsValid(parsedListOfUserInput);
			isBinNumberTooLong(parsedListOfUserInput);
		}
	}

	private void isHexNumberTooLong(List<String> parsedListOfHexInput) throws InvalidNumberLengthException {
		if (parsedListOfHexInput.size() > maxHexInputLength) {
			throw new InvalidNumberLengthException();
		}
	}

	private void isDecNumberTooLong(List<String> parsedListOfDecInput) throws InvalidNumberLengthException {
		if (parsedListOfDecInput.size() > maxDecInputLength) {
			throw new InvalidNumberLengthException();
		}
	}

	private void isBinNumberTooLong(List<String> parsedListOfBinInput) throws InvalidNumberLengthException {
		if (parsedListOfBinInput.size() > maxBinInputLength) {
			throw new InvalidNumberLengthException();
		}
	}

	private void areHexSymbolsValid(List<String> parsedListOfHexInput) throws InvalidSymbolException {
		for (String hexChar : parsedListOfHexInput) {
			if (!validHexSymbols.contains(hexChar)) {
				throw new InvalidSymbolException();
			}
		}
	}

	private void areDecSymbolsValid(List<String> parsedListOfDecInput) throws InvalidSymbolException {
		for (String decChar : parsedListOfDecInput) {
			if (!validDecSymbols.contains(decChar)) {
				throw new InvalidSymbolException();
			}
		}
	}

	private void areBinSymbolsValid(List<String> parsedListOfBinInput) throws InvalidSymbolException {
		for (String binChar : parsedListOfBinInput) {
			if (!validBinSymbols.contains(binChar)) {
				throw new InvalidSymbolException();
			}
		}
	}
}
