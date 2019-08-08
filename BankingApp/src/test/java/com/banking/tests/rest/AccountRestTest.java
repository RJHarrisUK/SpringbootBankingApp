package com.banking.tests.rest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.banking.persistence.domain.Account;
import com.banking.persistence.repository.AccountRepository;
import com.banking.rest.AccountRest;
import com.banking.service.AccountServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRestTest {

	@InjectMocks
	private AccountRest rest;

	@Mock
	private AccountServiceImpl service;

	@Mock
	private AccountRepository repo;

	private static final Account MOCK_ACCOUNT1 = new Account(1L, "Tom", "Bombadil", "123", "50");
	private static final Account MOCK_ACCOUNT2 = new Account(2L, "Peregrin", "Took", "456", "0");
	private static final ResponseEntity<Object> MOCK_RESPONSE_ENTITY = new ResponseEntity<Object>(HttpStatus.ACCEPTED);

	@Test
	public void getAccountsTest() {
		List<Account> ACCOUNT_LIST = new ArrayList<>();
		ACCOUNT_LIST.add(MOCK_ACCOUNT1);
		ACCOUNT_LIST.add(MOCK_ACCOUNT2);
		Mockito.when(service.getAccounts()).thenReturn(ACCOUNT_LIST);
		assertEquals(ACCOUNT_LIST, rest.getAccounts());
		Mockito.verify(service).getAccounts();

	}

//	@Test
//	public void createAccountTest() {
//		Mockito.when(repo.save(MOCK_ACCOUNT1)).thenReturn(MOCK_ACCOUNT1);
//		assertEquals(MOCK_ACCOUNT1, rest.createAccount(MOCK_ACCOUNT1));
//		Mockito.verify(repo).save(MOCK_ACCOUNT1);
//	}

	@Test
	public void deleteAccountTest() {
		Mockito.when(service.deleteAccount(1L)).thenReturn(MOCK_RESPONSE_ENTITY);
		assertEquals(MOCK_RESPONSE_ENTITY, rest.deleteAccount(1L));
		Mockito.verify(service).deleteAccount(1L);
	}

	@Test
	public void updateAccountTest() {
		Mockito.when(service.updateAccount(MOCK_ACCOUNT1, 1L)).thenReturn(MOCK_RESPONSE_ENTITY);
		assertEquals(MOCK_RESPONSE_ENTITY, rest.updateAccount(MOCK_ACCOUNT1, 1L));
		Mockito.verify(service).updateAccount(MOCK_ACCOUNT1, 1L);
	}
}