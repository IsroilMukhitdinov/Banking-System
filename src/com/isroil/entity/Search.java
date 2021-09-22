package com.isroil.entity;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Search {
	
	private static Label nameLabel;
	private static TextField nameField;
	private static Label idLabel;
	private static TextField idField;
	private static Button searchButton;
	private static GridPane root;
	private static Scene scene;
	private static Stage stage;
	
	private static User user;
	
	public static User display(Database db) {
		
		
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
		
		searchButton = new Button("SEARCH");
		searchButton.setPrefHeight(50);
		searchButton.setPrefWidth(200);
		searchButton.setOnAction(e -> {
			stage.close();
			String name = nameField.getText();
			int id = Integer.parseInt(idField.getText());
			user = db.findUser(name, id);
			UserMenu.display(user);
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
		GridPane.setConstraints(searchButton,1,3);
		root.getChildren().addAll(nameLabel,
				nameField,
				idLabel,
				idField,
				searchButton);
		scene = new Scene(root,500,500);
		stage = new Stage();
		stage.setTitle("Search User");
		stage.setScene(scene);
		stage.show();
		
		return user;
	}

}
