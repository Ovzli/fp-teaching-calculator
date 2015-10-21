package edu.cs222.fp_teaching_calculator.view;

import edu.cs222.fp_teaching_calculator.model.converter.HexToBinConvertor;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConvertButton extends Button {

	public ConvertButton(String buttonLabel){
		super(buttonLabel);
	}
	
	
	public void handleConvert(TextField inputTarget){
		this.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
			String inputValue = inputTarget.getText();
				if(inputValue.equals("")){
					System.out.println("NO VALUE WAS ENTERED");  //  NO VALUE ENTERED ERROR			-- TO DO
				} else {
					HexToBinConvertor hexToBin = new HexToBinConvertor();
					boolean successfulConversion = hexToBin.convertHexToBin(inputValue);
					if(successfulConversion){
						System.out.println(hexToBin.parsedListOfHexInput);
						System.out.println(hexToBin.listOfDecimalEquivalents);
						System.out.println(hexToBin.listOfBinaryEquivalents);
						System.out.println(hexToBin.listOfSeparatedBinaryNibbles);
					}
					System.out.println("INPUT VALUE IS: " + inputValue);  //  PASS VALUE TO MODEL	 			-- TO DO
				}
			}
		});
	}
}
