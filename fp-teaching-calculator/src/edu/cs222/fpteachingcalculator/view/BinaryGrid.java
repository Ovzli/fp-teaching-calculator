package edu.cs222.fpteachingcalculator.view;

import java.util.List;

import javafx.scene.layout.GridPane;

public class BinaryGrid extends GridPane {

	public BinaryGrid(List<List<Integer>> binDigits) {
		super();
		this.getStyleClass().add("bigCharCell");
		for (int i = 0; i < binDigits.size(); i++) {
			String binDigit = String.valueOf(binDigits.get(i).get(0))
					+ String.valueOf(binDigits.get(i).get(1))
					+ String.valueOf(binDigits.get(i).get(2))
					+ String.valueOf(binDigits.get(i).get(3));
			BigCharLabel binString = new BigCharLabel(binDigit);
			this.add(binString, i, 0);
		}
	}

}
