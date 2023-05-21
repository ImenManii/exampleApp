package com.example.service;

import com.example.entity.Account;
import com.example.entity.Customer;
import com.example.model.AccountInputData;

public interface AccountService {

	public Account openNewAccount(AccountInputData accountInputData);
	
	public Customer getCustomer(String customerId);
	
	public Account getAccount(String customerId);
}
