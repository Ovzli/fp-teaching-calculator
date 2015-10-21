package edu.cs222.fp_teaching_calculator.model.converter;

import org.junit.Test;

import java.util.LinkedList;

import org.junit.Assert;

public class BinaryParserTest {
	private BinaryParser binaryParser = new BinaryParser();
	
	@Test
	public void testSeparateBinValueIntoDigits(){
		LinkedList<String> binList = new LinkedList<String>();
		binList.add("1010");
		binList.add("1111");
		LinkedList<int[]> correctOutput = new LinkedList<int[]>();
		int[] a = {1,0,1,0};
		int[] b = {1,1,1,1};
		correctOutput.add(a);
		correctOutput.add(b);
		LinkedList<int[]> testOutput = binaryParser.separateBinValuesIntoDigits(binList);
		for(int i = 0; i < correctOutput.size(); i++){
			for(int c = 0; c < 4; c++){
			Assert.assertEquals(correctOutput.get(i)[c], testOutput.get(i)[c]);
			}
		}		
	}
}
