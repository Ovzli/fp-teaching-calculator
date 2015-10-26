package edu.cs222.fp_teaching_calculator.model.converter;

import java.util.LinkedList;

public class InputParser {
	public LinkedList<String> parseHexInput(String input) {
		LinkedList<String> hexSymbols = new LinkedList<String>();
		for (int i = 0; i < input.length(); i++) {
			hexSymbols.add(Character.toString(input.charAt(i)).toUpperCase());
		}
		return hexSymbols;
	}
}
