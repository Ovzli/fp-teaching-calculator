package edu.cs222.fp_teaching_calculator.view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUI extends Application {
	public final Pane root = new Pane();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage rootStage) throws Exception {
		formatRoot(rootStage);
		rootStage.show();
	}

	private void formatRoot(Stage rootStage){
        //rootStage.setScene(new Scene(rootPane));
		rootStage.setScene(new Scene(root));
		rootStage.setTitle("Teaching Calculator");
		rootStage.setX(30);
		rootStage.setY(30);
		//rootStage.setWidth(rootWidth);
		//rootStage.setHeight(rootHeight);
		//root.getStylesheets().add(this.getClass().getResource("layoutStyles.css").toExternalForm());
		//root.getChildren().add(rootPane);
		//rootPane.getStyleClass().add("rootPane");	}
	}
}
