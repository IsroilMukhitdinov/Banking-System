package com.codehouse.entity;

import com.codehouse.data.BankDAO;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignUp {
	
	private static Label nameLabel;
	private static TextField nameField;
	private static Label idLabel;
	private static TextField idField;
	private static Label passwordLabel;
	private static PasswordField passwordField;
	private static Label balanceLabel;
	private static TextField balanceField;
	
	private static Button addButton;
	
	private static GridPane root;
	private static Scene scene;
	private static Stage stage;
	
	public static void display(BankDAO database) {
		nameLabel = new Label("Name");
		nameField = new TextField();
		idLabel = new Label("Client ID");
		idField = new TextField();
		passwordLabel = new Label("Password");
		passwordField = new PasswordField();
		balanceLabel = new Label("Balance");
		balanceField = new TextField();
		addButton = new Button("Add Client");
		addButton.setOnAction(e -> {
			String name = nameField.getText();
			int id = Integer.parseInt(idField.getText());
			String password = passwordField.getText();
			int balance = Integer.parseInt(balanceField.getText());
			database.addClient(new Client(name,id,password,balance));
			stage.close();
		});
		
		root = new GridPane();
		GridPane.setConstraints(nameLabel, 0, 0);
		GridPane.setConstraints(nameField,1,0);
		GridPane.setConstraints(idLabel, 0, 1);
		GridPane.setConstraints(idField, 1, 1);
		GridPane.setConstraints(passwordLabel, 0, 2);
		GridPane.setConstraints(passwordField, 1, 2);
		GridPane.setConstraints(balanceLabel, 0, 3);
		GridPane.setConstraints(balanceField, 1, 3);
		GridPane.setConstraints(addButton, 1, 5);
		
		root.getChildren().addAll(nameLabel,
				nameField,
				idLabel,
				idField,
				passwordLabel,
				passwordField,
				balanceLabel,
				balanceField,
				addButton);
		
		root.setPadding(new Insets(40,20,20,40));
		root.setHgap(20);
		root.setVgap(20);
		scene = new Scene(root,400,400);
		stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Add Client");
		stage.setScene(scene);
		stage.showAndWait();
	}

}
