package com.isroil.app;

import com.isroil.data.NationalBankDatabase;
import com.isroil.data.UnionBankDatabase;
import com.isroil.entity.OptionMenu;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{
	
	private Button button1;
	private Button button2;
	private VBox root;
	private Scene scene;
	
	private NationalBankDatabase ndb;
	private UnionBankDatabase udb;
	
	@Override
	public void init() {
		ndb = NationalBankDatabase.getDatabase();
		udb = UnionBankDatabase.getDatabase();
		
		button1 = new Button("National Bank");
		button1.setPrefHeight(50);
		button1.setPrefWidth(200);
		button1.setAlignment(Pos.CENTER);
		button1.setOnAction(e -> {
			OptionMenu.display(ndb);
		});
		
		button2 = new Button("Union Bank");
		button2.setPrefHeight(50);
		button2.setPrefWidth(200);
		button2.setAlignment(Pos.CENTER);
		button2.setOnAction(e -> {
			OptionMenu.display(udb);
		});
		
		root = new VBox();
		root.setPadding(new Insets(80,20,20,20));
		root.setSpacing(20);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(button1,button2);
		scene = new Scene(root,500,500);
		
		
		
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Bank Management System");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
