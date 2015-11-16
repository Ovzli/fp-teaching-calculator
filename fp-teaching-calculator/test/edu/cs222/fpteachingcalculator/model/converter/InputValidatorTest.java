package edu.cs222.fpteachingcalculator.model.converter;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.cs222.fpteachingcalculator.model.converter.InputValidator;
import edu.cs222.fpteachingcalculator.model.converter.inputexceptions.EmptyInputException;
import edu.cs222.fpteachingcalculator.model.converter.inputexceptions.InvalidHexNumberLengthException;
import edu.cs222.fpteachingcalculator.model.converter.inputexceptions.InvalidHexSymbolException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Rule;

public class InputValidatorTest {
	private InputValidator inputValidator = new InputValidator();

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test(expected = EmptyInputException.class)
	public void testCheckIfInputIsEmpty() throws EmptyInputException {
		inputValidator.checkIfInputIsEmpty("");
	}

	@Test
	public void testCheckIfHexValueIsValidSymbolFail()
			throws InvalidHexSymbolException, InvalidHexNumberLengthException {
		thrown.expect(InvalidHexSymbolException.class);
		LinkedList<String> hexList = createLinkedListOfStrings("C 2 G");
		inputValidator.checkIfHexValueIsValid(hexList);
	}

	@Test
	public void testCheckIfHexValueIsValidLengthFail()
			throws InvalidHexSymbolException, InvalidHexNumberLengthException {
		thrown.expect(InvalidHexNumberLengthException.class);
		LinkedList<String> hexList = createLinkedListOfStrings("C 2 A C 2 A C 2 A");
		inputValidator.checkIfHexValueIsValid(hexList);
	}

	private LinkedList<String> createLinkedListOfStrings(String input) {
		LinkedList<String> output = new LinkedList<String>();
		output.addAll(new ArrayList<String>(Arrays.asList(input.split(" "))));
		return output;
	}
}