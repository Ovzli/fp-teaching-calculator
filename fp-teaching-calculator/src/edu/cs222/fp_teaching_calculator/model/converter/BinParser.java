package edu.cs222.fp_teaching_calculator.model.converter;

import java.util.LinkedList;

public class BinParser {
	public LinkedList<int[]> separateBinValuesIntoDigits(LinkedList<String> inputValues) {
		LinkedList<int[]> listOfSeparatedBinaryNibbles = new LinkedList<int[]>();
		for (String binValue : inputValues) {
			char[] binDigits = binValue.toCharArray();
			int[] binDigitsAsInts = new int[4];
			for (int i = 0; i < binDigits.length; i++) {
				binDigitsAsInts[i] = Character.getNumericValue(binDigits[i]);
			}
			listOfSeparatedBinaryNibbles.add(binDigitsAsInts);
		}
		return listOfSeparatedBinaryNibbles;
	}
}
