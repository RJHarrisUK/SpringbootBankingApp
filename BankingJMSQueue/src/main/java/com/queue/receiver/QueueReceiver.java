package com.queue.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.queue.domain.SentAccount;
import com.queue.repository.ConsumerRepository;

@Component
public class QueueReceiver {

	@Autowired
	private ConsumerRepository repo;

	@JmsListener(destination = "AccountQueue", containerFactory = "myFactory")
	public void receiveMessage(SentAccount sentAccount) {
		repo.save(sentAccount);
	}
}