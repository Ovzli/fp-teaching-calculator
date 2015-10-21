package edu.cs222.fp_teaching_calculator.model.converter;

import org.junit.Test;

import java.util.LinkedList;

import org.junit.Assert;

public class HexToBinConvertorTest {
	private HexToBinConvertor hexToBinConverter = new HexToBinConvertor();
	@Test
	public void testConvertHexToBinSuccess(){
		String validInput =  "C2a";
		Boolean completedConversion = hexToBinConverter.convertHexToBin(validInput);
		Assert.assertTrue(completedConversion);
	}
	
	@Test
	public void testConvertHexToBinFail(){
		String invalidInput =  "C2aq";
		Boolean completedConversion = hexToBinConverter.convertHexToBin(invalidInput);
		Assert.assertFalse(completedConversion);
	}
}
