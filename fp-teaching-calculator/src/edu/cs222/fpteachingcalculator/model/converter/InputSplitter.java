package edu.cs222.fpteachingcalculator.model.converter;

import java.util.LinkedList;
import java.util.List;

public class InputSplitter {

	public List<String> splitInput(String input) {
		List<String> inputSymbols = new LinkedList<>();
		for (int i = 0; i < input.length(); i++) {
			inputSymbols.add(Character.toString(input.charAt(i)).toUpperCase());
		}
		return inputSymbols;
	}
}