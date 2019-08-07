package com.banking.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue
	private Long accountId;

	private String firstName;

	private String lastName;

	private String accountNumber;

	private String prize;

	public Account() {
	}

	public Account(Long accountId, String firstName, String lastName, String accountNumber, String prize) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
		this.accountId = accountId;
		this.prize = prize;
	}

	public Long getId() {
		return accountId;
	}

	public void setId(Long id) {
		this.accountId = id;
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

	public String toString() {
		return this.accountId + this.firstName + this.lastName + this.accountNumber + this.prize;
	}

}