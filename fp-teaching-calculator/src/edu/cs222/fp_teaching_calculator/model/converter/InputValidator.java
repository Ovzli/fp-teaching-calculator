package edu.cs222.fp_teaching_calculator.model.converter;

import java.util.LinkedList;

public class InputValidator {
	private final int maxHexInputLength = 8;
	private final String validHexSymbols = "0123456789ABCDEF";
	private int errorCode = 0;

	public boolean isHexValueValid(LinkedList<String> hexSymbols) {
		return areHexSymbolsValid(hexSymbols) && isHexNumberTooLong(hexSymbols);
	}

	private boolean areHexSymbolsValid(LinkedList<String> hexSymbols) {
		for (String hexChar : hexSymbols) {
			if (!validHexSymbols.contains(hexChar)) {
				errorCode = 1;
				return false;
			}
		}
		return true;
	}

	private boolean isHexNumberTooLong(LinkedList<String> hexSymbols) {
		if (hexSymbols.size() > maxHexInputLength) {
			errorCode = 2;
			return false;
		}
		return true;
	}

	public int getError() {
		return errorCode;
	}
}
