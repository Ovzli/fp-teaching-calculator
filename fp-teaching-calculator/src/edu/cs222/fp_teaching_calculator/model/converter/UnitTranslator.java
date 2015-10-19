package edu.cs222.fp_teaching_calculator.model.converter;

import java.util.LinkedList;

public class UnitTranslator {
	//	Contributors = HexToBinConvertor
	//	Responsibility = Translates a string character to another value
	private String[] hexadecimalValues = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	private String[] decimalValues = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
	private String[] binaryValues = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010",
									"1011","1100","1101","1110","1111"};
	
	public LinkedList<String> translateHexadecimalToDecimal(LinkedList<String> hexCharacters){
		LinkedList<String> decimalUnits = new LinkedList<String>();
		for(String hexChar : hexCharacters){
			decimalUnits.add(decimalValues[getPostitionOfValue(hexadecimalValues, hexChar)]);
		}		
		return decimalUnits;		
	}
	
	public LinkedList<String> translateDecimalToBinary(LinkedList<String> decCharacters){
		LinkedList<String> binaryUnits = new LinkedList<String>();
		for(String decChar : decCharacters){
			binaryUnits.add(binaryValues[getPostitionOfValue(decimalValues, decChar)]);
		}		
		return binaryUnits;	
	}
	
	public int getPostitionOfValue(String[] array, String value){
		for(int i = 0; i < array.length; i++){
			if (array[i].equals(value)){
				return i;
			}
		}
		return 0;
	}
	
	
	public int translateToDecimal(String character){
		int decimalEquivalent = 0;
		
		// makes translation here...
				
		// TO DO - SET UP TDD TEST WITH HexToBinConvertor!!!
		return decimalEquivalent;
	}
	
	public int translateToBinary(int decimal){
		int binaryEquivalent = 0;
		
		// makes translation here...
		
		// TO DO - SET UP TDD TEST WITH HexToBinConvertor!!!
		return binaryEquivalent;
	}
	
	
}
