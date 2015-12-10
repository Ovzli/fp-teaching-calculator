package edu.cs222.fpteachingcalculator.model.converter;

import java.util.List;

public class Conversion {
	private final String originalInput;
	private final String decValue;
	private final List<String> listOfUserInputChars;
	private final List<String> listOfRepresentativeHexChars;
	private final List<String> listOfRepresentativeDecChars;
	private final List<String> listOfRepresentationBinChars;
	private final List<List<Integer>> listOfSeparatedBinNibbles;

	public Conversion(ConversionBuilder builder) {
		this.originalInput = builder.originalInput;
		this.decValue = builder.decValue;
		this.listOfUserInputChars = builder.listOfUserInputChars;
		this.listOfRepresentativeHexChars = builder.listOfRepresentativeHexChars;
		this.listOfRepresentationBinChars = builder.listOfRepresentationBinChars;
		this.listOfRepresentativeDecChars = builder.listOfRepresentativeDecChars;
		this.listOfSeparatedBinNibbles = builder.listOfSeparatedBinNibbles;
	}

	public String getOriginalInput() {
		return originalInput;
	}

	public String getDecValue() {
		return decValue;
	}
	
	public List<String> getListOfUserInputChars(){
		return listOfUserInputChars;
	}
	
	public List<String> getListOfRepresentativeHexChars() {
		return listOfRepresentativeHexChars;
	}

	public List<String> getListOfRepresentativeDecChars() {
		return listOfRepresentativeDecChars;
	}

	public List<String> getListOfRepresentationBinChars() {
		return listOfRepresentationBinChars;
	}

	public List<List<Integer>> getListOfSeparatedBinNibbles() {
		return listOfSeparatedBinNibbles;
	}

	public static class ConversionBuilder {
		public String originalInput;
		public String decValue;
		public List<String> listOfUserInputChars;
		public List<String> listOfRepresentativeHexChars;
		public List<String> listOfRepresentativeDecChars;
		public List<String> listOfRepresentationBinChars;
		public List<List<Integer>> listOfSeparatedBinNibbles;

		public ConversionBuilder originalInput(String originalInput) {
			this.originalInput = originalInput;
			return this;
		}
		
		public ConversionBuilder decValue(String decValue){
			this.decValue = decValue;
			return this;
		}
		
		public ConversionBuilder listOfUserInputChars(List<String> listOfUserInputChars){
			this.listOfUserInputChars = listOfUserInputChars;
			return this;
		}

		public ConversionBuilder listOfRepresentativeHexChars(
				List<String> listOfRepresentativeHexChars) {
			this.listOfRepresentativeHexChars = listOfRepresentativeHexChars;
			return this;
		}

		public ConversionBuilder listOfRepresentativeDecChars(
				List<String> listOfRepresentativeDecChars) {
			this.listOfRepresentativeDecChars = listOfRepresentativeDecChars;
			return this;
		}

		public ConversionBuilder listOfRepresentationBinChars(
				List<String> listOfRepresentationBinChars) {
			this.listOfRepresentationBinChars = listOfRepresentationBinChars;
			return this;
		}

		public ConversionBuilder listOfSeparatedBinNibbles(
				List<List<Integer>> listOfSeparatedBinNibbles) {
			this.listOfSeparatedBinNibbles = listOfSeparatedBinNibbles;
			return this;
		}

		public Conversion build() {
			return new Conversion(this);
		}
	}
}