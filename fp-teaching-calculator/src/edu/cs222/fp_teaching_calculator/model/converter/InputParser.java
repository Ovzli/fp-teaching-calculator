package edu.cs222.fp_teaching_calculator.model.converter;

import java.util.LinkedList;

public class InputParser {
	//	Contributors = 
	//	Responsibility = 

	public LinkedList<String> parseHexidecimalInput(String input){
		LinkedList<String> characters = new LinkedList<String>();//rename characters?
		for(int i = 0; i < input.length() ; i++){ // relabel i?
			characters.add(Character.toString(input.charAt(i)).toUpperCase());
			}
 		return characters;		
	}
	
//	public LinkedList<String> parseDecimalInput(String input){
//		return null;		
//	}
	
//	public LinkedList<String> parseBinaryInput(String input){
//		return null;		
//	}
}
