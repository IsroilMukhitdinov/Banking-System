package com.codehouse.entity;

import java.time.LocalDate;
import java.util.ArrayList;

public class Client {

	private String name;
	private int id;
	private int balance;
	private String password;
	private LocalDate openDate = LocalDate.now();
	private ArrayList<Transaction> transactionList;

	public Client(final String name, final int id, final String password) {
		this.name = name;
		this.password = password;
	}

	public Client(final String name, final int id, final String password, final int balance) {
		this(name, id, password);
		this.balance = balance;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public LocalDate getOpenDate() {
		return openDate;
	}
	
	public int getBalance() {
		return balance;
	}

	public ArrayList<Transaction> getTransactionList() {
		return transactionList;
	}

//	public boolean deposit(final int depositAmount) {
//		if (ClientAuthentication.display(password)) {
//			OperationStatus.display("Deposited Successfully");
//			transactionList.add(new Transaction(LocalDate.now(),TransactionType.DEPOSIT,depositAmount));
//			return true;
//		}
//		OperationStatus.display("Wrong Password");
//		return false;
//	}
//
//
//	public boolean withdraw(final int withdrawAmount) {
//		if (ClientAuthentication.display(password)) {
//			if (balance >= withdrawAmount) {
//				OperationStatus.display("Withdrew Successfully");
//				transactionList.add(new Transaction(LocalDate.now(),TransactionType.WITHDRAW,withdrawAmount));
//				return true;
//			}
//			OperationStatus.display("Not Enough Balance");
//			return false;
//		}
//		OperationStatus.display("Wrong Password");
//		return false;
//	}
	
	@Override
	public String toString() {
		return "[Client] " + name + "   $" + balance;
	}

	
	

}
