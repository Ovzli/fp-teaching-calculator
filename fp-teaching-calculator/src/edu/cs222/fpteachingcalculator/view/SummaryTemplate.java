package edu.cs222.fpteachingcalculator.view;

import javafx.scene.layout.GridPane;

public class SummaryTemplate extends GridPane {
	int rowCount = 0;

	public void addInputReprintRow(GridPane inputReprintRow) {
		this.add(inputReprintRow, 0, rowCount);
		rowCount++;
	}

	public void addStepRow(GridPane rowContent) {
		this.add(rowContent, 0, rowCount);
		rowCount++;
	}

}
