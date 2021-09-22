package com.isroil.entity;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RemoveUser {

	private static Label nameLabel;
	private static TextField nameField;
	private static Label idLabel;
	private static TextField idField;
	private static Button removeButton;
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
		
		removeButton = new Button("REMOVE");
		removeButton.setPrefHeight(50);
		removeButton.setPrefWidth(200);
		removeButton.setOnAction(e -> {
			stage.close();
			String name = nameField.getText();
			int id = Integer.parseInt(idField.getText());
			database.removeUser(database.findUser(name, id));
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
		GridPane.setConstraints(removeButton,1,3);
		root.getChildren().addAll(nameLabel,
				nameField,
				idLabel,
				idField,
				removeButton);
		scene = new Scene(root,500,500);
		stage = new Stage();
		stage.setTitle("Remove User");
		stage.setScene(scene);
		stage.show();
	}

}
