package edu.cs222.fpteachingcalculator.view;

import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class ExpansionBit extends GridPane {
	Label prefixChars = new Label();
	Label baseDigit = new Label();
	Label exponentDigit = new Label();
	private int baseValue;

	public ExpansionBit(int baseNumber) {
		super();
		baseValue = baseNumber;
		formatExpansionBit();
		baseDigit.setText(String.valueOf(baseValue));		
	}

	public ExpansionBit(int binaryDigitValue, int exponentDigitValue) {
		super();
		baseValue = 2;
		formatExpansionBit();
		setBinaryDigit(binaryDigitValue);
		setExponentDigit(exponentDigitValue);
	}

	private void formatExpansionBit() {
		this.setAlignment(Pos.CENTER);
		prefixChars.getStyleClass().add("bigExpansionChar");
		baseDigit.getStyleClass().add("bigExpansionChar");
		exponentDigit.getStyleClass().add("bigExpansionExponent");
		prefixChars.setTextFill(Color.web("#9900ff"));
		baseDigit.setTextFill(Color.web("#9900ff"));
		exponentDigit.setTextFill(Color.web("#9900ff"));
		GridPane.setValignment(exponentDigit, VPos.TOP);
		this.add(baseDigit, 2, 0);
		this.add(exponentDigit, 3, 0);
	}

	public void setBinaryDigit(int binaryDigitValue) {
		baseDigit.setText(binaryDigitValue + "x" + baseValue);
		if (binaryDigitValue == 0) {
			baseDigit.setTextFill(Color.RED);
			exponentDigit.setTextFill(Color.RED);
		} else {
			baseDigit.setTextFill(Color.GREEN);
			exponentDigit.setTextFill(Color.GREEN);
		}
	}

	public void setExponentDigit(int exponentDigitValue) {
		exponentDigit.setText(String.valueOf(exponentDigitValue));
	}

	public void setExpansionBitHexColor(String hexColor) {
		setExpansionBaseHexColor(hexColor);
		exponentDigit.setTextFill(Color.web(hexColor));
	}

	public void setExpansionBaseHexColor(String hexColor) {
		baseDigit.setTextFill(Color.web(hexColor));
	}

	public void addPrefix(String prefix) {
		prefixChars.setText(prefix);
		this.add(prefixChars, 1, 0);
		prefixChars.setTextFill(Color.web("#9900ff"));
	}

	public void makeSmallFonts() {
		prefixChars.getStyleClass().add("smallExpansionChar");
		baseDigit.getStyleClass().add("smallExpansionChar");
		exponentDigit.getStyleClass().add("smallExpansionExponent");
	}
}
