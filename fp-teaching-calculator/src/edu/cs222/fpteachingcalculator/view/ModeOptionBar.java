package edu.cs222.fpteachingcalculator.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;

public class ModeOptionBar extends GridPane {
	public final RadioButton summaryModeRadio = new RadioButton();
	public final RadioButton tutorialModeRadio = new RadioButton();
	public final RadioButton practiceModeRadio = new RadioButton();

	public ModeOptionBar() {
		formatModeOptionGridPane();
		formatRadios();
		Label modeSelectTitle = makeModeLabel("MODE SELECT:   ");
		this.add(modeSelectTitle, 0, 0);
		this.setGridLinesVisible(false);
	}

	private void formatModeOptionGridPane() {
		this.getStyleClass().add("modeOptionPane");
		this.setMinWidth(600);
		this.setHgap(4);
		this.setAlignment(Pos.TOP_LEFT);
	}

	private void formatRadios() {
		summaryModeRadio.setText("SUMMARY  ");
		this.add(summaryModeRadio, 1, 0);
		summaryModeRadio.setAlignment(Pos.TOP_RIGHT);
		tutorialModeRadio.setText("TUTORIAL  ");
		this.add(tutorialModeRadio, 2, 0);
		tutorialModeRadio.setAlignment(Pos.TOP_RIGHT);
		practiceModeRadio.setText("PRACTICE  ");
		this.add(practiceModeRadio, 3, 0);
		practiceModeRadio.setAlignment(Pos.TOP_RIGHT);
		summaryModeRadio.setSelected(true);
		practiceModeRadio.setDisable(true);
	}

	private Label makeModeLabel(String labelName) {
		Label label = new Label(labelName);
		label.getStyleClass().add("boldedLabel");
		return label;
	}

}
