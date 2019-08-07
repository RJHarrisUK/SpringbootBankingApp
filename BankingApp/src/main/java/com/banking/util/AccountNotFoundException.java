package com.banking.util;

@SuppressWarnings("serial")
public class AccountNotFoundException extends RuntimeException {

	public AccountNotFoundException(String exception) {
		super("Id supplied does not exist. Id: " + exception);
	}

}
