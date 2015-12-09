package edu.cs222.fpteachingcalculator.model.converter;

import java.util.LinkedList;
import java.util.List;

public class ValueConverter {
	protected List<String> parsedListOfUserInput = new LinkedList<>();
	protected List<String> listOfRepresentativeHexChars = new LinkedList<>();
	protected List<String> listOfRepresentativeDecChars = new LinkedList<>();
	protected List<String> listOfRepresentationBinChars = new LinkedList<>();
	protected List<List<Integer>> listOfSeparatedBinNibbles = new LinkedList<>();
	protected String decValue = "";
	
	protected final InputSplitter inputSplitter = new InputSplitter();
	protected final ValueTranslator valueTranslator = new ValueTranslator();
	protected final BinSplitter binSplitter = new BinSplitter();

	public Conversion convertHexValue(String hexInputValue){
		listOfRepresentativeHexChars = inputSplitter.splitString(hexInputValue);
		listOfRepresentativeDecChars = valueTranslator
				.translateHexListToDecList(listOfRepresentativeHexChars);
		decValue = valueTranslator.translateDecListToDecValue(listOfRepresentativeDecChars);
		listOfRepresentationBinChars = valueTranslator
				.translateDecListToBinList(listOfRepresentativeDecChars);
		listOfSeparatedBinNibbles = binSplitter
				.separateBinValuesIntoDigits(listOfRepresentationBinChars);
		return new Conversion.ConversionBuilder().originalInput(hexInputValue)				
				.listOfRepresentativeHexChars(listOfRepresentativeHexChars)
				.listOfRepresentativeDecChars(listOfRepresentativeDecChars)
				.listOfRepresentationBinChars(listOfRepresentationBinChars)
				.listOfSeparatedBinNibbles(listOfSeparatedBinNibbles)
				.decValue(decValue)
				.build();
	}
	
	public Conversion convertDecValue(String decInputValue){
		listOfRepresentationBinChars = inputSplitter.splitBinString(valueTranslator.translateDecValueToBinValue(decInputValue));
		listOfSeparatedBinNibbles = binSplitter.separateBinValuesIntoDigits(listOfRepresentationBinChars);
		listOfRepresentativeHexChars = inputSplitter.splitString(valueTranslator.translateDecValueToHexValue(decInputValue));
		return new Conversion.ConversionBuilder().originalInput(decInputValue)
				.listOfRepresentativeHexChars(listOfRepresentativeHexChars)
				.listOfRepresentationBinChars(listOfRepresentationBinChars)
				.listOfSeparatedBinNibbles(listOfSeparatedBinNibbles) //possibly needed decValuelist
				.build();
	}
	
	public Conversion convertBinValue(String binInputValue){
		listOfRepresentationBinChars = inputSplitter.splitBinString(binInputValue);
		listOfSeparatedBinNibbles = binSplitter.separateBinValuesIntoDigits(listOfRepresentationBinChars);
		listOfRepresentativeDecChars = valueTranslator.translateBinListToDecList(listOfSeparatedBinNibbles);
		decValue = valueTranslator.translateDecListToDecValue(listOfRepresentativeDecChars);
		listOfRepresentativeHexChars = valueTranslator.translateDecListToHexList(listOfRepresentativeDecChars);
		return new Conversion.ConversionBuilder().originalInput(binInputValue)
				.listOfRepresentativeHexChars(listOfRepresentativeHexChars)
				.listOfRepresentativeDecChars(listOfRepresentativeDecChars)
				.listOfRepresentationBinChars(listOfRepresentationBinChars)
				.listOfSeparatedBinNibbles(listOfSeparatedBinNibbles)
				.decValue(decValue)
				.build();
	}

}
