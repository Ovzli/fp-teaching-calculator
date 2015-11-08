package edu.cs222.fpteachingcalculator.model.converter;

import java.util.LinkedList;

public class Conversion {
	private final boolean errorOccurred;
	private final int errorCode;
	private final String originalInput;
	private final LinkedList<String> parsedListOfHexInput;
	private final LinkedList<String> listOfDecEquivalents;
	private final LinkedList<String> listOfBinEquivalents;
	private final LinkedList<int[]> listOfSeparatedBinNibbles;

	public Conversion(int errorCode) {
		this.errorOccurred = true;
		this.errorCode = errorCode;
		this.originalInput = null;
		this.parsedListOfHexInput = null;
		this.listOfBinEquivalents = null;
		this.listOfDecEquivalents = null;
		this.listOfSeparatedBinNibbles = null;
	}

	public Conversion(ConversionBuilder builder) {
		this.errorOccurred = false;
		this.errorCode = 0;
		this.originalInput = builder.originalInput;
		this.parsedListOfHexInput = builder.parsedListOfHexInput;
		this.listOfBinEquivalents = builder.listOfBinEquivalents;
		this.listOfDecEquivalents = builder.listOfDecEquivalents;
		this.listOfSeparatedBinNibbles = builder.listOfSeparatedBinNibbles;
	}
	
	public boolean getErrorOccurred(){
		return errorOccurred;
	}
	
	public int getErrorCode(){
		return errorCode;
	}
	
	public String getOriginalInput(){
		return originalInput;
	}
	
	public LinkedList<String> getParsedListOfHexInput(){
		return parsedListOfHexInput;
	}
	public LinkedList<String> getListOfDecEquivalents(){
		return listOfDecEquivalents;
	}
	
	public LinkedList<String> getListOfBinEquivalents(){
		return listOfBinEquivalents;
	}
	
	public LinkedList<int[]> getListOfSeparatedBinNibbles(){
		return listOfSeparatedBinNibbles;
	}

	public static class ConversionBuilder {

		public String originalInput;
		public LinkedList<String> parsedListOfHexInput;
		public LinkedList<String> listOfDecEquivalents;
		public LinkedList<String> listOfBinEquivalents;
		public LinkedList<int[]> listOfSeparatedBinNibbles;

		public ConversionBuilder originalInput(String input) {
			this.originalInput = input;
			return this;
		}

		public ConversionBuilder parsedListOfHexInput(LinkedList<String> listOfHexInput) {
			this.parsedListOfHexInput = listOfHexInput;
			return this;
		}

		public ConversionBuilder listOfDecEquivalents(LinkedList<String> listOfDecEquivalents) {
			this.listOfDecEquivalents = listOfDecEquivalents;
			return this;
		}

		public ConversionBuilder listOfBinEquivalents(LinkedList<String> listOfBinEquivalents) {
			this.listOfBinEquivalents = listOfBinEquivalents;
			return this;
		}

		public ConversionBuilder listOfSeparatedBinNibbles(LinkedList<int[]> listOfNibbles) {
			this.listOfSeparatedBinNibbles = listOfNibbles;
			return this;
		}

		public Conversion build() {
			return new Conversion(this);
		}
	}
}