package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;

import javafx.scene.layout.GridPane;

public class ConcatenationGrid extends GridPane {

	public ConcatenationGrid(LinkedList<String> charList,
			LinkedList<int[]> binDigits) {
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
			BigCharLabel bigArch1 = new BigCharLabel("⌒");
			this.add(bigArch1, 3, i);
			BigCharLabel bigArch2 = new BigCharLabel("⌒");
			this.add(bigArch2, 5, i);
			BigCharLabel bigArch3 = new BigCharLabel("⌒");
			this.add(bigArch3, 7, i);
			BigCharLabel bigEqual2 = new BigCharLabel("=");
			this.add(bigEqual2, 9, i);
			BigCharLabel bigValue1 = new BigCharLabel(String.valueOf(binDigits
					.get(i)[0]));
			BigCharLabel bigValue2 = new BigCharLabel(String.valueOf(binDigits
					.get(i)[1]));
			BigCharLabel bigValue3 = new BigCharLabel(String.valueOf(binDigits
					.get(i)[2]));
			BigCharLabel bigValue4 = new BigCharLabel(String.valueOf(binDigits
					.get(i)[3]));
			this.add(bigValue1, 11, i);
			this.add(bigValue2, 13, i);
			this.add(bigValue3, 15, i);
			this.add(bigValue4, 17, i);
			ConcatenationBit concatenationBit1 = new ConcatenationBit(
					binDigits.get(i)[0]);
			ConcatenationBit concatenationBit2 = new ConcatenationBit(
					binDigits.get(i)[1]);
			ConcatenationBit concatenationBit3 = new ConcatenationBit(
					binDigits.get(i)[2]);
			ConcatenationBit concatenationBit4 = new ConcatenationBit(
					binDigits.get(i)[3]);
			this.add(concatenationBit1, 2, i);
			this.add(concatenationBit2, 4, i);
			this.add(concatenationBit3, 6, i);
			this.add(concatenationBit4, 8, i);
		}

	}
}
