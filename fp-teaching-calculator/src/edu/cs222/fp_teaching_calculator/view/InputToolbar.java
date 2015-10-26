package edu.cs222.fp_teaching_calculator.view;

import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputToolbar extends Toolbar {
	private Label errorLabel = new Label();

	public InputToolbar(GridPane parentGridPane, GridTemplate displayGridPane) {
		super(parentGridPane);
		this.addInstruction("Enter a hexadecimal value:\n(up to 8 symbols long)");
		errorLabel = this.addErrorText("");
		GridPane.setColumnSpan(errorLabel, 3);
		TextField hexInputField = this.addInputField();
		ConvertButton convertButton = new ConvertButton("CONVERT", this,
				displayGridPane);
		this.add(convertButton, 2, 0);
		convertButton.handleConvert(hexInputField);

		Label toLabel = new Label("(TO DECIMAL)");
		this.add(toLabel, 2, 1);
		toLabel.getStyleClass().add("smallItalicLabel");
		GridPane.setHalignment(toLabel, HPos.CENTER);
	}

	public void updateErrorText(String errorMessage) {
		errorLabel.setText(errorMessage);
	}

}
