package com.isroil.entity;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserMenu {
	
	private static Button depositButton;
	private static Button withdrawButton;
	private static Button transactionsButton;
	
	private static VBox root;
	private static Scene scene;
	private static Stage stage;
	
	public static void display(User user) {
		depositButton = new Button("Deposit");
		depositButton.setPrefHeight(50);
		depositButton.setPrefWidth(200);
		depositButton.setOnAction(e -> {
			stage.close();
			DepositMenu.display(user);
		});
		withdrawButton = new Button("Withdraw");
		withdrawButton.setPrefHeight(50);
		withdrawButton.setPrefWidth(200);
		withdrawButton.setOnAction(e -> {
			stage.close();
			WithdrawMenu.display(user);
		});
		transactionsButton = new Button("Transactions");
		transactionsButton.setPrefHeight(50);
		transactionsButton.setPrefWidth(200);
		transactionsButton.setOnAction(e -> {
			stage.close();
			TransactionList.display(user);
		});
		root = new VBox();
		root.setPadding(new Insets(40,20,20,20));
		root.setSpacing(20);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(depositButton,
				withdrawButton,
				transactionsButton);
		scene = new Scene(root,500,500);
		stage = new Stage();
		stage.setTitle("User Menu");
		stage.setScene(scene);
		stage.show();
	}
	

}
