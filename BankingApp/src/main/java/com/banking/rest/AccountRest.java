package com.banking.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.banking.persistence.domain.Account;
import com.banking.service.AccountService;

@RestController
public class AccountRest {

	public AccountService service;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	public AccountRest(AccountService service) {
		this.service = service;
	}

	public AccountRest() {
	}

	// READ
	@GetMapping("/getAccounts")
	public List<Account> getAccounts() {
		return service.getAccounts();
	}

	// DELETE
	@DeleteMapping("/deleteAccount/{accountId}")
	public ResponseEntity<Object> deleteAccount(@PathVariable("accountId") Long accountId) {
		return service.deleteAccount(accountId);
	}

	// UPDATE
	@PutMapping("/updateAccount")
	public ResponseEntity<Object> updateAccount(@RequestBody Account account, @PathVariable Long id) {
		return service.updateAccount(account, id);
	}

	// CREATE
	@PostMapping("/createAccount")
	public Account createAccount(@RequestBody Account account) {
		String AccountNumber = restTemplate.getForObject("http://richjharrisuk_accountnumgen_1:8079/getNumgen",
				String.class);
		String PrizeNumber = restTemplate.getForObject("http://richjharrisuk_accountprizegen_1:8078/getPrizegen",
				String.class);
		account.setAccountNumber(AccountNumber);
		account.setPrize(PrizeNumber);
		return service.addAccount(account);
	}

}
