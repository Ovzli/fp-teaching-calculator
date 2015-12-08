package edu.cs222.fpteachingcalculator.model.converter;

import java.util.List;

public class Conversion {
	private final String originalInput;
	private final List<String> parsedListOfUserInput;
	private final List<String> listOfHexEquivalents;
	private final List<String> listOfDecEquivalents;
	private final List<String> listOfBinEquivalents;
	private final List<List<Integer>> listOfSeparatedBinNibbles;

	public Conversion(ConversionBuilder builder) {
		this.originalInput = builder.originalInput;
		this.parsedListOfUserInput = builder.parsedListOfUserInput;
		this.listOfBinEquivalents = builder.listOfBinEquivalents;
		this.listOfDecEquivalents = builder.listOfDecEquivalents;
		this.listOfHexEquivalents = builder.listOfHexEquivalents;
		this.listOfSeparatedBinNibbles = builder.listOfSeparatedBinNibbles;
	}

	public String getOriginalInput() {
		return originalInput;
	}

	public List<String> getParsedListOfUserInput() {
		return parsedListOfUserInput;
	}

	public List<String> getListOfHexEquivalents() {
		return listOfHexEquivalents;
	}

	public List<String> getListOfDecEquivalents() {
		return listOfDecEquivalents;
	}

	public List<String> getListOfBinEquivalents() {
		return listOfBinEquivalents;
	}

	public List<List<Integer>> getListOfSeparatedBinNibbles() {
		return listOfSeparatedBinNibbles;
	}

	public static class ConversionBuilder {
		public String originalInput;
		public List<String> parsedListOfUserInput;
		public List<String> listOfHexEquivalents;
		public List<String> listOfDecEquivalents;
		public List<String> listOfBinEquivalents;
		public List<List<Integer>> listOfSeparatedBinNibbles;

		public ConversionBuilder originalInput(String input) {
			this.originalInput = input;
			return this;
		}

		public ConversionBuilder parsedListOfUserInput(
				List<String> listOfUserInput) {
			this.parsedListOfUserInput = listOfUserInput;
			return this;
		}

		public ConversionBuilder listOfHexEquivalents(
				List<String> listOfHexadecimalEquivalents) {
			this.listOfHexEquivalents = listOfHexadecimalEquivalents;
			return this;
		}

		public ConversionBuilder listOfDecEquivalents(
				List<String> listOfDecimalEquivalents) {
			this.listOfDecEquivalents = listOfDecimalEquivalents;
			return this;
		}

		public ConversionBuilder listOfBinEquivalents(
				List<String> listOfBinaryEquivalents) {
			this.listOfBinEquivalents = listOfBinaryEquivalents;
			return this;
		}

		public ConversionBuilder listOfSeparatedBinNibbles(
				List<List<Integer>> listOfSeparatedBinaryNibbles) {
			this.listOfSeparatedBinNibbles = listOfSeparatedBinaryNibbles;
			return this;
		}

		public Conversion build() {
			return new Conversion(this);
		}
	}
}