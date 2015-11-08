package edu.cs222.fpteachingcalculator.view;

import edu.cs222.fpteachingcalculator.model.converter.*;
import edu.cs222.fpteachingcalculator.model.converter.inputexceptions.*;
import edu.cs222.fpteachingcalculator.view.DisplayTemplate;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConvertButton extends Button {
	private final InputToolbar parentInputToolbar;
	private String inputValue;
	private DisplayTemplate rootDisplayGrid;

	public ConvertButton(String buttonLabel, InputToolbar parentToolbar, DisplayTemplate rootDisplay) {
		super(buttonLabel);
		parentInputToolbar = parentToolbar;
		rootDisplayGrid = rootDisplay;
	}

	public void handleConvert(TextField inputTarget) {
		this.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				inputValue = inputTarget.getText();
				parentInputToolbar.updateErrorText("");
				doConversion();
			}
		});
	}

	public void doConversion() {
		HexToBinConverter hexToBin = new HexToBinConverter();
		Conversion conversionContainer = null;
		try {
			conversionContainer = hexToBin.convertHexToBin(inputValue);
		} catch (EmptyInputException e){
			parentInputToolbar.updateErrorText("NO VALUE WAS ENTERED");
			return;
		} catch (InvalidHexSymbolException e) {
			parentInputToolbar.updateErrorText("AN INVALID CHARCTER WAS DETECTED");
			return;
		} catch (InvalidHexNumberLengthException e) {
			parentInputToolbar.updateErrorText("THE INPUT ENTERED IS TOO LONG");
			return;
		}
		rootDisplayGrid.hexSymbols = conversionContainer.getParsedListOfHexInput();
		rootDisplayGrid.decValues = conversionContainer.getListOfDecEquivalents();
		rootDisplayGrid.binDigits = conversionContainer.getListOfSeparatedBinNibbles();
		rootDisplayGrid.updateDisplay();

	}
}
