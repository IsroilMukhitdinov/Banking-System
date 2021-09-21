package com.codehouse.app;



import com.codehouse.data.BankDAO;
import com.codehouse.entity.ClientAuthentication;
import com.codehouse.entity.SignUp;
import com.codehouse.entity.Table;
import com.codehouse.entity.TransactionType;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Bank extends Application {
	
	private Button depositButton;
	private Button withdrawButton;
	private Button addClientButton;
	private Button removeClientButton;
	private Button listAllClientsButton;

	
	private VBox root;
	private Scene scene;
	
	private BankDAO database = BankDAO.getBankDAO();
	
	@Override
	public void init() {
		depositButton = new Button("Deposit");
		depositButton.setOnAction(e -> {
			ClientAuthentication.display(database,TransactionType.DEPOSIT);
		});
		
		withdrawButton = new Button("Withdraw");
		addClientButton = new Button("Add Client");
		addClientButton.setOnAction(e -> SignUp.display(database));
		removeClientButton = new Button("Remove Client");
		listAllClientsButton = new Button("Clients List");
		listAllClientsButton.setOnAction(e -> {
			Table.display(database);
		});
		

		
				
		Button buttons[] = {depositButton,withdrawButton,addClientButton,removeClientButton,listAllClientsButton};
		
		styleButtons(buttons);
		
		root = new VBox();
		root.setPadding(new Insets(60,20,20,90));
		root.setSpacing(20);
		
		root.getChildren().addAll(depositButton,
				withdrawButton,
				addClientButton,
				removeClientButton,
				listAllClientsButton);
		scene = new Scene(root,400,400);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Bank");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void styleButtons(Button[] buttons) {
		for (Button button : buttons) {
			button.setPrefHeight(25);
			button.setPrefWidth(200);
			button.setAlignment(Pos.CENTER);
		}
	}
	

	
	public static void main(String[] args) {
		launch(args);
	}

}
