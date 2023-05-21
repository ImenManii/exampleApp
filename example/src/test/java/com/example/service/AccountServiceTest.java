package com.example.service;

import static org.junit.Assert.assertEquals;

import org.jeasy.random.EasyRandom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.entity.Account;
import com.example.model.AccountInputData;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {
	
	@Autowired
	private AccountService accountService;

	@Test
	public void openNewAccount() {
		EasyRandom generator = new EasyRandom();
		AccountInputData accountInputData =  generator.nextObject(AccountInputData.class);
		Account account = accountService.openNewAccount(accountInputData);
		assertEquals(account.getId(), accountInputData.getCustomerId());
	}
}
