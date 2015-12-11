package edu.cs222.fpteachingcalculator.view;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class SideBarPanel extends GridPane {
	public final ImageView decHexBinTable = new ImageView("file:src/assets/decHexBinTable.png");

	public SideBarPanel() {
		this.setAlignment(Pos.TOP_CENTER);
		this.add(decHexBinTable, 0, 0);
		this.setVisible(false);
	}
}