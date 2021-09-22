package com.isroil.entity;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AddUser {
	
	private static Label nameLabel;
	private static TextField nameField;
	private static Label idLabel;
	private static TextField idField;
	private static Label balanceLabel;
	private static TextField balanceField;
	private static Button addButton;
	private static GridPane root;
	private static Scene scene;
	private static Stage stage;
	
	public static void display(Database database) {
		
		
		nameLabel = new Label("Name");
		nameLabel.setPrefHeight(50);
		nameLabel.setPrefWidth(100);
		
		nameField = new TextField();
		nameField.setPrefHeight(50);
		nameField.setPrefWidth(200);
		
		idLabel = new Label("ID");
		idLabel.setPrefHeight(50);
		idLabel.setPrefWidth(100);
		
		idField = new TextField();
		idField.setPrefHeight(50);
		idField.setPrefWidth(200);
		
		balanceLabel = new Label("Balance");
		balanceLabel.setPrefHeight(50);
		balanceLabel.setPrefWidth(100);
		
		balanceField = new TextField();
		balanceField.setPrefHeight(50);
		balanceField.setPrefWidth(200);
	
		
		addButton = new Button("ADD");
		addButton.setPrefHeight(50);
		addButton.setPrefWidth(200);
		addButton.setOnAction(e -> {
			stage.close();
			String name = nameField.getText();
			int id = Integer.parseInt(idField.getText());
			int balance = Integer.parseInt(balanceField.getText());
			database.addUser(new User(name,id,balance));
		});
		root = new GridPane();
		root.setPadding(new Insets(80,20,20,20));
		root.setHgap(20);
		root.setVgap(20);
		root.setAlignment(Pos.CENTER);
		GridPane.setConstraints(nameLabel,0,0);
		GridPane.setConstraints(nameField,1,0);
		GridPane.setConstraints(idLabel,0,1);
		GridPane.setConstraints(idField,1,1);
		GridPane.setConstraints(balanceLabel,0,2);
		GridPane.setConstraints(balanceField,1,2);
		GridPane.setConstraints(addButton,1,4);
		root.getChildren().addAll(nameLabel,
				nameField,
				idLabel,
				idField,
				balanceLabel,
				balanceField,
				addButton);
		scene = new Scene(root,500,500);
		stage = new Stage();
		stage.setTitle("Add Use");
		stage.setScene(scene);
		stage.show();
	}

}
