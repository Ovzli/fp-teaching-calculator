package edu.cs222.fpteachingcalculator.view;

import edu.cs222.fpteachingcalculator.model.converter.BinToDecConverter;
import edu.cs222.fpteachingcalculator.model.converter.BinToHexConverter;
import edu.cs222.fpteachingcalculator.model.converter.Conversion;
import edu.cs222.fpteachingcalculator.model.converter.DecToBinConverter;
import edu.cs222.fpteachingcalculator.model.converter.DecToHexConverter;
import edu.cs222.fpteachingcalculator.model.converter.HexToBinConverter;
import edu.cs222.fpteachingcalculator.model.converter.HexToDecConverter;
import edu.cs222.fpteachingcalculator.model.converter.InputSplitter;
import edu.cs222.fpteachingcalculator.view.InputValidator;
import edu.cs222.fpteachingcalculator.view.inputexceptions.EmptyInputException;
import edu.cs222.fpteachingcalculator.view.inputexceptions.InvalidNumberLengthException;
import edu.cs222.fpteachingcalculator.view.inputexceptions.InvalidSymbolException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
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
	public final SideBarPanel sideBarPanel = new SideBarPanel();
	public final BinToHexResultDisplay binToHexDisplay = new BinToHexResultDisplay();
	public final BinToDecResultDisplay binToDecDisplay = new BinToDecResultDisplay();
	public final DecToHexResultDisplay decToHexDisplay = new DecToHexResultDisplay();
	public final DecToBinResultDisplay decToBinDisplay = new DecToBinResultDisplay();
	public final HexToDecResultDisplay hexToDecDisplay = new HexToDecResultDisplay();
	public final HexToBinResultDisplay hexToBinDisplay = new HexToBinResultDisplay();
	public final Toolbar inputToolbar = new Toolbar();
	public final ConversionOptionBar convertOptionBar = new ConversionOptionBar();
	public final ModeOptionBar modeOptionBar = new ModeOptionBar();
	public final FooterToolbar footerToolbar = new FooterToolbar();
	public String displayMode = "SUMMARY";
	public int slideOnDisplay;
	public int totalSlides;
	public String inputMode = "HEX";
	public String convertMode = "BIN";

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
		ColumnConstraints col1 = new ColumnConstraints(800);
		col1.setPercentWidth(80);
		ColumnConstraints col2 = new ColumnConstraints(200);
		col2.setPercentWidth(20);
		rootLayout.getColumnConstraints().addAll(col1, col2);
		rootLayout.add(convertOptionBar, 0, 0);
		rootLayout.add(inputToolbar, 0, 1);
		rootLayout.add(modeOptionBar, 0, 3);
		rootLayout.add(footerToolbar, 0, 5);
		rootLayout.add(sideBarPanel, 1, 4);
	}

	private void setupDisplay() {
		rootLayout.add(scrollDisplay, 0, 4);
		scrollDisplay.setPrefSize(700, 450);
		scrollDisplay.setMinWidth(600);
		scrollDisplay.setContent(displayPane);
		scrollDisplay.setFitToWidth(true);
		scrollDisplay.setFitToHeight(true);
		displayPane.getStyleClass().add("displayPane");
		displayPane.getChildren().add(hexToBinDisplay);
		binToHexDisplay.setMinHeight(424);
		binToDecDisplay.setMinHeight(424);
		decToHexDisplay.setMinHeight(424);
		decToBinDisplay.setMinHeight(424);
		hexToDecDisplay.setMinHeight(424);
		hexToBinDisplay.setMinHeight(424);
		handleConvert(inputToolbar.convertButton);
		handleGenerate(inputToolbar.generateButton);
		handlePreviousSlide(footerToolbar.previousButton);
		handleNextSlide(footerToolbar.nextButton);
		addModeRadioHandler(modeOptionBar.summaryModeRadio, "SUMMARY");
		addModeRadioHandler(modeOptionBar.tutorialModeRadio, "TUTORIAL");
		addModeRadioHandler(modeOptionBar.practiceModeRadio, "PRACTICE");
		addConvertModeHandler(convertOptionBar.hexInputType, "HEX");
		addConvertModeHandler(convertOptionBar.decInputType, "DEC");
		addConvertModeHandler(convertOptionBar.binInputType, "BIN");
		addConvertToOptionHandler(convertOptionBar.hexConvert, "HEX");
		addConvertToOptionHandler(convertOptionBar.decConvert, "DEC");
		addConvertToOptionHandler(convertOptionBar.binConvert, "BIN");
		rootLayout.setGridLinesVisible(false);
	}

	public void doConversion(String callee) {
		InputValidator inputValidator = new InputValidator();
		InputSplitter inputSplitter = new InputSplitter();
		footerToolbar.updateFooterVisibility(displayMode);
		String inputValue;
		try {
			inputValue = inputToolbar.getInputText();
			inputValidator.checkIfInputIsEmpty(inputValue);
			inputValidator.checkIfValueIsValid(inputSplitter
					.splitInput(inputValue), inputMode);
		} catch (EmptyInputException e) {
			if (callee.equals("CONVERT")) {
				inputToolbar.updateErrorText("NO VALUE WAS ENTERED");
			}
			return;
		} catch (InvalidSymbolException e) {
			if (callee.equals("CONVERT")) {
				inputToolbar
						.updateErrorText("AN INVALID CHARCTER WAS DETECTED");
			}
			return;
		} catch (InvalidNumberLengthException e) {
			if (callee.equals("CONVERT")) {
				inputToolbar.updateErrorText("THE INPUT ENTERED IS TOO LONG");
			}
			return;
		}
		selectDisplay(inputValue);
		updateDisplay();
	}
	
	private void selectDisplay(String inputValue){
		Conversion conversion = null;
		if (inputMode.equals("HEX") && (convertMode.equals("BIN"))) {
			HexToBinConverter hexToBin = new HexToBinConverter();
			conversion = hexToBin.convertHexToBin(inputValue);
			hexToBinDisplay.hexSymbols = conversion.getParsedListOfUserInput();
			hexToBinDisplay.decValues = conversion.getListOfDecEquivalents();
			hexToBinDisplay.binDigits = conversion.getListOfSeparatedBinNibbles();			
		} else if (inputMode.equals("HEX") && (convertMode.equals("DEC"))) {
			HexToDecConverter hexToDec = new HexToDecConverter();
			conversion = hexToDec.convertHexToDec(inputValue);
			hexToDecDisplay.hexSymbols = conversion.getParsedListOfUserInput();
			hexToDecDisplay.decValues = conversion.getListOfDecEquivalents();
			hexToDecDisplay.binDigits = conversion.getListOfSeparatedBinNibbles();			
		} else if (inputMode.equals("DEC") && (convertMode.equals("HEX"))) {
			DecToHexConverter decToHex = new DecToHexConverter();
			conversion = decToHex.convertDecToHex(inputValue);
			decToHexDisplay.hexSymbols = conversion.getParsedListOfUserInput();
			decToHexDisplay.decValues = conversion.getListOfDecEquivalents();
			decToHexDisplay.binDigits = conversion.getListOfSeparatedBinNibbles();			
		} else if (inputMode.equals("DEC") && (convertMode.equals("BIN"))) {
			DecToBinConverter decToBin = new DecToBinConverter();
			conversion = decToBin.convertDecToBin(inputValue);
			decToBinDisplay.hexSymbols = conversion.getParsedListOfUserInput();
			decToBinDisplay.decValues = conversion.getListOfDecEquivalents();
			decToBinDisplay.binDigits = conversion.getListOfSeparatedBinNibbles();			
		} else if (inputMode.equals("BIN") && (convertMode.equals("HEX"))) {
			BinToHexConverter binToHex = new BinToHexConverter();
			conversion = binToHex.convertBinToHex(inputValue);
			binToHexDisplay.hexSymbols = conversion.getParsedListOfUserInput();
			binToHexDisplay.decValues = conversion.getListOfDecEquivalents();
			binToHexDisplay.binDigits = conversion.getListOfSeparatedBinNibbles();			
		} else if (inputMode.equals("BIN") && (convertMode.equals("DEC"))) {
			BinToDecConverter binToDec = new BinToDecConverter();
			conversion = binToDec.convertBinToDec(inputValue);
			binToDecDisplay.hexSymbols = conversion.getParsedListOfUserInput();
			binToDecDisplay.decValues = conversion.getListOfDecEquivalents();
			binToDecDisplay.binDigits = conversion.getListOfSeparatedBinNibbles();			
		}
		
	}

	public void updateDisplay() {
		slideOnDisplay = 0;
		if (displayMode.equals("PRACTICE")) {
			sideBarPanel.setVisible(false);
		} else {
			sideBarPanel.setVisible(true);
		}
		if (!displayMode.equals("SUMMARY")) {
			scrollDisplay.setVvalue(0);
			totalSlides = hexToBinDisplay.setTotalSlideCount(displayMode);
			footerToolbar.resetFooterToDefaults(totalSlides);
		}
		hexToBinDisplay.setVisible(false);
		hexToDecDisplay.setVisible(false);
		decToHexDisplay.setVisible(false);
		decToBinDisplay.setVisible(false);
		binToHexDisplay.setVisible(false);
		binToDecDisplay.setVisible(false);
		if (inputMode.equals("HEX") && (convertMode.equals("BIN"))) {
			hexToBinDisplay.clearEntireDisplay();
			hexToBinDisplay.defineDisplaySetup(displayMode);
			hexToBinDisplay.setVisible(true);
		} else if (inputMode.equals("HEX") && (convertMode.equals("DEC"))) {
			hexToDecDisplay.clearEntireDisplay();
			hexToDecDisplay.defineDisplaySetup(displayMode);
			hexToDecDisplay.setVisible(true);
		} else if (inputMode.equals("DEC") && (convertMode.equals("HEX"))) {
			decToHexDisplay.clearEntireDisplay();
			decToHexDisplay.defineDisplaySetup(displayMode);
			decToHexDisplay.setVisible(true);
		} else if (inputMode.equals("DEC") && (convertMode.equals("BIN"))) {
			decToBinDisplay.clearEntireDisplay();
			decToBinDisplay.setVisible(true);
			decToBinDisplay.defineDisplaySetup(displayMode);
		} else if (inputMode.equals("BIN") && (convertMode.equals("HEX"))) {
			binToHexDisplay.clearEntireDisplay();
			binToHexDisplay.setVisible(true);
			binToHexDisplay.defineDisplaySetup(displayMode);
		} else if (inputMode.equals("BIN") && (convertMode.equals("DEC"))) {
			binToDecDisplay.clearEntireDisplay();
			binToDecDisplay.defineDisplaySetup(displayMode);
			binToDecDisplay.setVisible(true);
		}
	}

	public void handleConvert(Button button) {
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				resetErrorText();
				doConversion("CONVERT");
			}
		});
	}

	private void addModeRadioHandler(RadioButton radio, String mode) {
		radio.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				radioSetModeOption(mode);
			}
		});
	}

	private void radioSetModeOption(String mode) {
		displayMode = mode;
		modeOptionBar.summaryModeRadio.setSelected(false);
		modeOptionBar.tutorialModeRadio.setSelected(false);
		modeOptionBar.practiceModeRadio.setSelected(false);
		if (displayMode.equals("PRACTICE")) {
			modeOptionBar.practiceModeRadio.setSelected(true);
		} else if (displayMode.equals("TUTORIAL")) {
			modeOptionBar.tutorialModeRadio.setSelected(true);
		} else {
			modeOptionBar.summaryModeRadio.setSelected(true);
		}
		doConversion("MODE");
	}

	private void addConvertModeHandler(RadioButton radio, String inputType) {
		radio.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				radioSetConvertInputOption(inputType);
			}
		});
	}

	private void radioSetConvertInputOption(String inputType) {
		inputMode = inputType;
		convertOptionBar.hexInputType.setSelected(false);
		convertOptionBar.decInputType.setSelected(false);
		convertOptionBar.binInputType.setSelected(false);
		convertOptionBar.hexConvert.setDisable(false);
		convertOptionBar.decConvert.setDisable(false);
		convertOptionBar.binConvert.setDisable(false);
		if (inputMode.equals("HEX")) {
			convertOptionBar.hexInputType.setSelected(true);
			convertOptionBar.hexConvert.setDisable(true);
		} else if (inputMode.equals("DEC")) {
			convertOptionBar.decInputType.setSelected(true);
			convertOptionBar.decConvert.setDisable(true);
		} else {
			convertOptionBar.binInputType.setSelected(true);
			convertOptionBar.binConvert.setDisable(true);
		}
		if (inputMode.equals(convertMode)) {
			convertMode = convertOptionBar.forceUnmatchingMode(inputMode);
		}
		radioSetConvertToOption(convertMode);
		
		inputToolbar.changeInstruction(inputMode);
		// TODO - update toolbar...
		
		
	}

	private void addConvertToOptionHandler(RadioButton radio, String convertType) {
		radio.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				radioSetConvertToOption(convertType);
			}
		});
	}

	private void radioSetConvertToOption(String convertType) {
		convertMode = convertType;
		convertOptionBar.hexConvert.setSelected(false);
		convertOptionBar.decConvert.setSelected(false);
		convertOptionBar.binConvert.setSelected(false);
		if (convertMode.equals("HEX")) {
			convertOptionBar.hexConvert.setSelected(true);
		} else if (convertMode.equals("DEC")) {
			convertOptionBar.decConvert.setSelected(true);
		} else {
			convertOptionBar.binConvert.setSelected(true);
		}
	}

	public void handleGenerate(Button button) {
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				resetErrorText();
				inputToolbar.setInputText(inputMode);
			}
		});
	}

	public void handlePreviousSlide(Button button) {
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (slideOnDisplay > 0) {
					hexToBinDisplay.hideSlide(slideOnDisplay);
					slideOnDisplay--;
					footerToolbar.decrementSlideDisplay();
					hexToBinDisplay.displaySlide(slideOnDisplay);
					footerToolbar.enableNextButton();
					if (slideOnDisplay == 0) {
						footerToolbar.disablePreviousButton();
					} else {
						footerToolbar.enablePreviousButton();
					}
					scrollDisplay.setVvalue(0);
				}
			}
		});
	}

	public void handleNextSlide(Button button) {
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (slideOnDisplay < totalSlides - 1) {
					hexToBinDisplay.hideSlide(slideOnDisplay);
					slideOnDisplay++;
					footerToolbar.incrementSlideDisplay();
					hexToBinDisplay.displaySlide(slideOnDisplay);
					footerToolbar.enablePreviousButton();
					if (slideOnDisplay == totalSlides - 1) {
						footerToolbar.disableNextButton();
					} else {
						footerToolbar.enableNextButton();
					}
					scrollDisplay.setVvalue(0);
				}
			}
		});
	}

	private void resetErrorText() {
		inputToolbar.updateErrorText("");
	}
}