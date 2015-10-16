package edu.cs222.fp_teaching_calculator.model;

import java.util.LinkedList;

public class HexToBinConvertor {
	public LinkedList<Integer> parsedIndexOfHexInput = new LinkedList<Integer>(); 
	public LinkedList<Integer> decimalEquivalencyIndex = new LinkedList<Integer>(); 
	public LinkedList<Integer> binaryNotationIndex = new LinkedList<Integer>();
	
	public boolean convertHexToBin(String hexInputValue){
		/*	Contributors = GUI
		 * Responsibility:
		 * Produce a binary equivalent (as an index of each digit) to the hexInputValue provided
		 * 
		 * SEQUENCE:
		 * 1) PARSE INPUT STRING INTO AN INDEX OF CHARS  (use InputParser class)
		 * 2) VALIDATE EACH STRING DIGITS (use InputValidator class)
		 * 3) RETURN FALSE IF INVALID INPUT
		 * 4) BUILD THE DECIMAL INDEX FROM PARSED HEX STRING (sample concept below)
		 */
		
		CharacterTranslator hexCharTranslator = new CharacterTranslator();
		decimalEquivalencyIndex.add( hexCharTranslator.translateToDecimal("A") );
		// this needs to loop through all hex chars (instead of "A");
		
		/* 
		 * 4) BUILD THE PARSED BINARY LIST FROM THE DECIMAL LIST (use CharacterTranslator)
		 * 5) PARSE THE BINARY VALUES INTO 4 INDEXED DIGITS FOR EACH VALUE (use BinaryParser)
		 * 5) RETURN TRUE WHEN DATA IS FULLY CONVERTED
		 */

		
		// TO DO - SET UP TDD TEST WITH HexToBinConvertor!!!
		return true;
	}
	
	private void makeConversion(){
		
	}
	
	public LinkedList<Integer> getBinaryIndex(){
		// BUILD THE INDEX
		// TO DO - SET UP TDD TEST WITH GUI!!!
		return binaryNotationIndex;
	}
}
