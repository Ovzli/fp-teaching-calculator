package edu.cs222.fpteachingcalculator.view;

import javafx.geometry.HPos;
import javafx.scene.layout.GridPane;

public class SmallCharLabel extends BigCharLabel {

	public SmallCharLabel(String labelName) {
		super(labelName);
		this.changeToSmallChar();
		GridPane.setHalignment(this, HPos.RIGHT);
	}
}
