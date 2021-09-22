package com.isroil.entity;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class OptionMenu {
	
	private static Button findButton;
	private static Button addButton;
	private static Button removeButton;
	
	private static VBox root;
	private static Scene scene;
	private static Stage stage;
	
	public static void display(Database database) {
		findButton = new Button("Find User");
		findButton.setPrefHeight(50);
		findButton.setPrefWidth(200);
		findButton.setOnAction(e -> {
			stage.close();
			Search.display(database);
		});
		addButton = new Button("Add User");
		addButton.setPrefHeight(50);
		addButton.setPrefWidth(200);
		addButton.setOnAction(e -> {
			stage.close();
			AddUser.display(database);
		});
		removeButton = new Button("Remove User");
		removeButton.setPrefHeight(50);
		removeButton.setPrefWidth(200);
		removeButton.setOnAction(e -> {
			stage.close();
			RemoveUser.display(database);
		});
		
		root = new VBox();
		root.setPadding(new Insets(40,20,20,20));
		root.setSpacing(20);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(findButton,
				addButton,
				removeButton);
		
		scene = new Scene(root,500,500);
		stage = new Stage();
		stage.setScene(scene);
		stage.show();
	}

}
