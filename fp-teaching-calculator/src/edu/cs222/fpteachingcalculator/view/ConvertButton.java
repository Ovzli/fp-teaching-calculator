package edu.cs222.fpteachingcalculator.view;

import edu.cs222.fpteachingcalculator.model.converter.Conversion;
import edu.cs222.fpteachingcalculator.model.converter.HexToBinConverter;
import edu.cs222.fpteachingcalculator.view.DisplayTemplate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConvertButton extends Button {
	private final InputToolbar parentInputToolbar;
	private final ErrorLibrary errorLibrary = new ErrorLibrary();
	private String inputValue;
	private DisplayTemplate rootDisplayGrid;

	public ConvertButton(String buttonLabel, InputToolbar parentToolbar,
			DisplayTemplate rootDisplay) {
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
					parentInputToolbar.updateErrorText(errorLibrary
							.readErrorMessage(0));
				} else {
					doConversion();
				}
			}
		});
	}

	public void doConversion() {
		HexToBinConverter hexToBin = new HexToBinConverter();
		Conversion conversionContainer = hexToBin
				.convertHexToBin(inputValue);
		if (conversionContainer.errorOccurred) {
			parentInputToolbar.updateErrorText(errorLibrary
					.readErrorMessage(conversionContainer.errorCode));
		} else {
			rootDisplayGrid.hexSymbols = conversionContainer.parsedListOfHexInput;
			rootDisplayGrid.decValues = conversionContainer.listOfDecEquivalents;
			rootDisplayGrid.binDigits = conversionContainer.listOfSeparatedBinNibbles;
			rootDisplayGrid.updateDisplay();
		}
	}
}
