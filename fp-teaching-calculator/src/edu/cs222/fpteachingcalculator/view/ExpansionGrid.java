package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.layout.GridPane;

public class ExpansionGrid extends GridPane {
	private final List<BigValueExpansion> bigValueExpansionList = new LinkedList<>();
	private final List<BigValueExpansion> bigValueDecExpansionList = new LinkedList<>();

	public ExpansionGrid(List<String> charList, List<List<Integer>> binDigits) {
		super();
		this.setVgap(5);
		this.getStyleClass().add("bigCharCell");
		for (int i = 0; i < charList.size(); i++) {
			this.add(new BigCharBox(), 0, i);
			this.add(new BigCharLabel(charList.get(i)), 0, i);
			this.add(new BigCharLabel("="), 1, i);
			bigValueDecExpansionList.add(new BigValueDecExpansion(binDigits
					.get(i)));
			this.add(bigValueDecExpansionList.get(i), 2, i);
			bigValueDecExpansionList.get(i).addPlusSigns(3);
			this.add(new BigCharLabel("="), 9, i);
			bigValueExpansionList.add(new BigValueExpansion(binDigits.get(i)));
			this.add(bigValueExpansionList.get(i), 10, i);
			bigValueExpansionList.get(i).addParenthesis(8);
			bigValueExpansionList.get(i).addPlusSigns(3);
			bigValueExpansionList.get(i).multiplyByExpansion();
		}
	}

}
