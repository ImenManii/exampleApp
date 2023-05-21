package com.example.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.entity.Customer;
import com.example.entity.Transaction;
import com.example.model.AccountInputData;
import com.example.service.AccountService;
import com.example.service.TransactionService;

@Service
public class AccountServiceImpl implements AccountService{
	
	
	@Autowired
	private TransactionService transactionService;
	private Map<String, Customer> customers = new HashMap<String, Customer>();
	private Map<String, Account> accounts = new HashMap<String, Account>();

	@Override
	public Account openNewAccount(AccountInputData accountInputData) {
		Customer customer = null;
		Account account = null;
		List<Transaction> transactions;
		if (customers.containsKey(accountInputData.getCustomerId())) {
			customer = getCustomer(accountInputData.getCustomerId());
			account = accounts.get(accountInputData.getCustomerId());
		} else {
			customer = new Customer(accountInputData.getCustomerId(), accountInputData.getName(),
					accountInputData.getSurname());
			account = new Account(accountInputData.getCustomerId(), 0);
			transactions = new ArrayList<>();
		}
		if (accountInputData.getInitialCredit() != 0) {
			transactions = transactionService
					.newTransaction(accountInputData.getCustomerId(), accountInputData.getInitialCredit()).stream()
					.filter(trans -> trans.getAccountId().equals(accountInputData.getCustomerId()))
					.collect(Collectors.toList());
			account.setBalance(account.getBalance() + accountInputData.getInitialCredit());
			account.setTransactions(transactions);
		}
		customers.put(accountInputData.getCustomerId(), customer);
		accounts.put(accountInputData.getCustomerId(), account);
		return account;
	}

	@Override
	public Customer getCustomer(String customerId) {
		return customers.get(customerId);
	}

	@Override
	public Account getAccount(String customerId) {
		return accounts.get(customerId);
	}
}
