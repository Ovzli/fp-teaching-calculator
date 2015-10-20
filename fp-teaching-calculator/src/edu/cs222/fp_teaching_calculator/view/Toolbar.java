package edu.cs222.fp_teaching_calculator.view;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class Toolbar extends GridPane {
	
	public Toolbar(GridPane parentGP){
		parentGP.add(this, 0, 1);
		this.getStyleClass().add("toolbar");
		this.setMinWidth(500);
		this.setMinHeight(100);
		this.setHgap(6);
		this.setVgap(2);
		this.setGridLinesVisible(false);
	}
	
	public void addInstruction(String labelName){
		Label label = new Label(labelName);
		this.add(label, 0, 0);
		label.getStyleClass().add("boldedLabel");		
	}
	
	public TextField addInputField(){
		TextField inputField = new TextField();
		this.add(inputField, 1,0);
		inputField.setMaxWidth(160);
		return inputField;
	}

}
