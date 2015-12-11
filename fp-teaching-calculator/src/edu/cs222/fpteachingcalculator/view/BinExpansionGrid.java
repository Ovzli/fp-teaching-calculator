package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.layout.GridPane;

public class BinExpansionGrid extends GridPane {
	private final List<BigValueExpansion> bigValueBinaryList = new LinkedList<>();
	private final List<BigValueExpansion> bigValueSumExpansionList = new LinkedList<>();

	public BinExpansionGrid(List<List<Integer>> binDigits) {
		super();
		this.setVgap(5);
		for (int i = 0; i < binDigits.size(); i++) {
			bigValueBinaryList.add(new BigValueExpansion(binDigits.get(i)));
			this.add(bigValueBinaryList.get(i), 0, i);
			this.add(new BigCharLabel("="), 1, i);
			bigValueSumExpansionList.add(new BigValueExpansion(binDigits.get(i)));
			this.add(bigValueSumExpansionList.get(i), 2, i);
			bigValueSumExpansionList.get(i).addParenthesis(8);
			bigValueSumExpansionList.get(i).addPlusSigns(3);
			bigValueSumExpansionList.get(i).multiplyByExpansion();
		}
	}
}
