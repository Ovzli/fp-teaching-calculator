package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ConcatenationGrid extends GridPane {
	private final List<String> charList;
	public final List<TextField> answerInputFieldList = new LinkedList<>();
	private final List<BigValueExpansion> bigValueExpansionList = new LinkedList<>();
	private final List<BigValueExpansion> bigValueConcateList = new LinkedList<>();

	public ConcatenationGrid(List<String> charListReceived) {
		super();
		this.setVgap(5);
		this.getStyleClass().add("bigCharCell");
		charList = charListReceived;
		for (int i = 0; i < charList.size(); i++) {
			this.add(new BigCharBox(), 0, i);
			this.add(new BigCharLabel(charList.get(i)), 0, i);
			this.add(new BigCharLabel("="), 1, i);
		}
	}

	public void addTutorialContent(List<List<Integer>> binDigits) {
		for (int i = 0; i < charList.size(); i++) {
			bigValueConcateList.add(new BigValueExpansion(binDigits.get(i)));
			this.add(bigValueConcateList.get(i), 2, i);
			bigValueConcateList.get(i).addConcateSigns();
			bigValueConcateList.get(i).makeRedGreenValues();
			this.add(new BigCharLabel("="), 9, i);
			bigValueExpansionList.add(new BigValueExpansion(binDigits.get(i)));
			this.add(bigValueExpansionList.get(i), 10, i);
		}
	}
	
	public void addPracticeContent(List<List<Integer>> binDigits) {
		for (int i = 0; i < charList.size(); i++) {
			AnswerInputField inputField = new AnswerInputField(60);
			answerInputFieldList.add(inputField);
			this.add(inputField, 2, i);
			this.add(new BigCharLabel("="), 3, i);
			bigValueExpansionList.add(new BigValueExpansion(binDigits.get(i)));
			this.add(bigValueExpansionList.get(i), 4, i);
			bigValueExpansionList.get(i).addParenthesis();
			bigValueExpansionList.get(i).addPlusSigns();
			bigValueExpansionList.get(i).multiplyByExpansion();
		}
	}
	
	//public void addPractiveContentForDecEquivalents

}
