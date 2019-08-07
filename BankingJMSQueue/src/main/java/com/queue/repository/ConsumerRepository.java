package com.queue.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.queue.domain.SentAccount;

@Repository
public interface ConsumerRepository extends MongoRepository<SentAccount, Long> {
}
