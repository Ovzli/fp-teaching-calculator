package edu.cs222.fpteachingcalculator.model.converter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinSplitter {
	
	public List<List<Integer>> separateBinValuesIntoDigits(
			List<String> listOfBinaryEquivalents) {
		List<List<Integer>> listOfSeparatedBinaryNibbles = new LinkedList<>();
		for (String binValue : listOfBinaryEquivalents) {
			listOfSeparatedBinaryNibbles.add(createIntArrayOfBinDigits(binValue));
		}
		return listOfSeparatedBinaryNibbles;
	}

	private List<Integer> createIntArrayOfBinDigits(String binValue) {
		char[] binDigits = binValue.toCharArray();
		List<Integer> binDigitsAsInts = new ArrayList<>(4);
		for (int i = 0; i < binDigits.length; i++) {
			binDigitsAsInts.add(i, Character.getNumericValue(binDigits[i]));
		}
		return binDigitsAsInts;
	}
}