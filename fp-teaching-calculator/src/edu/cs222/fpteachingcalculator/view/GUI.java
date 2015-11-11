package edu.cs222.fpteachingcalculator.view;

import edu.cs222.fpteachingcalculator.model.converter.Conversion;
import edu.cs222.fpteachingcalculator.model.converter.ConversionObserver;
import edu.cs222.fpteachingcalculator.model.converter.HexToBinConverter;
import edu.cs222.fpteachingcalculator.model.converter.inputexceptions.EmptyInputException;
import edu.cs222.fpteachingcalculator.model.converter.inputexceptions.InvalidHexNumberLengthException;
import edu.cs222.fpteachingcalculator.model.converter.inputexceptions.InvalidHexSymbolException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI extends Application {
	private final AnchorPane rootPane = new AnchorPane();
	private final Canvas rootCanvas = new Canvas(900, 600);
	public final GridPane rootLayout = new GridPane();
	private final ScrollPane scrollDisplay = new ScrollPane();
	private final AnchorPane displayPane = new AnchorPane();
	public HexDecPanel sideBarPanel = new HexDecPanel("HEX to DEC\nEQUIVALENTS");
	public DisplayTemplate displayTemplate = new DisplayTemplate();
	public final InputToolbar hexInputToolbar = new InputToolbar();
	public final ConversionObserver conversionObserver = new ConversionObserver();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage rootStage) throws Exception {
		setupStage(rootStage);
		formatRoot();
		layoutRoot();
		setupDisplay();
		setupObserver();
		rootStage.show();
	}

	private void setupObserver() {
		conversionObserver.addObservers(sideBarPanel);
	}

	private void setupStage(Stage rootStage) {
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

	private void formatRoot() {
		rootPane.getStylesheets().add(
				this.getClass().getResource("layoutStyles.css")
						.toExternalForm());
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
		rootLayout.getColumnConstraints().addAll(col1, col2, col3);
		rootLayout.add(sideBarPanel, 2, 2);
		rootLayout.add(hexInputToolbar, 0, 1);
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
		displayPane.getChildren().add(displayTemplate);
		displayTemplate.setMinHeight(474);
		handleConvert(hexInputToolbar.convertButton);
		handleGenerate(hexInputToolbar.generateButton);
		rootLayout.setGridLinesVisible(false);
	}

	public void doConversion() {
		HexToBinConverter hexToBin = new HexToBinConverter();
		Conversion conversion = null;
		try {
			String inputValue = hexInputToolbar.getInputText();
			conversion = hexToBin.convertHexToBin(inputValue);
		} catch (EmptyInputException e) {
			hexInputToolbar.updateErrorText("NO VALUE WAS ENTERED");
			return;
		} catch (InvalidHexSymbolException e) {
			hexInputToolbar.updateErrorText("AN INVALID CHARCTER WAS DETECTED");
			return;
		} catch (InvalidHexNumberLengthException e) {
			hexInputToolbar.updateErrorText("THE INPUT ENTERED IS TOO LONG");
			return;
		}
		displayTemplate.hexSymbols = conversion.getParsedListOfHexInput();
		displayTemplate.decValues = conversion.getListOfDecEquivalents();
		displayTemplate.binDigits = conversion.getListOfSeparatedBinNibbles();
		updateDisplay();
	}

	public void updateDisplay() {
		displayTemplate.getChildren().clear();
		sideBarPanel.setVisible(true);
		displayTemplate.setupHexToBinTemplate();
	}

	public void handleConvert(Button button) {
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				resetErrorText();
				doConversion();
			}
		});
	}

	public void handleGenerate(Button button) {
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				resetErrorText();
				hexInputToolbar.setInputText();
				//doConversion();
			}
		});
	}

	private void resetErrorText() {
		hexInputToolbar.updateErrorText("");
	}

}