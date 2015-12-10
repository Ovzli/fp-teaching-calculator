package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class HexExpansionGrid extends GridPane {
	private final BigValueExpansion bigValueHexSumList = new BigValueExpansion();
	private final BigValueExpansion hexExpansionGrid = new BigValueExpansion();
	private final List<ExpansionBit> listOfExpansionBits = new LinkedList<>();
	public final List<TextField> answerInputFieldList = new LinkedList<>();
	private List<String> hexChars = new LinkedList<>();

	public HexExpansionGrid(List<String> hexSymbols, List<String> decValues) {
		super();
		this.setVgap(5);
		this.getStyleClass().add("bigCharCell");
		hexChars.clear();
		hexChars = hexSymbols;
		bigValueHexSumList.expandBigValueCharExpansion(hexChars);
		bigValueHexSumList.addParenthesis(hexChars.size() * 2);
		bigValueHexSumList.addPlusSigns(hexChars.size() - 1);
		bigValueHexSumList.makeHexColorValues("#0066CC");
		for (int i = 0; i < decValues.size(); i++) {
			listOfExpansionBits.add(new ExpansionBit(16));
			hexExpansionGrid.add(listOfExpansionBits.get(i), i * 2 + 1, 0);
			listOfExpansionBits.get(i).addPrefix(decValues.get(i) + "x");
		}
		hexExpansionGrid.addPlusSigns(decValues.size() - 1);
		this.add(hexExpansionGrid, 0, 1);
	}

	private void changeToSmallFonts(int listSize) {
		for (int i = 0; i < listSize; i++) {
			listOfExpansionBits.get(i).makeSmallFonts();
		}
	}

	public void addPracticeContent(List<String> decValues) {
		for (int i = 0; i < decValues.size(); i++) {
			listOfExpansionBits.get(i).setExpansionBaseHexColor("FF6600");
			AnswerInputField inputField = new AnswerInputField(35);
			answerInputFieldList.add(inputField);
			listOfExpansionBits.get(i).add(inputField, 3, 0);
		}
		changeToSmallFonts(decValues.size());
	}

	public void addTutorialContent(List<String> decValues) {
		this.add(bigValueHexSumList, 0, 0);
		for (int i = 0; i < decValues.size(); i++) {
			listOfExpansionBits.get(i).setExponentDigit(
					decValues.size() - i - 1);
			listOfExpansionBits.get(i).setExpansionBitHexColor("FF6600");
		}
		if (listOfExpansionBits.size() > 5) {
			changeToSmallFonts(decValues.size());
		}
	}

}
