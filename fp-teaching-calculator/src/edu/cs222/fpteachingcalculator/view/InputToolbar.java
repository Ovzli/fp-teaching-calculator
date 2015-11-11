package edu.cs222.fpteachingcalculator.view;

import edu.cs222.fpteachingcalculator.model.converter.ValueGenerator;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class InputToolbar extends Toolbar {
	private Label errorLabel = new Label();
	private TextField hexInputField;
	public final Button convertButton;
	public final Button generateButton;
	private final ValueGenerator valueGenerator = new ValueGenerator();

	public InputToolbar() {
		super();
		this.addInstruction("Enter a hexadecimal value:\n(up to 8 symbols long)");
		errorLabel = this.addErrorText("");
		GridPane.setColumnSpan(errorLabel, 3);
		hexInputField = this.addInputField();
		convertButton = new Button("CONVERT");
		this.add(convertButton, 2, 0);
		generateButton = new Button("GENERATE VALUE");
		this.add(generateButton, 3, 0);
		Label toLabel = makeButtonSubLabel("(TO BINARY)");
		this.add(toLabel, 2, 1);
		Label sizeLabel = makeButtonSubLabel("(3-8 SYMBOLS LONG)");
		this.add(sizeLabel, 3, 1);
	}
	
	private Label makeButtonSubLabel(String labelName){
		Label label = new Label("(TO BINARY)");
		label.getStyleClass().add("smallItalicLabel");
		GridPane.setHalignment(label, HPos.CENTER);
		return label;
	}

	public void updateErrorText(String errorMessage) {
		errorLabel.setText(errorMessage);
	}

	public String getInputText() {
		return hexInputField.getText();
	}

	public void setInputText() {
		String hexValue = valueGenerator.generateHexValue();
		hexInputField.setText(hexValue);
	}

}
