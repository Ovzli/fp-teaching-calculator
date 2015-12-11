package edu.cs222.fpteachingcalculator.model.converter;

import java.util.LinkedList;
import java.util.List;

public class ValueConverter {
	private String userInputValue = "";
	private List<String> listOfUserInputChars = new LinkedList<>();
	private List<String> listOfRepresentativeHexChars = new LinkedList<>();
	private List<String> listOfRepresentativeDecChars = new LinkedList<>();
	private List<String> listOfRepresentationBinChars = new LinkedList<>();
	private List<String> listOfIndividualBinChars = new LinkedList<>();
	private List<List<Integer>> listOfSeparatedBinNibbles = new LinkedList<>();
	private String decValue = "";
	
	private final InputSplitter inputSplitter = new InputSplitter();
	private final ValueTranslator valueTranslator = new ValueTranslator();
	private final BinSplitter binSplitter = new BinSplitter();

	public ValueConverter(String input){
		userInputValue = input;
		listOfUserInputChars = inputSplitter.splitString(userInputValue);
	}
	
	public Conversion convert(String inputMode){
		if(inputMode.equals("HEX")){
			return convertHexValue();
		}
		else if(inputMode.equals("DEC")){
			return convertDecValue();
		}
		else if(inputMode.equals("BIN")){
			return convertBinValue();	
		}
		return null;
	}
	
	private Conversion convertHexValue(){
		listOfRepresentativeHexChars = inputSplitter.splitString(userInputValue);
		listOfRepresentativeDecChars = valueTranslator
				.translateHexListToDecList(listOfRepresentativeHexChars);
		decValue = valueTranslator.translateDecListToDecValue(listOfRepresentativeDecChars);
		listOfRepresentationBinChars = valueTranslator
				.translateDecListToBinList(listOfRepresentativeDecChars);
		listOfSeparatedBinNibbles = binSplitter
				.separateBinValuesIntoDigits(listOfRepresentationBinChars);
		return returnConversion();
	}
	
	private Conversion convertDecValue(){
		decValue = userInputValue;
		listOfRepresentativeDecChars = listOfUserInputChars;
		listOfRepresentationBinChars = inputSplitter.splitBinString(valueTranslator.translateDecValueToBinValue(userInputValue));
		listOfSeparatedBinNibbles = binSplitter.separateBinValuesIntoDigits(listOfRepresentationBinChars);
		listOfIndividualBinChars = inputSplitter.splitBinList(listOfRepresentationBinChars);
		listOfRepresentativeHexChars = inputSplitter.splitString(valueTranslator.translateDecValueToHexValue(userInputValue));
		return returnConversion();
	}
	
	private Conversion convertBinValue(){
		listOfRepresentationBinChars = inputSplitter.splitBinString(userInputValue);
		listOfSeparatedBinNibbles = binSplitter.separateBinValuesIntoDigits(listOfRepresentationBinChars);
		listOfRepresentativeDecChars = valueTranslator.translateBinListToDecList(listOfSeparatedBinNibbles);
		listOfIndividualBinChars = inputSplitter.splitBinList(listOfRepresentationBinChars);
		decValue = valueTranslator.translateDecListToDecValue(listOfRepresentativeDecChars);
		listOfRepresentativeHexChars = valueTranslator.translateDecListToHexList(listOfRepresentativeDecChars);
		return returnConversion();
	}
	
	private Conversion returnConversion(){
		return new Conversion.ConversionBuilder().originalInput(userInputValue)
				.listOfUserInputChars(listOfUserInputChars)
				.listOfRepresentativeHexChars(listOfRepresentativeHexChars)
				.listOfRepresentativeDecChars(listOfRepresentativeDecChars)
				.listOfRepresentationBinChars(listOfRepresentationBinChars)
				.listOfIndividualBinChars(listOfIndividualBinChars)
				.listOfSeparatedBinNibbles(listOfSeparatedBinNibbles)
				.decValue(decValue)
				.build();
	}

}
