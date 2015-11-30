package edu.cs222.fpteachingcalculator.model.converter;

import java.util.LinkedList;
import java.util.List;

public class BinSplitter {
	
	public List<int[]> separateBinValuesIntoDigits(
			List<String> listOfBinaryEquivalents) {
		List<int[]> listOfSeparatedBinaryNibbles = new LinkedList<>();
		for (String binValue : listOfBinaryEquivalents) {
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