package edu.cs222.fpteachingcalculator.model.converter;

import java.util.LinkedList;
import java.util.List;

public class ValueTranslator {
	
	public LinkedList<String> translateHexToDec(
			List<String> parsedListOfHexInput) {
		LinkedList<String> decValues = new LinkedList<String>();
		for (String hexSymbol : parsedListOfHexInput) {
			decValues.add(Integer.toString(Integer.parseInt(hexSymbol, 16)));
		}
		return decValues;
	}

	public List<String> translateDecToHex(List<String> parsedListOfUserInput) {
		// TODO Auto-generated method stub
		return null;
	}

	public LinkedList<String> translateDecToBin(
			List<String> listOfDecimalEquivalents) {
		LinkedList<String> binValues = new LinkedList<String>();
		for (String decValue : listOfDecimalEquivalents) {
			binValues.add(fillOutBinValue(Integer.toBinaryString(Integer
					.parseInt(decValue, 10))));
		}
		return binValues;
	}

	public List<String> translateBinToDec(List<String> listOfDecimalEquivalents) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> translateBinToBin(List<String> listOfDecimalEquivalents) {
		// TODO Auto-generated method stub
		return null;
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