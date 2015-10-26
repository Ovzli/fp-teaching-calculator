package edu.cs222.fp_teaching_calculator.model.converter;

import java.util.LinkedList;

public class ValueTranslator {
	private String[] allHexSymbolsSorted = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
	private String[] allDecValuesSorted = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15"};
	private String[] allBinValuesSorted = {"0000","0001","0010","0011","0100","0101","0110","0111","1000","1001","1010",
											"1011","1100","1101","1110","1111"};

	public LinkedList<String> translateHexToDec(LinkedList<String> listOfHexSymbols) {
		LinkedList<String> decValues = new LinkedList<String>();
		for (String hexSymbol : listOfHexSymbols) {
			decValues.add(allDecValuesSorted[getPostitionOfValue(allHexSymbolsSorted, hexSymbol)]);
		}
		return decValues;
	}

	public LinkedList<String> translateDecToBin(LinkedList<String> listOfDecValues) {
		LinkedList<String> binValues = new LinkedList<String>();
		for (String decValue : listOfDecValues) {
			binValues.add(allBinValuesSorted[getPostitionOfValue(allDecValuesSorted, decValue)]);
		}
		return binValues;
	}

	public int getPostitionOfValue(String[] array, String value) {
		int indexPosition = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(value)) {
				indexPosition = i;
			}
		}
		return indexPosition;
	}
}
