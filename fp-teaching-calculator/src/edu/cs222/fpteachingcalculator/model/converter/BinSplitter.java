package edu.cs222.fpteachingcalculator.model.converter;

import java.util.LinkedList;

public class BinSplitter {
	public LinkedList<int[]> separateBinValuesIntoDigits(LinkedList<String> inputValues) {
		LinkedList<int[]> listOfSeparatedBinaryNibbles = new LinkedList<int[]>();
		for (String binValue : inputValues) {
			listOfSeparatedBinaryNibbles.add(createIntArrayOfBinDigits(binValue));
		}
		return listOfSeparatedBinaryNibbles;
	}

	private int[] createIntArrayOfBinDigits(String binValue) {
		char[] binDigits = binValue.toCharArray();
		int[] binDigitsAsInts = new int[4];
		for (int i = 0; i < binDigits.length; i++) {
			binDigitsAsInts[i] = Character.getNumericValue(binDigits[i]);
		}
		return binDigitsAsInts;
	}
}