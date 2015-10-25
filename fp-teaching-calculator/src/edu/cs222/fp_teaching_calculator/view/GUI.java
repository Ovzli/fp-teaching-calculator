package edu.cs222.fp_teaching_calculator.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {	
	private final AnchorPane rootPane = new AnchorPane();
	private final Canvas rootCanvas = new Canvas(900,600);
	public final GridPane rootLayout = new GridPane();
	private final ScrollPane scrollDisplay = new ScrollPane();
	private final AnchorPane displayPane = new AnchorPane();
	public GridTemplate displayGrid = new GridTemplate(displayPane);
	public final inputToolbar hexInputToolbar = new inputToolbar(rootLayout, displayGrid);
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage rootStage) throws Exception {	        
		setupStage(rootStage);	        
		formatRoot();
		layoutRoot();
		setupDisplay();	
		rootStage.show();
	}

	private void setupDisplay() {
		rootLayout.add(scrollDisplay, 0, 2);
		GridPane.setColumnSpan(scrollDisplay, 2);	
		scrollDisplay.setPrefSize(700, 500);
		scrollDisplay.setMinWidth(600);	
		scrollDisplay.setContent(displayPane);
		scrollDisplay.setFitToWidth(true);
		scrollDisplay.setFitToHeight(true);
		displayPane.getStyleClass().add("displayPane");
		displayGrid.setMinHeight(474);
		rootLayout.setGridLinesVisible(false);
	}

	private void setupStage(Stage rootStage){
		rootStage.setTitle("Teaching Calculator");
		rootStage.setX(60);
		rootStage.setY(30);
		rootStage.setScene(new Scene(rootPane));
        rootPane.getChildren().add(rootCanvas); 
		rootPane.getChildren().add(rootLayout);
		AnchorPane.setTopAnchor(rootLayout, 0.0);
		AnchorPane.setLeftAnchor(rootLayout, 0.0);
		AnchorPane.setBottomAnchor(rootLayout, 0.0);
		AnchorPane.setRightAnchor(rootLayout, 0.0);
	}
	
	private void formatRoot(){
		rootPane.getStylesheets().add(this.getClass().getResource("layoutStyles.css").toExternalForm());
		rootPane.getStyleClass().add("rootPane");
		rootLayout.getStyleClass().add("rootLayout"); 
	}
	
	private void layoutRoot() {
        ColumnConstraints col1 = new ColumnConstraints(500);
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints(300);
        col2.setPercentWidth(30);
        ColumnConstraints col3 = new ColumnConstraints(200);
        col3.setPercentWidth(20);
        rootLayout.getColumnConstraints().addAll(col1,col2,col3);		
	}
	
	public void transferLists(){
		System.out.println("TRANSFERRING LISTS");
	}
	
}
