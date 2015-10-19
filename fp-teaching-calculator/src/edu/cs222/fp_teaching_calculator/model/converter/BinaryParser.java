package edu.cs222.fp_teaching_calculator.model.converter;

import java.util.LinkedList;

public class BinaryParser {
	//	Contributors = HexToBinConvertor
	/*
	 * Responsibility:
	 * Converts a 1-4 digit binary value (0-1111)
	 * 		into a parsed index (ie: {0,0,0,0} - {1,1,1,1})
	 */
	
	public LinkedList<int[]> separateBinValuesIntoDigits(LinkedList<String> inputValues){
		LinkedList<int[]> listOfSeparatedBinaryNibbles = new LinkedList<int[]>();
		for(String binValue : inputValues){
			char[] binDigits = binValue.toCharArray();
			int[] binDigitsAsInts = new int[4];
			for(int i = 0; i < binDigits.length; i++){
				binDigitsAsInts[i] = (int)binDigits[i];
			}
			listOfSeparatedBinaryNibbles.add(binDigitsAsInts);
		}		
		return listOfSeparatedBinaryNibbles;	
	}
}
