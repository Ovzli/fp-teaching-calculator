package edu.cs222.fpteachingcalculator.view;

import edu.cs222.fpteachingcalculator.model.converter.Conversion;
import edu.cs222.fpteachingcalculator.model.converter.HexToBinConverter;
import edu.cs222.fpteachingcalculator.model.converter.InputSplitter;
import edu.cs222.fpteachingcalculator.view.InputValidator;
import edu.cs222.fpteachingcalculator.view.inputexceptions.EmptyInputException;
import edu.cs222.fpteachingcalculator.view.inputexceptions.InvalidHexNumberLengthException;
import edu.cs222.fpteachingcalculator.view.inputexceptions.InvalidHexSymbolException;
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
	public final HexToBinResultDisplay hexToBinDisplay = new HexToBinResultDisplay();
	public final InputToolbar hexInputToolbar = new InputToolbar();
	public final ModeOptionBar modeOptionBar = new ModeOptionBar();
	public final FooterToolbar footerToolbar = new FooterToolbar();
	public String displayMode = "SUMMARY";
	public int slideOnDisplay;
	public int totalSlides;

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
		rootLayout.add(sideBarPanel, 1, 4);
		rootLayout.add(hexInputToolbar, 0, 1);
		rootLayout.add(modeOptionBar, 0, 3);
		rootLayout.add(footerToolbar, 0, 5);
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
		hexToBinDisplay.setMinHeight(424);
		handleConvert(hexInputToolbar.convertButton);
		handleGenerate(hexInputToolbar.generateButton);
		handlePreviousSlide(footerToolbar.previousButton);
		handleNextSlide(footerToolbar.nextButton);
		addRadioButtonHandler(modeOptionBar.summaryModeRadio, "SUMMARY");
		addRadioButtonHandler(modeOptionBar.tutorialModeRadio, "TUTORIAL");
		addRadioButtonHandler(modeOptionBar.practiceModeRadio, "PRACTICE");
		rootLayout.setGridLinesVisible(false);
	}

	public void doConversion(String callee) {
		HexToBinConverter hexToBin = new HexToBinConverter();
		Conversion conversion = null;
		InputValidator inputValidator = new InputValidator();
		InputSplitter inputSplitter = new InputSplitter();
		footerToolbar.updateFooterVisibility(displayMode);
		String inputValue;
		try {
			inputValue = hexInputToolbar.getInputText();
			inputValidator.checkIfInputIsEmpty(inputValue);
			inputValidator.checkIfHexValueIsValid(inputSplitter
					.splitHexInput(inputValue));
		} catch (EmptyInputException e) {
			if (callee.equals("CONVERT")) {
				hexInputToolbar.updateErrorText("NO VALUE WAS ENTERED");
			}
			return;
		} catch (InvalidHexSymbolException e) {
			if (callee.equals("CONVERT")) {
				hexInputToolbar
						.updateErrorText("AN INVALID CHARCTER WAS DETECTED");
			}
			return;
		} catch (InvalidHexNumberLengthException e) {
			if (callee.equals("CONVERT")) {
				hexInputToolbar
						.updateErrorText("THE INPUT ENTERED IS TOO LONG");
			}
			return;
		}
		conversion = hexToBin.convertHexToBin(inputValue);
		hexToBinDisplay.hexSymbols = conversion.getParsedListOfHexInput();
		hexToBinDisplay.decValues = conversion.getListOfDecEquivalents();
		hexToBinDisplay.binDigits = conversion.getListOfSeparatedBinNibbles();
		updateDisplay();
	}

	public void updateDisplay() {
		slideOnDisplay = 0;
		hexToBinDisplay.clearHexToBinTemplates();
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
		hexToBinDisplay.defineTemplateSetup(displayMode);
	}

	public void handleConvert(Button button) {
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				resetErrorText();
				doConversion("CONVERT");
			}
		});
	}

	private void addRadioButtonHandler(RadioButton radioButton, String mode) {
		radioButton.setOnAction(new EventHandler<ActionEvent>() {
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

	public void handleGenerate(Button button) {
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				resetErrorText();
				hexInputToolbar.setInputText();
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
		hexInputToolbar.updateErrorText("");
	}
}