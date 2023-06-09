package com.example.entity;

public class Transaction {
	private String accountId;
	private double amount;

	// Constructor
	public Transaction(String accountId, double amount) {
		this.accountId = accountId;
		this.amount = amount;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
