package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BigValueExpansion extends GridPane {
	protected int[] binaryDigits;
	protected List<BigCharLabel> bigCharLabelList = new LinkedList<>();

	public BigValueExpansion() {
		super();
	}

	public BigValueExpansion(int[] binDigits) {
		binaryDigits = binDigits;
		for (int i = 0; i <= 3; i++) {
			String value = String.valueOf(binaryDigits[i]);
			bigCharLabelList.add(new BigCharLabel(value));
			this.add(bigCharLabelList.get(i), (i * 2) + 1, 0);
		}
	}

	public void addParenthesis() {
		BigCharLabel bigParenthesis1 = new BigCharLabel("(");
		this.add(bigParenthesis1, 0, 0);
		BigCharLabel bigParenthesis2 = new BigCharLabel(")");
		this.add(bigParenthesis2, 8, 0);
	}

	public void addPlusSigns() {
		for (int i = 2; i <= 6; i += 2) {
			this.add(new BigCharLabel("+"), i, 0);
		}
	}

	public void multiplyByExpansion() {
		for (int i = 0; i <= 3; i++) {
			int m = (int) (8 / Math.pow(2, i));
			String value = String.valueOf(binaryDigits[i] * m);
			bigCharLabelList.get(i).setText(value);
		}
	}

	public void makeRedGreenValues() {
		for (int i = 0; i <= 3; i++) {
			if (binaryDigits[i] == 0) {
				bigCharLabelList.get(i).setCharColor(Color.RED);
			} else {
				bigCharLabelList.get(i).setCharColor(Color.GREEN);
			}
		}
	}

	public void addConcateSigns() {
		for (int i = 2; i <= 6; i += 2) {
			this.add(new BigCharLabel("⌒"), i, 0);
		}
	}

}
