package com.isroil.entity;

import java.time.LocalDateTime;

public class Transaction {
	
	private String type;
	private int amount;
	private LocalDateTime time;
	
	public Transaction(final String type,final int amount,final LocalDateTime time) {
		this.type = type;
		this.amount = amount;
		this.time = time;
	}
	
	public String getType() {
		return type;
	}
	public int getAmount() {
		return amount;
	}
	
	public LocalDateTime getTime() {
		return time;
	}

}
