package edu.cs222.fpteachingcalculator.view;

import javafx.scene.layout.GridPane;

public class DecToBinResultDisplay extends ResultDisplay {
	public final GridPane decToBinSummaryDisplay;
	public final GridPane decToBinTutorialDisplay;
	private final ResultStep greatMultiplierStep;
	private final ResultStep remainderStep;
	private final ResultStep binRepresentStep;

	public DecToBinResultDisplay() {
		super(5);
		decToBinSummaryDisplay = summaryDisplay;
		decToBinTutorialDisplay = tutorialDisplay;
		greatMultiplierStep = displaySteps.get(0);
		remainderStep = displaySteps.get(1);
		binRepresentStep = displaySteps.get(2);
		tutorialSlideCount = 3;
	}

	public void defineDisplaySetup() {
		if (currentMode.equals("SUMMARY")) {
			setupDecToBinSummaryDisplay();
		} else if (currentMode.equals("TUTORIAL")) {
			setupDecToBinTutorialDisplay();
		}
	}

	private void setupDecToBinSummaryDisplay() {
		this.add(decToBinSummaryDisplay, 0, 0);
		makeGreatMultiplierStep(1, 2);
		makeRemainderStep(2, 2);
		makeBinRepresentStep(3);
	}

	private void setupDecToBinTutorialDisplay() {
		this.add(decToBinTutorialDisplay, 0, 0);
		slideList.add(greatMultiplierStep);
		slideList.add(remainderStep);
		slideList.add(binRepresentStep);
		makeGreatMultiplierStep(1, 2);
		makeRemainderStep(2, 2);
		makeBinRepresentStep(3);
	}
}
