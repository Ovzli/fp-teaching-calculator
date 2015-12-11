package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BaseRemainderTable extends GridPane {
	private int base;
	private int decValue;
	private int finalRowTotal = 0;
	public final List<TextField> answerInputFieldList = new LinkedList<>();
	public final List<String> carryValues = new LinkedList<>();
	public final List<String> remainderValues = new LinkedList<>();

	public BaseRemainderTable(int baseValue, String decString) {
		GridPane.setHalignment(this, HPos.RIGHT);
		GridPane.setValignment(this, VPos.CENTER);
		base = baseValue;
		decValue = Integer.parseInt(decString);
		SmallCharLabel arithmeticTitle = new SmallCharLabel("arithmetic");
		this.add(arithmeticTitle, 0, 0);
		GridPane.setColumnSpan(arithmeticTitle, 4);
		SmallCharLabel remainderTitle = new SmallCharLabel("remainder");
		this.add(remainderTitle, 5, 0);
		remainderTitle.setCharColor(Color.GREEN);
		carryValues.add(decString);
		int newCarry;
		while (decValue >= 1) {
			newCarry = decValue / base;
			remainderValues.add(Integer.toString(decValue % base));
			carryValues.add(Integer.toString(newCarry));
			decValue = newCarry;
			finalRowTotal++;
		}
		for (int i = 1; i < finalRowTotal; i++) {
			this.add(new SmallCharLabel(carryValues.get(i - 1)), 0, i);
			this.add(new SmallCharLabel("÷"), 1, i);
			this.add(new SmallCharLabel(Integer.toString(base)), 2, i);
			this.add(new SmallCharLabel("="), 3, i);
			this.add(new SmallCharLabel(carryValues.get(i)), 4, i);
		}
		this.add(new SmallCharLabel(carryValues.get(finalRowTotal - 1)), 0, finalRowTotal);
		this.add(new SmallCharLabel(Integer.toString(base)), 2, finalRowTotal);
		this.add(new SmallCharLabel("="), 3, finalRowTotal);
		if (Integer.parseInt(carryValues.get(finalRowTotal - 1)) < base) {
			this.add(new SmallCharLabel("<"), 1, finalRowTotal);
			SmallCharLabel Xlabel = new SmallCharLabel("X");
			Xlabel.setCharColor(Color.RED);
			this.add(Xlabel, 4, finalRowTotal);
		} else {
			this.add(new SmallCharLabel("÷"), 1, finalRowTotal);
			this.add(new SmallCharLabel(carryValues.get(finalRowTotal)), 4, finalRowTotal);
		}
	}

	public void insertRemainderValue(List<Integer> individualBinChars) {
		int listPos = individualBinChars.size() - 1;
		for (int i = finalRowTotal - 1; i >= 0; i--) {
			SmallCharLabel remainder = new SmallCharLabel(individualBinChars.get(listPos).toString());
			if (individualBinChars.get(listPos) == 0) {
				remainder.setCharColor(Color.RED);
			} else {
				remainder.setCharColor(Color.GREEN);
			}
			this.add(remainder, 5, i + 1);
			listPos--;
		}
	}
}
