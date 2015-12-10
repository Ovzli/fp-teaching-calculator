package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class ResultDisplay extends GridPane {
	protected final GridPane summaryDisplay = new GridPane();
	protected final GridPane tutorialDisplay = new GridPane();
	protected final GridPane practiceDisplay = new GridPane();
	protected GridPane reprintValue = new GridPane();
	protected List<String> hexSymbols = new LinkedList<String>();
	protected List<String> decValues = new LinkedList<String>();
	protected List<List<Integer>> binDigits = new LinkedList<>();
	protected String decString = "";
	protected final List<GridPane> slideList = new LinkedList<>();
	protected GridPane decimalChars = new GridPane();
	protected ExpansionGrid expansionGrid;
	protected ConcatenationGrid concatenationGrid;
	protected BinaryGrid binaryGrid;
	protected final ResultStep inputReprintRow = new ResultStep();
	protected List<ResultStep> displaySteps = new LinkedList<>();
	protected String currentMode = "SUMMARY";
	protected int numberDisplaySteps;
	protected int tutorialSlideCount;
	protected int practiceSlideCount;
	protected GridPane targetDisplay;

	public ResultDisplay() {
		super();
	}

	public ResultDisplay(int numberSteps) {
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
		summaryDisplay.setVgap(20);
		tutorialDisplay.setVgap(20);
		practiceDisplay.setVgap(20);
		numberDisplaySteps = numberSteps;
		for (int i = 1; i <= numberSteps; i++) {
			displaySteps.add(new ResultStep());
		}
	}

	protected void addStepsToDisplay() {
		displaySteps.get(0).setVisible(true);

		if (currentMode.equals("SUMMARY")) {
			targetDisplay = summaryDisplay;
			displaySteps.get(1).setVisible(true);
			displaySteps.get(2).setVisible(true);
			displaySteps.get(3).setVisible(true);
		} else {
			displaySteps.get(1).setVisible(false);
			displaySteps.get(2).setVisible(false);
			displaySteps.get(3).setVisible(false);
		}
		if (currentMode.equals("TUTORIAL")) {
			targetDisplay = tutorialDisplay;
		} else if (currentMode.equals("PRACTICE")) {
			targetDisplay = practiceDisplay;
		}
		targetDisplay.add(inputReprintRow, 0, 0);
		targetDisplay.add(displaySteps.get(0), 0, 1);
		if (currentMode.equals("SUMMARY")) {
			targetDisplay.add(displaySteps.get(1), 0, 2);
			targetDisplay.add(displaySteps.get(2), 0, 3);
			targetDisplay.add(displaySteps.get(3), 0, 4);
		} else {
			targetDisplay.add(displaySteps.get(1), 0, 1);
			targetDisplay.add(displaySteps.get(2), 0, 1);
			targetDisplay.add(displaySteps.get(3), 0, 1);
		}
	}

	protected void clearEntireDisplay() {
		this.getChildren().clear();
		slideList.clear();
		practiceDisplay.getChildren().clear();
		tutorialDisplay.getChildren().clear();
		summaryDisplay.getChildren().clear();
		reprintValue.getChildren().clear();
		displaySteps.get(0).getChildren().clear();
		displaySteps.get(1).getChildren().clear();
		displaySteps.get(2).getChildren().clear();
		displaySteps.get(3).getChildren().clear();
		displaySteps.get(1).setVisible(true);
	}

	protected void setCurrentMode(String mode) {
		currentMode = mode;
	}

	protected void makeInputReprintRow(String inputType) {
		inputReprintRow.setStepTitle("original input");
		inputReprintRow.setResultStepID(0);
		List<String> inputList = null;
		if (inputType.equals("HEX")) {
			inputList = hexSymbols;
			reprintValue = makeBigCharTable();
			fillOutBigCharTable(inputList);
		} else if (inputType.equals("DEC")) {
			inputList = decValues;
			reprintValue = new GridPane();
			reprintValue.add(new BigCharLabel(decString), 0, 0);
		} else if (inputType.equals("BIN")) {
			reprintValue = new BinaryGrid(binDigits);
		} 
		inputReprintRow.add(reprintValue, 1, 0);
	}

	protected GridPane makeBigCharTable() {
		GridPane gridPane = new GridPane();
		gridPane.setHgap(5);
		gridPane.getStyleClass().add("bigCharCell");
		return gridPane;
	}

	protected GridPane makeBigDecimalTable() {
		GridPane gridPane = makeBigCharTable();
		for (int i = 0; i < hexSymbols.size(); i++) {
			BigCharBox bigCharBox = new BigCharBox();
			gridPane.add(bigCharBox, i, 0);
			if (currentMode.equals("PRACTICE")) {
				AnswerInputField inputField = new AnswerInputField(40);
				gridPane.add(inputField, i, 0);
			} else {
				BigCharLabel bigCharLabel = new BigCharLabel(decValues.get(i));
				gridPane.add(bigCharLabel, i, 0);
			}
		}		
		return gridPane;
	}

	protected String writeDecEquivalentComment() {
		String DecEquivalentComment;
		if (currentMode.equals("PRACTICE")) {
			DecEquivalentComment = "Enter the decimal equivalents for each hexadecimal value above."
							+ "\nHINT: These are pre-determined representations.";
		} else {
			DecEquivalentComment = "This step shows each input symbol must be assigned a "
							+ "representative equivalent for each symbol needing "
							+ "converted. This is done through pre-determined "
							+ "representations of each individual symbol as outlined in the "
							+ "equivalency table shown to the right.";
		}
		return DecEquivalentComment;
	}

	private void fillOutBigCharTable(List<String> inputList) {
		for (int i = 0; i < inputList.size(); i++) {
			BigCharBox bigCharBox = new BigCharBox();
			reprintValue.add(bigCharBox, i, 0);
			BigCharLabel bigCharLabel = new BigCharLabel(inputList.get(i));
			reprintValue.add(bigCharLabel, i, 0);
			bigCharLabel.overrideCharHexColor("#0066CC");
		}
	}

	protected void makeEmptyRow(int indexRow) {
		Rectangle emptyRect = new Rectangle();
		this.add(emptyRect, 0, indexRow);
		emptyRect.setWidth(40);
		emptyRect.setHeight(80);
		emptyRect.setFill(Paint.valueOf("#FFFFFF"));
	}

	public int getTotalSlideCount(String displayMode) {
		if (displayMode.equals("PRACTICE")) {
			return practiceSlideCount;
		} else {
			return tutorialSlideCount;
		}
	}

	public void hideSlide(int slideToHide) {
		slideList.get(slideToHide).setVisible(false);
	}

	public void displaySlide(int slideToDisplay) {
		slideList.get(slideToDisplay).setVisible(true);
	}

}