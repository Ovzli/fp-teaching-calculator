package edu.cs222.fpteachingcalculator.view;

import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class ExpansionBit extends GridPane {
	Label binaryDigit = new Label();
	Label exponentDigit = new Label();

	public ExpansionBit() {
		super();
		this.setAlignment(Pos.CENTER);
		this.add(binaryDigit, 0, 0);
		binaryDigit.getStyleClass().add("bigExpansionChar");
		this.add(exponentDigit, 2, 0);
		exponentDigit.getStyleClass().add("bigExpansionExponent");
		GridPane.setValignment(exponentDigit, VPos.TOP);
	}

	public void setBinaryDigit(int binaryDigitValue) {
		binaryDigit.setText(binaryDigitValue + "x2");
		if (binaryDigitValue == 0) {
			binaryDigit.setTextFill(Color.RED);
			exponentDigit.setTextFill(Color.RED);
		} else {
			binaryDigit.setTextFill(Color.GREEN);
			exponentDigit.setTextFill(Color.GREEN);
		}
	}

	public void setExponentDigit(int exponentDigitValue) {
		exponentDigit.setText(String.valueOf(exponentDigitValue));
	}

}
