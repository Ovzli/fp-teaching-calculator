package edu.cs222.fpteachingcalculator.view;

import javafx.scene.layout.GridPane;

public class DecToHexResultDisplay extends ResultDisplay {
	public final GridPane decToHexSummaryDisplay;
	public final GridPane decToHexTutorialDisplay;
	public final GridPane decToHexPracticeDisplay;
	private final ResultStep greatMultiplierStep;
	private final ResultStep remainderStep;
	private final ResultStep baseExpansionStep;
	private final ResultStep remainderEvaluationStep;
	private final ResultStep hexEquivalentStep;

	public DecToHexResultDisplay() {
		super(5);
		decToHexSummaryDisplay = summaryDisplay;
		decToHexTutorialDisplay = tutorialDisplay;
		decToHexPracticeDisplay = practiceDisplay;
		greatMultiplierStep = displaySteps.get(0);
		remainderStep = displaySteps.get(1);
		baseExpansionStep = displaySteps.get(2);
		remainderEvaluationStep = displaySteps.get(3);
		hexEquivalentStep = displaySteps.get(4);
		tutorialSlideCount = 5;
		practiceSlideCount = 3;
	}

	public void defineDisplaySetup() {
		if (currentMode.equals("SUMMARY")) {
			setupDecToHexSummaryDisplay();
		} else if (currentMode.equals("TUTORIAL")) {
			setupDecToHexTutorialDisplay();
		} else {
			setupDecToHexPracticeDisplay();
		}
	}

	private void setupDecToHexSummaryDisplay() {
		this.add(decToHexSummaryDisplay, 0, 0);
		makeGreatMultiplierStep(1, 16);
		makeRemainderStep(2, 16);
		makeBaseExpansionStep(3, 16);
		makeRemainderEvaluationStep(4);
		makeHexEquivalentStep(5);
	}

	private void setupDecToHexTutorialDisplay() {
		this.add(decToHexTutorialDisplay, 0, 0);
		slideList.add(greatMultiplierStep);
		slideList.add(remainderStep);
		slideList.add(baseExpansionStep);
		slideList.add(remainderEvaluationStep);
		makeGreatMultiplierStep(1, 16);
		makeRemainderStep(2, 16);
		makeBaseExpansionStep(3, 16);
		makeRemainderEvaluationStep(4);
		makeHexEquivalentStep(5);
	}

	private void setupDecToHexPracticeDisplay() {
		this.add(decToHexPracticeDisplay, 0, 0);
		slideList.add(greatMultiplierStep);
		slideList.add(remainderStep);
		slideList.add(baseExpansionStep);
		slideList.add(remainderEvaluationStep);
		makeGreatMultiplierStep(1, 16);
		makeRemainderStep(2, 16);
		makeBaseExpansionStep(3, 16);
		makeRemainderEvaluationStep(4);
		makeHexEquivalentStep(5);
	}

	protected void makeHexEquivalentStep(int stepID) {
		hexEquivalentStep.addFormattedStepHeader("hexadecimal equivalents");
		hexEquivalentStep.setResultStepID(stepID);
		if (currentMode.equals("PRACTICE")) {
			hexEquivalentStep.addStepComment("PRACTICE STEP COMMENT.");
		} else {
			hexEquivalentStep.addStepComment("SUMMARY AND TUTORIAL COMMENT");
		}
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

	public void autoComplete(int slideOnDisplay) {
		// TODO
	}

	public boolean checkAnswers(int i) {
		return true;
		// TODO Auto-generated method stub

	}
}
