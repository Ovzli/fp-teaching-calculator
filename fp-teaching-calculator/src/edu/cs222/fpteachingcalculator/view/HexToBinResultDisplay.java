package edu.cs222.fpteachingcalculator.view;

import javafx.scene.layout.GridPane;

public class HexToBinResultDisplay extends ResultDisplay {
	public final GridPane hexToBinSummaryDisplay;
	public final GridPane hexToBinTutorialDisplay;
	private ResultStep decEquivalentStep;
	private final ResultStep decExpandStep;
	private final ResultStep binConcateStep;
	private final ResultStep binRepresentStep;

	public HexToBinResultDisplay() {
		super(4);
		hexToBinSummaryDisplay = summaryDisplay;
		hexToBinTutorialDisplay = tutorialDisplay;
		decEquivalentStep = displaySteps.get(0);
		decExpandStep = displaySteps.get(1);
		binConcateStep = displaySteps.get(2);
		binRepresentStep = displaySteps.get(3);
		tutorialSlideCount = 4;
	}

	public void defineDisplaySetup() {
		if (currentMode.equals("SUMMARY")) {
			setupHexToBinSummaryDisplay();
		} else if (currentMode.equals("TUTORIAL")) {
			setupHexToBinTutorialDisplay();
		}
	}

	private void setupHexToBinSummaryDisplay() {
		this.add(hexToBinSummaryDisplay, 0, 0);
		makeDecEquivalentStep(1);
		makeDecExpandStep(2);
		makeBinConcateStep(3);
		makeBinRepresentStep(4);
	}

	private void setupHexToBinTutorialDisplay() {
		this.add(hexToBinTutorialDisplay, 0, 0);
		slideList.add(decEquivalentStep);
		slideList.add(decExpandStep);
		slideList.add(binConcateStep);
		slideList.add(binRepresentStep);
		makeDecEquivalentStep(1);
		makeDecExpandStep(2);
		makeBinConcateStep(3);
		makeBinRepresentStep(4);
	}
	
	private void makeDecEquivalentStep(int stepID) {
		decEquivalentStep.addFormattedStepHeader("decimal equivalents");
		decEquivalentStep.setResultStepID(stepID);
		decEquivalentStep.addStepComment(writeDecEquivalentComment());
		decEquivalentStep.addStepContent(makeBigDecimalTable());
	}

	private void makeDecExpandStep(int stepID) {
		decExpandStep.addFormattedStepHeader("decimal expansion");
		decExpandStep.setResultStepID(stepID);
		decExpandStep.addStepComment("This step shows how using 2 as base multipler can represent a "
				+ "decimal number in the form of an expanded sum algorithm. The expansions "
				+ "in red represent values of zero in the sum (not needed). The green "
				+ "expansions show values that are used in constructing the base 2 " + "value of the decimal.");
		expansionGrid = new ExpansionGrid(decValues, binDigits);
		decExpandStep.addStepContent(expansionGrid);
	}

	private void makeBinConcateStep(int stepID) {
		binConcateStep.addFormattedStepHeader("binary concatenation");
		binConcateStep.setResultStepID(stepID);
		concatenationGrid = new ConcatenationGrid(decValues);
		binConcateStep.addStepComment("This step shows how the binary multipliers in the decimal expansions "
				+ "algorithms (of the previous step) are then extracted and combined into "
				+ "expanded binary representation.");
		concatenationGrid.addTutorialContent(binDigits);
		binConcateStep.addStepContent(concatenationGrid);
	}

	public void autoComplete(int slideOnDisplay) {
		if (slideOnDisplay == 1) {
			for (int i = 0; i < hexSymbols.size(); i++) {
				answerInputFieldList.get(i).setText(decValues.get(i));
			}
		} else if (slideOnDisplay == 2) {
			for (int i = 0; i < hexSymbols.size(); i++) {
				concatenationGrid.answerInputFieldList.get(i).setText(binChars.get(i));
			}
		}
	}

	public boolean checkAnswers(int slideOnDisplay) {
		boolean allCorrect = true;
		if (slideOnDisplay == 1) {
			for (int i = 0; i < hexSymbols.size(); i++) {
				allCorrect = allCorrect && answerInputFieldList.get(i).getText().equals(decValues.get(i));
			}
		} else if (slideOnDisplay == 2) {
			for (int i = 0; i < hexSymbols.size(); i++) {
				allCorrect = allCorrect
						&& concatenationGrid.answerInputFieldList.get(i).getText().equals(binChars.get(i));
			}
		}
		return allCorrect;
	}
}