package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BinToHexResultDisplay extends ResultDisplay {
	public final GridPane binToHexSummaryDisplay;
	public final GridPane binToHexTutorialDisplay;
	public final GridPane binToHexPracticeDisplay;
	private final ResultStep binarySumExpandStep;
	private final ResultStep decSumStep;
	private final ResultStep hexEquivalentStep;
	private final ResultStep hexRepresentStep;
	private BinExpansionGrid binarySums;
	private List<Integer> decSums = new LinkedList<>();

	public BinToHexResultDisplay() {
		super(4);
		binToHexSummaryDisplay = summaryDisplay;
		binToHexTutorialDisplay = tutorialDisplay;
		binToHexPracticeDisplay = practiceDisplay;
		binarySumExpandStep = displaySteps.get(0);
		decSumStep = displaySteps.get(1);
		hexEquivalentStep = displaySteps.get(2);
		hexRepresentStep = displaySteps.get(3);
		tutorialSlideCount = 4;
		practiceSlideCount = 3;
	}

	public void defineDisplaySetup() {
		if (currentMode.equals("SUMMARY")) {
			setupBinToHexSummaryDisplay();
		} else if (currentMode.equals("TUTORIAL")) {
			setupBinToHexTutorialDisplay();
		} else {
			setupBinToHexPracticeDisplay();
		}
	}

	private void setupBinToHexSummaryDisplay() {
		this.add(binToHexSummaryDisplay, 0, 0);
		makeBinarySumExpansionStep(1);
		makeDecSumStep(2);
		makeHexEquivalentStep(3);
		makeHexRepresentStep(4);
	}

	private void setupBinToHexTutorialDisplay() {
		this.add(binToHexTutorialDisplay, 0, 0);
		slideList.add(binarySumExpandStep);
		slideList.add(decSumStep);
		slideList.add(hexEquivalentStep);
		slideList.add(hexRepresentStep);
		makeBinarySumExpansionStep(1);
		makeDecSumStep(2);
		makeHexEquivalentStep(3);
		makeHexRepresentStep(4);
	}

	private void setupBinToHexPracticeDisplay() {
		this.add(binToHexPracticeDisplay, 0, 0);
		slideList.add(binarySumExpandStep);
		slideList.add(hexEquivalentStep);
		slideList.add(hexRepresentStep);
		makeBinarySumExpansionStep(1);
		makeHexEquivalentStep(2);
		makeHexRepresentStep(3);
	}

	private void makeBinarySumExpansionStep(int stepID) {
		binarySumExpandStep.addFormattedStepHeader("binary sum expansion");
		binarySumExpandStep.setResultStepID(stepID);
		if (currentMode.equals("PRACTICE")) {
			binarySumExpandStep.addStepComment("Enter each decimal "
					+ "value in the base 2 sum expansion.");
		} else {
			binarySumExpandStep.addStepComment("This step demonstrates "
					+ "how each 4 bit binary nibble of base 2 digits "
					+ "(of the original bit string being converted) "
					+ "represents a base 10 decimal sum expansion.");
		}
		binarySums = new BinExpansionGrid(binDigits);
		binarySumExpandStep.addStepContent(binarySums);
	}

	private void makeDecSumStep(int stepID) {
		decSumStep.addFormattedStepHeader("decimal summation");
		decSumStep.setResultStepID(stepID);
		if (currentMode.equals("PRACTICE")) {
			decSumStep.addStepComment("PRACTICE STEP COMMENT.");
		} else {
			decSumStep.addStepComment("This step outlines how each of "
					+ "the decimal sum expansions have been added to a"
					+ "single decimal value.");
		}
		binarySums = new BinExpansionGrid(binDigits);
		decSumStep.addStepContent(binarySums);
	}

	private void makeHexEquivalentStep(int stepID) {
		hexEquivalentStep.addFormattedStepHeader("hexadecimal equivalencies");
		hexEquivalentStep.setResultStepID(stepID);
		if (currentMode.equals("PRACTICE")) {
			hexEquivalentStep.addStepComment("Enter the hexadecimal "
					+ "equivalent of each decimal value.");
		} else {
			hexEquivalentStep.addStepComment("This step shows each "
					+ "decimal value is assigned a representative equivalent "
					+ "converted. This is done through pre-determined "
					+ "representations of each individual symbol as outlined "
					+ "in the equivalency table shown to the right.");
		}
		GridPane decimalTable = new GridPane();
		decimalTable = makeBigCharTable();
		for (int i = 0; i < decValues.size(); i++) {
			BigCharBox bigCharBox = new BigCharBox();
			decimalTable.add(bigCharBox, i, 0);
			BigCharLabel bigCharLabel = new BigCharLabel(decValues.get(i));
			decimalTable.add(bigCharLabel, i, 0);
			bigCharLabel.overrideCharHexColor("#0066CC");
		}
		GridPane equivalencyTable = new GridPane();
		equivalencyTable = makeBigCharTable();
		for (int i = 0; i < hexSymbols.size(); i++) {
			BigCharBox bigCharBox = new BigCharBox();
			equivalencyTable.add(bigCharBox, i, 0);
			BigCharLabel bigCharLabel = new BigCharLabel(hexSymbols.get(i));
			equivalencyTable.add(bigCharLabel, i, 0);
			bigCharLabel.overrideCharHexColor("#0066CC");
		}
		hexEquivalentStep.addStepContent(decimalTable);
		hexEquivalentStep.addStepPostContent(equivalencyTable);
	}

	private void makeHexRepresentStep(int stepID) {
		hexRepresentStep.addFormattedStepHeader("hexadecimal representation");
		hexRepresentStep.setResultStepID(stepID);
		hexRepresentStep.addStepComment("The final hexadecimal "
				+ "value is now displayed.");
		String hexString = "";
		for(String value : hexSymbols){
			hexString += value;
		}
		BigCharLabel endHexString = new BigCharLabel(hexString);
		endHexString.setCharColor(Color.BLUE);
		hexRepresentStep.addStepBigCharLabel(endHexString);
	}

	public void autoComplete(int slideOnDisplay) {
		// TODO
	}

	public boolean checkAnswers(int i) {
		return true;
		// TODO Auto-generated method stub

	}

}
