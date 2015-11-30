package edu.cs222.fpteachingcalculator.view;

import java.util.List;

import javafx.scene.layout.GridPane;

public class ExpansionGrid extends GridPane {

	public ExpansionGrid(List<String> charList, List<int[]> binDigits) {
		super();
		this.setVgap(5);
		this.getStyleClass().add("bigCharCell");
		for (int i = 0; i < charList.size(); i++) {
			BigCharBox bigCharBox = new BigCharBox();
			this.add(bigCharBox, 0, i);
			BigCharLabel bigCharLabel = new BigCharLabel(charList.get(i));
			this.add(bigCharLabel, 0, i);
			BigCharLabel bigEqual1 = new BigCharLabel("=");
			this.add(bigEqual1, 1, i);
			BigCharLabel bigPlus1 = new BigCharLabel("+");
			this.add(bigPlus1, 3, i);
			BigCharLabel bigPlus2 = new BigCharLabel("+");
			this.add(bigPlus2, 5, i);
			BigCharLabel bigPlus3 = new BigCharLabel("+");
			this.add(bigPlus3, 7, i);
			BigCharLabel bigEqual2 = new BigCharLabel("=");
			this.add(bigEqual2, 9, i);
			BigCharLabel bigParenthesis1 = new BigCharLabel("(");
			this.add(bigParenthesis1, 10, i);
			BigCharLabel bigPlus4 = new BigCharLabel("+");
			this.add(bigPlus4, 12, i);
			BigCharLabel bigPlus5 = new BigCharLabel("+");
			this.add(bigPlus5, 14, i);
			BigCharLabel bigPlus6 = new BigCharLabel("+");
			this.add(bigPlus6, 16, i);
			BigCharLabel bigParenthesis2 = new BigCharLabel(")");
			this.add(bigParenthesis2, 18, i);
			BigCharLabel bigValue1 = new BigCharLabel(String.valueOf(binDigits
					.get(i)[0] * 8));
			BigCharLabel bigValue2 = new BigCharLabel(String.valueOf(binDigits
					.get(i)[1] * 4));
			BigCharLabel bigValue3 = new BigCharLabel(String.valueOf(binDigits
					.get(i)[2] * 2));
			BigCharLabel bigValue4 = new BigCharLabel(String.valueOf(binDigits
					.get(i)[3]));
			this.add(bigValue1, 11, i);
			this.add(bigValue2, 13, i);
			this.add(bigValue3, 15, i);
			this.add(bigValue4, 17, i);
			ExpansionBit expansionBit1 = new ExpansionBit();
			ExpansionBit expansionBit2 = new ExpansionBit();
			ExpansionBit expansionBit3 = new ExpansionBit();
			ExpansionBit expansionBit4 = new ExpansionBit();
			this.add(expansionBit1, 2, i);
			this.add(expansionBit2, 4, i);
			this.add(expansionBit3, 6, i);
			this.add(expansionBit4, 8, i);
			expansionBit1.setExponentDigit(3);
			expansionBit2.setExponentDigit(2);
			expansionBit3.setExponentDigit(1);
			expansionBit4.setExponentDigit(0);
			expansionBit1.setBinaryDigit(binDigits.get(i)[0]);
			expansionBit2.setBinaryDigit(binDigits.get(i)[1]);
			expansionBit3.setBinaryDigit(binDigits.get(i)[2]);
			expansionBit4.setBinaryDigit(binDigits.get(i)[3]);
		}
	}

}
