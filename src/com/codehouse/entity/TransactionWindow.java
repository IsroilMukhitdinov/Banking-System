package com.codehouse.entity;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TransactionWindow {
	
	private static Stage stage;
	private static Scene scene;
	private static VBox root;
	private static Label messageLabel;
	private static TextField amountField;
	private static Button button;
	
	public static void display(TransactionType type) {
		stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(40,20,20,20));
		root.setSpacing(20);
		String message;
		if (type == TransactionType.DEPOSIT)
			message = "Deposit Amount";
		else
			message = "Withdraw Amount";
		messageLabel = new Label(message);
		amountField = new TextField();
		button = new Button(message.toUpperCase());
		button.setOnAction(e -> {
			
		});
		
		root.getChildren().addAll(messageLabel,amountField,button);
		scene = new Scene(root,400,400);
		stage.setTitle(message + " Window");
		stage.setScene(scene);
		stage.showAndWait();		
	}
	

}
