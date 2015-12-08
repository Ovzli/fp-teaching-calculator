package edu.cs222.fpteachingcalculator.view;

import javafx.scene.layout.GridPane;

public class HexToBinResultDisplay extends ResultDisplay {
	public final GridPane hexToBinSummaryDisplay;
	public final GridPane hexToBinTutorialDisplay;
	public final GridPane hexToBinPracticeDisplay;
	private final ResultStep decEquivalentStep;
	private final ResultStep decExpandStep;
	private final ResultStep binConcateStep;
	private final ResultStep binRepresentStep;

	public HexToBinResultDisplay() {
		super(4);
		hexToBinSummaryDisplay = summaryDisplay;
		hexToBinTutorialDisplay = tutorialDisplay;
		hexToBinPracticeDisplay = practiceDisplay;
		decEquivalentStep = displaySteps.get(0);
		decExpandStep = displaySteps.get(1);
		binConcateStep = displaySteps.get(2);
		binRepresentStep = displaySteps.get(3);
	}

	public void defineDisplaySetup(String mode) {
		currentMode = mode;
		makeHexInputReprintRow();
		addStepsToDisplay();
		if (currentMode.equals("SUMMARY")) {
			setupHexToBinSummaryDisplay();
		} else if (currentMode.equals("TUTORIAL")) {
			setupHexToBinTutorialDisplay();
		} else {
			setupHexToBinPracticeDisplay();
		}
		makeEmptyRow(10);
	}

	public void setupHexToBinSummaryDisplay() {
		this.add(hexToBinSummaryDisplay, 0, 0);
		makeDecEquivalentStep(1);
		makeDecExpandStep(2);
		makeBinConcateStep(3);
		makeBinRepresentStep(4);
	}

	public void setupHexToBinTutorialDisplay() {
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

	public void setupHexToBinPracticeDisplay() {
		this.add(hexToBinPracticeDisplay, 0, 0);		
		slideList.add(decEquivalentStep);
		slideList.add(binConcateStep);
		slideList.add(binRepresentStep);
		makeDecEquivalentStep(1);
		makeBinConcateStep(2);
		makeBinRepresentStep(3);
	}

	private void makeDecEquivalentStep(int stepID) {
		decEquivalentStep.addFormattedStepHeader("decimal equivalents");
		decEquivalentStep.setResultStepID(stepID);
		decimalChars = makeBigCharTable();
		for (int i = 0; i < hexSymbols.size(); i++) {
			BigCharBox bigCharBox = new BigCharBox();
			decimalChars.add(bigCharBox, i, 0);
			if (currentMode.equals("PRACTICE")) {

				// TODO - implement practice input fields here...

			} else {
				BigCharLabel bigCharLabel = new BigCharLabel(decValues.get(i));
				decimalChars.add(bigCharLabel, i, 0);
			}
		}

		if (currentMode.equals("PRACTICE")) {
			decEquivalentStep
					.addStepComment("Enter the decimal equivalents for each hexadecimal value above."
							+ "\nHINT: These are pre-determined representations.");
		} else {
			decEquivalentStep
					.addStepComment("This step shows each input symbol must be assigned a "
							+ "representative equivalent for each symbol needing "
							+ "converted. This is done through pre-determined "
							+ "representations of each individual symbol as outlined in the "
							+ "equivalency table shown to the right.");
		}
		decEquivalentStep.addStepContent(decimalChars);
	}

	private void makeDecExpandStep(int stepID) {
		decExpandStep.addFormattedStepHeader("decimal expansion");
		decExpandStep.setResultStepID(stepID);
		decExpandStep
				.addStepComment("This step shows how using 2 as base multipler can represent a "
						+ "decimal number in the form of an expanded sum algorithm. The expansions "
						+ "in red represent values of zero in the sum (not needed). The green "
						+ "expansions show values that are used in constructing the base 2 "
						+ "value of the decimal.");
		expansionGrid = new ExpansionGrid(decValues, binDigits);
		decExpandStep.addStepContent(expansionGrid);
	}

	private void makeBinConcateStep(int stepID) {
		binConcateStep.addFormattedStepHeader("binary concatenation");
		binConcateStep.setResultStepID(stepID);
		concatenationGrid = new ConcatenationGrid(decValues);
		if (currentMode.equals("PRACTICE")) {
			binConcateStep
					.addStepComment("Fill in the expanded binary digit multipliers (used in a decimal "
							+ "expansion) for each decimal value shown at the left.  "
							+ "HINT: The sum expansion at the right represents the value of "
							+ "the base 2 digits being defined.");
			concatenationGrid.addPracticeContent(binDigits);
		} else {
			binConcateStep
					.addStepComment("This step shows how the binary multipliers in the decimal expansions "
							+ "algorithms (of the previous step) are then extracted and combined into "
							+ "expanded binary representation.");
			concatenationGrid.addTutorialContent(binDigits);
		}
		binConcateStep.addStepContent(concatenationGrid);
	}

	private void makeBinRepresentStep(int stepID) {
		binRepresentStep.addFormattedStepHeader("binary representation");
		binRepresentStep.setResultStepID(stepID);
		binRepresentStep
				.addStepComment("This step shows the final binary representation rewritten as a "
						+ "binary number.");
		binaryGrid = new BinaryGrid(binDigits);
		binRepresentStep.addStepContent(binaryGrid);
	}

	public int setTotalSlideCount(String displayMode) {
		if (displayMode.equals("PRACTICE")) {
			return 3;
		} else {
			return 4;
		}
	}

}