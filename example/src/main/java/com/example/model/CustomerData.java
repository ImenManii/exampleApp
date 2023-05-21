package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerData {
	private String name;
	private String surname;
	private double balance;
	private List<TransactionData> transactions = new ArrayList<>();;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public List<TransactionData> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<TransactionData> transactions) {
		this.transactions = transactions;
	}
}
