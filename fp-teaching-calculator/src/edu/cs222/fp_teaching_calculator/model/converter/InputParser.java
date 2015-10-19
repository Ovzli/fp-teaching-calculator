package edu.cs222.fp_teaching_calculator.model.converter;

import java.util.LinkedList;

public class InputParser {
	//	Contributors = 
	//	Responsibility = 

	public LinkedList<Character> parseHexidecimalInput(String input){
		LinkedList<Character> characters = new LinkedList<Character>();//rename characters?
		for(int i = 0; i < input.length() ; i++){
			characters.add(input.charAt(i));
			}
 		return characters;		
	}
	
	public LinkedList<Character> parseDecimalInput(String input){
		return null;		
	}
	
	public LinkedList<Character> parseBinary(String input){
		return null;		
	}
}
