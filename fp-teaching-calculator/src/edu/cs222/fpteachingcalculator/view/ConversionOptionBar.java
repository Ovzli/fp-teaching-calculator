package edu.cs222.fpteachingcalculator.view;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.GridPane;

public class ConversionOptionBar extends GridPane {
	public final RadioButton hexInputType = new RadioButton();
	public final RadioButton decInputType = new RadioButton();
	public final RadioButton binInputType = new RadioButton();
	public final RadioButton hexConvert = new RadioButton();
	public final RadioButton decConvert = new RadioButton();
	public final RadioButton binConvert = new RadioButton();
	private final Label convertOptionTitle = new Label(" CONVERSION OPTIONS:  ");
	private final Label convertToTitle = new Label("   CONVERT TO:  ");

	public ConversionOptionBar() {
		formatConversionOptionGridPane();
		formatRadios();
		this.add(convertOptionTitle, 0, 0);
		convertOptionTitle.getStyleClass().add("boldedLabel");
		this.add(convertToTitle, 4, 0);
		convertToTitle.getStyleClass().add("boldedLabel");
		hexInputType.setSelected(true);
		binConvert.setSelected(true);
		hexConvert.setDisable(true);
		this.setGridLinesVisible(false);
	}

	private void formatConversionOptionGridPane() {
		this.getStyleClass().addAll("modeOptionPane", "convertPanel");
		this.setMaxWidth(720);
		this.setMinHeight(40);
		this.setHgap(6);
		this.setAlignment(Pos.CENTER_LEFT);
	}

	private void formatRadios() {
		hexInputType.setText("HEX  ");
		this.add(hexInputType, 1, 0);
		hexInputType.setAlignment(Pos.TOP_RIGHT);
		decInputType.setText("DEC  ");
		this.add(decInputType, 2, 0);
		decInputType.setAlignment(Pos.TOP_RIGHT);
		binInputType.setText("BIN  ");
		this.add(binInputType, 3, 0);
		binInputType.setAlignment(Pos.TOP_RIGHT);
		hexConvert.setText("HEX  ");
		this.add(hexConvert, 5, 0);
		hexConvert.setAlignment(Pos.TOP_RIGHT);
		decConvert.setText("DEC  ");
		this.add(decConvert, 6, 0);
		decConvert.setAlignment(Pos.TOP_RIGHT);
		binConvert.setText("BIN  ");
		this.add(binConvert, 7, 0);
		binConvert.setAlignment(Pos.TOP_RIGHT);
	}

	public String forceUnmatchingMode(String mode) {
		if (mode.equals("HEX")) {
			return "DEC";
		} else {
			return "HEX";
		}
	}

}
