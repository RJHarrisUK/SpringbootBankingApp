package com.banking.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.banking.persistence.domain.SentAccount;

@Repository
public interface ConsumerRepository extends MongoRepository<SentAccount, Long> {
}
