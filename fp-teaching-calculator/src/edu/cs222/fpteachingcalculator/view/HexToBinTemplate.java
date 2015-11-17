package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;

import javafx.scene.layout.GridPane;

public class HexToBinTemplate extends DisplayTemplate {
	public GridPane H2BSummaryTemplate = new GridPane();
	public GridPane H2BTutorialTemplate = new GridPane();
	private TemplateStep inputReprintRow = new TemplateStep(0);
	private TemplateStep step1GP = new TemplateStep(1);
	private TemplateStep step2GP = new TemplateStep(2);
	private TemplateStep step3GP = new TemplateStep(3);
	private TemplateStep step4GP = new TemplateStep(4);
	private GridPane tableOfInputValues = new GridPane();
	private GridPane decimalChars = new GridPane();
	private ExpansionGrid expansionGrid;
	private ConcatenationGrid concatenationGrid;
	private BinaryGrid binaryGrid;
	private LinkedList<GridPane> slideList = new LinkedList<GridPane>();
	private String currentMode = "SUMMARY";

	public HexToBinTemplate() {
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
		this.add(H2BSummaryTemplate, 0, 0);
		H2BSummaryTemplate.setVgap(20);
		H2BSummaryTemplate.add(inputReprintRow, 0, 0);
		H2BSummaryTemplate.add(step1GP, 0, 1);
		H2BSummaryTemplate.add(step2GP, 0, 2);
		H2BSummaryTemplate.add(step3GP, 0, 3);
		H2BSummaryTemplate.add(step4GP, 0, 4);
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
		this.add(H2BTutorialTemplate, 0, 0);
		H2BTutorialTemplate.setVgap(20);
		H2BTutorialTemplate.add(inputReprintRow, 0, 0);
		H2BTutorialTemplate.add(step1GP, 0, 1);
		H2BTutorialTemplate.add(step2GP, 0, 1);
		H2BTutorialTemplate.add(step3GP, 0, 1);
		H2BTutorialTemplate.add(step4GP, 0, 1);
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
		H2BTutorialTemplate.getChildren().clear();
		H2BSummaryTemplate.getChildren().clear();
		tableOfInputValues.getChildren().clear();
		step1GP.getChildren().clear();
		step2GP.getChildren().clear();
		step3GP.getChildren().clear();
		step4GP.getChildren().clear();
		step1GP.setVisible(true);
	}
}