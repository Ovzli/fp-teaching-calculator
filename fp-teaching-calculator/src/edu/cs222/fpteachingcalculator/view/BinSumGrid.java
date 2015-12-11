package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.layout.GridPane;

public class BinSumGrid extends GridPane {
	private final List<BigValueExpansion> bigValueSumExpansionList = new LinkedList<>();

	public BinSumGrid(List<List<Integer>> binDigits, List<String> decValues) {
		super();
		this.setVgap(5);
		for (int i = 0; i < binDigits.size(); i++) {
			bigValueSumExpansionList.add(new BigValueExpansion(binDigits.get(i)));
			this.add(bigValueSumExpansionList.get(i), 0, i);
			bigValueSumExpansionList.get(i).addParenthesis(8);
			bigValueSumExpansionList.get(i).addPlusSigns(3);
			bigValueSumExpansionList.get(i).multiplyByExpansion();
			this.add(new BigCharLabel("="), 1, i);
			this.add(new BigCharLabel(decValues.get(i)), 2, i);
		}
	}
}
