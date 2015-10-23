package edu.cs222.fp_teaching_calculator.view;

import java.util.LinkedList;

import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class GridTemplate extends GridPane {
	public LinkedList<String> hexChars = new LinkedList<String>();
	public LinkedList<String> decChars = new LinkedList<String>();
	public LinkedList<int[]> binDigits = new LinkedList<int[]>();
	
	public GridTemplate(AnchorPane parentAP){
		super();
		parentAP.getChildren().add(this); 	
		AnchorPane.setTopAnchor(this, 0.0);
	    AnchorPane.setLeftAnchor(this, 0.0);
	    AnchorPane.setRightAnchor(this, 0.0);
		this.getStyleClass().add("displayGrid");
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(100);
        this.getColumnConstraints().add(col1);
	}
	
	public void setupHexToBinTemplate(){        
		Label testText = new Label();
	    this.add(testText, 0,0); 
		testText.setText("test\n\ntest\n\ntest\n\ntest\n\ntest\n\ntest\n\ntest\n\ntest\n\n"
				+ "test\n\ntest\n\ntest\n\ntest\n\ntest\n\ntest\n\ntest\n\n"
				+ "test\n\ntest\n\ntest\n\ntest\n\ntest\n\ntest\n\ntest\n\n");	
		this.setGridLinesVisible(true);		
	}
	
	public void updateDisplay(){
		System.out.println("UPDATE DISPLAY NOW");
		setupHexToBinTemplate();

		System.out.println(hexChars);
		System.out.println(decChars);

		for(int i = 0; i < binDigits.size(); i++){
			for(int c = 0; c < 4; c++){
				System.out.print(binDigits.get(i)[c]);
			}
			System.out.println();
		}
	}
}
