package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class ResultDisplay extends GridPane {
	protected List<String> hexSymbols = new LinkedList<String>();
	protected List<String> decValues = new LinkedList<String>();
	protected List<List<Integer>> binDigits = new LinkedList<>();

	public ResultDisplay() {
		super();
		AnchorPane.setTopAnchor(this, 0.0);
		AnchorPane.setLeftAnchor(this, 0.0);
		AnchorPane.setRightAnchor(this, 0.0);
		this.getStyleClass().add("displayGrid");
		this.setVgap(2);
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(100);
		this.getColumnConstraints().add(col1);
		this.setGridLinesVisible(false);
	}

	protected GridPane makeBigCharTable() {
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.getStyleClass().add("bigCharCell");
		return gridPane;
	}

	protected void makeEmptyRow(int indexRow) {
		Rectangle emptyRect = new Rectangle();
		this.add(emptyRect, 0, indexRow);
		emptyRect.setWidth(40);
		emptyRect.setHeight(80);
		emptyRect.setFill(Paint.valueOf("#FFFFFF"));
	}

}