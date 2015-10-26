package edu.cs222.fp_teaching_calculator.model.converter;

import org.junit.Test;

import java.util.LinkedList;

import org.junit.Assert;

public class InputValidatorTest {
	private InputValidator inputValidator = new InputValidator();

	@Test
	public void testIsHexValueValidSuccess() {
		LinkedList<String> hexList = new LinkedList<String>();
		hexList.add("C");
		hexList.add("2");
		hexList.add("A");
		Assert.assertTrue(inputValidator.isHexValueValid(hexList));
	}

	@Test
	public void testIsHexValueValidSymbolFail() {
		LinkedList<String> hexList = new LinkedList<String>();
		hexList.add("C");
		hexList.add("2");
		hexList.add("G");
		Assert.assertFalse(inputValidator.isHexValueValid(hexList));
	}

	@Test
	public void testIsHexValueValidLengthFail() {
		LinkedList<String> hexList = new LinkedList<String>();
		hexList.add("C");
		hexList.add("2");
		hexList.add("A");
		hexList.add("C");
		hexList.add("2");
		hexList.add("A");
		hexList.add("C");
		hexList.add("2");
		hexList.add("A");
		Assert.assertFalse(inputValidator.isHexValueValid(hexList));
	}
}
