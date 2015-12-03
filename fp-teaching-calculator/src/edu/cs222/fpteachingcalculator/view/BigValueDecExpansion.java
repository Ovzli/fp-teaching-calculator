package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.layout.GridPane;

public class BigValueDecExpansion extends BigValueExpansion {
	private List<GridPane> expansionGridList = new LinkedList<>();

	public BigValueDecExpansion(int[] binDigits) {
		super();
		binaryDigits = binDigits;
		for (int i = 0; i <= 3; i++) {
			expansionGridList.add(new ExpansionBit(binaryDigits[i], (3 - i)));
			this.add(new ExpansionBit(binaryDigits[i], (3 - i)), (i * 2) + 1, 0);
		}
	}

}
