package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;

import javafx.scene.layout.GridPane;

public class TutorialTemplate extends GridPane {
	int slideCount = 0;
	LinkedList<GridPane> slideList = new LinkedList<GridPane>();

	public void addInputReprintRow(GridPane inputReprintRow) {
		this.add(inputReprintRow, 0, 0);
	}

	public void addStepSlide(GridPane slideContent) {
		slideList.add(slideContent);
		this.add(slideContent, 0, 1);
		if (slideCount > 0) {
			slideContent.setVisible(false);
		}
		slideCount++;
	}

	public void clearSlideList() {
		slideCount = 0;
		slideList.clear();
	}

}
