package edu.cs222.fpteachingcalculator.view;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class BigCharBox extends Rectangle {

	public BigCharBox() {
		super();
		this.setWidth(40);
		this.setHeight(40);
		this.setStroke(Color.ROYALBLUE);
		this.setFill(Paint.valueOf("#E6E6E6"));
	}

}
