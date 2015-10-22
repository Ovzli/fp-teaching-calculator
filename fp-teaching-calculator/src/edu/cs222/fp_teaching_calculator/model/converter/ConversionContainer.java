package edu.cs222.fp_teaching_calculator.model.converter;

import java.util.LinkedList;

public class ConversionContainer {
	public final boolean errorOccurred;
	public final int errorCode;
	public final String originalInput;
	public final LinkedList<String> parsedListOfHexInput; 
	public final LinkedList<String> listOfDecimalEquivalents; 
	public final LinkedList<String> listOfBinaryEquivalents;
	public final LinkedList<int[]>  listOfSeparatedBinaryNibbles;

	public ConversionContainer(int errorCode){
		this.errorOccurred = true;
		this.errorCode = errorCode;
		this.originalInput = null;
		this.parsedListOfHexInput = null;
		this.listOfBinaryEquivalents = null;
		this.listOfDecimalEquivalents = null;
		this.listOfSeparatedBinaryNibbles = null;
	}
	
	public ConversionContainer(ContainerBuilder builder){
		this.errorOccurred = false;
		this.errorCode = 0;
		this.originalInput = builder.originalInput;
		this.parsedListOfHexInput = builder.parsedListOfHexInput;
		this.listOfBinaryEquivalents = builder.listOfBinaryEquivalents;
		this.listOfDecimalEquivalents = builder.listOfDecimalEquivalents;
		this.listOfSeparatedBinaryNibbles = builder.listOfSeparatedBinaryNibbles;
	}
	
	public static class ContainerBuilder{
		
		public String originalInput;
		public LinkedList<String> parsedListOfHexInput; 
		public LinkedList<String> listOfDecimalEquivalents; 
		public LinkedList<String> listOfBinaryEquivalents;
		public LinkedList<int[]>  listOfSeparatedBinaryNibbles;
		
		public ContainerBuilder originalInput(String input){
			this.originalInput = input;
			return this;
		}
		
		public ContainerBuilder parsedListOfHexInput(LinkedList<String> listOfHexInput){
			this.parsedListOfHexInput = listOfHexInput;
			return this;
		}
		
		public ContainerBuilder listOfDecimalEquivalents(LinkedList<String> listOfDecEquivalents){
			this.listOfDecimalEquivalents = listOfDecEquivalents;
			return this;
		}
		
		public ContainerBuilder listOfBinaryEquivalents(LinkedList<String> listOfBinEquivalents){
			this.listOfBinaryEquivalents = listOfBinEquivalents;
			return this;
		}
		
		public ContainerBuilder listOfSeparatedBinaryNibbles(LinkedList<int[]> listOfNibbles){
			this.listOfSeparatedBinaryNibbles = listOfNibbles;
			return this;
		}
		
		public ConversionContainer build(){
			return new ConversionContainer(this);
		}
		
		
	}
}
