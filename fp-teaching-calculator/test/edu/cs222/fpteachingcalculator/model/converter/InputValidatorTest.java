package edu.cs222.fpteachingcalculator.model.converter;

import org.junit.Test;

import edu.cs222.fpteachingcalculator.model.converter.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Assert;

public class InputValidatorTest {
	private InputValidator inputValidator = new InputValidator();

	@Test
	public void testIsHexValueValidSuccess() {
		LinkedList<String> hexList = createLinkedListOfStrings("C 2 A");
		Assert.assertTrue(inputValidator.isHexValueValid(hexList));
	}

	@Test
	public void testIsHexValueValidSymbolFail() {
		LinkedList<String> hexList = createLinkedListOfStrings("C 2 G");
		Assert.assertFalse(inputValidator.isHexValueValid(hexList));
	}

	@Test
	public void testIsHexValueValidLengthFail() {
		LinkedList<String> hexList = createLinkedListOfStrings("C 2 A C 2 A C 2 A");
		Assert.assertFalse(inputValidator.isHexValueValid(hexList));
	}
	
	private LinkedList<String> createLinkedListOfStrings(String input){
		LinkedList<String> output = new LinkedList<String>();
		output.addAll(new ArrayList<String>(Arrays.asList(input.split(" "))));
		return output;
	}
}
