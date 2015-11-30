package edu.cs222.fpteachingcalculator.model.converter;

import java.util.LinkedList;
import java.util.List;

public class InputSplitter {

	public List<String> splitHexInput(String input) {
		List<String> hexSymbols = new LinkedList<>();
		for (int i = 0; i < input.length(); i++) {
			hexSymbols.add(Character.toString(input.charAt(i)).toUpperCase());
		}
		return hexSymbols;
	}
}