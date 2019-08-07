package com.banking.persistence.domain;

public class SentAccount {

	private Long accountId;

	private String firstName;

	private String lastName;

	private String accountNumber;

	private String prize;

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public SentAccount() {
	}

	public SentAccount(Account account) {
		this.accountId = account.getId();
		this.firstName = account.getFirstName();
		this.lastName = account.getLastName();
		this.accountNumber = account.getAccountNumber();
		this.prize = account.getPrize();
	}

}