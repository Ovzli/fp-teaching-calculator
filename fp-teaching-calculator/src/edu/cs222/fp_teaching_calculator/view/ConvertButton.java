package edu.cs222.fp_teaching_calculator.view;

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
					System.out.println("INPUT VALUE IS: " + inputValue);  //  PASS VALUE TO MODEL	 			-- TO DO
				}
			}
		});
	}
}
