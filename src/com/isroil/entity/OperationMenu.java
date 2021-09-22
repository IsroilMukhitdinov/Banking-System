package com.isroil.entity;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class OperationMenu {

	private static Label amountLabel;
	private static TextField amountField;
	private static Button confirmButton;

	private static GridPane root;
	private static Scene scene;
	private static Stage stage;

	public static void display(User user, final Type type) {

		amountLabel = new Label("Amount");
		amountLabel.setPrefHeight(50);
		amountLabel.setPrefWidth(100);

		amountField = new TextField();
		amountField.setPrefHeight(50);
		amountField.setPrefWidth(200);

		confirmButton = new Button("Confirm");
		confirmButton.setPrefHeight(50);
		confirmButton.setPrefWidth(100);
		confirmButton.setOnAction(e -> {
			stage.close();
			int amount = Integer.parseInt(amountField.getText());
			if (type == Type.DEPOSIT)
				user.deposit(amount);
			if (type == Type.WITHDRAW)
				user.withdraw(amount);
		});

		root = new GridPane();
		root.setPadding(new Insets(40, 20, 20, 20));
		root.setHgap(20);
		root.setVgap(20);
		root.setAlignment(Pos.CENTER);
		GridPane.setConstraints(amountLabel, 0, 0);
		GridPane.setConstraints(amountField, 1, 0);
		GridPane.setConstraints(confirmButton, 1, 2);
		root.getChildren().addAll(amountLabel, amountField, confirmButton);
		scene = new Scene(root, 500, 500);
		stage = new Stage();
		stage.setTitle("Operation Menu");
		stage.setScene(scene);
		stage.show();

	}

}
