package edu.cs222.fpteachingcalculator.model.converter;

import java.util.LinkedList;
import java.util.List;

public class ValueTranslator {
	
	public List<String> translateDecListToHexList(List<String> decList){
		List<String> hexValues = new LinkedList<>();
		for (String decValue : decList) {
			hexValues.add(Integer.toHexString(Integer.parseInt(decValue)).toUpperCase());
		}
		return hexValues;
	}
	
	public List<String> translateHexListToDecList(List<String> hexList) {
		List<String> decValues = new LinkedList<>();
		for (String hexSymbol : hexList) {
			decValues.add(Integer.toString(Integer.parseInt(hexSymbol, 16)));
		}
		return decValues;
	}
	
	public String translateDecListToDecValue(List<String> decList){
		int decNum = 0;
		for (int i = 0; i < decList.size(); i++){
			int tempValue = Integer.parseInt(decList.get(decList.size()-i-1));
			decNum += tempValue * Math.pow(16, i);
		}
		String finalValue = Integer.toString(decNum);
		return finalValue;
	}
	
	public List<String> translateBinListToDecList(List<List<Integer>> binList){
		List<String> decList = new LinkedList<String>();
		for(List<Integer> binNibble : binList){
			String binValue = "";
			for(int binDigit : binNibble){ //refactor out inside for loop
				binValue = binValue + Integer.toString(binDigit);
			}
			decList.add(Integer.toString(Integer.parseInt(binValue, 2)));
		}
		return decList;
		
	}
	//*****************************************************************
	//actually returns a single string within a list. determine whether to refactor
	public String translateDecValueToHexValue(String decValue){
		String hexValue;
		hexValue = Integer.toHexString(Integer.parseInt(decValue)).toUpperCase();
		return hexValue;
	}
	
	public String translateDecValueToBinValue(String decValue){
		String binValue;
		binValue = Integer.toBinaryString(Integer.parseInt(decValue));
		return binValue;
	}
	
	
	//************************************************************************
	public List<String> translateDecListToBinList(List<String> listOfDecimalEquivalents) {
		List<String> binValues = new LinkedList<>();
		for (String decValue : listOfDecimalEquivalents) {
			binValues.add(fillOutBinValue(Integer.toBinaryString(Integer.parseInt(decValue))));
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
