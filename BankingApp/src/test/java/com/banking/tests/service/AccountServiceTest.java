package com.banking.tests.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.banking.service.AccountServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountServiceTest {

	@InjectMocks
	private AccountServiceImpl service;

	@Mock
	private AccountRepository repo;

	private static final Account MOCK_ACCOUNT1 = new Account(1L, "Tom", "Bombadil", "123", "50");
	private static final Account MOCK_ACCOUNT2 = new Account(2L, "Peregrin", "Took", "456", "0");
//	private static final ResponseEntity<Object> MOCK_RESPONSE_ENTITY = new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	private static final Optional<Account> MOCK_ACCOUNT_OPTIONAL = Optional.of(MOCK_ACCOUNT1);
	private static final Optional<Account> MOCK_NULL_OPTIONAL = Optional.empty();

	private static final ResponseEntity<Object> MOCK_OK_RESPONSE = new ResponseEntity<Object>(HttpStatus.OK);
	private static final ResponseEntity<Object> MOCK_NOT_FOUND_RESPONSE = new ResponseEntity<Object>(
			HttpStatus.NOT_FOUND);

	@Test
	public void getAccountsTest() {
		List<Account> ACCOUNT_LIST = new ArrayList<>();
		ACCOUNT_LIST.add(MOCK_ACCOUNT1);
		ACCOUNT_LIST.add(MOCK_ACCOUNT2);
		Mockito.when(repo.findAll()).thenReturn(ACCOUNT_LIST);
		assertEquals(ACCOUNT_LIST, service.getAccounts());
		Mockito.verify(repo).findAll();
	}

//	@Test
//	public void addAccountTest() {
//		Mockito.when(repo.save(MOCK_ACCOUNT1)).thenReturn(MOCK_ACCOUNT1);
//		assertEquals(MOCK_ACCOUNT1, service.addAccount(MOCK_ACCOUNT1));
//		Mockito.verify(repo).save(MOCK_ACCOUNT1);
//	}

	@Test
	public void deleteAccountTest() {
		Mockito.when(repo.findById(1L)).thenReturn(MOCK_ACCOUNT_OPTIONAL);
		Mockito.when(repo.findById(3L)).thenReturn(MOCK_NULL_OPTIONAL);
		assertEquals(MOCK_OK_RESPONSE, service.deleteAccount(1L));
		assertEquals(MOCK_NOT_FOUND_RESPONSE, service.deleteAccount(3L));
		Mockito.verify(repo).findById(1L);
	}

	@Test
	public void updateAccountTest() {
		Mockito.when(repo.findById(1L)).thenReturn(MOCK_ACCOUNT_OPTIONAL);
		Mockito.when(repo.findById(3L)).thenReturn(MOCK_NULL_OPTIONAL);
		assertEquals(MOCK_OK_RESPONSE, service.updateAccount(MOCK_ACCOUNT1, 1L));
		assertEquals(MOCK_NOT_FOUND_RESPONSE, service.updateAccount(MOCK_ACCOUNT1, 3L));
		Mockito.verify(repo).findById(1L);
	}

}
