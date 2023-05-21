package com.example.mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.Account;
import com.example.entity.Customer;
import com.example.model.CustomerData;
import com.example.model.TransactionData;

public class CustomerDataMapper {

	public CustomerData mapToCustomerData(Customer customer, Account account) {
		CustomerData customerData = new CustomerData();
		customerData.setName(customer.getName());
		customerData.setSurname(customer.getSurname());
		customerData.setBalance(account.getBalance());
		List<TransactionData> transactionsData = new ArrayList<>();
		account.getTransactions().forEach(transaction -> {
			TransactionData transactionData = new TransactionData();
			transactionData.setAmount(transaction.getAmount());
			transactionsData.add(transactionData);
		});
		customerData.setTransactions(transactionsData);
		return customerData;
	}
}
