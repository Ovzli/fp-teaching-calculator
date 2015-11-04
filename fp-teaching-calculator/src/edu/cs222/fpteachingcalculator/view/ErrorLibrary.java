package edu.cs222.fpteachingcalculator.view;

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
