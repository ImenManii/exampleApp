package com.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Account {

	private String id;
	private double balance;
	private List<Transaction> transactions = new ArrayList<>();

	public Account(String id, double balance) {
		this.id = id;
		this.balance = balance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
