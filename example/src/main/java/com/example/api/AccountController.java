package com.example.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.entity.Customer;
import com.example.mapper.CustomerDataMapper;
import com.example.model.AccountInputData;
import com.example.model.CustomerData;
import com.example.service.AccountService;

@RestController
public class AccountController {

	@Autowired
	private AccountService accountService;

	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

	@PostMapping("/accounts")
	public ResponseEntity<String> openAccount(@RequestBody AccountInputData accountInputData) throws Exception {
		Account account = null;
		try {
			account = accountService.openNewAccount(accountInputData);
		} catch (Exception e) {
			LOG.error("open Account failed :: ", e);
			throw new Exception(e.getMessage());
		}
		return ResponseEntity.ok().body(account.getId());
	}
	
	@GetMapping("/accounts/{customerId}")
    public ResponseEntity<CustomerData> getAccountDetails(@PathVariable String customerId) {
        Customer customer = accountService.getCustomer(customerId);
        Account account = accountService.getAccount(customerId);
        CustomerDataMapper mapper = new CustomerDataMapper();
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
		return ResponseEntity.ok(mapper.mapToCustomerData(customer, account));
    }

}
