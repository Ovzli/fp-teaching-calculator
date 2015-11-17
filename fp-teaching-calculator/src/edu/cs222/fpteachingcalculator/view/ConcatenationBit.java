package edu.cs222.fpteachingcalculator.view;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class ConcatenationBit extends Label {

	public ConcatenationBit(int binaryElem) {
		super(String.valueOf(binaryElem));
		this.getStyleClass().add("bigExpansionChar");
		if (binaryElem == 0) {
			this.setTextFill(Color.RED);
		} else {
			this.setTextFill(Color.GREEN);
		}
	}

}
