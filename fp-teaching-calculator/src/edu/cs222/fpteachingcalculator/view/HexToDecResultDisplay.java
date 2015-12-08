package edu.cs222.fpteachingcalculator.view;

import javafx.scene.layout.GridPane;

public class HexToDecResultDisplay extends ResultDisplay {
	public final GridPane hexToDecSummaryDisplay;
	public final GridPane hexToDecTutorialDisplay;
	public final GridPane hexToDecPracticeDisplay;
	private ResultStep decEquivalentStep;
	private final ResultStep stepName2;
	private final ResultStep stepName3;
	private final ResultStep stepName4;

	public HexToDecResultDisplay() {
		super(4);
		hexToDecSummaryDisplay = summaryDisplay;
		hexToDecTutorialDisplay = tutorialDisplay;
		hexToDecPracticeDisplay = practiceDisplay;
		decEquivalentStep = displaySteps.get(0);
		stepName2 = displaySteps.get(1);
		stepName3 = displaySteps.get(2);
		stepName4 = displaySteps.get(3);
		tutorialSlideCount = 4;
		practiceSlideCount = 3;
	}

	public void defineDisplaySetup() {
		if (currentMode.equals("SUMMARY")) {
			setupHexToDecSummaryDisplay();
		} else if (currentMode.equals("TUTORIAL")) {
			setupHexToDecTutorialDisplay();
		} else {
			setupHexToDecPracticeDisplay();
		}
	}

	private void setupHexToDecSummaryDisplay() {
		this.add(hexToDecSummaryDisplay, 0, 0);;
		makeDecEquivalentStep(1);
		makeStep2(2);
		makeStep3(3);
		makeStep4(4);
	}

	private void setupHexToDecTutorialDisplay() {
		this.add(hexToDecTutorialDisplay, 0, 0);
		slideList.add(decEquivalentStep);
		slideList.add(stepName2);
		slideList.add(stepName3);
		slideList.add(stepName4);
		makeDecEquivalentStep(1);
		makeStep2(2);
		makeStep3(3);
		makeStep4(4);
	}

	private void setupHexToDecPracticeDisplay() {
		this.add(hexToDecPracticeDisplay, 0, 0);
		slideList.add(decEquivalentStep);
		slideList.add(stepName2);
		slideList.add(stepName3);
		slideList.add(stepName4);
		makeDecEquivalentStep(1);
		makeStep2(2);
		makeStep3(3);
		makeStep4(4);
	}

	private void makeDecEquivalentStep(int stepID) {
		decEquivalentStep.addFormattedStepHeader("decimal equivalents");
		decEquivalentStep.setResultStepID(stepID);
		decEquivalentStep.addStepComment(writeDecEquivalentComment());
		decEquivalentStep.addStepContent(makeBigDecimalTable());
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

}
