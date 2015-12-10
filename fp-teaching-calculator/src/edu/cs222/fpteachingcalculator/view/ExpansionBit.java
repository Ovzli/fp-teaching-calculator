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
		this.setAlignment(Pos.CENTER);
		prefixChars.getStyleClass().add("bigExpansionChar");
		this.add(baseDigit, 1, 0);
		baseDigit.setText(String.valueOf(baseValue));
		baseDigit.getStyleClass().add("bigExpansionChar");
		this.add(exponentDigit, 2, 0);
		exponentDigit.getStyleClass().add("bigExpansionExponent");
		GridPane.setValignment(exponentDigit, VPos.TOP);
	}

	public ExpansionBit(int binaryDigitValue, int exponentDigitValue) {
		super();
		baseValue = 2;
		this.setAlignment(Pos.CENTER);
		this.add(baseDigit, 0, 0);
		baseDigit.getStyleClass().add("bigExpansionChar");
		baseDigit.setTextFill(Color.web("#9900ff"));
		this.add(exponentDigit, 2, 0);
		exponentDigit.getStyleClass().add("bigExpansionExponent");
		GridPane.setValignment(exponentDigit, VPos.TOP);
		setBinaryDigit(binaryDigitValue);
		setExponentDigit(exponentDigitValue);
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
		baseDigit.setTextFill(Color.web(hexColor));
		exponentDigit.setTextFill(Color.web(hexColor));
	}

	public void addPrefix(String prefix) {
		prefixChars.setText(prefix);
		this.add(prefixChars, 0, 0);
		prefixChars.setTextFill(Color.web("#9900ff"));
	}

	public void makeSmallFonts() {
		prefixChars.getStyleClass().add("smallExpansionChar");
		baseDigit.getStyleClass().add("smallExpansionChar");
		exponentDigit.getStyleClass().add("smallExpansionExponent");
	}

}
