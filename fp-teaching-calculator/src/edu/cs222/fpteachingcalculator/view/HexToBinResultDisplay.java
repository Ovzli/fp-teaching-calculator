package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.layout.GridPane;

public class HexToBinResultDisplay extends ResultDisplay {
	public final GridPane hexToBinSummaryTemplate = new GridPane();
	public final GridPane hexToBinTutorialTemplate = new GridPane();
	private final ResultStep inputReprintRow = new ResultStep(0);
	private final ResultStep step1GP = new ResultStep(1);
	private final ResultStep step2GP = new ResultStep(2);
	private final ResultStep step3GP = new ResultStep(3);
	private final ResultStep step4GP = new ResultStep(4);
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
		}
	}

	private void makeInputReprintRow() {
		inputReprintRow.setStepTitle("original input");
		tableOfInputValues = makeBigCharTable();
		for (int i = 0; i < hexSymbols.size(); i++) {
			BigCharBox bigCharBox = new BigCharBox();
			tableOfInputValues.add(bigCharBox, i, 0);
			BigCharLabel bigCharLabel = new BigCharLabel(hexSymbols.get(i));
			tableOfInputValues.add(bigCharLabel, i, 0);
			bigCharLabel.overrideCharColor("#0066CC");
		}
		inputReprintRow.add(tableOfInputValues, 1, 0);
	}

	public void setupHexToBinSummaryTemplate() {
		this.add(hexToBinSummaryTemplate, 0, 0);
		hexToBinSummaryTemplate.setVgap(20);
		hexToBinSummaryTemplate.add(inputReprintRow, 0, 0);
		hexToBinSummaryTemplate.add(step1GP, 0, 1);
		hexToBinSummaryTemplate.add(step2GP, 0, 2);
		hexToBinSummaryTemplate.add(step3GP, 0, 3);
		hexToBinSummaryTemplate.add(step4GP, 0, 4);
		makeStep1Pane();
		makeStep2Pane();
		makeStep3Pane();
		makeStep4Pane();
		makeEmptyRow(5);
		step1GP.setVisible(true);
		step2GP.setVisible(true);
		step3GP.setVisible(true);
		step4GP.setVisible(true);
	}

	public void setupHexToBinTutorialTemplate() {
		this.add(hexToBinTutorialTemplate, 0, 0);
		hexToBinTutorialTemplate.setVgap(20);
		hexToBinTutorialTemplate.add(inputReprintRow, 0, 0);
		hexToBinTutorialTemplate.add(step1GP, 0, 1);
		hexToBinTutorialTemplate.add(step2GP, 0, 1);
		hexToBinTutorialTemplate.add(step3GP, 0, 1);
		hexToBinTutorialTemplate.add(step4GP, 0, 1);
		step1GP.setVisible(true);
		step2GP.setVisible(false);
		step3GP.setVisible(false);
		step4GP.setVisible(false);
		slideList.add(step1GP);
		slideList.add(step2GP);
		slideList.add(step3GP);
		slideList.add(step4GP);
		makeStep1Pane();
		makeStep2Pane();
		makeStep3Pane();
		makeStep4Pane();
		makeEmptyRow(5);
	}

	private void makeStep1Pane() {
		step1GP.addFormattedStepHeader("decimal equivalents");
		step1GP.addStepComment("shows each input symbol must be assigned a "
				+ "representative equivalent for each symbol needing "
				+ "converted. This is done through pre-determined "
				+ "representations of each individual symbol as outlined in the "
				+ "equivalency table shown to the right.");
		decimalChars = makeBigCharTable();
		for (int i = 0; i < hexSymbols.size(); i++) {
			BigCharBox bigCharBox = new BigCharBox();
			decimalChars.add(bigCharBox, i, 0);
			BigCharLabel bigCharLabel = new BigCharLabel(decValues.get(i));
			decimalChars.add(bigCharLabel, i, 0);
		}
		step1GP.addStepContent(decimalChars);
	}

	private void makeStep2Pane() {
		step2GP.addFormattedStepHeader("decimal expansion");
		step2GP.addStepComment("shows how using 2 as base multipler can represent a decimal number "
				+ "in the form of an expanded sum algorithm. The expansions in "
				+ "red represent values of zero in the sum (not needed). The green "
				+ "expansions show values that are used in constructing the base 2 "
				+ "value of the decimal.");
		expansionGrid = new ExpansionGrid(decValues, binDigits);
		step2GP.addStepContent(expansionGrid);
	}

	private void makeStep3Pane() {
		step3GP.addFormattedStepHeader("binary concatenation");
		step3GP.addStepComment("shows how the binary multipliers in the decimal expansions algorithms "
				+ "(of the previous step) are then extracted and combined into "
				+ "expanded binary representation.");
		concatenationGrid = new ConcatenationGrid(decValues, binDigits);
		step3GP.addStepContent(concatenationGrid);
	}

	private void makeStep4Pane() {
		step4GP.addFormattedStepHeader("binary representation");
		step4GP.addStepComment("shows the final binary representation rewritten as a binary number.");
		binaryGrid = new BinaryGrid(binDigits);
		step4GP.addStepContent(binaryGrid);
	}

	public void hideSlide(int slideToHide) {
		if (currentMode.equals("TUTORIAL")) {
			slideList.get(slideToHide).setVisible(false);
		}
	}

	public void displaySlide(int slideToDisplay) {
		if (currentMode.equals("TUTORIAL")) {
			slideList.get(slideToDisplay).setVisible(true);
		}
	}

	public void clearHexToBinTemplates() {
		this.getChildren().clear();
		slideList.clear();
		hexToBinTutorialTemplate.getChildren().clear();
		hexToBinSummaryTemplate.getChildren().clear();
		tableOfInputValues.getChildren().clear();
		step1GP.getChildren().clear();
		step2GP.getChildren().clear();
		step3GP.getChildren().clear();
		step4GP.getChildren().clear();
		step1GP.setVisible(true);
	}
}