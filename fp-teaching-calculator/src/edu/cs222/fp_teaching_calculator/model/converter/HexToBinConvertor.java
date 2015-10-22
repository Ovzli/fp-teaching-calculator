package edu.cs222.fp_teaching_calculator.model.converter;

import java.util.LinkedList;

public class HexToBinConvertor {
	private LinkedList<String> parsedListOfHexInput = new LinkedList<String>(); 
	private LinkedList<String> listOfDecimalEquivalents = new LinkedList<String>(); 
	private LinkedList<String> listOfBinaryEquivalents= new LinkedList<String>();
	private LinkedList<int[]>  listOfSeparatedBinaryNibbles = new LinkedList<int[]>();
	
	private InputParser inputParser = new InputParser();
	private InputValidator inputValidator = new InputValidator();
	private ValueTranslator valueTranslator = new ValueTranslator();
	private BinaryParser binaryParser = new BinaryParser();
	
	private int errorCode=0;
	
	public ConversionContainer convertHexToBin(String hexInputValue){
		errorCode=0;
		/*	Contributors = GUI
		 * Responsibility:
		 * Produce a binary equivalent (as an index of each digit) to the hexInputValue provided
		 * 
		 * SEQUENCE:
		 * 1) PARSE INPUT STRING INTO AN INDEX OF CHARS (now strings)  (use InputParser class)*/
		 parsedListOfHexInput = inputParser.parseHexidecimalInput(hexInputValue);
		 // 2) VALIDATE EACH STRING DIGITS (use InputValidator class)
		 // 3) RETURN FALSE IF INVALID INPUT
		 if(!inputValidator.isHexValueValid(parsedListOfHexInput)){
			errorCode = inputValidator.getError();
			return new ConversionContainer(errorCode);
			// conversionContainer = new ConversionContainer(errorcode);
			 //return new ConversionContainer(errorCode);
		 }		 
		 // 4) BUILD THE DECIMAL INDEX FROM PARSED HEX STRING (sample concept below)
		 listOfDecimalEquivalents = valueTranslator.translateHexadecimalToDecimal(parsedListOfHexInput);
		 // 5) BUILD THE PARSED BINARY LIST FROM THE DECIMAL LIST (use CharacterTranslator (now unitTranslators)
		 listOfBinaryEquivalents = valueTranslator.translateDecimalToBinary(listOfDecimalEquivalents);
		 // 6) PARSE THE BINARY VALUES INTO 4 INDEXED DIGITS FOR EACH VALUE (use BinaryParser)
		 listOfSeparatedBinaryNibbles = binaryParser.separateBinValuesIntoDigits(listOfBinaryEquivalents);
		 // 7) RETURN TRUE WHEN DATA IS FULLY CONVERTED
		 return new ConversionContainer.ContainerBuilder().originalInput(hexInputValue).
				 									parsedListOfHexInput(parsedListOfHexInput).
				 									listOfBinaryEquivalents(listOfBinaryEquivalents).
				 									listOfDecimalEquivalents(listOfDecimalEquivalents).
				 									listOfSeparatedBinaryNibbles(listOfSeparatedBinaryNibbles).
				 									build();		
		// TO DO - SET UP TDD TEST WITH HexToBinConvertor!!!
	}
	
	
//	public LinkedList<String> getBinaryIndex(){
//		// BUILD THE INDEX
//		// TO DO - SET UP TDD TEST WITH GUI!!!
//		return listOfBinaryEquivalents;
//	}
}
