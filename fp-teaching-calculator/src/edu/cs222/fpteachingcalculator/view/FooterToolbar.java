package edu.cs222.fpteachingcalculator.view;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class FooterToolbar extends GridPane {
	public int currentSlide = 1;
	public final GridPane buttonPane = new GridPane();
	public final Button previousButton = new Button("<< PREV");
	public final Button nextButton = new Button("NEXT >>");
	public final GridPane slideThumbPane = new GridPane();

	public FooterToolbar() {
		formatToolbar();
		formatButtonPane();
		setupSlideThumbPane();
		formatSlideThumbPane();
		this.setVisible(false);
		this.setGridLinesVisible(false);
	}

	private void formatToolbar(){
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

	private void setupSlideThumbPane() {
		for (int i = 0; i < 10; i++){
			Rectangle slideBG = makeSlideBGRectangle(30, 30);
			slideThumbPane.add(slideBG, i, 0);	
			Label slideLabel = makeSlideLabel(i+1);
			slideThumbPane.add(slideLabel, i, 0);	
		}		
	}
	
	private void formatSlideThumbPane() {
		this.add(slideThumbPane, 0, 0);
		slideThumbPane.setAlignment(Pos.TOP_LEFT);
		slideThumbPane.setHgap(5);		
	}

	private Rectangle makeSlideBGRectangle(int width, int height) {
		Rectangle customRectangle = new Rectangle();
		customRectangle.setWidth(width);
		customRectangle.setHeight(height);
		customRectangle.setFill(Paint.valueOf("#FFFFFF"));
		GridPane.setHalignment(customRectangle, HPos.CENTER);
		return customRectangle;
	}
	
	private Label makeSlideLabel(int id){
		Label label = new Label(Integer.toString(id));
		label.getStyleClass().add("boldedLabel");
		GridPane.setHalignment(label, HPos.CENTER);			
		return label;
	}
	
	public void resetCurrentSlideDefault(){
		currentSlide = 1;
	}
	
	public int getCurrentSlide(){
		return currentSlide;
	}
	
	public void setCurrentSlide(int slideNumber){
		currentSlide = slideNumber;
	}
	
	public void updateSlideThumbDisplay(){
		// TO DO
	}
	
	public void incrementSlideDisplay(){
		//  TO DO
	}
	
	public void decrementSlideDisplay(){
		//  TO DO
	}
	
	public void enableNextButton(){
		nextButton.setDisable(false);
	}

	public void disableNextButton(){
		nextButton.setDisable(true);	
	}
	
	public void enablePreviousButton(){
		previousButton.setDisable(false);	
	}
	
	public void disablePreviousButton(){
		previousButton.setDisable(true);		
	}
	
	public void resetFooterToDefaults(){
		disablePreviousButton();
		resetCurrentSlideDefault();
		enableNextButton();
		updateSlideThumbDisplay();
	}
	
	public void updateFooterVisibility(String mode){
		if(mode.equals("SUMMARY")){
			this.setVisible(false);
		} else {
			this.setVisible(true);
		}		
	}
	
}
