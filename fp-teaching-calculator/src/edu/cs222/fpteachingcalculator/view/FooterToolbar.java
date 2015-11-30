package edu.cs222.fpteachingcalculator.view;

import java.util.LinkedList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class FooterToolbar extends GridPane {
	public int currentSlideIndex = 0;
	public final GridPane buttonPane = new GridPane();
	public final Button previousButton = new Button("<< PREV");
	public final Button nextButton = new Button("NEXT >>");
	public final GridPane slideThumbRibbon = new GridPane();
	public final List<SlideThumb> slideThumbList = new LinkedList<>();

	public FooterToolbar() {
		formatToolbar();
		formatButtonPane();
		formatSlideThumbPane();
		this.setVisible(false);
		this.setGridLinesVisible(false);
	}

	private void formatToolbar() {
		this.getStyleClass().add("footerPane");
		this.setMinWidth(600);
		this.setMinHeight(80);
		this.setHgap(20);
		ColumnConstraints col1 = new ColumnConstraints(400);
		col1.setPercentWidth(65);
		ColumnConstraints col2 = new ColumnConstraints(200);
		col2.setPercentWidth(35);
		this.getColumnConstraints().addAll(col1, col2);
		this.setAlignment(Pos.TOP_RIGHT);
	}

	private void formatButtonPane() {
		this.add(buttonPane, 1, 0);
		buttonPane.setHgap(10);
		buttonPane.setAlignment(Pos.TOP_RIGHT);
		buttonPane.add(previousButton, 0, 0);
		buttonPane.add(nextButton, 1, 0);
	}

	private void setupSlideThumbPane(int totalSlides) {
		slideThumbRibbon.getChildren().clear();
		slideThumbList.clear();
		currentSlideIndex = 0;
		for (int i = 0; i < totalSlides; i++) {
			slideThumbList.add(new SlideThumb(i + 1));
			slideThumbRibbon.add(slideThumbList.get(i), i, 0);
		}
	}

	private void formatSlideThumbPane() {
		this.add(slideThumbRibbon, 0, 0);
		slideThumbRibbon.setAlignment(Pos.TOP_LEFT);
		slideThumbRibbon.setHgap(5);
	}

	public void incrementSlideDisplay() {
		slideThumbList.get(currentSlideIndex).colorSlideThumb("DEFAULT");
		currentSlideIndex++;
		slideThumbList.get(currentSlideIndex).colorSlideThumb("SELECTED");
	}

	public void decrementSlideDisplay() {
		slideThumbList.get(currentSlideIndex).colorSlideThumb("DEFAULT");
		currentSlideIndex--;
		slideThumbList.get(currentSlideIndex).colorSlideThumb("SELECTED");
	}

	public void enableNextButton() {
		nextButton.setDisable(false);
	}

	public void disableNextButton() {
		nextButton.setDisable(true);
	}

	public void enablePreviousButton() {
		previousButton.setDisable(false);
	}

	public void disablePreviousButton() {
		previousButton.setDisable(true);
	}

	public void resetFooterToDefaults(int totalSlides) {
		setupSlideThumbPane(totalSlides);
		disablePreviousButton();
		enableNextButton();
	}

	public void updateFooterVisibility(String mode) {
		if (mode.equals("SUMMARY")) {
			this.setVisible(false);
		} else {
			this.setVisible(true);
		}
	}
}