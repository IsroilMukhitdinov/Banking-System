package com.codehouse.entity;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class OperationStatus {
	
	private static Stage stage;
	private static Scene scene;
	private static VBox root;
	private static Label messageLabel;
	private static Button okButton;

	
	public static void display(final String message){
		
		stage = new Stage();
		stage.setTitle("Transaction Status");
		stage.initModality(Modality.APPLICATION_MODAL);
		
		root = new VBox();
		root.setPadding(new Insets(40,20,20,20));
		root.setSpacing(20);
		root.setAlignment(Pos.CENTER);
		
		okButton = new Button("OK");
		okButton.setOnAction(e -> stage.close());
		messageLabel = new Label(message);
		
		root.getChildren().addAll(messageLabel,okButton);
		scene = new Scene(root,300,300);
		
		stage.setScene(scene);
		stage.showAndWait();
	}
}
