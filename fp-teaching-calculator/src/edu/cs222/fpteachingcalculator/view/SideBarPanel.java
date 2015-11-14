package edu.cs222.fpteachingcalculator.view;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class SideBarPanel extends GridPane {

	public SideBarPanel(String titleString, int panelWidth) {
		super();
		this.setMinWidth(panelWidth);
		this.setAlignment(Pos.TOP_CENTER);
		this.setVgap(4);
		Rectangle titleBGRect = makeRectangle(panelWidth, 44, "navy");
		titleBGRect.setStroke(Color.BLACK);
		titleBGRect.setStrokeWidth(2.0);
		this.add(titleBGRect, 0, 0);
		Label title = new Label(titleString);
		this.add(title, 0, 0);
		title.getStyleClass().add("sideBarTitle");
		GridPane.setHalignment(title, HPos.CENTER);
		GridPane.setValignment(title, VPos.TOP);
		Rectangle tableBGRect = makeRectangle(panelWidth, 400, "royalblue");
		tableBGRect.setStroke(Color.NAVY);
		tableBGRect.setStrokeWidth(2.0);
		GridPane.setValignment(tableBGRect, VPos.TOP);
		this.add(tableBGRect, 0, 1);
		this.setVisible(false);
		this.setGridLinesVisible(false);
	}

	public Rectangle makeRectangle(int width, int height, String color) {
		Rectangle customRectangle = new Rectangle();
		customRectangle.setWidth(width);
		customRectangle.setHeight(height);
		customRectangle.setFill(Paint.valueOf(color));
		GridPane.setHalignment(customRectangle, HPos.CENTER);
		return customRectangle;
	}

}
