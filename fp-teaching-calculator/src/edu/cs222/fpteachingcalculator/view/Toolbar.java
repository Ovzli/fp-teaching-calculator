package edu.cs222.fpteachingcalculator.view;

import edu.cs222.fpteachingcalculator.model.converter.ValueGenerator;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

public class Toolbar extends GridPane {
	private final ValueGenerator valueGenerator = new ValueGenerator();
	private final TextField userInputField = new TextField();
	public final Button convertButton = new Button("CONVERT");
	public final Button generateButton = new Button("GENERATE VALUE");
	public Label errorLabel = new Label("");
	private final Rectangle spacerRectangle = new Rectangle();
	private Label instructionLabel = new Label();

	public Toolbar() {
		this.getStyleClass().add("toolbar");
		this.setMaxWidth(720);
		this.setMinHeight(60);
		this.setHgap(6);
		this.setVgap(2);
		this.add(userInputField, 1, 0);
		this.setAlignment(Pos.BOTTOM_RIGHT);
		userInputField.setMinWidth(220);
		this.add(convertButton, 2, 0);
		this.add(generateButton, 3, 0);
		this.add(errorLabel, 1, 1);
		errorLabel.getStyleClass().add("errorLabel");
		GridPane.setColumnSpan(errorLabel, 3);
		spacerRectangle.setWidth(185);
		spacerRectangle.setHeight(30);
		this.add(spacerRectangle, 0, 0);
		spacerRectangle.setVisible(false);
		this.add(instructionLabel, 0, 0);
		changeInstruction("HEX");
		this.setGridLinesVisible(false);
	}

	public void changeInstruction(String inputMode) {
		String typeString;
		int symbolLength;
		if (inputMode.equals("HEX")) {
			typeString = "hexadecimal";
			symbolLength = 8;
		} else if (inputMode.equals("DEC")) {
			typeString = "decimal";
			symbolLength = 6;
		} else {
			typeString = "binary";
			symbolLength = 24;
		}
		instructionLabel.setText("Enter a " + typeString + " value:\n"
				+ "(up to " + symbolLength + " digits long) ");
	}

	public TextField addInputField() {
		TextField inputField = new TextField();
		return inputField;
	}

	public String getInputText() {
		return userInputField.getText();
	}

	public void setInputText(String inputMode) {
		String genValue;
		if(inputMode.equals("HEX")){
			genValue = valueGenerator.generateHexValue();
		} else if(inputMode.equals("DEC")){
			genValue = valueGenerator.generateDecValue();
		} else {
			genValue = valueGenerator.generateBinValue();
		}
		userInputField.setText(genValue);
	}

	public void updateErrorText(String errorMessage) {
		errorLabel.setText(errorMessage);
	}

}