package edu.cs222.fpteachingcalculator.view;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class HexToBinTemplate extends DisplayTemplate {
	public SummaryTemplate H2BSummaryTemplate = new SummaryTemplate();
	public TutorialTemplate H2BTutorialTemplate = new TutorialTemplate();
	private String currentMode;

	public HexToBinTemplate() {
		super();
	}

	public void defineTemplateSetup(String mode) {
		currentMode = mode;
		if (currentMode.equals("SUMMARY")) {
			setupHexToBinSummaryTemplate();
		} else if (currentMode.equals("TUTORIAL")) {
			setupHexToBinTutorialTemplate();
		} else {
			setupHexToBinPracticeTemplate();
		}
	}

	public void setupHexToBinSummaryTemplate() {
		H2BSummaryTemplate.getChildren().clear();
		this.add(H2BSummaryTemplate, 0, 0);
		H2BSummaryTemplate.addInputReprintRow(makeInputReprintRow());
		H2BSummaryTemplate.addStepRow(makeStep1Pane());
		H2BSummaryTemplate.addStepRow(makeStep2Pane());
		H2BSummaryTemplate.addStepRow(makeStep3Pane());
		H2BSummaryTemplate.addStepRow(makeStep4Pane());
		makeEmptyRow(5);
	}

	public void setupHexToBinTutorialTemplate() {
		H2BTutorialTemplate.getChildren().clear();
		this.add(H2BTutorialTemplate, 0, 0);
		H2BTutorialTemplate.clearSlideList();
		H2BTutorialTemplate.addInputReprintRow(makeInputReprintRow());
		H2BTutorialTemplate.addStepSlide(makeStep1Pane());
		H2BTutorialTemplate.addStepSlide(makeStep2Pane());
		H2BTutorialTemplate.addStepSlide(makeStep3Pane());
		H2BTutorialTemplate.addStepSlide(makeStep4Pane());
		makeEmptyRow(5);
	}

	public void setupHexToBinPracticeTemplate() {
		// TO DO (NEXT USER STORY)
	}

	private GridPane makeStep1Pane() {
		GridPane step1GP = buildStep(1, "decimal equivalents:  ");
		String comment = "shows each input symbol must be assigned a "
				+ "representative equivalent for each symbol needing "
				+ "converted. This is done through pre-determined "
				+ "representations of each individual symbol as outlined in the "
				+ "equivalency table shown to the right.";
		Label Step1Label = addStepComment(1, comment);
		step1GP.add(Step1Label, 1, 1);
		GridPane decimalChars = makeBigCharLabelGrid(decValues);
		step1GP.add(decimalChars, 1, 2);
		return step1GP;
	}

	private GridPane makeStep2Pane() {
		GridPane step2GP = buildStep(2, "decimal expansion:  ");
		String comment = "shows how using 2 as base multipler can represent a decimal number "
				+ "in the form of an expanded sum algorithm. The expansions in "
				+ "red represent values of zero in the sum (not needed). The green "
				+ "expansions show values that are used in constructing the base 2 " + "value of the decimal.";
		Label Step2Label = addStepComment(2, comment);
		step2GP.add(Step2Label, 1, 1);
		GridPane expansionGrid = makeExpansionGrid(decValues);
		step2GP.add(expansionGrid, 1, 2);
		return step2GP;
	}

	private GridPane makeStep3Pane() {
		GridPane step3GP = buildStep(3, "binary concatenation:  ");
		String comment = "shows how the binary multipliers in the decimal expansions algorithms "
				+ "(of the previous step) are then extracted and combined into " + "expanded binary representation.";
		Label Step3Label = addStepComment(3, comment);
		step3GP.add(Step3Label, 1, 1);
		GridPane evaluationGrid = makeEvaluationGrid(decValues);
		step3GP.add(evaluationGrid, 1, 2);
		return step3GP;
	}

	private GridPane makeStep4Pane() {
		GridPane step4GP = buildStep(4, "binary representation:  ");
		String comment = "shows the final binary representation rewritten as a binary number.";
		Label Step4Label = addStepComment(4, comment);
		step4GP.add(Step4Label, 1, 1);
		GridPane binaryGrid = makeBinaryGrid(binDigits);
		step4GP.add(binaryGrid, 1, 2);
		return step4GP;
	}

	public void hideSlide(int slideToHide) {
		if (currentMode.equals("TUTORIAL")) {
			H2BTutorialTemplate.slideList.get(slideToHide).setVisible(false);
		} else {
			// TODO (NEXT USER STORY)
		}
	}

	public void displaySlide(int slideToDisplay) {
		if (currentMode.equals("TUTORIAL")) {
			H2BTutorialTemplate.slideList.get(slideToDisplay).setVisible(true);
		} else {
			// TODO (NEXT USER STORY)
		}
	}
}