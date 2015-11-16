package edu.cs222.fpteachingcalculator.model.converter;

import java.util.LinkedList;

public class ValueTranslator {
	public LinkedList<String> translateHexToDec(LinkedList<String> listOfHexSymbols) {
		LinkedList<String> decValues = new LinkedList<String>();
		for (String hexSymbol : listOfHexSymbols) {
			decValues.add(Integer.toString(Integer.parseInt(hexSymbol, 16)));
		}
		return decValues;
	}

	public LinkedList<String> translateDecToBin(LinkedList<String> listOfDecValues) {
		LinkedList<String> binValues = new LinkedList<String>();
		for (String decValue : listOfDecValues) {
			binValues.add(fillOutBinValue(Integer.toBinaryString(Integer.parseInt(decValue, 10))));
		}
		return binValues;
	}

	private String fillOutBinValue(String binValue) {
		if (binValue.length() < 4) {
			int orignalLength = binValue.length();
			for (int i = 0; i < (4 - orignalLength); i++) {
				binValue = "0" + binValue;
			}
		}
		return binValue;
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