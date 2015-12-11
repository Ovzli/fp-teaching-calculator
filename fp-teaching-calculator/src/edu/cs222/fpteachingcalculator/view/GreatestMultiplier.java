package edu.cs222.fpteachingcalculator.view;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;

public class GreatestMultiplier extends GridPane {
	private int base;
	private int exponent = 0;
	private int decValue;

	public GreatestMultiplier(int baseValue, String decString) {
		GridPane.setHalignment(this, HPos.CENTER);
		GridPane.setValignment(this, VPos.CENTER);
		base = baseValue;
		decValue = Integer.parseInt(decString);
		findGreatestExponent();
		ExpansionBit lowBit = new ExpansionBit(baseValue);
		lowBit.setExponentDigit(exponent);
		this.add(lowBit, 0, 0);
		BigCharLabel signLeft = new BigCharLabel("≤ ");
		this.add(signLeft, 2, 0);
		BigCharLabel originalInput = new BigCharLabel(decString);
		this.add(originalInput, 3, 0);
		BigCharLabel signRight = new BigCharLabel("≤ ");
		this.add(signRight, 4, 0);
		ExpansionBit highBit = new ExpansionBit(baseValue);
		highBit.setExponentDigit(exponent + 1);
		this.add(highBit, 5, 0);
		BigCharLabel equalSign = new BigCharLabel(" = ");
		this.add(equalSign, 6, 0);
		BigCharLabel lowValue = new BigCharLabel(Integer.toString((int) Math.pow(base, exponent)));
		this.add(lowValue, 7, 0);
		BigCharLabel signLeft2 = new BigCharLabel("≤ ");
		this.add(signLeft2, 8, 0);
		BigCharLabel originalInput2 = new BigCharLabel(decString);
		this.add(originalInput2, 9, 0);
		BigCharLabel signRight2 = new BigCharLabel("≤ ");
		this.add(signRight2, 10, 0);
		BigCharLabel highValue = new BigCharLabel(Integer.toString((int) Math.pow(base, exponent + 1)));
		this.add(highValue, 11, 0);
		BigCharLabel statement = new BigCharLabel(
				"The greatest base " + base + " exponent without going over is " + exponent + ".");
		statement.changeToSmallChar();
		statement.overrideCharHexColor("#0066CC");
		this.add(statement, 0, 1);
		GridPane.setColumnSpan(statement, 16);
		BigCharLabel statement2 = new BigCharLabel(
				"This means that the bitstring will be " + (exponent + 1) + " digits in total length.");
		statement2.changeToSmallChar();
		statement2.overrideCharHexColor("#0066CC");
		this.add(statement2, 0, 2);
		GridPane.setColumnSpan(statement2, 16);
	}

	private void findGreatestExponent() {
		double value = -1;
		while (value < decValue) {
			exponent++;
			value = Math.pow(base, exponent);
		}
		exponent = exponent - 1;
	}
}
