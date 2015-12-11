package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.layout.GridPane;

public class HexToDecResultDisplay extends ResultDisplay {
	public final GridPane hexToDecSummaryDisplay;
	public final GridPane hexToDecTutorialDisplay;
	public final GridPane hexToDecPracticeDisplay;
	private ResultStep decEquivalentStep;
	private final ResultStep base16multiplyStep;
	private final ResultStep hexExpandStep;
	private final ResultStep expansionProductStep;
	private final ResultStep productSumStep;
	private HexExpansionGrid hexExpansionGrid;
	private List<String> listOfProducts = new LinkedList<>();
	private final List<String> listOfProductsOverflow = new LinkedList<>();
	private final List<ExpansionBit> listOfBase16s = new LinkedList<>();
	private BigValueExpansion base16multipliers = new BigValueExpansion();
	private BigValueExpansion productExpansion = new BigValueExpansion();

	public HexToDecResultDisplay() {
		super(5);
		hexToDecSummaryDisplay = summaryDisplay;
		hexToDecTutorialDisplay = tutorialDisplay;
		hexToDecPracticeDisplay = practiceDisplay;
		decEquivalentStep = displaySteps.get(0);
		base16multiplyStep = displaySteps.get(1);
		hexExpandStep = displaySteps.get(2);
		expansionProductStep = displaySteps.get(3);
		productSumStep = displaySteps.get(4);
		tutorialSlideCount = 5;
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
		this.add(hexToDecSummaryDisplay, 0, 0);
		makeDecEquivalentStep(1);
		makeBase16Step(2);
		makeHexExpandStep(3);
		makeCalcProductStep(4);
		makeProductSumStep(5);
	}

	private void setupHexToDecTutorialDisplay() {
		this.add(hexToDecTutorialDisplay, 0, 0);
		slideList.add(decEquivalentStep);
		slideList.add(base16multiplyStep);
		slideList.add(hexExpandStep);
		slideList.add(expansionProductStep);
		slideList.add(productSumStep);
		makeDecEquivalentStep(1);
		makeBase16Step(2);
		makeHexExpandStep(3);
		makeCalcProductStep(4);
		makeProductSumStep(5);
	}

	private void setupHexToDecPracticeDisplay() {
		this.add(hexToDecPracticeDisplay, 0, 0);
		slideList.add(decEquivalentStep);
		slideList.add(hexExpandStep);
		slideList.add(productSumStep);
		makeDecEquivalentStep(1);
		makeHexExpandStep(2);
		makeProductSumStep(3);
	}

	private void makeDecEquivalentStep(int stepID) {
		decEquivalentStep.addFormattedStepHeader("decimal equivalents");
		decEquivalentStep.setResultStepID(stepID);
		decEquivalentStep.addStepComment(writeDecEquivalentComment());
		decEquivalentStep.addStepContent(makeBigDecimalTable());
	}

	private void makeBase16Step(int stepID) {
		listOfBase16s.clear();
		base16multiplyStep.addFormattedStepHeader("base 16 multipliers");
		base16multiplyStep.setResultStepID(stepID);
		base16multiplyStep
				.addStepComment("Base 16 multipliers are assigned to each decimal "
						+ "equivalent to determine their product weight.");
		for (int i = 0; i < decValues.size(); i++) {
			listOfBase16s.add(new ExpansionBit(16));
			listOfBase16s.get(i).setExponentDigit(decValues.size() - i - 1);
			listOfBase16s.get(i).setExpansionBitHexColor("FF6600");
		}
		base16multipliers = new BigValueExpansion();
		base16multipliers.expandBigValueExpansionBits(listOfBase16s);
		base16multipliers.changeHGap(6);
		base16multiplyStep.addStepContent(base16multipliers);
	}

	private void makeHexExpandStep(int stepID) {
		hexExpandStep.addFormattedStepHeader("hexadecimal expansion");
		hexExpandStep.setResultStepID(stepID);
		hexExpansionGrid = new HexExpansionGrid(hexSymbols, decValues);
		if (currentMode.equals("PRACTICE")) {
			hexExpandStep
					.addStepComment("Enter each exponent value for the base 16 "
							+ "multiplier that is applied to each decimal equivalent.");
			hexExpansionGrid.addPracticeContent(decValues);
		} else {
			hexExpandStep
					.addStepComment("This step shows how 16 is used as base multipler to "
							+ "determine the decimal product for each decimal numeric equivalent "
							+ "to the original hexadecimal base values.");
			hexExpansionGrid.addTutorialContent(decValues);
		}
		hexExpandStep.addStepContent(hexExpansionGrid);
	}

	private void makeCalcProductStep(int stepID) {
		listOfProducts.clear();
		listOfProductsOverflow.clear();
		expansionProductStep.addFormattedStepHeader("expansion products");
		expansionProductStep.setResultStepID(stepID);
		expansionProductStep
				.addStepComment("Below is a sum expansion of the products of each "
						+ "hexadecimal symbol's value in decimal form.");
		for (int i = 0; i < decValues.size(); i++) {
			double baseMultiplier = Math.pow(16, (decValues.size() - i - 1));
			double product = Integer.parseInt(decValues.get(i))
					* baseMultiplier;
			listOfProducts.add(String.valueOf((int) product));
		}
		productExpansion = new BigValueExpansion();
		productExpansion.expandBigValueCharExpansion(listOfProducts);
		if (decValues.size() > 6) {
			productExpansion.makeSmallFonts();
		}
		productExpansion.addPlusSigns(listOfProducts.size() - 1);
		expansionProductStep.addStepContent(productExpansion);
	}

	private void makeProductSumStep(int stepID) {
		productSumStep.addFormattedStepHeader("product sum");
		productSumStep.setResultStepID(stepID);
		productSumStep
				.addStepComment("Below is the final product sum of the product expansion.");
		productSumStep.addStepBigCharLabel(new BigCharLabel(decString));
	}

	public void autoComplete(int slideOnDisplay) {
		// TODO
	}

	public boolean checkAnswers(int i) {
		return true;
		// TODO Auto-generated method stub
		
	}

}
