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
	protected GridPane reprintValue = new GridPane();
	protected List<String> hexSymbols = new LinkedList<>();
	protected List<String> decValues = new LinkedList<>();
	protected List<List<Integer>> binDigits = new LinkedList<>();
	protected List<String> binChars = new LinkedList<>();
	protected List<String> individualBinChars = new LinkedList<>();
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
			BigCharLabel bigCharLabel = new BigCharLabel(decValues.get(i));
			gridPane.add(bigCharLabel, i, 0);
		}
		return gridPane;
	}

	protected void makeGreatMultiplierStep(int stepID, int baseValue) {
		int stepIDindex = stepID - 1;
		displaySteps.get(stepIDindex).addFormattedStepHeader("greatest base " + baseValue + " multiplier");
		displaySteps.get(stepIDindex).setResultStepID(stepID);
		greatMultiplier = new GreatestMultiplier(baseValue, decString);
		displaySteps.get(stepIDindex).addStepComment("This step is used to determine the greatest exponential "
				+ "multiplier of the base without going over the " + "value needing to be coverted.");
		displaySteps.get(stepIDindex).addStepContent(greatMultiplier);
	}

	protected void makeBinRepresentStep(int stepID) {
		int stepIDindex = stepID - 1;
		displaySteps.get(stepIDindex).addFormattedStepHeader("binary representation");
		displaySteps.get(stepIDindex).setResultStepID(stepID);
		displaySteps.get(stepIDindex)
				.addStepComment("This step shows the final binary " + "representation rewritten as a binary number.");
		binaryGrid = new BinaryGrid(binDigits);
		displaySteps.get(stepIDindex).addStepContent(binaryGrid);
	}

	protected void makeRemainderStep(int stepID, int baseValue) {
		int stepIDindex = stepID - 1;
		displaySteps.get(stepIDindex).addFormattedStepHeader("calculate remainders");
		displaySteps.get(stepIDindex).setResultStepID(stepID);
		remainderCalcs = new BaseRemainderTable(baseValue, decString);
		displaySteps.get(stepIDindex).addStepComment(
				"This step shows using arithmetic to find the remainders of the original value when divided by its base, to show the values of the characters.");
		createRemainders(baseValue);
		remainderCalcs.insertRemainderValue(remainders);
		displaySteps.get(stepIDindex).addStepContent(remainderCalcs);
	}

	private void createRemainders(int baseValue) {
		remainders.clear();
		int value = Integer.valueOf(decString);
		while (value > 0) {
			remainders.add(0, value % baseValue);
			value = value / baseValue;
		}
	}

	protected void makeProductSumStep(int stepID) {
		int stepIDindex = stepID - 1;
		displaySteps.get(stepIDindex).addFormattedStepHeader("product sum");
		displaySteps.get(stepIDindex).setResultStepID(stepID);
		displaySteps.get(stepIDindex).addStepComment("Below is the final product sum of the product expansion.");
		BigCharLabel productSumLabel = new BigCharLabel(decString);
		productSumLabel.overrideCharHexColor("#0066CC");
		displaySteps.get(stepIDindex).addStepBigCharLabel(productSumLabel);
	}

	protected String writeDecEquivalentComment() {
		return "This step shows each input symbol must be assigned a "
				+ "representative equivalent for each symbol needing "
				+ "converted. This is done through pre-determined "
				+ "representations of each individual symbol as outlined in the "
				+ "equivalency table shown to the right.";
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
		return tutorialSlideCount;

	}

	public void hideSlide(int slideToHide) {
		slideList.get(slideToHide).setVisible(false);
	}

	public void displaySlide(int slideToDisplay) {
		slideList.get(slideToDisplay).setVisible(true);
	}

}