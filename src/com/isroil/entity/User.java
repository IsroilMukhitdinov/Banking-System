package com.isroil.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {

	private String name;
	private int id;
	private int balance;
	private ArrayList<Transaction> transactionList;
	
	public User(final String name,final int id) {
		this.name = name;
		this.id = id;
		balance = 0;
		transactionList = new ArrayList<Transaction>();
	}
	public User(final String name,final int id,final int balance) {
		this(name,id);
		this.balance = balance;
	}
	
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public int getBalance() {
		return balance;
	}
	public ArrayList<Transaction> getTransactionList(){
		return transactionList;
	}
	
	public boolean deposit(final int amount) {
		if (amount >= 0) {
			balance = balance + amount;
			transactionList.add(new Transaction("Deposit",amount,LocalDateTime.now()));
			return true;
		}
		return false;
	}
	
	public boolean withdraw(User user,final int amount) {
		if (amount >= 0 && amount <= balance && user != null) {
			balance = balance - amount;
			transactionList.add(new Transaction("Withdraw",amount,LocalDateTime.now()));
			user.deposit(amount);
			return true;
		}
		return false;
	}
	
	
	
	
	
	
	
	
}
