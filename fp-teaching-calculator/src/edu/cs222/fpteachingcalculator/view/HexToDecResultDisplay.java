package edu.cs222.fpteachingcalculator.view;

import javafx.scene.layout.GridPane;

public class HexToDecResultDisplay extends ResultDisplay {
	public final GridPane hexToDecSummaryDisplay;
	public final GridPane hexToDecTutorialDisplay;
	public final GridPane hexToDecPracticeDisplay;
	private final ResultStep stepName1;
	private final ResultStep stepName2;
	private final ResultStep stepName3;
	private final ResultStep stepName4;

	public HexToDecResultDisplay() {
		super(4);
		hexToDecSummaryDisplay = summaryDisplay;
		hexToDecTutorialDisplay = tutorialDisplay;
		hexToDecPracticeDisplay = practiceDisplay;
		stepName1 = displaySteps.get(0);
		stepName2 = displaySteps.get(1);
		stepName3 = displaySteps.get(2);
		stepName4 = displaySteps.get(3);
	}

	public void defineDisplaySetup(String mode) {
		currentMode = mode;
		makeHexInputReprintRow();
		if (currentMode.equals("SUMMARY")) {
			setupHexToDecSummaryDisplay();
		} else if (currentMode.equals("TUTORIAL")) {
			setupHexToDecTutorialDisplay();
		} else {
			setupHexToDecPracticeDisplay();
		}
		makeEmptyRow(10);
	}

	private void setupHexToDecPracticeDisplay() {
		this.add(hexToDecSummaryDisplay, 0, 0);
		hexToDecSummaryDisplay.add(inputReprintRow, 0, 0);
		makeStep1(1);
		makeStep2(2);
		makeStep3(3);
		makeStep4(4);
	}

	private void setupHexToDecTutorialDisplay() {
		this.add(hexToDecTutorialDisplay, 0, 0);
		slideList.add(stepName1);
		slideList.add(stepName2);
		slideList.add(stepName3);
		slideList.add(stepName4);
		makeStep1(1);
		makeStep2(2);
		makeStep3(3);
		makeStep4(4);
	}

	private void setupHexToDecSummaryDisplay() {
		this.add(hexToDecPracticeDisplay, 0, 0);
		slideList.add(stepName1);
		slideList.add(stepName2);
		slideList.add(stepName3);
		slideList.add(stepName4);
		makeStep1(1);
		makeStep2(2);
		makeStep3(3);
		makeStep4(4);
	}

	private void makeStep1(int stepID) {
		stepName1.addFormattedStepHeader("step header title");
		stepName1.setResultStepID(stepID);
		if (currentMode.equals("PRACTICE")) {
			stepName1.addStepComment("PRACTICE STEP COMMENT.");
		} else {
			stepName1.addStepComment("SUMMARY AND TUTORIAL COMMENT");
		}
		// stepName1.addStepContent( stepContentObject? );
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

	public int setTotalSlideCount(String displayMode) {
		if (displayMode.equals("PRACTICE")) {
			return 3;
		} else {
			return 4;
		}
	}

}