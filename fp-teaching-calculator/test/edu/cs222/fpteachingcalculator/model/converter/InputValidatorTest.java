package edu.cs222.fpteachingcalculator.model.converter;

import org.junit.Test;

import edu.cs222.fpteachingcalculator.model.converter.InputValidator;

import java.util.LinkedList;

import org.junit.Assert;

public class InputValidatorTest {
	private InputValidator inputValidator = new InputValidator();

	@Test
	public void testIsHexValueValidSuccess() {
		LinkedList<String> hexList = createLinkedListOfStrings("C", "2", "A");
		Assert.assertTrue(inputValidator.isHexValueValid(hexList));
	}

	@Test
	public void testIsHexValueValidSymbolFail() {
		LinkedList<String> hexList = createLinkedListOfStrings("C", "2", "G");
		Assert.assertFalse(inputValidator.isHexValueValid(hexList));
	}

	@Test
	public void testIsHexValueValidLengthFail() {
		LinkedList<String> hexList = createLinkedListOfStrings("C", "2", "A","C", "2", "A","C", "2", "A");
		Assert.assertFalse(inputValidator.isHexValueValid(hexList));
	}

	private LinkedList<String> createLinkedListOfStrings(String string1, String string2, String string3) {
		LinkedList<String> output = new LinkedList<String>();
		output.add(string1);
		output.add(string2);
		output.add(string3);
		return output;
	}

	private LinkedList<String> createLinkedListOfStrings(String string1, String string2, String string3, String string4,
			String string5, String string6, String string7, String string8, String string9) {
		LinkedList<String> output = new LinkedList<String>();
		output.add(string1);
		output.add(string2);
		output.add(string3);
		output.add(string4);
		output.add(string5);
		output.add(string6);
		output.add(string7);
		output.add(string8);
		output.add(string9);
		return output;
	}
}
