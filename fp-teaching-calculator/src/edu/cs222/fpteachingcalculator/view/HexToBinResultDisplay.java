package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.layout.GridPane;

public class HexToBinResultDisplay extends ResultDisplay {
	public final GridPane hexToBinSummaryTemplate = new GridPane();
	public final GridPane hexToBinTutorialTemplate = new GridPane();
	public final GridPane hexToBinPracticeTemplate = new GridPane();
	private final ResultStep inputReprintRow = new ResultStep();
	private final ResultStep decEquivalentStep = new ResultStep();
	private final ResultStep decExpandStep = new ResultStep();
	private final ResultStep binConcateStep = new ResultStep();
	private final ResultStep binRepresentStep = new ResultStep();
	private GridPane tableOfInputValues = new GridPane();
	private GridPane decimalChars = new GridPane();
	private ExpansionGrid expansionGrid;
	private ConcatenationGrid concatenationGrid;
	private BinaryGrid binaryGrid;
	private final List<GridPane> slideList = new LinkedList<>();
	private String currentMode = "SUMMARY";

	public HexToBinResultDisplay() {
		super();
	}

	public void defineTemplateSetup(String mode) {
		currentMode = mode;
		makeInputReprintRow();
		if (currentMode.equals("SUMMARY")) {
			setupHexToBinSummaryTemplate();
		} else if (currentMode.equals("TUTORIAL")) {
			setupHexToBinTutorialTemplate();
		} else {
			setupHexToBinPracticeTemplate();
		}
		makeEmptyRow(10);
	}

	private void makeInputReprintRow() {
		inputReprintRow.setStepTitle("original input");
		inputReprintRow.setResultStepID(0);
		tableOfInputValues = makeBigCharTable();
		for (int i = 0; i < hexSymbols.size(); i++) {
			BigCharBox bigCharBox = new BigCharBox();
			tableOfInputValues.add(bigCharBox, i, 0);
			BigCharLabel bigCharLabel = new BigCharLabel(hexSymbols.get(i));
			tableOfInputValues.add(bigCharLabel, i, 0);
			bigCharLabel.overrideCharHexColor("#0066CC");
		}
		inputReprintRow.add(tableOfInputValues, 1, 0);
	}

	public void setupHexToBinSummaryTemplate() {
		this.add(hexToBinSummaryTemplate, 0, 0);
		hexToBinSummaryTemplate.setVgap(20);
		hexToBinSummaryTemplate.add(inputReprintRow, 0, 0);
		hexToBinSummaryTemplate.add(decEquivalentStep, 0, 1);
		hexToBinSummaryTemplate.add(decExpandStep, 0, 2);
		hexToBinSummaryTemplate.add(binConcateStep, 0, 3);
		hexToBinSummaryTemplate.add(binRepresentStep, 0, 4);
		makeDecEquivalentStep(1);
		makeDecExpandStep(2);
		makeBinConcateStep(3);
		makeBinRepresentStep(4);
		decEquivalentStep.setVisible(true);
		decExpandStep.setVisible(true);
		binConcateStep.setVisible(true);
		binRepresentStep.setVisible(true);
	}

	public void setupHexToBinTutorialTemplate() {
		this.add(hexToBinTutorialTemplate, 0, 0);
		hexToBinTutorialTemplate.setVgap(20);
		hexToBinTutorialTemplate.add(inputReprintRow, 0, 0);
		hexToBinTutorialTemplate.add(decEquivalentStep, 0, 1);
		hexToBinTutorialTemplate.add(decExpandStep, 0, 1);
		hexToBinTutorialTemplate.add(binConcateStep, 0, 1);
		hexToBinTutorialTemplate.add(binRepresentStep, 0, 1);
		decEquivalentStep.setVisible(true);
		decExpandStep.setVisible(false);
		binConcateStep.setVisible(false);
		binRepresentStep.setVisible(false);
		slideList.add(decEquivalentStep);
		slideList.add(decExpandStep);
		slideList.add(binConcateStep);
		slideList.add(binRepresentStep);
		makeDecEquivalentStep(1);
		makeDecExpandStep(2);
		makeBinConcateStep(3);
		makeBinRepresentStep(4);
	}

	public void setupHexToBinPracticeTemplate() {
		this.add(hexToBinPracticeTemplate, 0, 0);
		hexToBinPracticeTemplate.setVgap(20);
		hexToBinPracticeTemplate.add(inputReprintRow, 0, 0);
		hexToBinPracticeTemplate.add(decEquivalentStep, 0, 1);
		hexToBinPracticeTemplate.add(decExpandStep, 0, 1);
		hexToBinPracticeTemplate.add(binConcateStep, 0, 1);
		hexToBinPracticeTemplate.add(binRepresentStep, 0, 1);
		decEquivalentStep.setVisible(true);
		decExpandStep.setVisible(false);
		binConcateStep.setVisible(false);
		binRepresentStep.setVisible(false);
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

	public void hideSlide(int slideToHide) {
		slideList.get(slideToHide).setVisible(false);
	}

	public void displaySlide(int slideToDisplay) {
		slideList.get(slideToDisplay).setVisible(true);
	}

	public void clearHexToBinTemplates() {
		this.getChildren().clear();
		slideList.clear();
		hexToBinPracticeTemplate.getChildren().clear();
		hexToBinTutorialTemplate.getChildren().clear();
		hexToBinSummaryTemplate.getChildren().clear();
		tableOfInputValues.getChildren().clear();
		decEquivalentStep.getChildren().clear();
		decExpandStep.getChildren().clear();
		binConcateStep.getChildren().clear();
		binRepresentStep.getChildren().clear();
		decEquivalentStep.setVisible(true);
	}

	public int setTotalSlideCount(String displayMode) {
		if (displayMode.equals("PRACTICE")) {
			return 3;
		} else {
			return 4;
		}
	}
}