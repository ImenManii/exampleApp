package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.Transaction;
import com.example.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	private List<Transaction> transactions = new ArrayList<Transaction>();

	public List<Transaction> newTransaction(String accountId, double initialCredit) {
		Transaction transaction = new Transaction(accountId, initialCredit);
		transactions.add(transaction);
		return transactions;
	}
}
