package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class DisplayTemplate extends GridPane {
	public LinkedList<String> hexSymbols = new LinkedList<String>();
	public LinkedList<String> decValues = new LinkedList<String>();
	public LinkedList<int[]> binDigits = new LinkedList<int[]>();
	private final int column1Width = 200;
	private GridPane expansionGP = new GridPane();

	public DisplayTemplate() {
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

	protected GridPane makeInputReprintRow() {
		GridPane inputRowGP = new GridPane();
		setColumn1Constraints(inputRowGP);
		Label rowTag = makeRowTag("original input:  ");
		inputRowGP.add(rowTag, 0, 0);
		GridPane inputLabel = makeBigCharLabelGrid(hexSymbols);
		for (int i = 0; i < hexSymbols.size(); i++) {
			// UNIQUE LABEL COLOR: "#0066CC"
		}
		inputRowGP.add(inputLabel, 1, 0);
		return inputRowGP;
	}

	protected GridPane buildStep(int stepID, String rowTagString) {
		GridPane stepGP = new GridPane();
		setColumn1Constraints(stepGP);
		stepGP.setHgap(2);
		Rectangle horizLine = horizontalLine();
		stepGP.add(horizLine, 0, 0);
		GridPane stepLabel = makeStepLabel(stepID, rowTagString);
		stepGP.add(stepLabel, 0, 1);
		Rectangle bgRect = makeBGRect("#FFFFFF");
		stepGP.add(bgRect, 1, 5);
		stepGP.setGridLinesVisible(false);
		return stepGP;
	}

	protected Label addStepComment(int stepID, String comment) {
		Label tutorText = new Label();
		tutorText.setText("Step " + stepID + " " + comment);
		tutorText.setWrapText(true);
		tutorText.setMinWidth(350);
		tutorText.getStyleClass().add("commentTag");
		GridPane.setValignment(tutorText, VPos.TOP);
		return tutorText;
	}

	private Rectangle horizontalLine() {
		Rectangle horizLine = new Rectangle();
		horizLine.setWidth(750);
		horizLine.setHeight(2);
		horizLine.setFill(Paint.valueOf("#0066CC"));
		return horizLine;
	}

	private Rectangle makeBGRect(String color) {
		Rectangle bgRect = new Rectangle();
		bgRect.setWidth(column1Width);
		bgRect.setHeight(24);
		bgRect.setFill(Paint.valueOf(color));
		return bgRect;
	}

	private Label makeStepTag(int stepID) {
		Label stepTag = new Label();
		stepTag.setText(" STEP " + stepID);
		stepTag.getStyleClass().add("stepLabel");
		return stepTag;
	}

	private GridPane makeStepLabel(int stepID, String rowTagString) {
		GridPane stepLabel = new GridPane();
		Rectangle bgRect = makeBGRect("#0066CC");
		stepLabel.add(bgRect, 0, 0);
		Label stepTag = makeStepTag(stepID);
		stepLabel.add(stepTag, 0, 0);
		Label rowTag = makeRowTag(rowTagString);
		stepLabel.add(rowTag, 0, 1);
		return stepLabel;
	}

	private Label makeRowTag(String labelName) {
		Label rowTagLabel = new Label("\n" + labelName);
		rowTagLabel.getStyleClass().add("rowTag");
		GridPane.setValignment(rowTagLabel, VPos.TOP);
		GridPane.setHalignment(rowTagLabel, HPos.RIGHT);
		return rowTagLabel;
	}

	protected GridPane makeBigCharLabelGrid(LinkedList<String> charList) {
		GridPane bigCharGP = new GridPane();
		bigCharGP.setHgap(5);
		bigCharGP.getStyleClass().add("bigCharCell");
		for (int i = 0; i < charList.size(); i++) {
			makeBigCharLabelBox(bigCharGP, i, 0, charList.get(i));
		}
		bigCharGP.setGridLinesVisible(false);
		return bigCharGP;
	}

	private void makeBigCharLabelBox(GridPane parentGP, int indexCol, int indexRow, String charElem) {
		Rectangle bgRect = new Rectangle();
		parentGP.add(bgRect, indexCol, indexRow);
		bgRect.setWidth(40);
		bgRect.setHeight(40);
		bgRect.setStroke(Color.ROYALBLUE);
		bgRect.setFill(Paint.valueOf("#E6E6E6"));
		makeBigChar(parentGP, indexCol, indexRow, charElem);
	}

	private void makeBigChar(GridPane parentGP, int indexCol, int indexRow, String charElem) {
		Label bigLabel = new Label(charElem);
		parentGP.add(bigLabel, indexCol, indexRow);
		GridPane.setHalignment(bigLabel, HPos.CENTER);
		bigLabel.getStyleClass().add("bigChar");
		bigLabel.setTextFill(Color.web("#9900ff"));
	}

	protected GridPane makeExpansionGrid(LinkedList<String> charList) {
		expansionGP.setVgap(5);
		expansionGP.getStyleClass().add("bigCharCell");
		for (int i = 0; i < charList.size(); i++) {
			makeBigCharLabelBox(expansionGP, 0, i, charList.get(i));
			makeBigChar(expansionGP, 1, i, "=");
			makeExpansionBit(2, i, binDigits.get(i)[0], "3");
			makeBigChar(expansionGP, 3, i, "+");
			makeExpansionBit(4, i, binDigits.get(i)[1], "2");
			makeBigChar(expansionGP, 5, i, "+");
			makeExpansionBit(6, i, binDigits.get(i)[2], "1");
			makeBigChar(expansionGP, 7, i, "+");
			makeExpansionBit(8, i, binDigits.get(i)[3], "0");
			makeBigChar(expansionGP, 9, i, "=");
			makeBigChar(expansionGP, 10, i, "(");
			makeBigChar(expansionGP, 11, i, String.valueOf(binDigits.get(i)[0] * 8));
			makeBigChar(expansionGP, 12, i, "+");
			makeBigChar(expansionGP, 13, i, String.valueOf(binDigits.get(i)[1] * 4));
			makeBigChar(expansionGP, 14, i, "+");
			makeBigChar(expansionGP, 15, i, String.valueOf(binDigits.get(i)[2] * 2));
			makeBigChar(expansionGP, 16, i, "+");
			makeBigChar(expansionGP, 17, i, String.valueOf(binDigits.get(i)[3] * 1));
			makeBigChar(expansionGP, 18, i, ")");
		}
		expansionGP.setGridLinesVisible(false);
		return expansionGP;
	}

	private void makeExpansionBit(int indexCol, int indexRow, int binaryElem, String exponentElem) {
		GridPane bitGP = new GridPane();
		bitGP.setAlignment(Pos.CENTER);
		expansionGP.add(bitGP, indexCol, indexRow);
		Label binaryDigit = new Label(binaryElem + "x2");
		bitGP.add(binaryDigit, 0, 0);
		binaryDigit.getStyleClass().add("bigExpansionChar");
		Label exponentDigit = new Label(exponentElem);
		bitGP.add(exponentDigit, 2, 0);
		exponentDigit.getStyleClass().add("bigExpansionExponent");
		GridPane.setValignment(exponentDigit, VPos.TOP);
		if (binaryElem == 0) {
			binaryDigit.setTextFill(Color.RED);
			exponentDigit.setTextFill(Color.RED);
		} else {
			binaryDigit.setTextFill(Color.GREEN);
			exponentDigit.setTextFill(Color.GREEN);
		}
		bitGP.setGridLinesVisible(false);
	}

	protected GridPane makeEvaluationGrid(LinkedList<String> charList) {
		GridPane evaluationGP = new GridPane();
		evaluationGP.setVgap(5);
		evaluationGP.getStyleClass().add("bigCharCell");
		for (int i = 0; i < charList.size(); i++) {
			makeBigCharLabelBox(evaluationGP, 0, i, charList.get(i));
			makeBigChar(evaluationGP, 1, i, "=");
			makeEvaluationBit(evaluationGP, 2, i, binDigits.get(i)[0]);
			makeBigChar(evaluationGP, 3, i, "⌒");
			makeEvaluationBit(evaluationGP, 4, i, binDigits.get(i)[1]);
			makeBigChar(evaluationGP, 5, i, "⌒");
			makeEvaluationBit(evaluationGP, 6, i, binDigits.get(i)[2]);
			makeBigChar(evaluationGP, 7, i, "⌒");
			makeEvaluationBit(evaluationGP, 8, i, binDigits.get(i)[3]);
			makeBigChar(evaluationGP, 9, i, "=");
			makeBigChar(evaluationGP, 10, i, String.valueOf(binDigits.get(i)[0]));
			makeBigChar(evaluationGP, 11, i, String.valueOf(binDigits.get(i)[1]));
			makeBigChar(evaluationGP, 12, i, String.valueOf(binDigits.get(i)[2]));
			makeBigChar(evaluationGP, 13, i, String.valueOf(binDigits.get(i)[3]));
		}
		evaluationGP.setGridLinesVisible(false);
		return evaluationGP;
	}

	private void makeEvaluationBit(GridPane parentGP, int indexCol, int indexRow, int binaryElem) {
		Label binaryDigit = new Label(String.valueOf(binaryElem));
		parentGP.add(binaryDigit, indexCol, indexRow);
		binaryDigit.getStyleClass().add("bigExpansionChar");
		if (binaryElem == 0) {
			binaryDigit.setTextFill(Color.RED);
		} else {
			binaryDigit.setTextFill(Color.GREEN);
		}
	}

	protected GridPane makeBinaryGrid(LinkedList<int[]> binDigitList) {
		GridPane binaryGP = new GridPane();
		binaryGP.getStyleClass().add("bigCharCell");
		for (int i = 0; i < binDigitList.size(); i++) {
			String binDigit = String.valueOf(binDigits.get(i)[0]) + String.valueOf(binDigits.get(i)[1])
					+ String.valueOf(binDigits.get(i)[2]) + String.valueOf(binDigits.get(i)[3]);
			makeBigChar(binaryGP, i, 0, binDigit);
		}
		return binaryGP;
	}

	protected void makeEmptyRow(int indexRow) {
		Rectangle emptyRect = new Rectangle();
		this.add(emptyRect, 0, indexRow);
		emptyRect.setWidth(40);
		emptyRect.setHeight(80);
		emptyRect.setFill(Paint.valueOf("#FFFFFF"));
	}

	private void setColumn1Constraints(GridPane gridPane) {
		ColumnConstraints col1 = new ColumnConstraints(column1Width);
		gridPane.getColumnConstraints().add(col1);
	}
}