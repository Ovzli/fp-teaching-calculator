package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.layout.GridPane;

public class HexExpansionGrid extends GridPane {
	private final BigValueExpansion bigValueHexSumList = new BigValueExpansion();
	private final BigValueExpansion hexExpansionGrid = new BigValueExpansion();
	private final List<ExpansionBit> listOfExpansionBits = new LinkedList<>();

	public HexExpansionGrid(List<String> hexSymbols, List<String> decValues) {
		super();
		this.setVgap(5);
		this.getStyleClass().add("bigCharCell");
		bigValueHexSumList.expandBigValueCharExpansion(hexSymbols);
		bigValueHexSumList.addParenthesis(hexSymbols.size() * 2);
		bigValueHexSumList.addPlusSigns(hexSymbols.size() - 1);
		bigValueHexSumList.makeHexColorValues("#0066CC");
		this.add(bigValueHexSumList, 0, 0);
		for (int i = 0; i < decValues.size(); i++) {
			listOfExpansionBits.add(new ExpansionBit(16));
			listOfExpansionBits.get(i).setExponentDigit(
					decValues.size() - i - 1);
			listOfExpansionBits.get(i).setExpansionBitHexColor("FF6600");
			listOfExpansionBits.get(i).addPrefix(decValues.get(i) + "x");
			hexExpansionGrid.add(listOfExpansionBits.get(i), i * 2 + 1, 0);
		}
		hexExpansionGrid.addPlusSigns(decValues.size() - 1);
		this.add(hexExpansionGrid, 0, 1);

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
