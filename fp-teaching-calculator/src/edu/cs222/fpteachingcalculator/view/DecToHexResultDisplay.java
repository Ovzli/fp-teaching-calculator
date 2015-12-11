package edu.cs222.fpteachingcalculator.view;

import javafx.scene.layout.GridPane;

public class DecToHexResultDisplay extends ResultDisplay {
	public final GridPane decToHexSummaryDisplay;
	public final GridPane decToHexTutorialDisplay;
	public final GridPane decToHexPracticeDisplay;
	private final ResultStep greatMultiplierStep;
	private final ResultStep stepName2;
	private final ResultStep stepName3;
	private final ResultStep stepName4;

	public DecToHexResultDisplay() {
		super(4);
		decToHexSummaryDisplay = summaryDisplay;
		decToHexTutorialDisplay = tutorialDisplay;
		decToHexPracticeDisplay = practiceDisplay;
		greatMultiplierStep = displaySteps.get(0);
		stepName2 = displaySteps.get(1);
		stepName3 = displaySteps.get(2);
		stepName4 = displaySteps.get(3);
		tutorialSlideCount = 4;
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
		makeStep2(2);
		makeStep3(3);
		makeStep4(4);
	}

	private void setupDecToHexTutorialDisplay() {
		this.add(decToHexTutorialDisplay, 0, 0);
		slideList.add(greatMultiplierStep);
		slideList.add(stepName2);
		slideList.add(stepName3);
		slideList.add(stepName4);
		makeGreatMultiplierStep(1, 16);
		makeStep2(2);
		makeStep3(3);
		makeStep4(4);
	}

	private void setupDecToHexPracticeDisplay() {
		this.add(decToHexPracticeDisplay, 0, 0);
		slideList.add(greatMultiplierStep);
		slideList.add(stepName2);
		slideList.add(stepName3);
		slideList.add(stepName4);
		makeGreatMultiplierStep(1, 16);
		makeStep2(2);
		makeStep3(3);
		makeStep4(4);
	}

	private void makeStep2(int stepID) {
		stepName2.addFormattedStepHeader("step header title");
		stepName2.setResultStepID(stepID);
		if (currentMode.equals("PRACTICE")) {
			stepName2.addStepComment("PRACTICE STEP COMMENT.");
		} else {
			stepName2.addStepComment("SUMMARY AND TUTORIAL COMMENT");
		}
		// stepName2.addStepContent( stepContentObject? );
	}

	private void makeStep3(int stepID) {
		stepName3.addFormattedStepHeader("step header title");
		stepName3.setResultStepID(stepID);
		if (currentMode.equals("PRACTICE")) {
			stepName3.addStepComment("PRACTICE STEP COMMENT.");
		} else {
			stepName3.addStepComment("SUMMARY AND TUTORIAL COMMENT");
		}
		// stepName3.addStepContent( stepContentObject? );
	}

	private void makeStep4(int stepID) {
		stepName4.addFormattedStepHeader("step header title");
		stepName4.setResultStepID(stepID);
		if (currentMode.equals("PRACTICE")) {
			stepName4.addStepComment("PRACTICE STEP COMMENT.");
		} else {
			stepName4.addStepComment("SUMMARY AND TUTORIAL COMMENT");
		}
		// stepName4.addStepContent( stepContentObject? );
	}
	
	public void autoComplete(int slideOnDisplay) {
		// TODO
	}

	public boolean checkAnswers(int i) {
		return true;
		// TODO Auto-generated method stub
		
	}
}
