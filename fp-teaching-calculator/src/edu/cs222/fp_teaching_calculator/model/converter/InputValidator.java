package edu.cs222.fp_teaching_calculator.model.converter;

import java.util.LinkedList;

public class InputValidator {
	//	Contributors = HexToBinConvertor
	//	Responsibility = Validates each character of the
	//			user's input string to verify it is a hex value
	private final String validHexidecimalCharacters = "0123456789ABCDEFabcdef";
	
	public boolean hexadecimalValidator(LinkedList<Character> hexCharacters){
		for(Character hexChar : hexCharacters){
			if(validHexidecimalCharacters.contains(hexChar.toString()) == false){
				return false;
			}
		}
		return true;
	}
	
	public boolean decimalValidator(){
		return true;
		
	}
	
	public boolean binaryValidator(){
		return true;
		
	}
	
}
