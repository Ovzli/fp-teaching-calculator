package edu.cs222.fpteachingcalculator.model.converter;

import java.util.LinkedList;
import java.util.List;

public class ValueConverter {
	protected List<String> parsedListOfUserInput = new LinkedList<>();
	protected List<String> listOfHexadecimalEquivalents = new LinkedList<>();
	protected List<String> listOfDecimalEquivalents = new LinkedList<>();
	protected List<String> listOfBinaryEquivalents = new LinkedList<>();
	protected List<List<Integer>> listOfSeparatedBinaryNibbles = new LinkedList<>();

	protected final InputSplitter inputSplitter = new InputSplitter();
	protected final ValueTranslator valueTranslator = new ValueTranslator();
	protected final BinSplitter binaryParser = new BinSplitter();

}
