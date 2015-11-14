package edu.cs222.fpteachingcalculator.view;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class HexToBinTemplate extends DisplayTemplate{
	public SummaryTemplate H2BSummaryTemplate = new SummaryTemplate();
	public TutorialTemplate H2BTutorialTemplate = new TutorialTemplate();
	public HexToBinTemplate(){
		super();
	}
	
	public void throttleTemplate(String mode){
		if(mode.equals("SUMMARY")){
			setupHexToBinSummaryTemplate();
		} else if(mode.equals("TUTORIAL")){
			setupHexToBinTutorialTemplate();
		} else {
			setupHexToBinPracticeTemplate();
		}
	}
	
	public void setupHexToBinSummaryTemplate() {
		GridPane inputReprintRow = makeInputReprintRow();
		this.add(inputReprintRow, 0, 0);
		
		GridPane step1GP = buildStep(1, "decimal equivalents:  ");
		this.add(step1GP, 0, 1);
		Label Step1Label = addStepComment(1, "hexDecStep");
		step1GP.add(Step1Label, 1, 1);
		GridPane decimalChars = makeBigCharLabelGrid(decValues, "#9900ff");
		step1GP.add(decimalChars, 1, 2);
		
		GridPane step2GP = buildStep(2, "decimal expansion:  ");
		this.add(step2GP, 0, 2);
		Label Step2Label = addStepComment(2, "decExpansionStep");
		step2GP.add(Step2Label, 1, 1);
		GridPane expansionGrid = makeExpansionGrid(decValues);
		step2GP.add(expansionGrid, 1, 2);
		
		GridPane step3GP = buildStep(3, "binary concatenation:  ");
		this.add(step3GP, 0, 3);
		Label Step3Label = addStepComment(3, "binConcatenationStep");
		step3GP.add(Step3Label, 1, 1);
		GridPane evaluationGrid = makeEvaluationGrid(decValues);
		step3GP.add(evaluationGrid, 1, 2);
		
		GridPane step4GP = buildStep(4, "binary representation:  ");
		this.add(step4GP, 0, 4);
		Label Step4Label = addStepComment(4, "binRepresentationStep");
		step4GP.add(Step4Label, 1, 1);
		GridPane binaryGrid = makeBinaryGrid(binDigits);
		step4GP.add(binaryGrid, 1, 2);
		
		makeEmptyRow(this, 5);
	}
	
	public void setupHexToBinTutorialTemplate() {
		GridPane inputReprintRow = makeInputReprintRow();
		this.add(inputReprintRow, 0, 0);
		
		GridPane step1GP = buildStep(1, "decimal equivalents:  ");
		this.add(step1GP, 0, 1);
		Label Step1Label = addStepComment(1, "hexDecStep");
		step1GP.add(Step1Label, 1, 1);
		GridPane decimalChars = makeBigCharLabelGrid(decValues, "#9900ff");
		step1GP.add(decimalChars, 1, 2);
		
		GridPane step2GP = buildStep(2, "decimal expansion:  ");
		this.add(step2GP, 0, 2);
		Label Step2Label = addStepComment(2, "decExpansionStep");
		step2GP.add(Step2Label, 1, 1);
		GridPane expansionGrid = makeExpansionGrid(decValues);
		step2GP.add(expansionGrid, 1, 2);
		
		GridPane step3GP = buildStep(3, "binary concatenation:  ");
		this.add(step3GP, 0, 3);
		Label Step3Label = addStepComment(3, "binConcatenationStep");
		step3GP.add(Step3Label, 1, 1);
		GridPane evaluationGrid = makeEvaluationGrid(decValues);
		step3GP.add(evaluationGrid, 1, 2);
		
		GridPane step4GP = buildStep(4, "binary representation:  ");
		this.add(step4GP, 0, 4);
		Label Step4Label = addStepComment(4, "binRepresentationStep");
		step4GP.add(Step4Label, 1, 1);
		GridPane binaryGrid = makeBinaryGrid(binDigits);
		step4GP.add(binaryGrid, 1, 2);
		
		makeEmptyRow(this, 5);
	}
	
	public void setupHexToBinPracticeTemplate() {
		GridPane inputReprintRow = makeInputReprintRow();
		this.add(inputReprintRow, 0, 0);
		
		GridPane step1GP = buildStep(1, "decimal equivalents:  ");
		this.add(step1GP, 0, 1);
		Label Step1Label = addStepComment(1, "hexDecStep");
		step1GP.add(Step1Label, 1, 1);
		GridPane decimalChars = makeBigCharLabelGrid(decValues, "#9900ff");
		step1GP.add(decimalChars, 1, 2);
		
		GridPane step2GP = buildStep(2, "decimal expansion:  ");
		this.add(step2GP, 0, 2);
		Label Step2Label = addStepComment(2, "decExpansionStep");
		step2GP.add(Step2Label, 1, 1);
		GridPane expansionGrid = makeExpansionGrid(decValues);
		step2GP.add(expansionGrid, 1, 2);
		
		GridPane step3GP = buildStep(3, "binary concatenation:  ");
		this.add(step3GP, 0, 3);
		Label Step3Label = addStepComment(3, "binConcatenationStep");
		step3GP.add(Step3Label, 1, 1);
		GridPane evaluationGrid = makeEvaluationGrid(decValues);
		step3GP.add(evaluationGrid, 1, 2);
		
		GridPane step4GP = buildStep(4, "binary representation:  ");
		this.add(step4GP, 0, 4);
		Label Step4Label = addStepComment(4, "binRepresentationStep");
		step4GP.add(Step4Label, 1, 1);
		GridPane binaryGrid = makeBinaryGrid(binDigits);
		step4GP.add(binaryGrid, 1, 2);
		
		makeEmptyRow(this, 5);
	}
}
