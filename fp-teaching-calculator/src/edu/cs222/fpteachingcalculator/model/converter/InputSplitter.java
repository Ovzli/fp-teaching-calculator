package edu.cs222.fpteachingcalculator.model.converter;

import java.util.LinkedList;
import java.util.List;

public class InputSplitter {

	public List<String> splitString(String input) {
		List<String> symbols = new LinkedList<>();
		for (int i = 0; i < input.length(); i++) {
			symbols.add(Character.toString(input.charAt(i)).toUpperCase());
		}
		return symbols;
	}

	public List<String> splitBinList(List<String> input) {
		List<String> symbols = new LinkedList<>();
		for (int i = 0; i < input.size(); i++) {
			for (int j = 0; j < input.get(i).length(); j++) {
				symbols.add(Character.toString(input.get(i).charAt(j)));
			}
		}
		return symbols;
	}

	public List<String> splitBinString(String input) {
		List<String> binNibbles = new LinkedList<>();
		String binValue = "";
		int nibbleCount = 0;
		for (int i = 0; i < input.length(); i++) {
			binValue = Character.toString(input.charAt(input.length() - i - 1)) + binValue;
			nibbleCount++;
			if (nibbleCount >= 4) {
				binNibbles.add(0, binValue);
				binValue = "";
				nibbleCount = 0;
			}
		}
		if (nibbleCount != 0) {
			binNibbles.add(0, fillOutBinValue(binValue));
		}
		return binNibbles;
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
}