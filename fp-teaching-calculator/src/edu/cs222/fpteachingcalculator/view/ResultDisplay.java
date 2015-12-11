package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.control.TextField;
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
	protected List<String> hexSymbols = new LinkedList<>();
	protected List<String> decValues = new LinkedList<>();
	protected List<List<Integer>> binDigits = new LinkedList<>();
	protected List<String> binChars = new LinkedList<>();
	protected String decString = "";
	protected final List<GridPane> slideList = new LinkedList<>();
	protected GridPane decimalChars = new GridPane();
	protected ExpansionGrid expansionGrid;
	protected ConcatenationGrid concatenationGrid;
	protected BinaryGrid binaryGrid;
	protected GreatestMultiplier greatMultiplier;
	protected BaseRemainderTable remainderCalcs;
	protected List<Integer> remainders = new LinkedList<>();
	protected final ResultStep inputReprintRow = new ResultStep();
	protected List<ResultStep> displaySteps = new LinkedList<>();
	protected String currentMode = "SUMMARY";
	protected int numberDisplaySteps;
	protected int tutorialSlideCount;
	protected int practiceSlideCount;
	protected GridPane targetDisplay;
	protected final List<TextField> answerInputFieldList = new LinkedList<>();

	public ResultDisplay() {
		super();
		this.setVisible(false);
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
		displaySteps.get(0).setVisible(true);
		displaySteps.get(1).setVisible(true);
		this.setVisible(false);
		this.setMinHeight(424);
	}

	protected void addStepsToDisplay() {
		displaySteps.get(0).setVisible(true);
		if (currentMode.equals("SUMMARY")) {
			targetDisplay = summaryDisplay;
			setAllStepVisibility(true);
			insertSummaryDisplaySteps();
		} else if (currentMode.equals("TUTORIAL")) {
			targetDisplay = tutorialDisplay;
			setAllStepVisibility(false);
			insertTutorialDisplaySteps();
		} else if (currentMode.equals("PRACTICE")) {
			targetDisplay = practiceDisplay;
			setAllStepVisibility(false);
			insertTutorialDisplaySteps();
		}
		targetDisplay.add(inputReprintRow, 0, 0);
	}

	private void setAllStepVisibility(boolean visibility) {
		for (int i = 1; i < displaySteps.size(); i++) {
			displaySteps.get(i).setVisible(visibility);
		}
	}

	private void insertSummaryDisplaySteps() {
		for (int i = 0; i < displaySteps.size(); i++) {
			targetDisplay.add(displaySteps.get(i), 0, i + 1);
		}
	}

	private void insertTutorialDisplaySteps() {
		for (int i = 0; i < displaySteps.size(); i++) {
			targetDisplay.add(displaySteps.get(i), 0, 1);
		}
	}

	protected void clearEntireDisplay() {
		this.getChildren().clear();
		slideList.clear();
		practiceDisplay.getChildren().clear();
		tutorialDisplay.getChildren().clear();
		summaryDisplay.getChildren().clear();
		reprintValue.getChildren().clear();
		for (int i = 0; i < displaySteps.size(); i++) {
			displaySteps.get(i).getChildren().clear();
		}
	}

	protected void makeInputReprintRow(String inputType) {
		inputReprintRow.setStepTitle("original input");
		inputReprintRow.setResultStepID(0);
		List<String> inputList = null;
		reprintValue.getChildren().clear();
		inputReprintRow.getChildren().remove(reprintValue);
		if (inputType.equals("HEX")) {
			inputList = hexSymbols;
			reprintValue = makeBigCharTable();
			fillOutBigCharTable(inputList);
		} else if (inputType.equals("DEC")) {
			inputList = decValues;
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
		answerInputFieldList.clear();
		for (int i = 0; i < hexSymbols.size(); i++) {
			BigCharBox bigCharBox = new BigCharBox();
			gridPane.add(bigCharBox, i, 0);
			if (currentMode.equals("PRACTICE")) {
				answerInputFieldList.add(new AnswerInputField(40));
				gridPane.add(answerInputFieldList.get(i), i, 0);
			} else {
				BigCharLabel bigCharLabel = new BigCharLabel(decValues.get(i));
				gridPane.add(bigCharLabel, i, 0);
			}
		}
		return gridPane;
	}

	protected void makeGreatMultiplierStep(int stepID, int baseValue) {
		int stepIDindex = stepID - 1;
		displaySteps.get(stepIDindex).addFormattedStepHeader(
				"greatest base " + baseValue + " multiplier");
		displaySteps.get(stepIDindex).setResultStepID(stepID);
		greatMultiplier = new GreatestMultiplier(baseValue, decString);
		if (currentMode.equals("PRACTICE")) {
			displaySteps.get(stepIDindex).addStepComment(
					"Determine the greatest exponent of the base without going "
							+ "over the value being converted");
			greatMultiplier.setupForPracticeMode();
		} else {
			displaySteps.get(stepIDindex).addStepComment(
					"This step is used to determine the greatest exponential "
							+ "multiplier of the base without going over the "
							+ "value needing to be coverted.");
		}
		displaySteps.get(stepIDindex).addStepContent(greatMultiplier);
	}

	protected void makeBinRepresentStep(int stepID) {
		int stepIDindex = stepID - 1;
		displaySteps.get(stepIDindex).addFormattedStepHeader("binary representation");
		displaySteps.get(stepIDindex).setResultStepID(stepID);
		displaySteps.get(stepIDindex).addStepComment("This step shows the final binary "
				+ "representation rewritten as a binary number.");
		binaryGrid = new BinaryGrid(binDigits);
		displaySteps.get(stepIDindex).addStepContent(binaryGrid);
	}
	
	protected void makeRemainderStep(int stepID, int baseValue) {
		int stepIDindex = stepID - 1;
		int greatestExponent = greatMultiplier.getGreatestExponent();
		displaySteps.get(stepIDindex).addFormattedStepHeader(
				"calculate remainders");
		displaySteps.get(stepIDindex).setResultStepID(stepID);
		if (currentMode.equals("PRACTICE")) {
			displaySteps.get(stepIDindex).addStepComment(
					"PRACTICE STEP COMMENT.");
		} else {
			displaySteps.get(stepIDindex).addStepComment(
					"SUMMARY AND TUTORIAL COMMENT");
		}
		remainderCalcs = new BaseRemainderTable(baseValue, decString);
		displaySteps.get(stepIDindex).addStepContent(remainderCalcs);
	}

	protected void makeBaseExpansionStep(int stepID) {
		int stepIDindex = stepID - 1;
		displaySteps.get(stepIDindex).addFormattedStepHeader("step header title");
		displaySteps.get(stepIDindex).setResultStepID(stepID);
		if (currentMode.equals("PRACTICE")) {
			displaySteps.get(stepIDindex).addStepComment("PRACTICE STEP COMMENT.");
		} else {
			displaySteps.get(stepIDindex).addStepComment("SUMMARY AND TUTORIAL COMMENT");
		}
		// stepName3.addStepContent( stepContentObject? );
	}

	protected void makeRemainderEvaluationStep(int stepID) {
		int stepIDindex = stepID - 1;
		displaySteps.get(stepIDindex).addFormattedStepHeader("decimal evaluation");
		displaySteps.get(stepIDindex).setResultStepID(stepID);
		if (currentMode.equals("PRACTICE")) {
			displaySteps.get(stepIDindex).addStepComment("PRACTICE STEP COMMENT.");
		} else {
			displaySteps.get(stepIDindex).addStepComment("SUMMARY AND TUTORIAL COMMENT");
		}
		// stepName4.addStepContent( stepContentObject? );
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

	protected void fillOutBigCharTable(List<String> inputList) {
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

	protected void setCurrentMode(String mode) {
		currentMode = mode;
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