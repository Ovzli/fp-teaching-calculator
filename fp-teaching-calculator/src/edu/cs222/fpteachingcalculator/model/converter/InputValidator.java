package edu.cs222.fpteachingcalculator.model.converter;

import java.util.LinkedList;
import edu.cs222.fpteachingcalculator.model.converter.inputexceptions.*;

public class InputValidator {
	private final int maxHexInputLength = 8;
	private final String validHexSymbols = "0123456789ABCDEF";
	private int errorCode = 0;

	public boolean isHexValueValid(LinkedList<String> hexSymbols) throws InvalidHexSymbolException, InvalidHexNumberLengthException {
		return areHexSymbolsValid(hexSymbols) && isHexNumberTooLong(hexSymbols);
	}
	
	public boolean isInputEmpty(String input) throws EmptyInputException{
		if(input.isEmpty()){
			throw new EmptyInputException();
		}
		return true;
	}
	
	private boolean areHexSymbolsValid(LinkedList<String> hexSymbols) throws InvalidHexSymbolException {
		for (String hexChar : hexSymbols) {
			if (!validHexSymbols.contains(hexChar)) {
				throw new InvalidHexSymbolException();
			}
		}
		return true;
	}
	
	private boolean isHexNumberTooLong(LinkedList<String> hexSymbols) throws InvalidHexNumberLengthException {
		if (hexSymbols.size() > maxHexInputLength) {
			throw new InvalidHexNumberLengthException();
		}
		return true;
	}
	
	public int getError() {
		return errorCode;
	}
	
	
}
