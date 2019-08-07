package com.banking.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.banking.persistence.domain.SentAccount;
import com.banking.persistence.repository.ConsumerRepository;

@Component
public class QueueReceiver {

	@Autowired
	private ConsumerRepository repo;

	@JmsListener(destination = "AccountQueue", containerFactory = "myFactory")
	public void receiveMessage(SentAccount sentAccount) {
		repo.save(sentAccount);
	}
}