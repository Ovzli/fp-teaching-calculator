package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BigValueExpansion extends GridPane {
	protected List<String> charList;
	protected List<Integer> binaryDigits;
	protected List<BigCharLabel> bigCharLabelList = new LinkedList<>();
	protected List<BigCharLabel> bigCharPlusList = new LinkedList<>();
	protected List<BigCharLabel> bigCharParenthesisList = new LinkedList<>();

	public BigValueExpansion() {
		super();
	}

	public BigValueExpansion(List<Integer> binDigits) {
		binaryDigits = binDigits;
		for (int i = 0; i <= 3; i++) {
			String value = String.valueOf(binaryDigits.get(i));
			bigCharLabelList.add(new BigCharLabel(value));
			this.add(bigCharLabelList.get(i), (i * 2) + 1, 0);
		}
	}

	public void expandBigValueCharExpansion(List<String> chars) {
		charList = chars;
		for (int i = 0; i < chars.size(); i++) {
			bigCharLabelList.add(new BigCharLabel(charList.get(i)));
			this.add(bigCharLabelList.get(i), (i * 2) + 1, 0);
		}
	}

	public void expandBigValueExpansionBits(List<ExpansionBit> paneList) {
		for (int i = 0; i < paneList.size(); i++) {
			this.add(paneList.get(i), (i * 2) + 1, 0);
		}
	}

	public void addParenthesis(int endSlot) {
		bigCharParenthesisList.add(new BigCharLabel("("));
		this.add(bigCharParenthesisList.get(0), 0, 0);
		bigCharParenthesisList.add(new BigCharLabel(")"));
		this.add(bigCharParenthesisList.get(1), endSlot, 0);
	}

	public void addPlusSigns(int numberOfSigns) {
		for (int i = 0; i < numberOfSigns; i++) {
			bigCharPlusList.add(new BigCharLabel("+"));
			this.add(bigCharPlusList.get(i), (i * 2) + 2, 0);
		}
	}

	public void addConcateSigns() {
		for (int i = 2; i <= 6; i += 2) {
			this.add(new BigCharLabel("⌒"), i, 0);
		}
	}

	public void multiplyByExpansion() {
		for (int i = 0; i <= 3; i++) {
			int m = (int) (8 / Math.pow(2, i));
			String value = String.valueOf(binaryDigits.get(i) * m);
			bigCharLabelList.get(i).setText(value);
		}
	}

	public void makeRedGreenValues() {
		for (int i = 0; i <= 3; i++) {
			if (binaryDigits.get(i) == 0) {
				bigCharLabelList.get(i).setCharColor(Color.RED);
			} else {
				bigCharLabelList.get(i).setCharColor(Color.GREEN);
			}
		}
	}

	public void makeHexColorValues(String hexColor) {
		for (int i = 0; i < bigCharLabelList.size(); i++) {
			bigCharLabelList.get(i).setCharColor(Color.web(hexColor));
		}
		makePlusColorValues(hexColor);
		bigCharParenthesisList.get(0).setCharColor(Color.web(hexColor));
		bigCharParenthesisList.get(1).setCharColor(Color.web(hexColor));
	}

	public void makePlusColorValues(String hexColor) {
		for (int i = 0; i < bigCharPlusList.size(); i++) {
			bigCharPlusList.get(i).setCharColor(Color.web(hexColor));
		}
	}

	public void changeHGap(int HgapSize) {
		this.setHgap(HgapSize);
	}

	public void makeSmallFonts() {
		for (int i = 0; i < bigCharLabelList.size(); i++) {
			bigCharLabelList.get(i).changeToSmallChar();
		}	
	}

}
