package edu.cs222.fpteachingcalculator.view;

import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BigCharLabel extends Label {
	
	public BigCharLabel(String labelName) {
		super(labelName);
		GridPane.setHalignment(this, HPos.CENTER);
		this.getStyleClass().add("bigChar");
		this.setTextFill(Color.web("#9900ff"));
	}
	
	public void overrideCharColor(String hexColor){
		this.setTextFill(Color.web(hexColor));		
	}

}
