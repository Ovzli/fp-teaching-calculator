package edu.cs222.fp_teaching_calculator.view;

import edu.cs222.fp_teaching_calculator.model.converter.ConversionContainer;
import edu.cs222.fp_teaching_calculator.model.converter.HexToBinConvertor;
import edu.cs222.fp_teaching_calculator.view.GridTemplate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConvertButton extends Button {
	private final InputToolbar parentInputToolbar;
	private final ErrorLibrary errorLibrary = new ErrorLibrary();
	private String inputValue;
	private GridTemplate rootDisplayGrid;

	public ConvertButton(String buttonLabel, InputToolbar parentToolbar, GridTemplate rootDisplay) {
		super(buttonLabel);
		parentInputToolbar = parentToolbar;
		rootDisplayGrid = rootDisplay;
	}

	public void handleConvert(TextField inputTarget) {
		this.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				inputValue = inputTarget.getText();
				parentInputToolbar.updateErrorText("");
				if (inputValue.equals("")) {
					parentInputToolbar.updateErrorText(errorLibrary.readErrorMessage(0));
				} else {
					doConversion();
				}
			}
		});
	}

	public void doConversion() {
		HexToBinConvertor hexToBin = new HexToBinConvertor();
		ConversionContainer conversionContainer = hexToBin.convertHexToBin(inputValue);
		if (conversionContainer.errorOccurred) {
			parentInputToolbar.updateErrorText(errorLibrary.readErrorMessage(conversionContainer.errorCode));
		} else {
			rootDisplayGrid.hexSymbols = conversionContainer.parsedListOfHexInput;
			rootDisplayGrid.decValues = conversionContainer.listOfDecEquivalents;
			rootDisplayGrid.binDigits = conversionContainer.listOfSeparatedBinNibbles;
			rootDisplayGrid.updateDisplay();
		}
	}
}
