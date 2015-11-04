package edu.cs222.fpteachingcalculator.view;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HexDecPanel extends SideBarPanel {
	private static int panelWidth = 150;
	private final GridPane tableColumns = new GridPane();
	private final String[] hexadecimals = { "0", "1", "2", "3", "4", "5", "6",
			"7", "8", "9", "A", "B", "C", "D", "E", "F" };
	private final String[] decimals = { "0", "1", "2", "3", "4", "5", "6", "7",
			"8", "9", "10", "11", "12", "13", "14", "15" };

	public HexDecPanel(String titleString) {
		super(titleString, panelWidth);
		this.add(tableColumns, 0, 1);
		tableColumns.setPadding(new Insets(10.0));
		tableColumns.setAlignment(Pos.TOP_CENTER);

		GridPane leftColumn = makeDigitColumn(hexadecimals, Color.BLUE);
		Label hexHeader = makeDigitLabel("HEX");
		hexHeader.setTextFill(Color.NAVY);
		leftColumn.add(hexHeader, 0, 16);
		tableColumns.add(leftColumn, 0, 0);

		GridPane centerColumn = makeEqualColumn();
		Rectangle blankRect = this.makeRectangle(10, 19, "royalblue");
		centerColumn.add(blankRect, 0, 16);
		tableColumns.add(centerColumn, 1, 0);

		GridPane rightColumn = makeDigitColumn(decimals, Color.DARKORCHID);
		Label decHeader = makeDigitLabel("DEC");
		decHeader.setTextFill(Color.NAVY);
		rightColumn.add(decHeader, 0, 16);
		tableColumns.add(rightColumn, 2, 0);
	}

	private GridPane makeEqualColumn() {
		GridPane column = new GridPane();
		column.setVgap(2);
		column.getStyleClass().add("sideBarTable");
		for (int i = 0; i < 15; i++) {
			Rectangle digitBG = this.makeRectangle(20, 24, "royalblue");
			digitBG.setStroke(Color.ROYALBLUE);
			column.add(digitBG, 0, i);
			Label equalSign = makeDigitLabel("=");
			equalSign.setTextFill(Color.NAVY);
			column.add(equalSign, 0, i);
		}
		return column;
	}

	private GridPane makeDigitColumn(String[] digitList, Color color) {
		GridPane column = new GridPane();
		column.setVgap(2);
		column.getStyleClass().add("sideBarTable");
		for (int i = 0; i < 15; i++) {
			Rectangle digitBG = this.makeRectangle(40, 24, "white");
			digitBG.setStroke(Color.NAVY);
			column.add(digitBG, 0, i);
			Label digit = makeDigitLabel(digitList[i]);
			digit.setTextFill(color);
			column.add(digit, 0, i);
		}
		return column;
	}

	private Label makeDigitLabel(String string) {
		Label charDigit = new Label(string);
		charDigit.getStyleClass().add("sideBarTableDigit");
		GridPane.setHalignment(charDigit, HPos.CENTER);
		GridPane.setValignment(charDigit, VPos.CENTER);
		return charDigit;
	}

}
