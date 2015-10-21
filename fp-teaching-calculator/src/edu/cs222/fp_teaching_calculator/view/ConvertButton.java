package edu.cs222.fp_teaching_calculator.view;

import org.junit.Assert;

import edu.cs222.fp_teaching_calculator.model.converter.ConversionContainer;
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
					ConversionContainer conversionContainer = hexToBin.convertHexToBin(inputValue);
					if(conversionContainer.errorCode == -1){
						System.out.println(conversionContainer.parsedListOfHexInput);
						System.out.println(conversionContainer.listOfDecimalEquivalents);
						System.out.println(conversionContainer.listOfBinaryEquivalents);
						for(int i = 0; i < conversionContainer.listOfSeparatedBinaryNibbles.size(); i++){
							for(int c = 0; c < 4; c++){
							System.out.print(conversionContainer.listOfSeparatedBinaryNibbles.get(i)[c]);
							}
							System.out.println();
						}
					}
					System.out.println("INPUT VALUE IS: " + inputValue);  //  PASS VALUE TO MODEL	 			-- TO DO
				}
			}
		});
	}
}
