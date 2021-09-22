package com.isroil.entity;

import java.time.LocalDateTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TransactionList {
	
	private static TableView<Transaction> table;
	private static TableColumn<Transaction,String> typeColumn;
	private static TableColumn<Transaction,Integer> amountColumn;
	private static TableColumn<Transaction,LocalDateTime> timeColumn;
	
	private static Scene scene;
	private static Stage stage;
	
	@SuppressWarnings("unchecked")
	public static void display(User user) {
		
		ObservableList<Transaction> transactions = FXCollections.observableArrayList();
		transactions.addAll(user.getTransactionList());
		

		typeColumn = new TableColumn<>("Type");
		typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
		typeColumn.setMinWidth(160);
		amountColumn = new TableColumn<>("Amount");
		amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));
		amountColumn.setMinWidth(120);
		timeColumn = new TableColumn<>("Date");
		timeColumn.setCellValueFactory(new PropertyValueFactory<>("time"));
		timeColumn.setMinWidth(200);
		table = new TableView<>();
		table.setItems(transactions);
		table.getColumns().addAll(typeColumn,amountColumn,timeColumn);
		
		scene = new Scene(table,500,500);
		stage = new Stage();
		stage.setTitle("User Transactions");
		stage.setScene(scene);
		stage.show();
	}
	


}
