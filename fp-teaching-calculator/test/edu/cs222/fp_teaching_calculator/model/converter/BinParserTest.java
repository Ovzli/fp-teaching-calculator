package edu.cs222.fp_teaching_calculator.model.converter;

import org.junit.Test;

import java.util.LinkedList;

import org.junit.Assert;

public class BinParserTest {
	private BinParser binParser = new BinParser();

	@Test
	public void testSeparateBinValueIntoDigits() {
		LinkedList<String> binList = createBinList();
		LinkedList<int[]> correctOutput = createCorrectOutput();
		LinkedList<int[]> testOutput = binParser.separateBinValuesIntoDigits(binList);
		for (int i = 0; i < correctOutput.size(); i++) {
			AssertArraysAreEqual(correctOutput.get(i), testOutput.get(i));
		}
	}
	
	private void AssertArraysAreEqual(int[] correctOutput, int[] testOutput){
		for (int c = 0; c < 4; c++) {
			Assert.assertEquals(correctOutput[c], testOutput[c]);
		}
	}
	
	private LinkedList<String> createBinList(){
		LinkedList<String> binList = new LinkedList<String>();
		binList.add("1010");
		binList.add("1111");
		return binList;
	}
	
	private LinkedList<int[]> createCorrectOutput(){
		LinkedList<int[]> correctOutput = new LinkedList<int[]>();
		int[] a = { 1, 0, 1, 0 };
		int[] b = { 1, 1, 1, 1 };
		correctOutput.add(a);
		correctOutput.add(b);
		return correctOutput;
	}
}
