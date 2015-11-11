package edu.cs222.fpteachingcalculator.view;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputToolbar extends Toolbar {
	private Label errorLabel = new Label();
	private TextField hexInputField;
	public final Button convertButton;
	
	public InputToolbar() {
		super();
		this.addInstruction("Enter a hexadecimal value:\n(up to 8 symbols long)");
		errorLabel = this.addErrorText("");
		GridPane.setColumnSpan(errorLabel, 3);
		hexInputField = this.addInputField();
		convertButton = new Button("CONVERT");
		this.add(convertButton, 2, 0);
		Label toLabel = new Label("(TO BINARY)");
		this.add(toLabel, 2, 1);
		toLabel.getStyleClass().add("smallItalicLabel");
		GridPane.setHalignment(toLabel, HPos.CENTER);
	}

	public void updateErrorText(String errorMessage) {
		errorLabel.setText(errorMessage);
	}
	
	public String getInputText(){
		return hexInputField.getText();
	}

}
