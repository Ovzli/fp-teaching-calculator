package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.layout.GridPane;

public class BinExpansion extends GridPane {
	private final BigValueExpansion bigValueSumList = new BigValueExpansion();
	private final BigValueExpansion binExpansionGrid = new BigValueExpansion();
	private final List<ExpansionBit> listOfExpansionBits = new LinkedList<>();
	
	public BinExpansion(int base, List<Integer> remainders){
		super();
		this.setVgap(5);
		this.getStyleClass().add("bigCharCell");
		for (int i = 0; i < remainders.size(); i++) {
			System.out.println("test");
			listOfExpansionBits.add(new ExpansionBit(base));
			binExpansionGrid.add(listOfExpansionBits.get(i), i * 2 + 1, 0);
			listOfExpansionBits.get(i).addPrefix(remainders.get(i) + "x");
		}
		this.add(binExpansionGrid, 0, 0);
	}
	
//	public void addPracticeContent(List<String> decValues) {
//		for (int i = 0; i < decValues.size(); i++) {
//			listOfExpansionBits.get(i).setExpansionBaseHexColor("FF6600");
//			AnswerInputField inputField = new AnswerInputField(35);
//			answerInputFieldList.add(inputField);
//			listOfExpansionBits.get(i).add(inputField, 3, 0);
//		}
//		changeToSmallFonts(decValues.size());
//	}

	public void addTutorialContent(List<String> decValues) {
		//this.add(bigValueSumList, 0, 0);
		for (int i = 0; i < decValues.size(); i++) {
			listOfExpansionBits.get(i).setExponentDigit(
					decValues.size() - i - 1);
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
