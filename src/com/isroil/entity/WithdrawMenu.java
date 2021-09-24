package com.isroil.entity;

import com.isroil.data.NationalBankDatabase;
import com.isroil.data.UnionBankDatabase;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class WithdrawMenu {
	
	private static Label nameLabel;
	private static TextField nameField;
	private static Label idLabel;
	private static TextField idField;
	private static CheckBox nbCheckBox;
	private static CheckBox ubCheckBox;
	private static Label nbLabel;
	private static Label ubLabel;
	private static Label amountLabel;
	private static TextField amountField;
	private static Button confirmButton;
	private static GridPane root;
	private static Scene scene;
	private static Stage stage;
	
	private static Database database;

	public static void display(User user) {

		nameLabel = new Label("Name");
		nameLabel.setPrefHeight(40);
		nameLabel.setPrefWidth(120);
		
		nameField = new TextField();
		nameField.setPrefHeight(40);
		nameField.setPrefWidth(100);
		
		idLabel = new Label("ID");
		idLabel.setPrefHeight(40);
		idLabel.setPrefWidth(120);
		
		idField = new TextField();
		idField.setPrefHeight(40);
		idField.setPrefWidth(100);
		
		nbCheckBox = new CheckBox();
		ubCheckBox = new CheckBox();
		
		nbLabel = new Label("National Bank");
		nbLabel.setPrefHeight(40);
		nbLabel.setPrefWidth(120);
		
		ubLabel = new Label("Union Bank");
		ubLabel.setPrefHeight(40);
		ubLabel.setPrefWidth(120);
		
		amountLabel = new Label("Amount");
		amountLabel.setPrefHeight(40);
		amountLabel.setPrefWidth(120);

		amountField = new TextField();
		amountField.setPrefHeight(40);
		amountField.setPrefWidth(100);

		confirmButton = new Button("Confirm");
		confirmButton.setPrefHeight(40);
		confirmButton.setPrefWidth(100);
		confirmButton.setOnAction(e -> {
			stage.close();
			int amount = Integer.parseInt(amountField.getText());
			String name = nameField.getText();
			int id = Integer.parseInt(idField.getText());
			if (nbCheckBox.isSelected())
				database = NationalBankDatabase.getDatabase();
			else 
				database = UnionBankDatabase.getDatabase();
			User u = database.findUser(name, id);
			user.withdraw(u,amount);
			
		});

		root = new GridPane();
		root.setPadding(new Insets(40, 20, 20, 20));
		root.setHgap(20);
		root.setVgap(20);
		root.setAlignment(Pos.CENTER);
		GridPane.setConstraints(nameLabel, 0, 0);
		GridPane.setConstraints(nameField, 1, 0);
		GridPane.setConstraints(idLabel, 0, 1);
		GridPane.setConstraints(idField, 1, 1);
		GridPane.setConstraints(nbLabel, 0, 2);
		GridPane.setConstraints(nbCheckBox, 1, 2);
		GridPane.setConstraints(ubLabel, 0, 3);
		GridPane.setConstraints(ubCheckBox, 1, 3);
		GridPane.setConstraints(amountLabel, 0, 4);
		GridPane.setConstraints(amountField, 1, 4);
		GridPane.setConstraints(confirmButton, 1, 6);
		root.getChildren().addAll(nameLabel,
				nameField,
				idLabel,
				idField,
				nbCheckBox,
				nbLabel,
				ubCheckBox,
				ubLabel,
				amountLabel,
				amountField,
				confirmButton);
		scene = new Scene(root, 600, 600);
		stage = new Stage();
		stage.setTitle("Withdraw Menu");
		stage.setScene(scene);
		stage.show();

	}

}
