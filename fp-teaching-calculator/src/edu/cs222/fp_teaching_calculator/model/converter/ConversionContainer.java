package edu.cs222.fp_teaching_calculator.model.converter;

import java.util.LinkedList;

public class ConversionContainer {
	public final boolean errorOccurred;
	public final int errorCode;
	public final String originalInput;
	public final LinkedList<String> parsedListOfHexInput;
	public final LinkedList<String> listOfDecEquivalents;
	public final LinkedList<String> listOfBinEquivalents;
	public final LinkedList<int[]> listOfSeparatedBinNibbles;

	public ConversionContainer(int errorCode) {
		this.errorOccurred = true;
		this.errorCode = errorCode;
		this.originalInput = null;
		this.parsedListOfHexInput = null;
		this.listOfBinEquivalents = null;
		this.listOfDecEquivalents = null;
		this.listOfSeparatedBinNibbles = null;
	}

	public ConversionContainer(ContainerBuilder builder) {
		this.errorOccurred = false;
		this.errorCode = 0;
		this.originalInput = builder.originalInput;
		this.parsedListOfHexInput = builder.parsedListOfHexInput;
		this.listOfBinEquivalents = builder.listOfBinEquivalents;
		this.listOfDecEquivalents = builder.listOfDecEquivalents;
		this.listOfSeparatedBinNibbles = builder.listOfSeparatedBinNibbles;
	}

	public static class ContainerBuilder {

		public String originalInput;
		public LinkedList<String> parsedListOfHexInput;
		public LinkedList<String> listOfDecEquivalents;
		public LinkedList<String> listOfBinEquivalents;
		public LinkedList<int[]> listOfSeparatedBinNibbles;

		public ContainerBuilder originalInput(String input) {
			this.originalInput = input;
			return this;
		}

		public ContainerBuilder parsedListOfHexInput(LinkedList<String> listOfHexInput) {
			this.parsedListOfHexInput = listOfHexInput;
			return this;
		}

		public ContainerBuilder listOfDecEquivalents(LinkedList<String> listOfDecEquivalents) {
			this.listOfDecEquivalents = listOfDecEquivalents;
			return this;
		}

		public ContainerBuilder listOfBinEquivalents(LinkedList<String> listOfBinEquivalents) {
			this.listOfBinEquivalents = listOfBinEquivalents;
			return this;
		}

		public ContainerBuilder listOfSeparatedBinNibbles(LinkedList<int[]> listOfNibbles) {
			this.listOfSeparatedBinNibbles = listOfNibbles;
			return this;
		}

		public ConversionContainer build() {
			return new ConversionContainer(this);
		}
	}
}
