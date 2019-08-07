package com.banking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.banking.persistence.domain.Account;
import com.banking.persistence.domain.SentAccount;
import com.banking.persistence.repository.AccountRepository;
import com.banking.util.AccountNotFoundException;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository repo;
	private JmsTemplate jmsTemplate;

	@Autowired
	public AccountServiceImpl(AccountRepository repo, JmsTemplate jmsTemplate) {
		this.repo = repo;
		this.jmsTemplate = jmsTemplate;
	}

	public AccountServiceImpl() {
	}

	// READ
	@Override
	public List<Account> getAccounts() {
		return repo.findAll();
	}

	// READ
	@Override
	public Account getAccount(Long id) {
		Optional<Account> account = repo.findById(id);
		return account.orElseThrow(() -> new AccountNotFoundException(id.toString()));
	}

	// CREATE
	@Override
	public Account addAccount(Account account) {
		sendToQueue(account);
		return repo.save(account);
	}

	// DELETE
	@Override
	public ResponseEntity<Object> deleteAccount(Long id) {
		if (accountExists(id)) {
			repo.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	// UPDATE
	@Override
	public ResponseEntity<Object> updateAccount(Account account, Long id) {
		if (accountExists(id)) {
			account.setId(id);
			repo.save(account);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	// CHECK IF ACCOUNT EXISTS
	private boolean accountExists(Long id) {
		Optional<Account> accountOptional = repo.findById(id);
		return accountOptional.isPresent();
	}

	private void sendToQueue(Account account) {
		SentAccount accountToStore = new SentAccount(account);
		jmsTemplate.convertAndSend("AccountQueue", accountToStore);
	}
}
