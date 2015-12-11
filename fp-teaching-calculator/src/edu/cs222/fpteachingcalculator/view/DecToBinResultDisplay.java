package edu.cs222.fpteachingcalculator.view;

import javafx.scene.layout.GridPane;

public class DecToBinResultDisplay extends ResultDisplay {
	public final GridPane decToBinSummaryDisplay;
	public final GridPane decToBinTutorialDisplay;
	public final GridPane decToBinPracticeDisplay;
	private final ResultStep greatMultiplierStep;
	private final ResultStep remainderStep;
	private final ResultStep baseExpansionStep;
	private final ResultStep remainderEvaluationStep;
	private final ResultStep binRepresentStep;

	public DecToBinResultDisplay() {
		super(5);
		decToBinSummaryDisplay = summaryDisplay;
		decToBinTutorialDisplay = tutorialDisplay;
		decToBinPracticeDisplay = practiceDisplay;
		greatMultiplierStep = displaySteps.get(0);
		remainderStep = displaySteps.get(1);
		baseExpansionStep = displaySteps.get(2);
		remainderEvaluationStep = displaySteps.get(3);
		binRepresentStep = displaySteps.get(4);
		tutorialSlideCount = 5;
		practiceSlideCount = 4;
	}

	public void defineDisplaySetup() {
		if (currentMode.equals("SUMMARY")) {
			setupDecToBinSummaryDisplay();
		} else if (currentMode.equals("TUTORIAL")) {
			setupDecToBinTutorialDisplay();
		} else {
			setupDecToBinPracticeDisplay();
		}
	}

	private void setupDecToBinSummaryDisplay() {
		this.add(decToBinSummaryDisplay, 0, 0);
		makeGreatMultiplierStep(1, 2);
		makeRemainderStep(2, 2);
		makeBaseExpansionStep(3, 2);
		makeRemainderEvaluationStep(4);
		makeBinRepresentStep(5);
	}

	private void setupDecToBinTutorialDisplay() {
		this.add(decToBinTutorialDisplay, 0, 0);
		slideList.add(greatMultiplierStep);
		slideList.add(remainderStep);
		slideList.add(baseExpansionStep);
		slideList.add(remainderEvaluationStep);
		slideList.add(binRepresentStep);
		makeGreatMultiplierStep(1, 2);
		makeRemainderStep(2, 2);
		makeBaseExpansionStep(3, 2);
		makeRemainderEvaluationStep(4);
		makeBinRepresentStep(5);
	}

	private void setupDecToBinPracticeDisplay() {
		this.add(decToBinPracticeDisplay, 0, 0);
		slideList.add(greatMultiplierStep);
		slideList.add(remainderStep);
		slideList.add(remainderEvaluationStep);
		slideList.add(binRepresentStep);
		makeGreatMultiplierStep(1, 2);
		makeRemainderStep(2, 2);
		makeRemainderEvaluationStep(3);
		makeBinRepresentStep(4);
	}
	
	public void autoComplete(int slideOnDisplay) {
		// TODO
	}

	public boolean checkAnswers(int i) {
		return true;
		// TODO Auto-generated method stub
		
	}

}
