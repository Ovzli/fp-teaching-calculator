package edu.cs222.fp_teaching_calculator.view;

public class ErrorLibrary {	
	private final String[] errorMessage = {
			"NO VALUE WAS ENTERED",
			"AN INVALID CHARCTER WAS DETECTED",
			"THE INPUT ENTERED IS TOO LONG"
	};
	
	public String readErrorMessage(int indexID){
		return errorMessage[indexID];
	}
}
