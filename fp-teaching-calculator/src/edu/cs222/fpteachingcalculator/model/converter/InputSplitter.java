package edu.cs222.fpteachingcalculator.model.converter;

import java.util.LinkedList;

public class InputSplitter {
	public LinkedList<String> splitHexInput(String input) {
		LinkedList<String> hexSymbols = new LinkedList<String>();
		for (int i = 0; i < input.length(); i++) {
			hexSymbols.add(Character.toString(input.charAt(i)).toUpperCase());
		}
		return hexSymbols;
	}
}