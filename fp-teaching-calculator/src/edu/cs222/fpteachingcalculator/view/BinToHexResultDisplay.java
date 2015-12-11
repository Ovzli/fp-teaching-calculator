package edu.cs222.fpteachingcalculator.view;

import javafx.scene.layout.GridPane;

public class BinToHexResultDisplay extends ResultDisplay {
	public final GridPane binToHexSummaryDisplay;
	public final GridPane binToHexTutorialDisplay;
	private final ResultStep binarySumExpandStep;
	private final ResultStep decSumStep;
	private final ResultStep hexEquivalentStep;
	private final ResultStep hexRepresentStep;
	private BinExpansionGrid binarySums;
	private DecSumGrid decSum;

	public BinToHexResultDisplay() {
		super(4);
		binToHexSummaryDisplay = summaryDisplay;
		binToHexTutorialDisplay = tutorialDisplay;
		binarySumExpandStep = displaySteps.get(0);
		decSumStep = displaySteps.get(1);
		hexEquivalentStep = displaySteps.get(2);
		hexRepresentStep = displaySteps.get(3);
		tutorialSlideCount = 4;
	}

	public void defineDisplaySetup() {
		if (currentMode.equals("SUMMARY")) {
			setupBinToHexSummaryDisplay();
		} else if (currentMode.equals("TUTORIAL")) {
			setupBinToHexTutorialDisplay();
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

	private void makeBinarySumExpansionStep(int stepID) {
		binarySumExpandStep.addFormattedStepHeader("binary sum expansion");
		binarySumExpandStep.setResultStepID(stepID);
		binarySumExpandStep.addStepComment("This step demonstrates " + "how each 4 bit binary nibble of base 2 digits "
				+ "(of the original bit string being converted) " + "represents a base 10 decimal sum expansion.");
		binarySums = new BinExpansionGrid(binDigits);
		binarySumExpandStep.addStepContent(binarySums);
	}

	private void makeDecSumStep(int stepID) {
		decSumStep.addFormattedStepHeader("decimal summation");
		decSumStep.setResultStepID(stepID);
		decSumStep.addStepComment("This step outlines how each of " + "the decimal sum expansions have been added to a "
				+ "single decimal value.");
		decSum = new DecSumGrid(binDigits, decValues);
		decSumStep.addStepContent(decSum);
	}

	private void makeHexEquivalentStep(int stepID) {
		hexEquivalentStep.addFormattedStepHeader("hexadecimal equivalencies");
		hexEquivalentStep.setResultStepID(stepID);
		hexEquivalentStep.addStepComment(
				"This step shows how each " + "decimal value is assigned a representative equivalent when "
						+ "converted. This is done through pre-determined "
						+ "representations of each individual symbol as outlined "
						+ "in the equivalency table shown to the right.");
		GridPane decimalTable = new GridPane();
		decimalTable = makeBigCharTable();
		for (int i = 0; i < decValues.size(); i++) {
			BigCharBox bigCharBox = new BigCharBox();
			decimalTable.add(bigCharBox, i, 0);
			BigCharLabel bigCharLabel = new BigCharLabel(decValues.get(i));
			decimalTable.add(bigCharLabel, i, 0);
		}
		GridPane equivalencyTable = new GridPane();
		equivalencyTable = makeBigCharTable();
		for (int i = 0; i < hexSymbols.size(); i++) {
			BigCharBox bigCharBox = new BigCharBox();
			equivalencyTable.add(bigCharBox, i, 0);
			BigCharLabel bigCharLabel = new BigCharLabel(hexSymbols.get(i));
			equivalencyTable.add(bigCharLabel, i, 0);
		}
		hexEquivalentStep.addStepContent(decimalTable);
		hexEquivalentStep.addStepPostContent(equivalencyTable);
	}

	private void makeHexRepresentStep(int stepID) {
		hexRepresentStep.addFormattedStepHeader("hexadecimal representation");
		hexRepresentStep.setResultStepID(stepID);
		hexRepresentStep.addStepComment("The final hexadecimal " + "value is now displayed.");
		String hexString = "";
		for (String value : hexSymbols) {
			hexString += value;
		}
		BigCharLabel endHexString = new BigCharLabel(hexString);
		endHexString.overrideCharHexColor("#0066CC");
		hexRepresentStep.addStepBigCharLabel(endHexString);
	}
}
