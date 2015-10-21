package edu.cs222.fp_teaching_calculator.model.converter;

import java.util.LinkedList;

public class InputValidator {
	//	Contributors = HexToBinConvertor
	//	Responsibility = Validates each character of the
	//			user's input string to verify it is a hex value
	private final String validHexidecimalCharacters = "0123456789ABCDEF";
	
	public boolean isHexValueValid(LinkedList<String> hexCharacters){
		for(String hexChar : hexCharacters){ //add length checker?
			if(validHexidecimalCharacters.contains(hexChar) == false){
				return false;
			}
		}
		return true;
	}
	
	public boolean isDecValueValid(){
		return true;
		
	}
	
	public boolean isBinValueValid(){
		return true;
		
	}
	
}
