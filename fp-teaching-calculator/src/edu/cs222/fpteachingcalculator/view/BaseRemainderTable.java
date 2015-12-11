package edu.cs222.fpteachingcalculator.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BaseRemainderTable extends GridPane {
	private int base;
	private int decValue;
	private int currentRow = 0;

	public BaseRemainderTable(int baseValue, String decString) {
		GridPane.setHalignment(this, HPos.RIGHT);
		GridPane.setValignment(this, VPos.CENTER);
		base = baseValue;
		decValue = Integer.parseInt(decString);
		//add labels
		while(decValue >= 1){
			createLine(generateLineContent(decValue));
			currentRow++;
			decValue = decValue/base;
		}
		
	}

	private List<BigCharLabel> generateLineContent(int lineValue){
		List<BigCharLabel> content = new LinkedList<>();
		content.add(new BigCharLabel(String.valueOf(lineValue)));
		if(lineValue >= 2){
			content.add(new BigCharLabel("÷"));
		}
		else{
			content.add(new BigCharLabel("<"));
		}
		content.add(new BigCharLabel(String.valueOf(base)));
		content.add(new BigCharLabel("="));
		if(lineValue >= 2){
			content.add(new BigCharLabel(String.valueOf(lineValue/base)));
		}
		else{
			BigCharLabel X = new BigCharLabel("X");
			X.setCharColor(Color.RED);
			content.add(X);
		}
		content.add(new BigCharLabel(" "));
		BigCharLabel remainder = new BigCharLabel(String.valueOf(lineValue%base));
		if(lineValue%base == 0){
			remainder.setCharColor(Color.RED);
		}
		else{
			remainder.setCharColor(Color.GREEN);
		}
		content.add(remainder);
		return content;
	}
	
	private void createLine(List<BigCharLabel> lineMembers) {
		int currentColumn = 0;
		for (BigCharLabel member : lineMembers) {
			this.add(member, currentColumn, currentRow);
			currentColumn++;
		}
	}
//
//	private void generateCell(){
//		BigCharLabel value = new BigCharLabel(String.valueOf(decValue));
//		this.
//	}

}
