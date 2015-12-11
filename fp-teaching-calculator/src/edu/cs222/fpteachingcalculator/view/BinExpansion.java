package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.layout.GridPane;

public class BinExpansion extends GridPane {
	private final BigValueExpansion binExpansionGrid = new BigValueExpansion();
	private final List<ExpansionBit> listOfExpansionBits = new LinkedList<>();

	public BinExpansion(int base, List<Integer> remainders) {
		super();
		this.setVgap(5);
		this.getStyleClass().add("bigCharCell");
		for (int i = 0; i < remainders.size(); i++) {
			listOfExpansionBits.add(new ExpansionBit(base));
			binExpansionGrid.add(listOfExpansionBits.get(i), i * 2 + 1, 0);
			listOfExpansionBits.get(i).addPrefix(remainders.get(i) + "x");
		}
		this.add(binExpansionGrid, 0, 0);
	}

	public void addTutorialContent(List<String> decValues) {
		for (int i = 0; i < decValues.size(); i++) {
			listOfExpansionBits.get(i).setExponentDigit(decValues.size() - i - 1);
			listOfExpansionBits.get(i).setExpansionBitHexColor("FF6600");
		}
		if (listOfExpansionBits.size() > 5) {
			changeToSmallFonts(decValues.size());
		}
	}

	private void changeToSmallFonts(int listSize) {
		for (int i = 0; i < listSize; i++) {
			listOfExpansionBits.get(i).makeSmallFonts();
		}
	}
}
