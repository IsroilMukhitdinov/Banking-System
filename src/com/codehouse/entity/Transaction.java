package com.codehouse.entity;

import java.time.LocalDate;

public class Transaction {
	
	private LocalDate date;
	private TransactionType type;
	private int amount;
	
	public Transaction(final LocalDate date,final TransactionType type,final int amount) {
		this.date = date;
		this.type = type;
		this.amount = amount;
	}
	
	public LocalDate getDate() { return date; }
	public TransactionType getType() { return type; }
	public int getAmount() { return amount; }

}
