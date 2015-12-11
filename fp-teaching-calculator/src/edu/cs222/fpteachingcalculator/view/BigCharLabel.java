package edu.cs222.fpteachingcalculator.view;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BigCharLabel extends Label {
	public BigCharLabel(String labelName) {
		super(labelName);
		GridPane.setHalignment(this, HPos.CENTER);
		GridPane.setValignment(this, VPos.CENTER);
		this.getStyleClass().add("bigChar");
		this.setTextFill(Color.web("#9900ff"));
	}

	public void overrideCharHexColor(String hexColor) {
		this.setTextFill(Color.web(hexColor));
	}

	public void setCharColor(Color color) {
		this.setTextFill(color);
	}

	public void changeToSmallChar() {
		this.getStyleClass().add("smallChar");
	}

	public void updateHalignment(HPos newPos) {
		GridPane.setHalignment(this, newPos);
	}
}
