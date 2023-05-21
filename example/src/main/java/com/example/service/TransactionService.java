package com.example.service;

import java.util.List;

import com.example.entity.Transaction;

public interface TransactionService {

	public List<Transaction> newTransaction(String accountId, double initialCredit);
}
