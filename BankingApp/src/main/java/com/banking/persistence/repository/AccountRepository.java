package com.banking.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.banking.persistence.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}