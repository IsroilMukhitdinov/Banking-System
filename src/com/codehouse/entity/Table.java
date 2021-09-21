package com.codehouse.entity;

import java.time.LocalDate;

import com.codehouse.data.BankDAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Table {

	private static Stage stage;
	private static Scene scene;
	private static TableView<Client> tableView;
	private static Pane root;

	@SuppressWarnings("unchecked")
	public static void display(BankDAO database) {
		stage = new Stage();
		stage.setTitle("Clients List");
		stage.initModality(Modality.APPLICATION_MODAL);
		root = new Pane();
		root.setPadding(new Insets(40, 20, 20, 40));
		tableView = new TableView<>();

		// ID Column
		TableColumn<Client, Integer> idColumn = new TableColumn<Client,Integer>("ID");
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		idColumn.setMinWidth(50);

		// Name Column
		TableColumn<Client, String> nameColumn = new TableColumn<Client,String>("Name");
		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		nameColumn.setMinWidth(150);

		// Balance Column
		TableColumn<Client, Integer> balanceColumn = new TableColumn<Client,Integer>("Balance");
		balanceColumn.setCellValueFactory(new PropertyValueFactory<>("balance"));
		balanceColumn.setMinWidth(80);

		// Open Date Column
		TableColumn<Client, LocalDate> openDateColumn = new TableColumn<Client,LocalDate>("Opened");
		openDateColumn.setCellValueFactory(new PropertyValueFactory<>("openDate"));
		openDateColumn.setMinWidth(120);
		
		tableView.setItems(getClient(database));
		tableView.getColumns().addAll(idColumn,nameColumn,balanceColumn,openDateColumn);
		
		root.getChildren().add(tableView);
		scene = new Scene(root,400,400);
		stage.setScene(scene);
		stage.showAndWait();
	}
	
	public static ObservableList<Client> getClient(BankDAO database){
		ObservableList<Client> clients = FXCollections.observableArrayList();
		for (Client client : database.getClients()) {
			clients.add(client);
		}
		return clients;
	}

}
