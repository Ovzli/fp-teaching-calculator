package edu.cs222.fpteachingcalculator.model.converter;

import java.util.LinkedList;
import edu.cs222.fpteachingcalculator.model.converter.inputexceptions.*;

public class InputValidator {
	private final int maxHexInputLength = 8;
	private final String validHexSymbols = "0123456789ABCDEF";

	public void checkIfHexValueIsValid(LinkedList<String> hexSymbols) throws InvalidHexSymbolException, InvalidHexNumberLengthException {
		areHexSymbolsValid(hexSymbols);
		isHexNumberTooLong(hexSymbols);
	}

	public void checkIfInputIsEmpty(String input) throws EmptyInputException {
		if (input.isEmpty()) {
			throw new EmptyInputException();
		}
	}

	private void areHexSymbolsValid(LinkedList<String> hexSymbols) throws InvalidHexSymbolException {
		for (String hexChar : hexSymbols) {
			if (!validHexSymbols.contains(hexChar)) {
				throw new InvalidHexSymbolException();
			}
		}
	}

	private void isHexNumberTooLong(LinkedList<String> hexSymbols) throws InvalidHexNumberLengthException {
		if (hexSymbols.size() > maxHexInputLength) {
			throw new InvalidHexNumberLengthException();
		}
	}
}
