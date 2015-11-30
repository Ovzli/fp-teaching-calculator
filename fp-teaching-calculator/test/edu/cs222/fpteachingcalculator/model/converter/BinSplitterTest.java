package edu.cs222.fpteachingcalculator.model.converter;

import org.junit.Test;

import edu.cs222.fpteachingcalculator.model.converter.BinSplitter;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

public class BinSplitterTest {
	private final BinSplitter binParser = new BinSplitter();

	@Test
	public void testSeparateBinValueIntoDigits() {
		List<String> binList = createBinList();
		List<int[]> correctOutput = createCorrectOutput();
		List<int[]> testOutput = binParser.separateBinValuesIntoDigits(binList);
		for (int i = 0; i < correctOutput.size(); i++) {
			AssertArraysAreEqual(correctOutput.get(i), testOutput.get(i));
		}
	}

	private void AssertArraysAreEqual(int[] correctOutput, int[] testOutput) {
		for (int c = 0; c < 4; c++) {
			Assert.assertEquals(correctOutput[c], testOutput[c]);
		}
	}

	private List<String> createBinList() {
		List<String> binList = new LinkedList<>();
		binList.add("1010");
		binList.add("1111");
		return binList;
	}

	private List<int[]> createCorrectOutput() {
		List<int[]> correctOutput = new LinkedList<>();
		int[] a = { 1, 0, 1, 0 };
		int[] b = { 1, 1, 1, 1 };
		correctOutput.add(a);
		correctOutput.add(b);
		return correctOutput;
	}
}