package edu.cs222.fpteachingcalculator.model.converter;

import org.junit.Test;

import edu.cs222.fpteachingcalculator.model.converter.BinSplitter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

public class BinSplitterTest {
	private final BinSplitter binParser = new BinSplitter();

	@Test
	public void testSeparateBinValueIntoDigits() {
		List<String> binList = createBinList();
		List<List<Integer>> correctOutput = createCorrectOutput();
		List<List<Integer>> testOutput = binParser.separateBinValuesIntoDigits(binList);
		for (int i = 0; i < correctOutput.size(); i++) {
			AssertArraysAreEqual(correctOutput.get(i), testOutput.get(i));
		}
	}

	private void AssertArraysAreEqual(List<Integer> list, List<Integer> list2) {
		for (int c = 0; c < 4; c++) {
			Assert.assertEquals(list.get(c), list2.get(c));
		}
	}

	private List<String> createBinList() {
		List<String> binList = new LinkedList<>();
		binList.add("1010");
		binList.add("1111");
		return binList;
	}

	private List<List<Integer>> createCorrectOutput() {
		List<List<Integer>> correctOutput = new LinkedList<>();
		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(0);
		a.add(1);
		a.add(0);
		List<Integer> b = new ArrayList<>();
		b.add(1);
		b.add(1);
		b.add(1);
		b.add(1);
		b.add(1);
		correctOutput.add(a);
		correctOutput.add(b);
		return correctOutput;
	}
}