package com.example.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.jeasy.random.EasyRandom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.Account;
import com.example.entity.Transaction;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionServiceTest {

	@Autowired
	private TransactionService transactionService;
	
	@Test
	public void newTransaction() {
		EasyRandom generator = new EasyRandom();
		Account account =  generator.nextObject(Account.class);
		List<Transaction> transactions = transactionService.newTransaction(account.getId(), account.getBalance());
		assertThat(transactions.isEmpty(), is(false));
	}
}
