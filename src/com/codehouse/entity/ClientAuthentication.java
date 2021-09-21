package com.codehouse.entity;

import com.codehouse.data.BankDAO;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ClientAuthentication {
	
	private static boolean result = false;
	
	private static Stage stage;
	private static Scene scene;
	private static VBox root;
	private static Label nameLabel;
	private static TextField nameField;
	private static Label passwordLabel;
	private static PasswordField passwordField;
	private static Button okButton;
	
	public static boolean display(BankDAO database,TransactionType type) {
		stage = new Stage();
		stage.setTitle("Authentication");
		stage.initModality(Modality.APPLICATION_MODAL);
		
		root = new VBox();
		root.setPadding(new Insets(40,20,20,20));
		root.setSpacing(20);
		root.setAlignment(Pos.CENTER);
		
		nameLabel = new Label("Name");
		nameField = new TextField();
		passwordLabel = new Label("Password");
		passwordField = new PasswordField();
		okButton = new Button("Ok");
		
		okButton.setOnAction(e -> {
			Client client = findByName(database,nameField.getText());
			if (client != null) {
				stage.close();
				TransactionWindow.display(type);
				//DepositMenu.display(client);
			}
			else {
				OperationStatus.display("No Such Client Exists");
				stage.close();
			}
			
		});
		root.getChildren().addAll(nameLabel,nameField,passwordLabel,passwordField,okButton);
		scene = new Scene(root,300,300);
		stage.setScene(scene);
		stage.showAndWait();
		
		return result;
			
	}
	
	public static Client findByName(final BankDAO database, final String name) {
		for (Client client : database.getClients()) {
			if (name.equals(client.getName())) {
				return client;
			}
		}
		return null;
	}
	

}
