package edu.cs222.fpteachingcalculator.view;

import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class SlideThumb extends GridPane {
	private final Rectangle backgroundRectangle = new Rectangle();
	private final Label slideLabel = new Label();

	public SlideThumb(int slideID) {
		backgroundRectangle.setWidth(30);
		backgroundRectangle.setHeight(30);
		GridPane.setHalignment(backgroundRectangle, HPos.CENTER);
		this.add(backgroundRectangle, 0, 0);
		slideLabel.setText(Integer.toString(slideID));
		slideLabel.getStyleClass().add("boldedLabel");
		GridPane.setHalignment(slideLabel, HPos.CENTER);
		this.add(slideLabel, 0, 0);
		if (slideID == 1) {
			colorSlideThumb("SELECTED");
		} else {
			colorSlideThumb("DEFAULT");
		}
	}

	public void colorSlideThumb(String state) {
		if (state.equals("SELECTED")) {
			backgroundRectangle.setFill(Color.ROYALBLUE);
			backgroundRectangle.setStroke(Color.BLACK);
			slideLabel.setTextFill(Color.WHITE);

		} else {
			backgroundRectangle.setFill(Paint.valueOf("#FFFFFF"));
			backgroundRectangle.setStroke(Color.ROYALBLUE);
			slideLabel.setTextFill(Color.ROYALBLUE);
		}
	}
}
