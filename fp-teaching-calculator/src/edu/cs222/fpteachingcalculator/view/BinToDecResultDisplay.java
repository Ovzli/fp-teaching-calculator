package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.layout.GridPane;

public class BinToDecResultDisplay extends ResultDisplay {
	public final GridPane binToDecSummaryDisplay;
	public final GridPane binToDecTutorialDisplay;
	public final GridPane binToDecPracticeDisplay;
	private final ResultStep binExpansionStep;
	private final ResultStep expansionProductsStep;
	private final ResultStep productSum;
	private List<String> listOfProducts = new LinkedList<>();
	private BigValueExpansion productExpansion = new BigValueExpansion();

	public BinToDecResultDisplay() {
		super(3);
		binToDecSummaryDisplay = summaryDisplay;
		binToDecTutorialDisplay = tutorialDisplay;
		binToDecPracticeDisplay = practiceDisplay;
		binExpansionStep = displaySteps.get(0);
		expansionProductsStep = displaySteps.get(1);
		productSum = displaySteps.get(2);
		tutorialSlideCount = 3;
		practiceSlideCount = 3;
	}

	public void defineDisplaySetup() {
		if (currentMode.equals("SUMMARY")) {
			setupBinToDecSummaryDisplay();
		} else if (currentMode.equals("TUTORIAL")) {
			setupBinToDecTutorialDisplay();
		} else {
			setupBinToDecPracticeDisplay();
		}
	}

	private void setupBinToDecSummaryDisplay() {
		this.add(binToDecSummaryDisplay, 0, 0);
		makeBinExpandStep(1);
		makeExpandProductStep(2);
		makeProductSumStep(3);
	}

	private void setupBinToDecTutorialDisplay() {
		this.add(binToDecTutorialDisplay, 0, 0);
		slideList.add(binExpansionStep);
		slideList.add(expansionProductsStep);
		slideList.add(productSum);
		makeBinExpandStep(1);
		makeExpandProductStep(2);
		makeProductSumStep(3);
	}

	private void setupBinToDecPracticeDisplay() {
		this.add(binToDecPracticeDisplay, 0, 0);
		slideList.add(binExpansionStep);
		slideList.add(expansionProductsStep);
		slideList.add(productSum);
		makeBinExpandStep(1);
		makeExpandProductStep(2);
		makeProductSumStep(3);
	}

	private void makeBinExpandStep(int stepID) {
		binExpansionStep.addFormattedStepHeader("binary expansion");
		binExpansionStep.setResultStepID(stepID);
		if (currentMode.equals("PRACTICE")) {
			binExpansionStep.addStepComment("Enter each exponent "
					+ "value shown for the base 2 multiplier that is "
					+ "applied to each binary digit.");
		} else {
			binExpansionStep.addStepComment("This step shows "
					+ "how each binary digit represents a weighted "
					+ "base 2 value when expanded.");
		}
		// binExpansionStep.addStepContent( binExpansion );
	}

	private void makeExpandProductStep(int stepID) {
		listOfProducts.clear();
		expansionProductsStep.addFormattedStepHeader("expansion products");
		expansionProductsStep.setResultStepID(stepID);
		if (currentMode.equals("PRACTICE")) {
			expansionProductsStep.addStepComment("PRACTICE STEP COMMENT.");
		} else {
			expansionProductsStep.addStepComment("Below is a "
					+ "sum expansion of the products of each binary "
					+ "digits value in decimal form.");

		}
		for (int i = 0; i < binChars.size(); i++) {
			double baseMultiplier = Math.pow(2, (binChars.size() - i - 1));
			double product = Integer.parseInt(binChars.get(i))
					* baseMultiplier;
			listOfProducts.add(String.valueOf((int) product));
		}
		productExpansion = new BigValueExpansion();
		productExpansion.expandBigValueCharExpansion(listOfProducts);
		productExpansion.makeSmallFonts();
		productExpansion.addPlusSigns(listOfProducts.size() - 1);
		expansionProductsStep.addStepContent(productExpansion);
	}

	public void autoComplete(int slideOnDisplay) {
		// TODO
	}

	public boolean checkAnswers(int i) {
		return true;
		// TODO

	}

}
