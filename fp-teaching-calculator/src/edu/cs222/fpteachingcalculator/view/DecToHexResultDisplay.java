package edu.cs222.fpteachingcalculator.view;

import javafx.scene.layout.GridPane;

public class DecToHexResultDisplay extends ResultDisplay {
	public final GridPane decToHexSummaryDisplay;
	public final GridPane decToHexTutorialDisplay;
	private final ResultStep greatMultiplierStep;
	private final ResultStep remainderStep;
	private final ResultStep hexEquivalentStep;

	public DecToHexResultDisplay() {
		super(5);
		decToHexSummaryDisplay = summaryDisplay;
		decToHexTutorialDisplay = tutorialDisplay;
		greatMultiplierStep = displaySteps.get(0);
		remainderStep = displaySteps.get(1);
		hexEquivalentStep = displaySteps.get(2);
		tutorialSlideCount = 3;
	}

	public void defineDisplaySetup() {
		if (currentMode.equals("SUMMARY")) {
			setupDecToHexSummaryDisplay();
		} else if (currentMode.equals("TUTORIAL")) {
			setupDecToHexTutorialDisplay();
		}
	}

	private void setupDecToHexSummaryDisplay() {
		this.add(decToHexSummaryDisplay, 0, 0);
		makeGreatMultiplierStep(1, 16);
		makeRemainderStep(2, 16);
		makeHexEquivalentStep(3);
	}

	private void setupDecToHexTutorialDisplay() {
		this.add(decToHexTutorialDisplay, 0, 0);
		slideList.add(greatMultiplierStep);
		slideList.add(remainderStep);
		slideList.add(hexEquivalentStep);
		makeGreatMultiplierStep(1, 16);
		makeRemainderStep(2, 16);
		makeHexEquivalentStep(3);
	}

	protected void makeHexEquivalentStep(int stepID) {
		hexEquivalentStep.addFormattedStepHeader("hexadecimal equivalents");
		hexEquivalentStep.setResultStepID(stepID);
		hexEquivalentStep.addStepComment("The final hexadecimal representation is shown below.");
		GridPane hexTable = new GridPane();
		hexTable = makeBigCharTable();
		for (int i = 0; i < hexSymbols.size(); i++) {
			BigCharBox bigCharBox = new BigCharBox();
			hexTable.add(bigCharBox, i, 0);
			BigCharLabel bigCharLabel = new BigCharLabel(hexSymbols.get(i));
			hexTable.add(bigCharLabel, i, 0);
			bigCharLabel.overrideCharHexColor("#0066CC");
		}
		hexEquivalentStep.addStepContent(hexTable);
	}
}
