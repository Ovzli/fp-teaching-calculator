package edu.cs222.fpteachingcalculator.view;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class ResultStep extends GridPane {
	private int stepID;
	private final Label stepTitle = new Label("x");
	private final Label stepIDTag = new Label("x");
	private final GridPane stepHeader = new GridPane();

	public ResultStep() {
		super();
		ColumnConstraints col1 = new ColumnConstraints(200);
		this.getColumnConstraints().add(col1);
		this.setHgap(2);
		this.add(stepTitle, 0, 0);
		stepTitle.getStyleClass().add("stepTitle");
		GridPane.setHalignment(stepTitle, HPos.RIGHT);
		GridPane.setValignment(stepTitle, VPos.TOP);
	}

	public void setResultStepID(int stepIDassigned) {
		stepID = stepIDassigned;
		stepIDTag.setText("  STEP " + stepID);
	}

	public void addFormattedStepHeader(String rowTagString) {
		stepHeader.getChildren().clear();
		this.getChildren().remove(stepTitle);
		this.getChildren().remove(stepHeader);
		this.add(stepTitle, 0, 1);
		setStepTitle(rowTagString);
		this.add(stepHeader, 0, 0);
		Rectangle horizLine = new Rectangle();
		horizLine.setWidth(750);
		horizLine.setHeight(2);
		horizLine.setFill(Paint.valueOf("#0066CC"));
		stepHeader.add(horizLine, 0, 0);
		GridPane.setValignment(horizLine, VPos.TOP);
		Rectangle bgRectBlue = new Rectangle();
		bgRectBlue.setWidth(200);
		bgRectBlue.setHeight(24);
		bgRectBlue.setFill(Paint.valueOf("#0066CC"));
		stepHeader.add(bgRectBlue, 0, 0);
		GridPane.setValignment(bgRectBlue, VPos.TOP);
		stepIDTag.getStyleClass().add("stepLabel");
		stepHeader.add(stepIDTag, 0, 0);
	}

	public void setStepTitle(String rowTagString) {
		stepTitle.setText("\n" + rowTagString + ":  ");
	}

	public void addStepComment(String comment) {
		Label tutorText = new Label();
		tutorText.setText(comment);
		tutorText.setWrapText(true);
		tutorText.setMinWidth(350);
		tutorText.setDisable(false);
		tutorText.getStyleClass().add("commentTag");
		GridPane.setValignment(tutorText, VPos.TOP);
		this.add(tutorText, 1, 0);
	}

	public void addStepPostContent(GridPane content) {
		this.add(content, 1, 2);
	}

	public void addStepContent(GridPane content) {
		this.add(content, 1, 1);
	}

	public void addStepBigCharLabel(BigCharLabel content) {
		this.add(content, 1, 1);
		content.updateHalignment(HPos.LEFT);
	}

}
